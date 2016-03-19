package fr.GalileeGFormation.service;

import fr.GalileeGFormation.entites.Cours;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface CoursMetier {
    
    public void save(Cours cours);
    public void delete(Cours cours);
    public Cours findById(Integer id);
    public List<Cours> findAll();
    public List<Cours> search(String searchString);
}
