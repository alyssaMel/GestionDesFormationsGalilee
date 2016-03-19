package fr.GalileeGFormation.service;

import fr.GalileeGFormation.entites.SuperFormation;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface SuperFormationMetier {

    public void save(SuperFormation sforma);
    public void delete(SuperFormation sforma);
    public SuperFormation findById(Integer id);
    public List<SuperFormation> findAll();
    public List<SuperFormation> search(String searchString);
}
