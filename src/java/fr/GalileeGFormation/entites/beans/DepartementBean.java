package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Departement;
import fr.GalileeGFormation.entites.SuperFormation;
import fr.GalileeGFormation.service.DepartementMetier;
import fr.GalileeGFormation.service.SuperFormationMetier;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "departementBean")
@SessionScoped
public class DepartementBean implements Serializable{

    private DepartementMetier departementMetier;
    private List<Departement> departements;
    private Departement depart;
    
    private final ApplicationContext bf;
    
    String id;
    private SuperFormationMetier supFormationMetier;
    private List<SuperFormation> supFormations;
    private String rechercherValeur;
    
    public DepartementBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        departementMetier= (DepartementMetier) bf.getBean("departementMetier");
        supFormationMetier= (SuperFormationMetier) bf.getBean("superFormationMetier");
        
    }
    
    @PostConstruct
    public void init(){
        departements= departementMetier.findAll();
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

    public Departement getDepart() {
        //get id from url
        
        Map<String, String> urlParams;//parametre passe en URL
        urlParams = FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap();
        String parameterOne = urlParams.get("id");
        id = parameterOne;
        depart = departementMetier.findById(Integer.parseInt(parameterOne));
        return depart;
    }

    public void setDepart(Departement depart) {
        this.depart = depart;
    }

    public SuperFormationMetier getSupFormationMetier() {
        return supFormationMetier;
    }

    public void setSupFormationMetier(SuperFormationMetier supFormationMetier) {
        this.supFormationMetier = supFormationMetier;
    }

    public List<SuperFormation> getSupFormations() {
        return supFormations;
    }

    public void setSupFormations(List<SuperFormation> supFormations) {
        this.supFormations = supFormations;
    }

    public String getRechercherValeur() {
        return rechercherValeur;
    }

    public void setRechercherValeur(String rechercherValeur) {
        this.rechercherValeur = rechercherValeur;
    }
    
    public void rechercher(){
        if (rechercherValeur != null) {
            supFormations= supFormationMetier.search(rechercherValeur);
        }
    }
    
}
