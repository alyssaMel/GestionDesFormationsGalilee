/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GalileeGFormation.dao;

import fr.GalileeGFormation.entites.Universite;
import java.util.List;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author alyssa
 */
public class UniversiteDaoImplTest {
    
    public static ClassPathXmlApplicationContext context;
    public static UniversiteDao universiteDao;
    
    public UniversiteDaoImplTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        context= new ClassPathXmlApplicationContext("applicationContext.xml");
        universiteDao= (UniversiteDao) context.getBean("universiteDao");    
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //@Test
    public void testSave() {
        System.out.println("****Sauvegarder une universite*****");
        Universite univ = new Universite("univ Paris13", "P13","");
        universiteDao.save(univ);
        assertNotNull(univ.getUnivId());
        System.out.println("id universite: "+univ.getUnivId());
    }

    //@Test
    public void testDelete() {
        System.out.println("****Supprimer une universite****");
        Universite univ = new Universite();
        univ.setUnivId(3);
        universiteDao.delete(univ);
    }

    @Test
    public void testFinfById() {
        System.out.println("****Recherche par ID****");
        Universite univ= universiteDao.finfById(3);
        assertNotNull(univ);
        assertEquals(3, univ.getUnivId().intValue());
        System.out.println(univ);
    }

    //@Test
    public void testFindAll() {
        System.out.println("****Rechercher toutes les universites****");
        
        List<Universite> allUniv= universiteDao.findAll();
        assertNotNull(allUniv);
        assertTrue(allUniv.size()> 0);
        System.out.println("universite: " +allUniv);
    }

    //@Test
    public void testSearch() {
        System.out.println("search");
        String searchString = "";
        UniversiteDaoImpl instance = new UniversiteDaoImpl();
        List<Universite> expResult = null;
        List<Universite> result = instance.search(searchString);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    

    
}
