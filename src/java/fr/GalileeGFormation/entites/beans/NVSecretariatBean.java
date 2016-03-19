package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Secretariat;
import fr.GalileeGFormation.service.SecretariatMetier;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "nvSecretariatBean")
@SessionScoped
public class NVSecretariatBean implements Serializable{

    private SecretariatMetier secretariatMetier;
    private List<Secretariat> secretariats;
    private Secretariat nvsecretariat;
    
    private final ApplicationContext bf;
    
    public NVSecretariatBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        secretariatMetier= (SecretariatMetier) bf.getBean("secretariatMetier");
        nvsecretariat= new Secretariat();
    }
    
    @PostConstruct
    public void init(){
        secretariats= secretariatMetier.findAll();
    }

    public SecretariatMetier getSecretariatMetier() {
        return secretariatMetier;
    }

    public void setSecretariatMetier(SecretariatMetier secretariatMetier) {
        this.secretariatMetier = secretariatMetier;
    }

    public List<Secretariat> getSecretariats() {
        return secretariats;
    }

    public void setSecretariats(List<Secretariat> secretariats) {
        this.secretariats = secretariats;
    }

    public Secretariat getNvsecretariat() {
        return nvsecretariat;
    }

    public void setNvsecretariat(Secretariat nvsecretariat) {
        this.nvsecretariat = nvsecretariat;
    }

    public void onPress(){
        secretariatMetier.save(nvsecretariat);
//        return "nvUniversite.jsf?faces-redirect=true";
    }
}
