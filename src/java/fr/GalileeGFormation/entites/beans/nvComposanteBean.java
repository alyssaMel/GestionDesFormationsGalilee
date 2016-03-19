package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Composante;
import fr.GalileeGFormation.entites.Departement;
import fr.GalileeGFormation.entites.Secretariat;
import fr.GalileeGFormation.entites.Universite;
import fr.GalileeGFormation.entites.Users;
import fr.GalileeGFormation.service.ComposanteMetier;
import fr.GalileeGFormation.service.DepartementMetier;
import fr.GalileeGFormation.service.SecretariatMetier;
import fr.GalileeGFormation.service.UniversiteMetier;
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
@ManagedBean(name = "nvComposanteBean")
@ViewScoped
public class nvComposanteBean implements Serializable{

    private ComposanteMetier composanteMetier;
    private List<Composante> composantes;
    private Composante nvComp;
    
    private final ApplicationContext bf;
    
    /* ---- Partie Responsable ---- */
    Users us= new Users();
    @Autowired
    private UsersMetier usersMetier;
    /* Pour créer les combobox des responsables */
    private List<SelectItem> selectRes= new ArrayList<>();
    private List <Users> userList= new ArrayList<>();
    
    /* ---- Partie Secretariat ----- */
    private Secretariat s= new Secretariat();
    private List<SelectItem> selectSec= new ArrayList<>();
    private List<Secretariat> secretList= new ArrayList<>()  ;
    private SecretariatMetier secretariatMetier;
    
    /* ----- Partie Departement ---- */
    @Autowired
    private DepartementMetier departementMetier;
    private List<Departement> departements;
    
    /* ---- Partie Universite ---- */
    @Autowired
    private UniversiteMetier universiteMetier;
    private List<Universite> universites;
    private Universite univ= new Universite();
    /* Pour créer les combobox des universites */
    private List<SelectItem> selectUniv= new ArrayList<>();
    private List <Universite> univList= new ArrayList<>();
    
    public nvComposanteBean() {
        
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        composanteMetier= (ComposanteMetier) bf.getBean("composanteMetier");
        secretariatMetier= (SecretariatMetier) bf.getBean("secretariatMetier");
        departementMetier= (DepartementMetier) bf.getBean("departementMetier");
        universiteMetier= (UniversiteMetier) bf.getBean("universiteMetier");
        usersMetier= (UsersMetier) bf.getBean("usersMetier");
        
        nvComp= new Composante();
    }
    
    @PostConstruct
    public void init(){
        composantes= composanteMetier.findAll();
    }

    /* ---- Setters & Getters pour composante ---- */
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

    public Composante getNvComp() {
        return nvComp;
    }

    public void setNvComp(Composante nvComp) {
        this.nvComp = nvComp;
    }
    /* ---- Fin Comp ---- */

    /* ---- Setters & Getters pour secrétariat ---- */
    public Secretariat getS() {
        return s;
    }

    public void setS(Secretariat s) {
        this.s = s;
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
    public SecretariatMetier getSecretariatMetier() {
        return secretariatMetier;
    }

    public void setSecretariatMetier(SecretariatMetier secretariatMetier) {
        this.secretariatMetier = secretariatMetier;
    }
    /* ---- Fin Secret ---- */

    /* ---- Departements ---- */
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
    
    /* ---- Setters et Getters pour Responsable ---- */
    public Users getUs() {
        return us;
    }

    public void setUs(Users us) {
        this.us = us;
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
            selectRes.add(new SelectItem(us, us.getFirstName()+ "  "+ us.getLastName()));
        }
        return selectRes;
    }

    public void setSelectRes(List<SelectItem> selectRes) {
        this.selectRes = selectRes;
    }

    public UsersMetier getUsersMetier() {
        return usersMetier;
    }

    public void setUsersMetier(UsersMetier usersMetier) {
        this.usersMetier = usersMetier;
    }
    /* ---- Fin Responsable ---- */ 

    /* ---- Setters et Getters pour université ---- */
    public Universite getUniv(){
        return univ;
    }

    public void setUniv(Universite univ) {
        this.univ = univ;
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

    public List<Universite> getUnivList() {
        univList= universiteMetier.findAll();
        return univList;
    }

    public void setUnivList(List<Universite> univList) {
        this.univList = univList;
    }
    
    public List<SelectItem> getSelectUniv() {
        selectUniv.clear();
        univList= this.getUnivList();
        for (Universite univ : univList) {
            selectUniv.add(new SelectItem(univ, univ.getLibelle()));
        }
        return selectUniv;
    }

    public void setSelectUniv(List<SelectItem> selectUniv) {
        this.selectUniv = selectUniv;
    }
    /* ---- Fin Univ ---- */
    
    public void onAddPress() {
        // Récupérer le résponsable
        us.getUsername();
        // Récupérer le secretariat
        s.getSecretariatId();
        // Récupérer l'université
        univ.getUnivId();
        univ.getLibelle();
        univ.getAbreviation();
        univ.getDescription();
        
         // Les mettre dans la nouvelle composante
        nvComp.setSecretariat(s);
        nvComp.setUsers(us);
        
        Set<Universite> u= new HashSet<>();
        Set<Composante> c= new HashSet<>();
        
        u.add(univ);
        c.add(nvComp);
//        nvComp.setUniversites(u);
        
//        nvComp.getUniversites().add(uv);

        nvComp.setUniversites(u);
        univ.setComposantes(c);
        
        composanteMetier.save(nvComp);
        FacesMessage message= new FacesMessage("Composante ajoutée avec succés", "aploaded succ");
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println(nvComp);
        
        
//        univ.getComposantes().add(nvComp);
    }
    
}
