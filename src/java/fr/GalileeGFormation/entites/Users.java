package fr.GalileeGFormation.entites;
// Generated 9 mars 2016 21:41:37 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Users generated by hbm2java
 */
@Entity
@Table(name="users"
    ,catalog="formation_db"
)
public class Users  implements java.io.Serializable {


     private String username;
     private String password;
     private boolean enabled;
     private String firstName;
     private String lastName;
     private String telephone;
     private String email;
     private String status;
     private Set<Cours> courses = new HashSet<Cours>(0);
     private Set<Composante> composantes = new HashSet<Composante>(0);
     private Set<Role> roles = new HashSet<Role>(0);
     private Set<Universite> universites = new HashSet<Universite>(0);
     private Set<Formation> formations = new HashSet<Formation>(0);
     private Set<SuperFormation> superFormations = new HashSet<SuperFormation>(0);
     private Set<Departement> departements = new HashSet<Departement>(0);

    public Users() {
    }

    public Users(String username, String password, boolean enabled, String firstName, String lastName, String telephone, String email, String status) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.firstName = firstName;
        this.lastName = lastName;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
    }

    public Users(String username, String password, boolean enabled) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
    }

    public Users(String username, String password, boolean enabled,Set<Role> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }
    
    
    public Users(String username, String password, boolean enabled, String firstName, String lastName, String telephone, String email, String status, Set<Cours> courses, Set<Composante> composantes, Set<Role> roles, Set<Universite> universites, Set<Formation> formations, Set<SuperFormation> superFormations, Set<Departement> departements) {
       this.username = username;
       this.password = password;
       this.enabled = enabled;
       this.firstName = firstName;
       this.lastName = lastName;
       this.telephone = telephone;
       this.email = email;
       this.status = status;
       this.courses = courses;
       this.composantes = composantes;
       this.roles = roles;
       this.universites = universites;
       this.formations = formations;
       this.superFormations = superFormations;
       this.departements = departements;
    }
   
     @Id 

    
    @Column(name="username", unique=true, nullable=false, length=45)
    public String getUsername() {
        return this.username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    
    @Column(name="password", nullable=false, length=60)
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    
    @Column(name="enabled", nullable=false)
    public boolean isEnabled() {
        return this.enabled;
    }
    
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    
    @Column(name="first_name", length=70)
    public String getFirstName() {
        return this.firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    
    @Column(name="last_name", length=45)
    public String getLastName() {
        return this.lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    
    @Column(name="telephone", length=45)
    public String getTelephone() {
        return this.telephone;
    }
    
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    
    @Column(name="email", length=75)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="status", length=45)
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<Cours> getCourses() {
        return this.courses;
    }
    
    public void setCourses(Set<Cours> courses) {
        this.courses = courses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<Composante> getComposantes() {
        return this.composantes;
    }
    
    public void setComposantes(Set<Composante> composantes) {
        this.composantes = composantes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<Role> getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<Universite> getUniversites() {
        return this.universites;
    }
    
    public void setUniversites(Set<Universite> universites) {
        this.universites = universites;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<Formation> getFormations() {
        return this.formations;
    }
    
    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<SuperFormation> getSuperFormations() {
        return this.superFormations;
    }
    
    public void setSuperFormations(Set<SuperFormation> superFormations) {
        this.superFormations = superFormations;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="users")
    public Set<Departement> getDepartements() {
        return this.departements;
    }
    
    public void setDepartements(Set<Departement> departements) {
        this.departements = departements;
    }

    @Override
    public String toString() {
        return "Users{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }

    
}


