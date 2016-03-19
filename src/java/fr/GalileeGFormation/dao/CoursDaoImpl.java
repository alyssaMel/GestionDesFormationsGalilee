package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Cours;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service("coursDao")
@Transactional
public class CoursDaoImpl implements CoursDao{

    @Autowired
    private SessionFactory sessionFactory;
    private Cours cours;
    
    @Override
    public void save(Cours cours) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(cours);
        sessionFactory.getCurrentSession().beginTransaction().commit();
        sessionFactory.getCurrentSession().close();
        
    }

    @Override
    public void delete(Cours cours) {
        sessionFactory.getCurrentSession().beginTransaction();

        cours.getFormations().clear();
//        sessionFactory.getCurrentSession().delete(cours);
        Query query= sessionFactory.getCurrentSession().createQuery("DELETE Cours c WHERE c.coursId = :id");
        query.setParameter("id", cours.getCoursId());
        query.executeUpdate();
        
        sessionFactory.getCurrentSession().beginTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    public Cours findById(Integer id) {
        sessionFactory.getCurrentSession().beginTransaction();
        return (Cours) sessionFactory.getCurrentSession().load(Cours.class, id);
        // return (Cours) sessionFactory.getCurrentSession().get(Cours.class, id);
    }

    @Override
    public List<Cours> findAll() {
        sessionFactory.getCurrentSession().beginTransaction();
        String q= "FROM Cours";
        return sessionFactory.getCurrentSession().createQuery(q).list();
    }

    @Override
    public List<Cours> search(String searchString) {
        sessionFactory.getCurrentSession().beginTransaction();
        try {
            Query query= sessionFactory.getCurrentSession().createQuery("SELECT c FROM Cours c WHERE c.libelle LIKE :searchString OR c.abreviation LIKE :searchString OR c.description LIKE :searchString");
            query.setParameter("searchString", searchString);
            List<Cours> coursList= (List < Cours >) query.list();
            return coursList;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Cours>();
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void init(){
        System.out.println("****** CoursDao ******");
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
    
    
}
