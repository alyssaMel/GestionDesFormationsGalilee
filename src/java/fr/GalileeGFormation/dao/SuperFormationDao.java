package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.SuperFormation;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface SuperFormationDao {
    
    public void save(SuperFormation supforma);
    public void delete(SuperFormation supforma);
    public SuperFormation findById(Integer id);
    public List<SuperFormation> findAll();
    public List<SuperFormation> search(String searchString);
}
