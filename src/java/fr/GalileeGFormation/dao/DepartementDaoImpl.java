package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Departement;
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
@Service("departementDao")
@Transactional
public class DepartementDaoImpl implements DepartementDao{

    @Autowired
    private SessionFactory sessionFactory; 
    
    @Override
    public void save(Departement dep) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(dep);
        sessionFactory.getCurrentSession().beginTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    public void delete(Departement dep) {
        sessionFactory.getCurrentSession().beginTransaction();
        // sessionFactory.getCurrentSession().delete(dep);
        
        Query query= sessionFactory.getCurrentSession().createQuery("DELETE Departement d WHERE d.departementId = :id");
        query.setParameter("id", dep.getDepartementId());
        query.executeUpdate();
        
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    @Override
    public Departement findById(Integer id) {
        sessionFactory.getCurrentSession().beginTransaction();
        return (Departement) sessionFactory.getCurrentSession().load(Departement.class, id);
        // return (Departement) sessionFactory.getCurrentSession().get(Departement.class, id);
    }

    @Override
    public List<Departement> findAll() {
        sessionFactory.getCurrentSession().beginTransaction();
        String query= "FROM Departement";
        return sessionFactory.getCurrentSession().createQuery(query).list();
    }

    @Override
    public List<Departement> search(String searchString) {
        String searchNoSpace= searchString.replaceAll("\\s+", "");
        String params= "1=0";
        String [] parts= searchString.split(" ");
        if (searchNoSpace.length()> 0) {
            for (int i = 0; i < parts.length; i++) {
                params= params+" or d.description LIKE :param"+i;
            }
        }
        sessionFactory.getCurrentSession().beginTransaction();
        Query q= sessionFactory.getCurrentSession().createQuery("  FROM Departement d WHERE "+params);
        if (searchNoSpace.length()> 0) {
            for (int i = 0; i < parts.length; i++) {
                q.setParameter("param" + i, "%" + parts[i] + "%");
            }
        }
        return q.list();
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public void init(){
        System.out.println("****** DepartementDao ******");
    }
}
