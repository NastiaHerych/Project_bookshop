package application.dbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
    private static String USER_NAME = "root";
    private static String USER_PASSWORD = "18454360";
    private static String URL = "jdbc:mysql://localhost:3306/bookshop?serverTimezone=UTC";
   // private static String URL = "jdbc:mysql://localhost:3036/bookshop?useUnicode=true&serverTimezone=UTC&useSSL=true&verifyServerCertificate=false";

    public static Connection openConnection() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
        Class.forName ("com.mysql.cj.jdbc.Driver").newInstance();
        return DriverManager.getConnection (URL, USER_NAME, USER_PASSWORD);
    }
}
