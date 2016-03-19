package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Users;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface UsersDao {
    
    public void save(Users usr);
    public void delete(Users usr);
    public Users findByUserName(String username);
    public List<Users> findAll();
    
}
