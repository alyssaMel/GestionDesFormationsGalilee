package fr.GalileeGFormation.service;

import fr.GalileeGFormation.dao.DepartementDao;
import fr.GalileeGFormation.entites.Departement;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("departementMetier")
@Transactional
public class DepartementMetierImpl implements DepartementMetier{

    @Autowired
    private DepartementDao departementDao;
    
    @Override
    public void save(Departement dep) {
        departementDao.save(dep);
    }

    @Override
    public void delete(Departement dep) {
        departementDao.delete(dep);
    }

    @Override
    public Departement findById(Integer id) {
        return departementDao.findById(id);
    }

    @Override
    public List<Departement> findAll() {
        return departementDao.findAll();
    }

    @Override
    public List<Departement> search(String searchString) {
        return departementDao.search(searchString);
    }

    public void setDepartementDao(DepartementDao departementDao) {
        this.departementDao = departementDao;
    }
    
    public void init(){
        System.out.println("****** DepartementMetierImpl ******");
    }
    
}
