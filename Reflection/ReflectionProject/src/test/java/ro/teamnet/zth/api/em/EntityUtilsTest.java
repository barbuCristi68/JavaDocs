package ro.teamnet.zth.api.em;

import org.junit.Test;
import ro.teamnet.zth.api.annotations.Column;
import ro.teamnet.zth.api.annotations.Id;
import ro.teamnet.zth.appl.domain.Department;
import ro.teamnet.zth.appl.domain.Location;

import java.math.BigDecimal;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by Cristian.Barbu on 7/12/2017.
 */

public class EntityUtilsTest {
    @Test
    public void testGetTableNameMethod() {
        String tableName = EntityUtils.getTableName(Department.class);
        String tableName1 = EntityUtils.getTableName(Location.class);

        assertEquals("Table name should be departments!", "DEPARTMENTS", tableName);
        assertEquals("Table name should be locations!", "LOCATIONS", tableName1);

    }
    @Test
    public void testGetColumns(){
        int response = EntityUtils.getColumns(Department.class).size();
        int response1 = EntityUtils.getColumns(Location.class).size();

        assertEquals("Size should be 3", 3, response);
        assertEquals("Size should be 5", 5, response1);
    }
    @Test
    public void testGetFieldsByAnnotations(){
        int response = EntityUtils.getFieldsByAnnotations(Department.class, Column.class).size();
        int response1 = EntityUtils.getFieldsByAnnotations(Department.class, Id.class).size();


        assertEquals("Size should be 2", 2, response);
        assertEquals("Size should be 1", 1, response1);
    }

}
