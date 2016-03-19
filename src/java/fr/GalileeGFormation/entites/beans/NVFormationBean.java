package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Cours;
import fr.GalileeGFormation.entites.Formation;
import fr.GalileeGFormation.entites.Secretariat;
import fr.GalileeGFormation.entites.SuperFormation;
import fr.GalileeGFormation.entites.Users;
import fr.GalileeGFormation.service.CoursMetier;
import fr.GalileeGFormation.service.FormationMetier;
import fr.GalileeGFormation.service.SecretariatMetier;
import fr.GalileeGFormation.service.SuperFormationMetier;
import fr.GalileeGFormation.service.UsersMetier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "nvFormationBean")
@ViewScoped
public class NVFormationBean implements Serializable{

    /* ---- Partie Formation ---- */
    private FormationMetier formationMetier;
    private List<Formation> formations;
    private Formation nvform;
    
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
    
    /* ---- Partie Cours ---- */
    private CoursMetier coursMetier;
    private List<Cours> courses;
    
    /* ---- Partie SuperFormation ---- */
    private SuperFormation sf= new SuperFormation();
    private SuperFormationMetier supFormationMetier;
    private List<SuperFormation> supFormations;
    /* Pour créer les combobox des SuperFormation */
    private List<SelectItem> selectSupForm= new ArrayList<SelectItem>();
    private List <SuperFormation> supFormList= new ArrayList<SuperFormation>();
    
    public NVFormationBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        formationMetier= (FormationMetier) bf.getBean("formationMetier");
        
        usersMetier= (UsersMetier) bf.getBean("usersMetier");
        secretariatMetier= (SecretariatMetier) bf.getBean("secretariatMetier");
        coursMetier= (CoursMetier) bf.getBean("coursMetier");
        supFormationMetier= (SuperFormationMetier) bf.getBean("superFormationMetier");
        
        nvform= new Formation();
    }
    
    @PostConstruct
    public void init(){
        formations= formationMetier.findAll();
    }
    
    /* ---- Setters & Getters pour Formation ---- */
    public Formation getNvform() {
        return nvform;
    }

    public void setNvform(Formation nvform) {
        this.nvform = nvform;
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
    /* ---- Fin Formation ---- */
    
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
    
    /* ---- Setters & Getters pour SuperFormation ---- */
    public SuperFormation getSf() {
        return sf;
    }

    public void setSf(SuperFormation sf) {
        this.sf = sf;
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

    public List<SuperFormation> getSupFormList() {
        supFormList= supFormationMetier.findAll();
        return supFormList;
    }

    public void setSupFormList(List<SuperFormation> supFormList) {
        this.supFormList = supFormList;
    }
    
    public List<SelectItem> getSelectSupForm() {
        selectSupForm.clear();
        supFormList= this.getSupFormList();
        for (SuperFormation sf : supFormList) {
            selectSupForm.add(new SelectItem(sf, sf.getLibelle()));
        }
        return selectSupForm;
    }

    public void setSelectSupForm(List<SelectItem> selectSupForm) {
        this.selectSupForm = selectSupForm;
    }
    /* ---- Fin SuperFormation ---- */
    
    /* ---- Bouton ajouter une formation---- */
    public void onAddPress(){
        // Récupérer le résponsable
        us.getUsername();
        // Récupérer le secretariat
        s.getSecretariatId();
        // Récupérer la superFormation
        sf.getSupformationId();
        sf.getLibelle();
        sf.getAbreviation();
        sf.getDescription();
        
        Set<SuperFormation> spf= new HashSet<>();
        Set<Formation> f= new HashSet<>();
        
        spf.add(sf);
        f.add(nvform);
        
        nvform.setSecretariat(s);
        nvform.setUsers(us);
        
        nvform.setSuperFormations(spf);
        sf.setFormations(f);
        
        formationMetier.save(nvform);
        
        FacesMessage message= new FacesMessage("Formation ajoutée avec succés", "uploaded success");
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println(nvform);
    }
    
}

