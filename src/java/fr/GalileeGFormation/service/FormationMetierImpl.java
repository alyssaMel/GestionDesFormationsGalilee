/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.GalileeGFormation.service;

import fr.GalileeGFormation.dao.FormationDao;
import fr.GalileeGFormation.entites.Formation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author alyssa
 */
@Service("formationMetier")
@Transactional
public class FormationMetierImpl implements FormationMetier{

    @Autowired
    private FormationDao formationDao;
    
    @Override
    public void save(Formation form) {
        formationDao.save(form);
    }

    @Override
    public void delete(Formation form) {
        formationDao.delete(form);
    }

    @Override
    public Formation findById(Integer id) {
        return formationDao.findById(id);
    }

    @Override
    public List<Formation> findAll() {
        return formationDao.findAll();
    }

    @Override
    public List<Formation> search(String searchString) {
        return formationDao.search(searchString);
    }

    public void setFormationDao(FormationDao formationDao) {
        this.formationDao = formationDao;
    }
    
    public void init(){
        System.out.println("****** FormationMetierImpl ******");
    }
}
