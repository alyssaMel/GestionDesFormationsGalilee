/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Composante;
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
@Service("composanteDao")
@Transactional
public class ComposanteDaoImpl implements ComposanteDao{

    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void save(Composante comp) {
        sessionFactory.getCurrentSession().beginTransaction();
        sessionFactory.getCurrentSession().save(comp);
        sessionFactory.getCurrentSession().beginTransaction().commit();
        sessionFactory.getCurrentSession().close();
    }

    @Override
    public void delete(Composante comp) {
        sessionFactory.getCurrentSession().beginTransaction();
        
        // sessionFactory.getCurrentSession().delete(comp);
        Query query= sessionFactory.getCurrentSession().createQuery("DELETE Composante c WHERE c.composanteId = :id ");
        query.setParameter("id", comp.getComposanteId());
        query.executeUpdate();
        
        sessionFactory.getCurrentSession().beginTransaction().commit();
    }

    @Override
    public Composante findById(Integer id) {
        sessionFactory.getCurrentSession().beginTransaction();
        return (Composante) sessionFactory.getCurrentSession().load(Composante.class, id);
        // return (Composante) sessionFactory.getCurrentSession().get(Composante.class, id);
    }

    @Override
    public List<Composante> findAll() {
        sessionFactory.getCurrentSession().beginTransaction();
        String q= "FROM Composante";
        
        return sessionFactory.getCurrentSession().createQuery(q).list();
    }

    @Override
    public List<Composante> search(String searchString) {
        
        String[] parts = searchString.split(" ");
        String parames="1=1";
        for (int i = 0; i < parts.length; i++) {
              parames=parames+" and c.libelle LIKE :param"+i;
            
        }
         sessionFactory.getCurrentSession().beginTransaction();
        Query query = sessionFactory.getCurrentSession().createQuery("  from Composante c where "+parames);
       for (int i = 0; i < parts.length; i++) {
            
           query.setParameter("param"+i,parts[i]);
            
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
        System.out.println("****** ComposanteDaoImpl ******");
    }
}
