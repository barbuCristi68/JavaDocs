package ro.teamnet.zth.api.em;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Cristian.Barbu on 7/13/2017.
 */
public interface EnityManager {
    <T> T findById(Class<T> entityClass, Long id) throws SQLException, NoSuchFieldException;
    Long getNextIdVal(String tableName, String columnIdName);
    <T> Object insert(T entity);
    <T> List<T> findAll(Class<T> entityClass);

}