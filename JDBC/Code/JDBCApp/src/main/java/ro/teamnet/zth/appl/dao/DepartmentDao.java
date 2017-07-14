package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EnityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Cristian.Barbu on 7/14/2017.
 */
public class DepartmentDao {
    EnityManager entityManager = new EntityManagerImpl();

    public Department findById(Long id) throws NoSuchFieldException, SQLException {
            return entityManager.findById(Department.class, id);
    }

    public Long getNextIdVal(String columnIdName){
        return entityManager.getNextIdVal("DEPARTMENTS",columnIdName);
    }

    public void delete(Department entity){
        entityManager.delete(entity);
    }

    public Object insert( Department entity){
        return entityManager.insert(entity);
    }

    public Object update(Department entity){
        return entityManager.update(entity);
    }


}
