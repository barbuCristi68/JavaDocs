package ro.teamnet.zth.appl.dao;

import ro.teamnet.zth.api.em.EnityManager;
import ro.teamnet.zth.api.em.EntityManagerImpl;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;

/**
 * Created by Cristian.Barbu on 7/14/2017.
 */
public class LocationDao {
    EnityManager entityManager = new EntityManagerImpl();

    public Location findById(Long id) throws NoSuchFieldException, SQLException {
        return entityManager.findById(Location.class, id);
    }

    public Long getNextIdVal(String columnIdName){
        return entityManager.getNextIdVal("LOCATIONS",columnIdName);
    }

    public void delete(Location entity){
        entityManager.delete(entity);
    }

    public Object insert( Location entity){
        return entityManager.insert(entity);
    }

    public Object update(Location entity){
        return entityManager.update(entity);
    }
}
