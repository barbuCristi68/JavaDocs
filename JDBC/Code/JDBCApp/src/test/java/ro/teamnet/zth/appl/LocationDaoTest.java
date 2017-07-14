package ro.teamnet.zth.appl;

import org.junit.Assert;
import org.junit.Test;
import ro.teamnet.zth.appl.dao.LocationDao;
import ro.teamnet.zth.appl.domain.Location;

import java.sql.SQLException;

/**
 * Created by Cristian.Barbu on 7/14/2017.
 */
public class LocationDaoTest {
    @Test
    public void daoFindByIdTest() throws NoSuchFieldException, SQLException {
        LocationDao dao = new LocationDao();

        Location result = dao.findById(new  Long(1400));

        Assert.assertEquals("Southlake",result.getCity());
    }

    @Test
    public void testGetNextIdVal() {
        LocationDao dao = new LocationDao();
        Long result = dao.getNextIdVal("location_id");

        Assert.assertEquals(new Long(3201), result);

    }
    @Test
    public void deleteTest() throws NoSuchFieldException, SQLException {
        LocationDao dao = new LocationDao();
        Location dep = new Location();
        dep.setId(new Long(1300));

        dao.delete(dep);

        Assert.assertEquals(null,dao.findById(new Long(1300)));
    }

    @Test
    public  void testUpdate(){
        LocationDao dao = new LocationDao();
        Location dep = new Location();
        dep.setId(new Long(1500));
        dep.setCity("Whatever");
        dep.setPostalCode("1223234213");
        dep.setStateProvince("sdsadas");
        dep.setStreetAddress("sdasd122");

        Location result = (Location) dao.update(dep);

        Assert.assertEquals("Whatever", dep.getCity());
    }

    @Test
    public void testInsert(){
        LocationDao dao = new LocationDao();
        Location dep = new Location();
        dep.setCity("InsertTest");
        dep.setPostalCode("1223234213");
        dep.setStateProvince("sdsadas");
        dep.setStreetAddress("sdasd122");

        Location result = (Location) dao.insert(dep);


        Assert.assertEquals("InsertTest", result.getCity());
    }

}
