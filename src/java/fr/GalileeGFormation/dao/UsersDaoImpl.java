package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Users;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("usersDao")
@Transactional
public class UsersDaoImpl implements UsersDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Users usr) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(usr);
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    @Override
    public void delete(Users usr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @SuppressWarnings("unchecked")
    @Override
    public Users findByUserName(String username) {
        List<Users> userList= new ArrayList<Users>();
        sessionFactory.getCurrentSession().beginTransaction();
        userList= sessionFactory.getCurrentSession().createQuery("from Users where username=?").setParameter(0, username).list();
        if (userList.size()>0) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    @Override
    public List<Users> findAll() {
        sessionFactory.getCurrentSession().beginTransaction();
        return sessionFactory.getCurrentSession().createQuery("from Users").list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void init(){
        System.out.println("--------------- UsersDaoImpl ------------");
    }

    
}
