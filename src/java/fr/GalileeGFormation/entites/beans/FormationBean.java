package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Cours;
import fr.GalileeGFormation.entites.Formation;
import fr.GalileeGFormation.service.CoursMetier;
import fr.GalileeGFormation.service.FormationMetier;
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
@ManagedBean(name = "formationBean")
@SessionScoped
public class FormationBean implements Serializable{

    private FormationMetier formationMetier;
    private List<Formation> formations;
    private Formation forma;
    
    private final ApplicationContext bf;
    
    String id;
    private CoursMetier coursMetier;
    private List<Cours> courses;
    private String rechercherValeur;
    
    public FormationBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        formationMetier= (FormationMetier) bf.getBean("formationMetier");
        coursMetier= (CoursMetier) bf.getBean("coursMetier");
    }
    
    @PostConstruct
    public void init(){
        rechercherValeur= null;
        formations= formationMetier.findAll();
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

    public Formation getForma() {
         //get id from url
        
            Map<String, String> urlParams;//parametre passe en URL
            urlParams = FacesContext.getCurrentInstance().
                    getExternalContext().getRequestParameterMap();
            String parameterOne = urlParams.get("id");
            id = parameterOne;
            forma = formationMetier.findById(Integer.parseInt(parameterOne));
        
        return forma;
    }

    public void setForma(Formation forma) {
        this.forma = forma;
    }

    public CoursMetier getCoursMetier() {
        return coursMetier;
    }

    public void setCoursMetier(CoursMetier coursMetier) {
        this.coursMetier = coursMetier;
    }

    public List<Cours> getCourses() {
        return courses;
    }

    public void setCourses(List<Cours> courses) {
        this.courses = courses;
    }

    public String getRechercherValeur() {
        return rechercherValeur;
    }

    public void setRechercherValeur(String rechercherValeur) {
        this.rechercherValeur = rechercherValeur;
    }
    
    public void rechercher(){
        if (rechercherValeur != null) {
            formations= formationMetier.search(rechercherValeur);
        }
    }
}
