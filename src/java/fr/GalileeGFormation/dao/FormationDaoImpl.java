package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Formation;
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
@Service("formationDao")
@Transactional
public class FormationDaoImpl implements FormationDao{

    @Autowired
    private SessionFactory sessionFactory; 
    
    @Override
    public void save(Formation form) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(form);
        sessionFactory.getCurrentSession().beginTransaction().commit();
        sessionFactory.getCurrentSession().close();
        
    }

    @Override
    public void delete(Formation form) {
        sessionFactory.getCurrentSession().beginTransaction();
        // sessionFactory.getCurrentSession().delete(form);
        
        Query query= sessionFactory.getCurrentSession().createQuery("DELETE Formation f WHERE f.formationId = id");
        query.setParameter("id", form.getFormationId());
        query.executeUpdate();
        
        sessionFactory.getCurrentSession().beginTransaction().commit();;
    }

    @Override
    public Formation findById(Integer id) {
        sessionFactory.getCurrentSession().beginTransaction();
        return (Formation) sessionFactory.getCurrentSession().load(Formation.class, id);
        // return (Formation) sessionFactory.getCurrentSession().get(Formation.class, id);
    }

    @Override
    public List<Formation> findAll() {
        sessionFactory.getCurrentSession().beginTransaction();
        String q= "FROM Formation";
        return sessionFactory.getCurrentSession().createQuery(q).list();
    }

    @Override
    public List<Formation> search(String searchString) {
        String rechNonSpace = searchString.replaceAll("\\s+", "");
        String parames = "1=0";
        String[] parts = searchString.split(" ");
        if (rechNonSpace.length() > 0) {
            for (int i = 0; i < parts.length; i++) {
                parames = parames + " or f.libelle LIKE :param" + i;

            }
        }
        sessionFactory.getCurrentSession().beginTransaction();
        Query query = sessionFactory.getCurrentSession().createQuery("  from Formation f where " + parames + " ");
        if (rechNonSpace.length() > 0) {
            for (int i = 0; i < parts.length; i++) {

                query.setParameter("param" + i, "%" + parts[i] + "%");
            }
        }
        return query.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void init(){
        System.out.println("****** FormationDaoImpl *******");
    }
}
