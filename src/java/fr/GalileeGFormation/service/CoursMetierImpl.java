package fr.GalileeGFormation.service;

import fr.GalileeGFormation.dao.CoursDao;
import fr.GalileeGFormation.entites.Cours;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("coursMetier")
@Transactional
public class CoursMetierImpl implements CoursMetier{

    @Autowired
    private CoursDao coursDao;
    
    @Override
    public void save(Cours cours) {
        coursDao.save(cours);
    }

    @Override
    public void delete(Cours cours) {
        coursDao.delete(cours);
    }

    @Override
    public Cours findById(Integer id) {
        return coursDao.findById(id);
    }

    @Override
    public List<Cours> findAll() {
        return coursDao.findAll();
    }

    @Override
    public List<Cours> search(String searchString) {
        return coursDao.search(searchString);
    }

    public void setCoursDao(CoursDao coursDao) {
        this.coursDao = coursDao;
    }
    
    public void init(){
        System.out.println("****** CoursMetierImpl ******");
    }
}
