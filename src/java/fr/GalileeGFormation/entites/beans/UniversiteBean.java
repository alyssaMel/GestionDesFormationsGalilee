package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Composante;
import fr.GalileeGFormation.entites.Universite;
import fr.GalileeGFormation.service.ComposanteMetier;
import fr.GalileeGFormation.service.UniversiteMetier;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * @author alyssa
 */
@ManagedBean(name = "universiteBean")
@RequestScoped
public class UniversiteBean implements Serializable{

    
    private UniversiteMetier universiteMetier;
    private List<Universite> universites;
    private Universite uv;
    
    private final ApplicationContext bf;
    
    String univId;
    @Autowired
    private ComposanteMetier composanteMetier;
    private List<Composante> composantes;
    private String rechercherValeur;
    
    private String idUrlUniversite; 
    
    public UniversiteBean() {
    
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        universiteMetier= (UniversiteMetier) bf.getBean("universiteMetier");
    }

    @PostConstruct
    public void init(){
        refrech();
        System.out.println("----------------------"+universites.size());
    }
    
    public void refrech(){
        rechercherValeur= null;
        universites= getUniversiteMetier().findAll();
    }

    public Universite getUv() {
        
        //get id from url
        Map<String, String> urlParams;//parametre passe en URL
        urlParams = FacesContext.getCurrentInstance().
        getExternalContext().getRequestParameterMap();
        String parameterOne = urlParams.get("id");
        uv = universiteMetier.findById(Integer.parseInt(parameterOne));
        return uv;
    }

    public void setUv(Universite uv) {
        this.uv = uv;
    }

    public UniversiteMetier getUniversiteMetier() {
        return universiteMetier;
    }

    public void setUniversiteMetier(UniversiteMetier universiteMetier) {
        this.universiteMetier = universiteMetier;
    }

    public List<Universite> getUniversites() {
        return universites;
    }

    public void setUniversites(List<Universite> universites) {
        this.universites = universites;
    }

    public ComposanteMetier getComposanteMetier() {
        return composanteMetier;
    }

    public void setComposanteMetier(ComposanteMetier composanteMetier) {
        this.composanteMetier = composanteMetier;
    }

    public List<Composante> getComposantes() {
        // get idComposante depuis URL
        Map<String, String> urlParams;
        urlParams= FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        idUrlUniversite= urlParams.get("composanteId");
        if (idUrlUniversite != null && !"".equals(rechercherValeur)) {
            composantes= composanteMetier.findAll();
        }
        rechercherValeur= null;
        return composantes;
    }

    public void setComposantes(List<Composante> composantes) {
        this.composantes = composantes;
    }

    public String getRechercherValeur() {
        return rechercherValeur;
    }

    public void setRechercherValeur(String rechercherValeur) {
        this.rechercherValeur = rechercherValeur;
    }
    
    public void rechercher(){
        if (rechercherValeur != null) {
            universites= getUniversiteMetier().search(rechercherValeur);
        }else {
            universites= universiteMetier.findAll();
        }
    }

    public String getIdUrlUniversite() {
        return idUrlUniversite;
    }

    
    public int sizeOfList(Set t) {
        if (t != null) {
            return t.size();
        } else {
            return 0;
        }
    }
}
