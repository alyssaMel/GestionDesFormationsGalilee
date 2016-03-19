package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Composante;
import fr.GalileeGFormation.entites.Departement;
import fr.GalileeGFormation.service.ComposanteMetier;
import fr.GalileeGFormation.service.DepartementMetier;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "composanteBean")
@SessionScoped
public class ComposanteBean implements Serializable{

    @Autowired
    private ComposanteMetier composanteMetier;
    private List<Composante> composantes;
    private Composante com;
    
    private final ApplicationContext bf;
    
    String id;
    @Autowired
    private DepartementMetier departementMetier;
    private List<Departement> departements;
    private String rechercherValeur;
    
    public ComposanteBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        composanteMetier= (ComposanteMetier) bf.getBean("composanteMetier");
        departementMetier= (DepartementMetier) bf.getBean("departementMetier");
    }

    @PostConstruct
    public void init(){
        refresh();
    }
    
    public void refresh(){
        rechercherValeur=null;
        composantes= composanteMetier.findAll();
    }
    
    public Composante getCom() {
        //get id from url
        
        Map<String, String> urlParams;//parametre passe en URL
        urlParams = FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap();
        String parameterOne = urlParams.get("id");
        id = parameterOne;
        com = composanteMetier.findById(Integer.parseInt(parameterOne));
        return com;
    }

    public void setCom(Composante com) {
        this.com = com;
    }

    
    public ComposanteMetier getComposanteMetier() {
        return composanteMetier;
    }

    public void setComposanteMetier(ComposanteMetier composanteMetier) {
        this.composanteMetier = composanteMetier;
    }

    public List<Composante> getComposantes() {
        return composantes;
    }

    public void setComposantes(List<Composante> composantes) {
        this.composantes = composantes;
    }

    public DepartementMetier getDepartementMetier() {
        return departementMetier;
    }

    public void setDepartementMetier(DepartementMetier departementMetier) {
        this.departementMetier = departementMetier;
    }

    public List<Departement> getDepartements() {
        
        return departements;
    }

    public void setDepartements(List<Departement> departements) {
        this.departements = departements;
    }

    public String getRechercherValeur() {
        return rechercherValeur;
    }

    public void setRechercherValeur(String rechercherValeur) {
        this.rechercherValeur = rechercherValeur;
    }
    
    public void rechercher(){
        if (rechercherValeur != null) {
            composantes= composanteMetier.search(rechercherValeur);
        }
    }
}
