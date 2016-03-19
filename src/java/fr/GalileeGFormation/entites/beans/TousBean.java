package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Composante;
import fr.GalileeGFormation.entites.Cours;
import fr.GalileeGFormation.entites.Departement;
import fr.GalileeGFormation.entites.Formation;
import fr.GalileeGFormation.entites.SuperFormation;
import fr.GalileeGFormation.entites.Universite;
import fr.GalileeGFormation.entites.Users;
import fr.GalileeGFormation.service.ComposanteMetier;
import fr.GalileeGFormation.service.CoursMetier;
import fr.GalileeGFormation.service.DepartementMetier;
import fr.GalileeGFormation.service.FormationMetier;
import fr.GalileeGFormation.service.SuperFormationMetier;
import fr.GalileeGFormation.service.UniversiteMetier;
import fr.GalileeGFormation.service.UsersMetier;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.SelectEvent;
//import org.richfaces.component.html.HtmlScrollableDataTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "tousBean")
@SessionScoped
public class TousBean implements Serializable {

    private final ApplicationContext bf;
    /* ----- Universite ---- */
    @Autowired
    private transient UniversiteMetier universiteMetier;
    private DataTable univTable;
    private List<Universite> univList;
    private Universite universite;

    /* ---- Composante ---- */
    @Autowired
    private transient ComposanteMetier composanteMetier;
    private DataTable compTable;
    private List<Composante> compList;
    private Composante composante;

    /* ---- Departement ---- */
    @Autowired
    private transient DepartementMetier departementMetier;
    private DataTable depTable;
    private List<Departement> depList;
    private Departement departement;

    /* ---- SuperFormation ---- */
    @Autowired
    private transient SuperFormationMetier supFormationMetier;
    private DataTable supFTable;
    private List<SuperFormation> supFList;
    private SuperFormation supFormation;

    /* ---- Formation ---- */
    @Autowired
    private transient FormationMetier formationMetier;
    private DataTable formTable;
    private List<Formation> formList;
    private Formation formation;

    /* ---- Cours ---- */
    @Autowired
    private transient CoursMetier coursMetier;
    private DataTable coursTable;
    private List<Cours> coursList;
    private Cours cours;

    /* ---- User ---- */
    private transient UsersMetier usersMetier;
    private DataTable userTable;
    private List<Users> userList;
    private Users users;

    public TousBean() {
        bf = new ClassPathXmlApplicationContext("applicationContext.xml");
        universiteMetier = (UniversiteMetier) bf.getBean("universiteMetier");
        composanteMetier = (ComposanteMetier) bf.getBean("composanteMetier");
        departementMetier = (DepartementMetier) bf.getBean("departementMetier");
        supFormationMetier = (SuperFormationMetier) bf.getBean("superFormationMetier");
        formationMetier = (FormationMetier) bf.getBean("formationMetier");
        coursMetier = (CoursMetier) bf.getBean("coursMetier");
        usersMetier = (UsersMetier) bf.getBean("UsersMetier");
    }

    @PostConstruct
    public void init() {
        univList = universiteMetier.findAll();
        compList = composanteMetier.findAll();
        depList = departementMetier.findAll();
        supFList = supFormationMetier.findAll();
        formList = formationMetier.findAll();
        coursList = coursMetier.findAll();
        userList = usersMetier.findAll();
    }

    /* ---- Universite Setters & Getters ---- */
    public UniversiteMetier getUniversiteMetier() {
        return universiteMetier;
    }

    public void setUniversiteMetier(UniversiteMetier universiteMetier) {
        this.universiteMetier = universiteMetier;
    }

    public DataTable getUnivTable() {
        return univTable;
    }

    public void setUnivTable(DataTable univTable) {
        this.univTable = univTable;
    }

    public List<Universite> getUnivList() {
        return univList;
    }

    public void setUnivList(List<Universite> univList) {
        this.univList = univList;
    }

    public Universite getUniversite() {
        return universite;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }
    /* ---- FIN ---- */

    /* ---- Composante Setters & Getters ---- */
    public ComposanteMetier getComposanteMetier() {
        return composanteMetier;
    }

    public void setComposanteMetier(ComposanteMetier composanteMetier) {
        this.composanteMetier = composanteMetier;
    }

    public DataTable getCompTable() {
        return compTable;
    }

    public void setCompTable(DataTable compTable) {
        this.compTable = compTable;
    }

    public List<Composante> getCompList() {
        return compList;
    }

    public void setCompList(List<Composante> compList) {
        this.compList = compList;
    }

    public Composante getComposante() {
        return composante;
    }

    public void setComposante(Composante composante) {
        this.composante = composante;
    }
    /* ---- FIN ---- */

    /* ---- Departement Setters & Getters ---- */
    public DepartementMetier getDepartementMetier() {
        return departementMetier;
    }

