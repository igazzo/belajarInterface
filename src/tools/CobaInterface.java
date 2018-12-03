/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.Controller;
import daos.DAOInterface;
import daos.GeneralDAO;
import entities.Department;
import entities.Job;
import entities.Login;
import entities.Region;
import java.math.BigDecimal;
import org.hibernate.SessionFactory;

/**
 *
 * @author Igaz
 */
public class CobaInterface {

    /**
     * @param args the command line arguments
     */
    private String hashPassword(String plainTextPassword){
    return BCrypt.hashpw(plainTextPassword, BCrypt.gensalt());
}
    
    private void checkPass(String plainPassword, String hashedPassword){
        if (BCrypt.checkpw(plainPassword, hashedPassword)) {
            System.out.println("Matches!");
        } else {
            System.out.println("doesnt match");
        }
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        junit.textui.TestRunner.run(TestBCrypt.class);
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        DAOInterface gdao = new GeneralDAO(sessionFactory);
        Controller rc = new Controller(sessionFactory);

//        Region region = new Region(new BigDecimal(5), "Baltic");
//        System.out.println(daoi.doDML(region, false));
//        for (Object object : daoi.doDDL("Department", "ec")) {
//            Department department = (Department) object;
//            
//            System.out.println(department.getDepartmentName());
//        }
//        
//        for (Object object : daoi.doDDL("Department", "")) {
//            Department department = (Department) object;
//        }
//        Job job = new Job("AS", "Tukang Sapu komplek");
//        System.out.println(gdao.doDML(job, true));
//        for (Object object : gdao.doDDL(new Job(), "Pre")) {
//            Job j = (Job) object;
//            System.out.println(j.getJobId() + " - " + j.getJobTitle());
//        }
//        Job job = new Job("Ig", "Igazzo ganteng");
//        System.out.println(rc.insertOrUpdateOrDelete(job, false));
//
//        for (Object object : rc.getAllData(new Job(), "")) {
//            Job j = (Job) object;
//            System.out.println(j.getJobId() + " - " + j.getJobTitle());
//        }
        String strong_salt = BCrypt.gensalt(10);
        String stronger_salt = BCrypt.gensalt(12);
        BCrypt bCrypt = new BCrypt();
        

        Login login = new Login("igaz", "igazzo");
        System.out.println(rc.insertOrUpdateOrDelete(login, false));

        for (Object object : rc.getAllData(new Login(), "")) {
            Login l = (Login) object;
            System.out.println(l.getUsername() + " - " + l.getPassword());
        }

//        for (Object object : gdao.doDDL(new Job(), "")) {
//            Job j = (Job) object;
//            System.out.println(j.getJobId() + " - " + j.getJobTitle());
//        }
//        Object id = gdao.getById(100);
//        Department department = (Department) id;
//        System.out.println(department.getDepartmentId()+" - "+department.getDepartmentName());
    }

}
