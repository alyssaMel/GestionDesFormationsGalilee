package fr.GalileeGFormation.service;

import fr.GalileeGFormation.dao.UsersDao;
import fr.GalileeGFormation.entites.Users;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("UsersMetier")
@Transactional
public class UsersMetierImpl implements UsersMetier{

    @Autowired
    private UsersDao usersDao;
    
    @Override
    public void save(Users usr) {
        usersDao.save(usr);
    }

    @Override
    public void delete(Users usr) {
        usersDao.delete(usr);
    }

    @Override
    public Users findByUserName(String username) {
        return usersDao.findByUserName(username);
    }

    @Override
    public List<Users> findAll() {
        return usersDao.findAll();
    }
    
        public UsersDao getUsersDao() {
        return usersDao;
    }

    public void setUsersDao(UsersDao usersDao) {
        this.usersDao = usersDao;
    }
    
    public void init(){
        System.out.println("---------- UsersMetierImpl ---------");
    }

    

}
