package fr.GalileeGFormation.service;

import fr.GalileeGFormation.entites.Universite;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface UniversiteMetier {
    
    public void save(Universite univ);
    public void delete(Universite univ);
    public Universite findById(Integer id);
    public List<Universite> findAll();
    public List<Universite> search(String searchString);
}
