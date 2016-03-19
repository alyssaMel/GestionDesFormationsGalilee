package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Composante;
import fr.GalileeGFormation.entites.Departement;
import fr.GalileeGFormation.entites.Secretariat;
import fr.GalileeGFormation.entites.SuperFormation;
import fr.GalileeGFormation.entites.Users;
import fr.GalileeGFormation.service.ComposanteMetier;
import fr.GalileeGFormation.service.DepartementMetier;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "nvDepartementBean")
@ViewScoped
public class NVDepartementBean implements Serializable{

    /* ---- Partie Departement ---- */
    private DepartementMetier departementMetier;
    private List<Departement> departements;
    private Departement nvDep;
    
    private final ApplicationContext bf;
    
    /* ---- Partie Responsable ---- */
    Users us= new Users();
    private UsersMetier usersMetier;
    /* Pour créer les combobox des responsables */
    private List<SelectItem> selectRes= new ArrayList<>();
    private List <Users> userList= new ArrayList<>();
    
    /* ---- Partie Secretariat ----- */
    private String secret;
    private Secretariat s= new Secretariat();
    private SecretariatMetier secretariatMetier;
    /* Pour créer la combobox des secretariats */
    private List<SelectItem> selectSec= new ArrayList<>();
    private List<Secretariat> secretList= new ArrayList<>();
    
    /* ---- Partie SuperFormation ---- */
    private SuperFormationMetier superFormationMetier;
    private List<SuperFormation> superFormations;
    
    /* ---- Partie Composante ---- */
    @Autowired
    private ComposanteMetier composanteMetier;
    private List<Composante> composantes;
    private Composante comp= new Composante();
    /* Pour créer les combobox des composantes */
    private List<SelectItem> selectComp= new ArrayList<>();
    private List <Composante> compList= new ArrayList<>();
    
    
    public NVDepartementBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        departementMetier= (DepartementMetier) bf.getBean("departementMetier");
        
        usersMetier= (UsersMetier) bf.getBean("usersMetier");
        secretariatMetier= (SecretariatMetier) bf.getBean("secretariatMetier");
        superFormationMetier= (SuperFormationMetier) bf.getBean("superFormationMetier");
        composanteMetier= (ComposanteMetier) bf.getBean("composanteMetier");
        
        nvDep= new Departement();
    }
    
    @PostConstruct
    public void init(){
        departements= departementMetier.findAll();
        composantes= composanteMetier.findAll();
    }
    
    /* ---- Setters & Getters pour Departement ---- */
    public Departement getNvDep() {
        return nvDep;
    }

    public void setNvDep(Departement nvDep) {
        this.nvDep = nvDep;
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
    /* ---- Fin Dep ---- */
    
    /* ---- Partie Secretariat ----- */
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

    /* ---- Partie User ----- */
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
            selectRes.add(new SelectItem(us, us.getFirstName()+" "+us.getLastName() ));
        }
        return selectRes;
    }
    public void setSelectRes(List<SelectItem> selectRes) {
        this.selectRes = selectRes;
    }
    /* ---- Fin User ---- */

    /* ---- Partie Composante ---- */
    public Composante getComp() {
        return comp;
    }

    public void setComp(Composante comp) {
        this.comp = comp;
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

    public List<Composante> getCompList() {
        compList= composanteMetier.findAll();
        return compList;
    }

    public void setCompList(List<Composante> compList) {
        this.compList = compList;
    }
    
    public List<SelectItem> getSelectComp() {
        selectComp.clear();
        compList= this.getCompList();
        for (Composante comp : compList) {
            selectComp.add(new SelectItem(comp, comp.getLibelle()));
        }
        return selectComp;
    }

    public void setSelectComp(List<SelectItem> selectComp) {
        this.selectComp = selectComp;
    }

    public void onAddPress(){
        s.getSecretariatId();
        us.getUsername();
        
        comp.getComposanteId();
        comp.getLibelle();
        comp.getDescription();
        comp.getDescription();
        
        
        Set<Composante> c= new HashSet<>();
//        Set<Departement> d= new HashSet<>();

        c.contains(composantes);
//        c.addAll(composantes);
//        d.add(nvDep);
//        
        nvDep.setUsers(us);
        nvDep.setSecretariat(s);
        
//        nvDep.setComposantes(c);
//        comp.setDepartements(d);
//        
        
        nvDep.setComposantes(c);
        departementMetier.save(nvDep);
        FacesMessage message= new FacesMessage("Département ajouté avec succés", "uploaded succes");
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println(nvDep);
    }
    
}
