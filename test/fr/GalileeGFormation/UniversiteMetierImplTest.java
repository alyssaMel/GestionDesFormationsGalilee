/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GalileeGFormation.service;

import fr.GalileeGFormation.dao.UniversiteDao;
import fr.GalileeGFormation.entites.Universite;
import java.util.List;
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
public class UniversiteMetierImplTest {
    
    public static ClassPathXmlApplicationContext context;
    public static UniversiteMetier universiteMetier;
    
    public UniversiteMetierImplTest() {
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        universiteMetier = (UniversiteMetier) context.getBean("universiteMetier");
    }
    
    @BeforeClass
    public static void setUpClass() {
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
        System.out.println("save");
        Universite univ = null;
        UniversiteMetierImpl instance = new UniversiteMetierImpl();
        instance.save(univ);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testDelete() {
        System.out.println("delete");
        Universite univ = null;
        UniversiteMetierImpl instance = new UniversiteMetierImpl();
        instance.delete(univ);
        fail("The test case is a prototype.");
    }

    //@Test
    public void testFindById() {
        System.out.println("findById");
        Integer id = null;
        UniversiteMetierImpl instance = new UniversiteMetierImpl();
        Universite expResult = null;
        Universite result = instance.findById(id);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testFindAll() {
        System.out.println("Rechercher TOUS");
        List<Universite> allUniv= universiteMetier.findAll();
        
        assertNotNull(allUniv);
        assertTrue(allUniv.size()>0);
        System.out.println(allUniv);
    }

    //@Test
    public void testSearch() {
        System.out.println("search");
        String searchString = "";
        UniversiteMetierImpl instance = new UniversiteMetierImpl();
        List<Universite> expResult = null;
        List<Universite> result = instance.search(searchString);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    
}
