package ro.teamnet.zth.appl;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.dao.DepartmentDao;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;

/**
 * Created by Cristian.Barbu on 7/14/2017.
 */
public class DepartmentDaoTest {

    @Test
    public void daoFindByIdTest() throws NoSuchFieldException, SQLException {
        DepartmentDao dao = new DepartmentDao();

        Department result = dao.findById(new  Long(10));

        Assert.assertEquals("FirstTest",result.getDepartmentName());
    }

    @Test
    public void testGetNextIdVal() {
        DepartmentDao dao = new DepartmentDao();
        Long result = dao.getNextIdVal("department_id");

        Assert.assertEquals(new Long(275), result);

    }
    @Test
    public void deleteTest() throws NoSuchFieldException, SQLException {
        DepartmentDao dao = new DepartmentDao();
        Department dep = new Department();
        dep.setId(new Long(10));

        dao.delete(dep);

        Assert.assertEquals(null,dao.findById(new Long(10)));
    }

    @Test
    public  void testUpdate(){
        DepartmentDao dao = new DepartmentDao();
        Department dep = new Department();
        dep.setLocation(new Long(1700));
        dep.setDepartmentName("FirstTest33333");
        dep.setId(new Long(10));

        Department result = (Department) dao.update(dep);

        Assert.assertEquals("FirstTest33333", dep.getDepartmentName());
    }

    @Test
    public void testInsert(){
        DepartmentDao dao = new DepartmentDao();
        Department dep = new Department();
        dep.setLocation(new Long(1700));
        dep.setDepartmentName("NewEntry");

        Department result = (Department) dao.insert(dep);


        Assert.assertEquals("NewEntry", result.getDepartmentName());
    }


}
