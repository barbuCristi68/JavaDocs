package ro.teamnet.zth.api.database;

import java.sql.*;

/**
 * Created by Cristian.Barbu on 7/13/2017.
 */
public class DBManager {

    private  DBManager(){
        throw  new UnsupportedOperationException();
    }

    static final String CONNECTION_STRING ="jdbc:oracle:thin:@" +DBProperties.IP + ":" + DBProperties.PORT + ":xe";

    private static void registerDriver(){
        try {
            Class.forName(DBProperties.DRIVER_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public static Connection getConnection() throws SQLException {
        registerDriver();
        return DriverManager.getConnection(CONNECTION_STRING, DBProperties.USER,DBProperties.PASS);
    }

    public static int checkConnection(Connection connection) throws SQLException {
        int result = 0;
        Statement statement = connection.createStatement();
            String sql = "SELECT 1 FROM DUAL";
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                result = rs.getInt(1);
            }
            statement.close();
            return result;

    }

}
