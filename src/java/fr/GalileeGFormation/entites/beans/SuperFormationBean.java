package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Formation;
import fr.GalileeGFormation.entites.SuperFormation;
import fr.GalileeGFormation.service.FormationMetier;
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
@ManagedBean(name="superFormationBean")
@SessionScoped
public class SuperFormationBean implements Serializable{

    private SuperFormationMetier supFormationMetier;
    private List<SuperFormation> supFormations;
    private SuperFormation supForm;
    
    private final ApplicationContext bf;
    
    String id;
    private FormationMetier formationMetier;
    private List<Formation> formations;
    private String rechercherValeur;
    
    public SuperFormationBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        supFormationMetier= (SuperFormationMetier) bf.getBean("superFormationMetier");
        formationMetier= (FormationMetier) bf.getBean("formationMetier");
    }
    
    @PostConstruct
    public void init(){
        supFormations= supFormationMetier.findAll();
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

    public SuperFormation getSupForm() {
         //get id from url
        
            Map<String, String> urlParams;//parametre passe en URL
            urlParams = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap();
            String parameterOne = urlParams.get("id");
            id = parameterOne;
            supForm = supFormationMetier.findById(Integer.parseInt(parameterOne));
        
        return supForm;
    }

    public void setSupForm(SuperFormation supForm) {
        this.supForm = supForm;
    }

    public FormationMetier getFormationMetier() {
        return formationMetier;
    }

    public void setFormationMetier(FormationMetier formationMetier) {
        this.formationMetier = formationMetier;
    }

    public List<Formation> getFormations() {
        return formations;
    }

    public void setFormations(List<Formation> formations) {
        this.formations = formations;
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
