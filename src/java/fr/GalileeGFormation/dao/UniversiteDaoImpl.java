package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Universite;
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
@Service("universiteDao")
@Transactional // Gestion des transactions avec les BDD
public class UniversiteDaoImpl implements UniversiteDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Universite univ) {
        sessionFactory.getCurrentSession().beginTransaction();
        // sessionFactory.getCurrentSession().persist(univ);
        sessionFactory.getCurrentSession().saveOrUpdate(univ);
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    @Override
    public void delete(Universite univ) {
        sessionFactory.getCurrentSession().beginTransaction();
        // sessionFactory.getCurrentSession().delete(univ);
        Query query= sessionFactory.getCurrentSession().createQuery("DELETE Universite u WHERE u.univId = :id");
        query.setParameter("id", univ.getUnivId());
        query.executeUpdate();
        
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    @Override
    
    public Universite finfById(Integer id) {
        sessionFactory.getCurrentSession().beginTransaction();
        //return (Universite) sessionFactory.getCurrentSession().load(Universite.class, id);
        return (Universite) sessionFactory.getCurrentSession().get(Universite.class, id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Universite> findAll() {
        sessionFactory.getCurrentSession().beginTransaction();
        return sessionFactory.getCurrentSession().createQuery("from Universite").list();
        
    }

    @Override
    public List<Universite> search(String searchString) {
        
        String rechNonSpace = searchString.replaceAll("\\s+", "");
        String parames = "1=0";
        String[] parts = searchString.split(" ");
        if (rechNonSpace.length() > 0) {
            for (int i = 0; i < parts.length; i++) {
                parames = parames + " or c.libelle LIKE :param" + i;

            }
        }
        sessionFactory.getCurrentSession().beginTransaction();
        Query query = sessionFactory.getCurrentSession().createQuery("  from Universite c where " + parames + " ");
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
        System.out.println("****** UniversiteDaoImpl ******");
    }
    
}
