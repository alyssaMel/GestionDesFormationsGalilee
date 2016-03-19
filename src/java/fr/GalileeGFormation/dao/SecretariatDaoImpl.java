package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Secretariat;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("secretariatDao")
@Transactional
public class SecretariatDaoImpl implements SecretariatDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Secretariat sec) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(sec);
        sessionFactory.getCurrentSession().beginTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    public void delete(Secretariat sec) {
        sessionFactory.getCurrentSession().beginTransaction();
        // sessionFactory.getCurrentSession().delete(sec);
        Query query= sessionFactory.getCurrentSession().createQuery("DELETE Secretariat s WHERE s.secretariatId= :id");
        query.setParameter("id", sec.getSecretariatId());
        query.executeUpdate();
        
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    @Override
    public Secretariat findById(Integer id) {
        sessionFactory.getCurrentSession().beginTransaction();
        // sessionFactory.getCurrentSession().load(Secretariat.class, id);
        return (Secretariat) sessionFactory.getCurrentSession().get(Secretariat.class, id);
    }

    @Override
    public List<Secretariat> findAll() {
        sessionFactory.getCurrentSession().beginTransaction();
        return sessionFactory.getCurrentSession().createQuery("FROM Secretariat").list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void init(){
        System.out.println("****** SecretariatDaoImpl ******");
    }

    @Override
    public List<Secretariat> search(String searchString) {
        sessionFactory.getCurrentSession().beginTransaction();
        try {
            Query q= sessionFactory.getCurrentSession().createQuery("SELECT s FROM Secretariat s WHERE s.campus LIKE :searchString OR v.batiment LIKE :searchString");
            q.setParameter("searchString", searchString);
            List<Secretariat> secreList= (List<Secretariat>) q.list();
            return secreList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Secretariat>();
        }
    }
}