    public void setDepartementMetier(DepartementMetier departementMetier) {
        this.departementMetier = departementMetier;
    }

    public DataTable getDepTable() {
        return depTable;
    }

    public void setDepTable(DataTable depTable) {
        this.depTable = depTable;
    }

    public List<Departement> getDepList() {
        return depList;
    }

    public void setDepList(List<Departement> depList) {
        this.depList = depList;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }
    /* ---- FIN ---- */

    /* ---- SuperFormation Setters & Getters ---- */
    public SuperFormationMetier getSupFormationMetier() {
        return supFormationMetier;
    }

    public void setSupFormationMetier(SuperFormationMetier supFormationMetier) {
        this.supFormationMetier = supFormationMetier;
    }

    public DataTable getSupFTable() {
        return supFTable;
    }

    public void setSupFTable(DataTable supFTable) {
        this.supFTable = supFTable;
    }

    public List<SuperFormation> getSupFList() {
        return supFList;
    }

    public void setSupFList(List<SuperFormation> supFList) {
        this.supFList = supFList;
    }

    public SuperFormation getSupFormation() {
        return supFormation;
    }

    public void setSupFormation(SuperFormation supFormation) {
        this.supFormation = supFormation;
    }
    /* ---- FIN ---- */

    /* ---- Formation Setters & Getters ---- */
    public FormationMetier getFormationMetier() {
        return formationMetier;
    }

    public void setFormationMetier(FormationMetier formationMetier) {
        this.formationMetier = formationMetier;
    }

    public DataTable getFormTable() {
        return formTable;
    }

    public void setFormTable(DataTable formTable) {
        this.formTable = formTable;
    }

    public List<Formation> getFormList() {
        return formList;
    }

    public void setFormList(List<Formation> formList) {
        this.formList = formList;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
    /* ---- FIN ---- */

    /* ---- Cours Setters & Getters ---- */
    public CoursMetier getCoursMetier() {
        return coursMetier;

    }

    public void setCoursMetier(CoursMetier coursMetier) {
        this.coursMetier = coursMetier;
    }

    public DataTable getCoursTable() {
        return coursTable;
    }

    public void setCoursTable(DataTable coursTable) {
        this.coursTable = coursTable;
    }

    public List<Cours> getCoursList() {
        return coursList;
    }

    public void setCoursList(List<Cours> coursList) {
        this.coursList = coursList;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
    /* ---- FIN ---- */

    /* ---- Cours Setters & Getters ---- */
    public UsersMetier getUsersMetier() {
        return usersMetier;
    }

    public void setUsersMetier(UsersMetier usersMetier) {
        this.usersMetier = usersMetier;
    }

    public DataTable getUserTable() {
        return userTable;
    }

    public void setUserTable(DataTable userTable) {
        this.userTable = userTable;
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    /* ---- FIN ---- */
    /* ---- Methode DELETE pour supprimer une universite ---- */
    public void onDeleteU() {
        try {
            universiteMetier.delete(universite);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        univList.remove(universite);
        FacesMessage message = new FacesMessage("Université supprimée avec succés");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    /* ---- Methode DELETE pour supprimer une composante ---- */
    public void onDeleteC() {
        try {
            composanteMetier.delete(composante);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        compList.remove(composante);
        FacesMessage message = new FacesMessage("Composante supprimée avec succés");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /* ---- Methode DELETE pour supprimer un Departement ---- */
    public void onDeleteD() {
        try {
            departementMetier.delete(departement);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        depList.remove(departement);
        FacesMessage message = new FacesMessage("Département supprimé avec succés");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /* ---- Methode DELETE pour supprimer une SuperFormation ---- */
    public void onDeleteSF() {
        try {
            supFormationMetier.delete(supFormation);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        supFList.remove(supFormation);
        FacesMessage message = new FacesMessage("Super Formation supprimée avec succés");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /* ---- Methode DELETE pour supprimer une Formation ---- */
    public void onDeleteF() {
        try {
            formationMetier.delete(formation);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        formList.remove(formation);
        FacesMessage message = new FacesMessage("Formation supprimée avec succés");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /* ---- Methode DELETE pour supprimer un cours ---- */
    public void onDeleteCr() {
        try {
            cours.getFormations().clear();

            coursMetier.delete(cours);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        coursList.remove(cours);
        FacesMessage message = new FacesMessage("Cours supprimée avec succés");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /* ---- Methode DELETE pour supprimer un cours ---- */
    public void onDeleteUs() {
        try {
            usersMetier.delete(users);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
        userList.remove(users);
        FacesMessage message = new FacesMessage("Résponsable supprimé avec succés");
        FacesContext.getCurrentInstance().addMessage(null, message);

    }

    /* ---- Selectionner une ligne dans la DataTable ---- */
    public void onRowSelect(SelectEvent event) {
        FacesMessage msg = new FacesMessage("ROW Selected");
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
}
