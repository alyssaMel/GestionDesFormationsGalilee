package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Universite;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface UniversiteDao {
 
    public void save(Universite univ);
    public void delete(Universite univ);
    public Universite finfById(Integer id);
    public List<Universite> findAll();
    public List<Universite> search(String searchString);
    
}
