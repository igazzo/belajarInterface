/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import entities.Job;
import entities.Region;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Ignatius
 */
public class FunctionDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public FunctionDAO() {
    }

    public FunctionDAO(SessionFactory factory) {
        this.factory = factory;
    }

    /**
     * Fungsi untuk melakukan insert atau update Region
     *
     * @param region
     * @param isDelete
     * @return
     */
    public boolean insertOrUpdateOrDelete(Object object,
            boolean isDelete) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isDelete) {
                session.delete(object);
            } else {
                session.saveOrUpdate(object);
            }
            result = true;
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    private String getQuery(Object entity, String keyword) {
        String className = entity.getClass().getSimpleName();
        String query = "FROM " + className;
        if (!keyword.equals("")) {
            query += " WHERE ";
            for (Object r : entity.getClass().getDeclaredFields()) {
                String field = r + "";
                if (!field.contains("UID") && !field.contains("List")) {
                    field = field.substring(field.lastIndexOf(".") + 1);
                    query += field + " LIKE '%" + keyword + "%' OR ";
                }
            }
            query = query.substring(0, query.lastIndexOf("OR")) + " ORDER BY 1";
        }
        return query;
    }

    /**
     *
     * @param query
     * @return
     */
    public List<Object> getData(Object entity, String keyword) {
        List<Object> rs = new ArrayList<>();
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
//        String className = entity.getClass().getSimpleName();
//        System.out.println(className);
//        String query = "FROM " + className + " WHERE ";
//        int fieldLength = 0;
//        int count = 0;
//        
//
//            for (Object declaredField : entity.getClass().getDeclaredFields()) {
//                String field = declaredField + "";
//                if (!field.contains("UID") && !field.contains("LIST")) {
//                    fieldLength++;
//                }
//            }
//
//            
//            for (Object declaredField : entity.getClass().getDeclaredFields()) {
//                String field = declaredField + "";
//                if (!field.contains("UID") && !field.contains("LIST")) {
//                    field = field.substring(field.lastIndexOf(".") + 1);
//                    System.out.println(field);
//                    query += field + " LIKE '%" + keyword + "%'";
//                    System.out.println(count + " - " + entity.getClass().getDeclaredFields());
//                    if (count < entity.getClass().getDeclaredFields().length - 3) {
//                        query += " OR ";
//                    }
//                    count++;
//                }
//            }
        try {
            rs = session.createQuery(getQuery(entity, keyword)).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return rs;
    }

    /**
     *
     * @param entity
     * @param query
     * @return
     */
    public Object getById(Object entity, Object jobId) {
        Job job = new Job();
        Session session = this.factory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            job = (Job)session.createQuery("FROM Job WHERE jobId = '" + jobId + "'").uniqueResult();
//            object = session.createQuery("FROM " + entity.getClass().getSimpleName()
//                    + "WHERE " + entity.getClass().getSimpleName() +"Id ="+ id).uniqueResult();
//            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return job;
    }
}
