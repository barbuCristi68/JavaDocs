package ro.teamnet.zth.api.database;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Cristian.Barbu on 7/13/2017.
 */

public class DBManagerTest {
    @Test
    public void testConnection() throws SQLException {
        int result = DBManager.checkConnection(DBManager.getConnection());

        Assert.assertEquals("Expected 1:",1,result);
    }

}
