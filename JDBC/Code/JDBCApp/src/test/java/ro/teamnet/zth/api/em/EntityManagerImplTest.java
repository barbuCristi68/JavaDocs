package ro.teamnet.zth.api.em;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.domain.Department;

import javax.swing.text.html.parser.Entity;
import java.util.List;

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
}
