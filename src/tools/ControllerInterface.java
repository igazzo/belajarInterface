/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entities.Job;
import entities.Region;
import java.util.List;

/**
 *
 * @author Igaz
 */
public interface ControllerInterface {

    public boolean insertOrUpdateOrDelete(Object object,
            boolean isDelete);

    public List<Object> getAllData(Object entity, String keyword);

    public Object getById (Object entity, Object jobId);

    public boolean insertData(Region region);

    public boolean updateData(Region region);

    public boolean deleteData(Region region);
}
