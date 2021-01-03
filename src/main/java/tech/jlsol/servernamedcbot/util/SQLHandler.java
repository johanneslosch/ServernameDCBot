package tech.jlsol.servernamedcbot.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLHandler {
    private static final String PORT = Config.readConfig("data", "credentials", "databasePORT");
    private static final String DBNAME = Config.readConfig("data", "credentials", "mysql_database_name");
    private static final String USER = Config.readConfig("data", "credentials", "databaseUSER");
    private static final String PASSWORD = Config.readConfig("data", "credentials", "databasePASSWORD");

    private static final String DATABASE_URL = "jdbc:mysql://" + Config.readConfig("data", "credentials","databaseURL") +":" + PORT + "/" + DBNAME;
    private static Connection connection;
    private static PreparedStatement prepareStatement;

    /**
     * @return                  the connection
     */
    private static Connection connect() {
        if (connection == null) {
            System.out.println("Connecting database...");

            try {
                connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
                System.out.println("Database connected!");
            } catch (SQLException e) {
                Logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }
}
