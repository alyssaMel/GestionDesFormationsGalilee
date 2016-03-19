package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Composante;
import fr.GalileeGFormation.entites.Secretariat;
import fr.GalileeGFormation.entites.Universite;
import fr.GalileeGFormation.entites.Users;
import fr.GalileeGFormation.service.ComposanteMetier;
import fr.GalileeGFormation.service.SecretariatMetier;
import fr.GalileeGFormation.service.UniversiteMetier;
import fr.GalileeGFormation.service.UsersMetier;
import java.io.File;
import java.io.FileInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.primefaces.model.UploadedFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "nvUniversiteBean")
@ViewScoped
public class NVUniversiteBean implements Serializable{

    /* ---- Partie Universite ---- */
    private UniversiteMetier universiteMetier;
    private List<Universite> universites;
    private Universite nvUniv;
    
    private final ApplicationContext bf;
    
    /* ---- Partie Responsable ---- */
    private Users us= new Users();
    private UsersMetier usersMetier;
     /* Pour créer les combobox des responsables */
    private List<SelectItem> selectRes= new ArrayList<SelectItem>();
    private List <Users> userList= new ArrayList<Users>();
    
    
    /* ---- Partie Secretariat ----- */
    private String secret;
    private Secretariat s= new Secretariat();
    private final SecretariatMetier secretariatMetier;
    /* Pour créer la combobox des secretariats */
    private List<SelectItem> selectSec= new ArrayList<>();
    private List<Secretariat> secretList= new ArrayList<>()  ;
    
    /* ---- Partie Composante ---- */
    @Autowired
    private ComposanteMetier composanteMetier;
    private List<Composante> composantes;
    
    private UploadedFile file;
    
    public NVUniversiteBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        universiteMetier= (UniversiteMetier) bf.getBean("universiteMetier");
        secretariatMetier= (SecretariatMetier) bf.getBean("secretariatMetier");
        usersMetier= (UsersMetier) bf.getBean("usersMetier");
        nvUniv= new Universite();
        
    }
    
    @PostConstruct
    public void init(){
        universites= universiteMetier.findAll();
    }

    public Universite getNvUniv() {
        return nvUniv;
    }

    public void setNvUniv(Universite nvUniv) {
        this.nvUniv = nvUniv;
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
        return composantes;
    }

    public void setComposantes(List<Composante> composantes) {
        this.composantes = composantes;
    }

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
//        selectSec.add(new SelectItem(null, "Choisir une secrétariat"));
        for (Secretariat s  : secretList) {
            selectSec.add(new SelectItem(s, s.getCampus()));
        }
//        for (Secretariat se  : secretariatMetier.findAll()) {
//            selectSec.add(new SelectItem(se, se.getCampus()));
//        }
        
        return selectSec;
    }

    public void setSelectSec(List<SelectItem> selectSec) {
        this.selectSec= selectSec;
    }

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
            selectRes.add(new SelectItem(us, us.getFirstName()+" "+us.getLastName()));
        }
        return selectRes;
    }

    public void setSelectRes(List<SelectItem> selectRes) {
        this.selectRes = selectRes;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    
    public void onAddPres(){
//        s.setSecretariatId(1);
//        s.setCampus("Galilee");
        /* Récupérer l'id du secretariat de la combobox */
        s.getSecretariatId();
//        s.getCampus();
//        s.getBatiment();
        
        /* Récupérer l'id du responsable de la combobox*/
        us.getUsername();
        
        nvUniv.setUsers(us);
//        secretariatMetier.save(s);
        nvUniv.setSecretariat(s);
        
        
        File file= new File("C:\\Users\\alyssa\\Desktop\\images projet\\logoParis13.jpg");
        byte[] bfile= new byte[(int) file.length()];
        
        try {
            FileInputStream fileInputStream= new FileInputStream(file);
            // Convert file into array of bytes
            fileInputStream.read(bfile);
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        nvUniv.setDocument(bfile);
        
        
        universiteMetier.save(nvUniv);
        FacesMessage message= new FacesMessage("Université ajoutée avec succés", "aploaded succ");
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println(nvUniv);
//        return "index.jsf?faces-redirect=true";
    }
    
}
