package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.SuperFormation;
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
@Service("superFormationDao")
@Transactional
public class SuperFormationDaoImpl implements SuperFormationDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(SuperFormation supforma) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().saveOrUpdate(supforma);
        sessionFactory.getCurrentSession().beginTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    public void delete(SuperFormation supforma) {
        sessionFactory.getCurrentSession().beginTransaction();
        // sessionFactory.getCurrentSession().delete(supforma);
        Query query= sessionFactory.getCurrentSession().createQuery("DELETE SuperFormation sf WHERE sf.supformationId = :id");
        query.setParameter("id", supforma.getSupformationId());
        query.executeUpdate();
        
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    @Override
    public SuperFormation findById(Integer id) {
        sessionFactory.getCurrentSession().beginTransaction();
        return (SuperFormation) sessionFactory.getCurrentSession().load(SuperFormation.class, id);
        // return (SuperFormation) sessionFactory.getCurrentSession().get(SuperFormation.class, id);
    }

    @Override
    public List<SuperFormation> findAll() {
        sessionFactory.getCurrentSession().beginTransaction();
        String q= "FROM SuperFormation";
        return sessionFactory.getCurrentSession().createQuery(q).list();
    }

    @Override
    public List<SuperFormation> search(String searchString) {
        sessionFactory.getCurrentSession().beginTransaction();
        try {
            Query query= sessionFactory.getCurrentSession().createQuery("SELECT sf FROM SuperFormation sf WHERE sf.libelle LIKE :searchString OR sf.abreviation LIKE :searchString OR sf.description LIKE :searchString");
            query.setParameter("searchString", searchString);
            List<SuperFormation> supFList= (List<SuperFormation>) query.list();
            return supFList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<SuperFormation>();
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void init(){
        System.out.println("****** SuperFormationDao ******");
    }
}
