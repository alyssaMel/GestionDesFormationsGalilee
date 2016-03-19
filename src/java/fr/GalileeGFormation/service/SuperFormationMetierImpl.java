package fr.GalileeGFormation.service;

import fr.GalileeGFormation.dao.SuperFormationDao;
import fr.GalileeGFormation.entites.SuperFormation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("superFormationMetier")
@Transactional
public class SuperFormationMetierImpl implements SuperFormationMetier{

    @Autowired
    private SuperFormationDao superFormationDao;
    
    @Override
    public void save(SuperFormation sforma) {
        superFormationDao.save(sforma);
    }

    @Override
    public void delete(SuperFormation sforma) {
        superFormationDao.delete(sforma);
    }

    @Override
    public SuperFormation findById(Integer id) {
        return superFormationDao.findById(id);
    }

    @Override
    public List<SuperFormation> findAll() {
        return superFormationDao.findAll();
    }

    @Override
    public List<SuperFormation> search(String searchString) {
        return superFormationDao.search(searchString);
    }

    public void setSuperFormationDao(SuperFormationDao superFormationDao) {
        this.superFormationDao = superFormationDao;
    }
    
    public void init(){
        System.out.println("****** SuperFormationMetierImpl ******");
    }
    
}
