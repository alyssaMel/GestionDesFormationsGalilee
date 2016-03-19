package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Cours;
import java.util.List;

public interface CoursDao {
 
    public void save(Cours cours);
    public void delete(Cours cours);
    public Cours findById(Integer id);
    public List<Cours> findAll();
    public List<Cours> search(String searchString);
}
