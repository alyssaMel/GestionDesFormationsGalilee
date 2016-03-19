package fr.GalileeGFormation.entites.beans;

import fr.GalileeGFormation.entites.Role;
import fr.GalileeGFormation.entites.Universite;
import fr.GalileeGFormation.entites.Users;
import fr.GalileeGFormation.service.UniversiteMetier;
import fr.GalileeGFormation.service.UsersMetier;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
@ManagedBean(name = "nvCompteBean")
@RequestScoped
public class NVCompteBean implements Serializable{

    
    private UniversiteMetier universiteMetier;
    private List<Universite> universites;
    
    private ApplicationContext bf;
    
    private Users nvUser;
    
    @Autowired
    private UsersMetier usersMetier;
    
    public NVCompteBean() {
        bf= new ClassPathXmlApplicationContext("applicationContext.xml");
        universiteMetier= (UniversiteMetier) bf.getBean("universiteMetier");
        usersMetier= (UsersMetier) bf.getBean("usersMetier");
        nvUser= new Users();
    }
    
    @PostConstruct
    public void init(){
        universites= universiteMetier.findAll();
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

    public Users getNvUser() {
        return nvUser;
    }

    public void setNvUser(Users nvUser) {
        this.nvUser = nvUser;
    }

    public UsersMetier getUsersMetier() {
        return usersMetier;
    }

    public void setUsersMetier(UsersMetier usersMetier) {
        this.usersMetier = usersMetier;
    }
    
    public int sizeOfList(Set t) {
        if (t != null) {
            return t.size();
        } else {
            return 0;
        }
    }
    
    public void onAddPress(){
        nvUser.setStatus("ACTIVE");
        nvUser.setEnabled(true);
        System.out.println("enregistrer---------------");
        Role role= new Role();
        // Attribuer le role simple_user au nouvel utilisateur cree
        role.setRole("ROLE_USER");
        Set<Role> r= new HashSet<>();
        r.add(role);
        nvUser.setRoles(r);
        usersMetier.save(nvUser);
        FacesMessage message= new FacesMessage("Compte créé avec succés");
        FacesContext.getCurrentInstance().addMessage(null, message);
        System.out.println(nvUser);
    }
    
}
