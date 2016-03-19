package fr.GalileeGFormation.service;

import fr.GalileeGFormation.dao.ComposanteDao;
import fr.GalileeGFormation.entites.Composante;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("composanteMetier")
@Transactional
public class ComposanteMetierImpl implements ComposanteMetier{

    @Autowired
    private ComposanteDao composanteDao;
    
    @Override
    public void save(Composante comp) {
        composanteDao.save(comp);
    }

    @Override
    public void delete(Composante comp) {
        composanteDao.delete(comp);
    }

    @Override
    public Composante findById(Integer id) {
        return composanteDao.findById(id);
    }

    @Override
    public List<Composante> findAll() {
        return composanteDao.findAll();
    }

    @Override
    public List<Composante> search(String searchString) {
        return composanteDao.search(searchString);
    }

    public void setComposanteDao(ComposanteDao composanteDao) {
        this.composanteDao = composanteDao;
    }
    
    public void init(){
        System.out.println("****** ComposanteMetierImpl ******");
    }
}
