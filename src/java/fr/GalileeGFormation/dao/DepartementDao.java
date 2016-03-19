package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Departement;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface DepartementDao {
 
    public void save(Departement dep);
    public void delete(Departement dep);
    public Departement findById(Integer id);
    public List<Departement> findAll();
    public List<Departement> search (String searchString);
    
}
