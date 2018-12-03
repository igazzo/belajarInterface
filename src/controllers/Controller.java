/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.GeneralDAO;
import entities.Job;
import entities.Region;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.SessionFactory;
import tools.ControllerInterface;

/**
 *
 * @author Igaz
 */
public class Controller implements ControllerInterface{

    private SessionFactory factory;
    private GeneralDAO gdao;

    public Controller(SessionFactory factory) {
        this.factory = factory;
        this.gdao = new GeneralDAO(factory);
    }

    @Override
    public boolean insertOrUpdateOrDelete(Object object, boolean isDelete) {
        return gdao.doDML(object, isDelete);
    }

    @Override
    public List<Object> getAllData(Object entity, String keyword) {
        List<Object> data = new ArrayList<>();
        data = gdao.doDDL(entity, keyword);
        return data;
    }

    @Override
    public Object getById(Object entity, Object jobId) {
        return gdao.getById(entity, jobId);
    }

    @Override
    public boolean insertData(Region region) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateData(Region region) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteData(Region region) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
