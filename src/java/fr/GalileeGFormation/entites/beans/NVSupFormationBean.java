/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Departement;
import fr.GalileeGFormation.entites.Formation;
import fr.GalileeGFormation.entites.Secretariat;
import fr.GalileeGFormation.entites.SuperFormation;
import fr.GalileeGFormation.entites.Users;
import fr.GalileeGFormation.service.DepartementMetier;
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
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "nvSupFormationBean")
@SessionScoped
public class NVSupFormationBean implements Serializable{

    /* ---- Partie SuperFormation ---- */
    private SuperFormationMetier superFormationMetier;
    private List<SuperFormation> supFormations;
    private SuperFormation nvSupForm;
    
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
    private FormationMetier formationMetier;
    private List<Formation> formations;
    
    /* ---- Partie Departement ---- */
    private DepartementMetier departementMetier;
    private List<Departement> departements;
    private Departement dep= new Departement();
    /* Pour créer les combobox des composantes */
    private List<SelectItem> selectDep= new ArrayList<SelectItem>();
    private List <Departement> depList= new ArrayList<Departement>();
    
    
    public NVSupFormationBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        superFormationMetier= (SuperFormationMetier) bf.getBean("superFormationMetier");
        
        usersMetier= (UsersMetier) bf.getBean("usersMetier");
        secretariatMetier= (SecretariatMetier) bf.getBean("secretariatMetier");
        formationMetier= (FormationMetier) bf.getBean("formationMetier");
        departementMetier= (DepartementMetier) bf.getBean("departementMetier");
        
        nvSupForm= new SuperFormation();
    }
    
    @PostConstruct
    public void init(){
        supFormations= superFormationMetier.findAll();
    }
    
    /* ---- Setters & Getters pour SuperFormation ---- */
    public SuperFormation getNvSupForm() {
        return nvSupForm;
    }

    public void setNvSupForm(SuperFormation nvSupForm) {
        this.nvSupForm = nvSupForm;
    }
    
    public SuperFormationMetier getSuperFormationMetier() {
        return superFormationMetier;
    }

    public void setSuperFormationMetier(SuperFormationMetier superFormationMetier) {
        this.superFormationMetier = superFormationMetier;
    }

    public List<SuperFormation> getSupFormations() {
        return supFormations;
    }

    public void setSupFormations(List<SuperFormation> supFormations) {
        this.supFormations = supFormations;
    }
    /* ---- Fin SupFormation ---- */
    
    /* ---- Setters et Getters pour Secretariat ----- */
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
    /* ---- Fin Secr ---- */

    /* ---- Setters et Getters pour User ----- */
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

    /* ---- Setters & Getters pour Departement ---- */
    public Departement getDep() {
        return dep;
    }

    public void setDep(Departement dep) {
        this.dep = dep;
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

    public List<Departement> getDepList() {
        depList= departementMetier.findAll();
        return depList;
    }

    public void setDepList(List<Departement> depList) {
        this.depList = depList;
    }
    
    public List<SelectItem> getSelectDep() {
        selectDep.clear();
        depList= this.getDepList();
        for (Departement dep : depList) {
            selectDep.add(new SelectItem(dep, dep.getLibelle()));
        }
        return selectDep;
    }

    public void setSelectDep(List<SelectItem> selectDep) {
        this.selectDep = selectDep;
    }

    public void onAddPress(){
        // Récupérer le résponsable
        us.getUsername();
        // Récupérer le secretariat
        s.getSecretariatId();
        // Récupérer le département
        dep.getDepartementId();
        dep.getLibelle();
        dep.getAbreviation();
        dep.getDescription();
        
        Set<Departement> d= new HashSet<>();
        Set<SuperFormation> sf= new HashSet<>();
        
        d.add(dep);
        sf.add(nvSupForm);
        
        nvSupForm.setSecretariat(s);
        nvSupForm.setUsers(us);
        
        nvSupForm.setDepartements(d);
        dep.setSuperFormations(sf);
        
        superFormationMetier.save(nvSupForm);
        
        FacesMessage message= new FacesMessage("Super Formation ajoutée avec succés");
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println(nvSupForm);
        
    }
    
    /* ---- Nombre d'elements de la liste */
    public int sizeOfList(Set t) {
        if (t != null) {
            return t.size();
        } else {
            return 0;
        }
    }
}
