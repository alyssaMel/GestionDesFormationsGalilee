package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Composante;
import java.util.List;

public interface ComposanteDao {
    
    public void save(Composante comp);
    public void delete(Composante comp);
    public Composante findById(Integer id);
    public List<Composante> findAll();
    public List<Composante> search(String searchString);
}
