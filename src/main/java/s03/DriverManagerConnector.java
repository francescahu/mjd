package s03;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DriverManagerConnector {
    private static Logger logger = LoggerFactory.getLogger(DriverManagerConnector.class);
    
    private static final String URL = "jdbc:mysql://localhost:3306/me?serverTimezone=Europe/Rome";
    private static final String USER = "me";
    private static final String PASSWORD = "password";

    /**
     * The following static initializer should not be required anymore
     */
//    static {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//        } catch (ClassNotFoundException cnfe) {
//            cnfe.printStackTrace();
//            throw new IllegalStateException("Can't load JDBC driver " + cnfe.getMessage());
//        }
//    }

    public static void main(String[] args) {
        System.out.println("Connected as " + getSchemaName());
    }

    public static String getSchemaName() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String user = conn.getCatalog(); //ritorna schema
            if (user == null) {
                user = conn.getSchema();
            }

            return user;
        } catch (SQLException e) {
            logger.error("Failure accessing DB" , e);
            throw new IllegalStateException("Can't get schema name");
        }
    }
}
