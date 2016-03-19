package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Secretariat;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface SecretariatDao {
 
    public void save(Secretariat sec);
    public void delete(Secretariat sec);
    public Secretariat findById(Integer id);
    public List<Secretariat> findAll(); 
    public List<Secretariat> search(String searchString);
}
