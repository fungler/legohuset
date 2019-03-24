package DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 The purpose of Connector is to...

 @author kasper
 */
public class Connector {

//    private static final String URL = "jdbc:mysql://localhost:3306/useradmin";
//    private static final String USERNAME = "root2";
//    private static final String PASSWORD = "password";
//
//    private static Connection singleton;
//
//    public static void setConnection( Connection con ) {
//        singleton = con;
//    }
//
//    public static Connection connection() throws ClassNotFoundException, SQLException {
//        if ( singleton == null ) {
//            Class.forName( "com.mysql.cj.jdbc.Driver" );
//            singleton = DriverManager.getConnection( URL, USERNAME, PASSWORD );
//        }
//        return singleton;
//    }

    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/useradmin";
    private static final String USER = "root";
    private static final String PASSWORD = "password";
    private static Connection conn = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            try {
                Class.forName(DRIVER);
                conn = (Connection) DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            } catch (SQLException ex) {
                //se hele sekvenst til det gik galt. Dette kan skrives til logfil.
                ex.printStackTrace();
            }
        }
        return conn;
    }
    
}
