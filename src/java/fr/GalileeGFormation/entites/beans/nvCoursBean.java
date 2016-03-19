package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Cours;
import fr.GalileeGFormation.entites.Formation;
import fr.GalileeGFormation.entites.Secretariat;
import fr.GalileeGFormation.entites.Users;
import fr.GalileeGFormation.service.CoursMetier;
import fr.GalileeGFormation.service.FormationMetier;
import fr.GalileeGFormation.service.SecretariatMetier;
import fr.GalileeGFormation.service.UsersMetier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "nvCoursBean")
@SessionScoped
public class nvCoursBean implements Serializable{

    /* ---- Partie Cours ---- */
    private CoursMetier coursMetier;
    private List<Cours> courses;
    private Cours nvCours;
    
    private final ApplicationContext bf;
    
    /* ---- Partie Résponsable ---- */
    private Users us= new Users();
    private UsersMetier usersMetier;
     /* Pour créer les combobox des responsables */
    private List<SelectItem> selectRes= new ArrayList<SelectItem>();
    private List <Users> userList= new ArrayList<Users>();
    
     /* ---- Partie Secretariat ----- */
    private String secret;
    private Secretariat s= new Secretariat();
    private SecretariatMetier secretariatMetier;
    /* Pour créer la combobox des secretariats */
    private List<SelectItem> selectSec= new ArrayList<SelectItem>();
    private List<Secretariat> secretList= new ArrayList<Secretariat>()  ;
    
    /* ---- Partie Formation ---- */
    private Formation f= new Formation();
    private FormationMetier formationMetier;
    private List<Formation> formations;
    private List<SelectItem> selectForm= new ArrayList<SelectItem>();
    private List <Formation> formList= new ArrayList<Formation>();
    
    public nvCoursBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        coursMetier= (CoursMetier) bf.getBean("coursMetier");
        
        usersMetier= (UsersMetier) bf.getBean("usersMetier");
        secretariatMetier= (SecretariatMetier) bf.getBean("secretariatMetier");
        formationMetier= (FormationMetier) bf.getBean("formationMetier");
        
        nvCours= new Cours();
    }
    
    @PostConstruct
    public void init(){
        courses= coursMetier.findAll();
    }

    /* ---- Setters & Getters pour Cours ---- */
    public Cours getNvCours() {
        return nvCours;
    }

    public void setNvCours(Cours nvCours) {
        this.nvCours = nvCours;
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
    /* ---- Fin Cours ---- */
    
    /* ---- Setters & Getters pour Secretariat ---- */
    public Secretariat getS() {
        return s;
    }

    public void setS(Secretariat s) {
        this.s = s;
    }

    public SecretariatMetier getSecretariatMetier() {
        return secretariatMetier;
    }

    public void setSecretariatMetier(SecretariatMetier secretariatMetier) {
        this.secretariatMetier = secretariatMetier;
    }

    public List<Secretariat> getSecretList() {
        secretList= secretariatMetier.findAll();
        return secretList;
    }

    public void setSecretList(List<Secretariat> secretList) {
        this.secretList = secretList;
    }
    
    public List<SelectItem> getSelectSec() {
        selectSec.clear();
        secretList= this.getSecretList();
        for (Secretariat s : secretList) {
            selectSec.add(new SelectItem(s, s.getCampus()));
        }
        return selectSec;
    }

    public void setSelectSec(List<SelectItem> selectSec) {
        this.selectSec = selectSec;
    }
    /* ---- Fin Secretariat ---- */
    
    /* ---- Setters & Getters pour Responsable ---- */
    public Users getUs() {
        return us;
    }

    public void setUs(Users us) {
        this.us = us;
    }

    public UsersMetier getUsersMetier() {
        return usersMetier;
    }

    public void setUsersMetier(UsersMetier usersMetier) {
        this.usersMetier = usersMetier;
    }

    public List<Users> getUserList() {
        userList= usersMetier.findAll();
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }
    
    public List<SelectItem> getSelectRes() {
        selectRes.clear();
        userList= this.getUserList();
        for (Users us : userList) {
            selectRes.add(new SelectItem(us, us.getFirstName()+"  "+us.getLastName()));
        }
        return selectRes;
    }

    public void setSelectRes(List<SelectItem> selectRes) {
        this.selectRes = selectRes;
    }
    /* ---- Fin Responsable ---- */
    
    /* ---- Setters & Getters pour Formation ---- */

    public Formation getF() {
        return f;
    }

    public void setF(Formation f) {
        this.f = f;
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

    public List<Formation> getFormList() {
        formList= formationMetier.findAll();
        return formList;
    }

    public void setFormList(List<Formation> formList) {
        this.formList = formList;
    }
    
    public List<SelectItem> getSelectForm() {
        selectForm.clear();
        formList= this.getFormList();
        for (Formation f : formList) {
            selectForm.add(new SelectItem(f, f.getLibelle()));
        }
        return selectForm;
    }

    public void setSelectForm(List<SelectItem> selectForm) {
        this.selectForm = selectForm;
    }
    /* ---- Fin Responsable ---- */
    
    /* ---- Bouton Ajouter Formation ---- */
    public void onAddPress(){
        // Récupérer le résponsable
        us.getUsername();
        
        // Récupérer la Formation
        f.getFormationId();
        f.getLibelle();
        f.getAbreviation();
        f.getDescription();
        
        Set<Formation> fr= new HashSet<>();
        Set<Cours> c= new HashSet<>();
        
        fr.add(f);
        c.add(nvCours);
        
        nvCours.setUsers(us);
        
        nvCours.setFormations(fr);
        f.setCourses(c);
        
        coursMetier.save(nvCours);
        
        FacesMessage message= new FacesMessage("Cours ajouté avec succés", "uploaded success");
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println(nvCours);
    }
}
