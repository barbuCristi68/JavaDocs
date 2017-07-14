package ro.teamnet.zth.api.em;

import ro.teamnet.zth.appl.domain.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by Cristian.Barbu on 7/13/2017.
 */
public interface EnityManager {
    <T> T findById(Class<T> entityClass, Long id) throws SQLException, NoSuchFieldException;
    Long getNextIdVal(String tableName, String columnIdName);
    <T> Object insert(T entity);
    <T> List<T> findAll(Class<T> entityClass);
    <T> T update(T entity);
    void delete(Object entity);
    <T> List<T> findByParams(Class<T> entityClass, Map<String,Object> params);
    <Employee> List<Employee> findAllSuplimentar(Class<Employee> entity, String departmentName);
    <T> void insertList(List<T> entity);

}
