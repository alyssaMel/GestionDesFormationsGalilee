package fr.GalileeGFormation.service;

import fr.GalileeGFormation.entites.Formation;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface FormationMetier {

    public void save(Formation form);
    public void delete(Formation form);
    public Formation findById(Integer id);
    public List<Formation> findAll();
    public List<Formation> search(String searchString);
}
