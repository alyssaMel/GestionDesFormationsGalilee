package fr.GalileeGFormation.service;

import fr.GalileeGFormation.dao.UniversiteDao;
import fr.GalileeGFormation.entites.Universite;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("universiteMetier")
@Transactional
public class UniversiteMetierImpl implements UniversiteMetier{

    @Autowired
    private UniversiteDao universiteDao;
    
    @Override
    @Secured(value = {"ROLE_ADMIN"})
    public void save(Universite univ) {
        universiteDao.save(univ);
    }

    @Override
    public void delete(Universite univ) {
        universiteDao.delete(univ);
    }

    @Override
    public Universite findById(Integer id) {
        return universiteDao.finfById(id);
    }

    @Override
    public List<Universite> findAll() {
        return universiteDao.findAll();
    }

    @Override
    public List<Universite> search(String searchString) {
        return universiteDao.search(searchString);
    }

    public void setUniversiteDao(UniversiteDao universiteDao) {
        this.universiteDao = universiteDao;
    }

    public UniversiteDao getUniversiteDao() {
        return universiteDao;
    }
    
    public void init(){
        System.out.println("****** UniversiteMetierImpl ******");
    }

    
}
