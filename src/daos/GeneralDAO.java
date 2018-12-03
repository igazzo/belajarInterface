/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Job;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ignatius
 */
public class GeneralDAO implements DAOInterface {

    private FunctionDAO fdao;

    public GeneralDAO(SessionFactory factory) {
        this.fdao = new FunctionDAO(factory);
    }

    /**
     * method for insert, update, or delete
     *
     * @param object
     * @param isDelete
     * @return
     */
    @Override
    public boolean doDML(Object object, boolean isDelete) {
        return this.fdao.insertOrUpdateOrDelete(object, isDelete);
    }

    @Override
    public List<Object> doDDL(Object entity, String keyword) {
        
        
        
//        String query = "";
//        if (table.equals("Department")) {
//            query = "FROM Department where department_id LIKE '%" + keyword + "%'"
//                    + "OR department_name LIKE '%" + keyword + "%'"
//                    + "OR manager_id LIKE '%" + keyword + "%'"
//                    + "OR location_id LIKE '&" + keyword + "%'";
//        } else if (table.equals("Region")) {
//            query = "FROM Region where region_id LIKE '%" + keyword + "%'"
//                    + "OR region_name LIKE '%" + keyword + "%'";
//        } else if (table.equals("Employee")) {
//            query = "FROM Employee where employee_id LIKE '%" + keyword + "%'"
//                    + "OR first_name LIKE '%" + keyword + "%'"
//                    + "OR last_name LIKE '&" + keyword + "%'"
//                    + "OR email LIKE '%" + keyword + "%'"
//                    + "OR phone_number LIKE '%" + keyword + "%'"
//                    + "OR hire_date LIKE '%" + keyword + "%'"
//                    + "OR salary LIKE '%" + keyword + "%'"
//                    + "OR commission_pct LIKE '%" + keyword + "%'"
//                    + "OR ";
//    }
        return this.fdao.getData(entity, keyword);
    }

    @Override
    public Object getById(Object entity, Object jobId) {
        return this.fdao.getById(entity, jobId);
    }

}
