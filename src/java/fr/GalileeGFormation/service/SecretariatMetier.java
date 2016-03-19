package fr.GalileeGFormation.service;

import fr.GalileeGFormation.entites.Secretariat;
import java.util.List;

/**
 *
 * @author alyssa
 */
public interface SecretariatMetier {

    public void save(Secretariat sec);
    public void delete(Secretariat sec);
    public Secretariat findById(Integer id);
    public List<Secretariat> findAll();
    public List<Secretariat> search(String searchString);
}
