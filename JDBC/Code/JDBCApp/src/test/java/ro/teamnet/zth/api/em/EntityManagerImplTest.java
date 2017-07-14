package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Employee;
import ro.teamnet.zth.appl.domain.Location;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Cristian.Barbu on 7/13/2017.
 */
public class EntityManagerImplTest {
    @Test
    public void testFindById(){
        EntityManagerImpl e = new EntityManagerImpl();

        Department result = e.findById(Department.class,new Long(10));


        Assert.assertEquals("Expected Administration","Administration",result.getDepartmentName());

    }

    @Test
    public void testGetNextIdVal() {
        EntityManagerImpl e = new EntityManagerImpl();
        Long result = e.getNextIdVal("DEPARTMENTS","department_id");

        Assert.assertEquals(new Long(271),result);


    }
    @Test
    public void testInsert(){
            EntityManagerImpl e = new EntityManagerImpl();
            Department dep = new Department();
            dep.setDepartmentName("LastTest");
            dep.setLocation(new Long(1700));
            Department result = (Department) e.insert(dep);


            Assert.assertEquals("Expected LastTest","LastTest",result.getDepartmentName());

    }



    @Test
    public void testFindAll(){
        EntityManagerImpl e = new EntityManagerImpl();

        List<Department> result = e.findAll(Department.class);

        Assert.assertEquals("Expected 27",27,result.size());
    }


    @Test
    public void testUpdate(){
        EntityManagerImpl e = new EntityManagerImpl();

        Department dep = new Department();
        dep.setLocation(new Long(1700));
        dep.setDepartmentName("FirstTest1211");
        dep.setId(new Long(10));

        Department result = e.update(dep);


        Assert.assertEquals("FirstTest1211", dep.getDepartmentName());


    }
    @Test
    public void testDelete(){
        EntityManagerImpl e = new EntityManagerImpl();

        Location loc = new Location();
        loc.setId(new Long(1100));

        e.delete(loc);

        Assert.assertEquals(null,e.findById(Location.class,new Long(1100)));


    }
    @Test
    public void testFindByParams(){
        EntityManagerImpl e = new EntityManagerImpl();
        Map<String,Object> find = new HashMap<String, Object>();
        find.put("department_id", new Long(60));
        find.put("location_id",new Long(1400));
        List<Department> result = e.findByParams(Department.class,find);

        Assert.assertEquals("IT", result.get(0).getDepartmentName());

    }

    @Test
    public void testSuplimentar(){
        EntityManagerImpl e = new EntityManagerImpl();

        List<Employee> result = e.findAllSuplimentar(Employee.class,"rke");

        Assert.assertEquals(2,result.size());
    }
    @Test
    public void testInsertAll(){
        EntityManagerImpl e = new EntityManagerImpl();

        List<Department> result = new ArrayList<Department>();

        Department d1 = new Department();
        Department d2 = new Department();

        d1.setDepartmentName("Insert1");
        d1.setLocation(new Long(1700));
        d2.setDepartmentName("Insert2");
        d2.setLocation(new Long(1700));

        result.add(d1);
        result.add(d2);

        e.insertList(result);

    }
}
