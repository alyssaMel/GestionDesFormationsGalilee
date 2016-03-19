package fr.GalileeGFormation.service;

import fr.GalileeGFormation.dao.SecretariatDao;
import fr.GalileeGFormation.entites.Secretariat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("secretariatMetier")
@Transactional
public class SecretariatMetierImpl implements SecretariatMetier{

    @Autowired
    private SecretariatDao secretariatDao;
    
    @Override
    public void save(Secretariat sec) {
        secretariatDao.save(sec);
    }

    @Override
    public void delete(Secretariat sec) {
        secretariatDao.delete(sec);
    }

    @Override
    public Secretariat findById(Integer id) {
        return secretariatDao.findById(id);
    }

    @Override
    public List<Secretariat> findAll() {
        return secretariatDao.findAll();
    }

    public SecretariatDao getSecretariatDao() {
        return secretariatDao;
    }

    public void setSecretariatDao(SecretariatDao secretariatDao) {
        this.secretariatDao = secretariatDao;
    }
    
    public void init(){
        System.out.println("****** SecretariatMetierImpl ******");
    }

    @Override
    public List<Secretariat> search(String searchString) {
        return secretariatDao.search(searchString);
    }
}
