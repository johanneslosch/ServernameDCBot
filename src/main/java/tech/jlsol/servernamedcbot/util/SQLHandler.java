package tech.jlsol.servernamedcbot.util;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

public class SQLHandler {
    private static final String PORT = Config.readConfig("data", "credentials", "databasePORT");
    private static final String DBNAME = Config.readConfig("data", "credentials", "databaseUSER");
    private static final String USER = DBNAME;
    private static final String PASSWORD = Config.readConfig("data", "credentials", "databasePASSWORD");

    private static final String DATABASE_URL = "jdbc:mysql://" + Config.readConfig("data", "credentials","databaseURL") +":" + PORT + "/" + DBNAME;
    private static Connection connection;
    private static PreparedStatement prepareStatement;

    /**
     * @return                  the connection
     */
    public static Connection connect() {


        if (connection == null) {
            System.out.println(System.nanoTime() + " Connecting database...");

            try {
                //String connectionString = "jdbc:mysql://116.203.106.254:3306/" + DBNAME + "?user=" + USER+ "&password=" + PASSWORD + "&useUnicode=true&characterEncoding=UTF-8";
                //connection = DriverManager.getConnection(connectionString);
                //Context context = new InitialContext();
                //DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/myDB");
                MysqlDataSource dataSource = new MysqlDataSource();
                dataSource.setUser(USER);
                dataSource.setPassword(PASSWORD);
                dataSource.setServerName("116.203.106.254");
                connection = dataSource.getConnection();
                System.out.println(System.nanoTime() + " Database connected!");
            } catch (SQLException e) {
                Logger.error(e.getMessage());
                e.printStackTrace();
            }
        }
        return connection;
    }

    /**
     * sets preparedStatement for Message-Recive event
     * @param time          time
     * @param channelID     channel ID
     * @param length        length
     * @param bot           is bot?
     * @param roles         number of roles
     * @param guild         guild ID
     * @return              preparedStatement
     * @throws SQLException then connection error?
     */
    private static PreparedStatement preparedStatementMessageRecive(String time, String channelID, int length, boolean bot, int roles, String guild) throws SQLException {
        connect();
        prepareStatement.execute();
        prepareStatement = connection.prepareStatement(String.format("INSERT INTO `messagerecive`(`time`, `channel_id`, `length`, `bot`, `roles`, `guild`) VALUES (%s,%s,%s,%s,%s,%s)", time, channelID, length, bot, roles, guild));
        return prepareStatement;
    }

    /**
     * sets prepared statement for User-update event
     * @param time          time
     * @param bot           is bot?
     * @param roles         role count
     * @param guild         guild id
     * @param oldStatus     old Status
     * @param newStatus     new Status
     * @return              prepared statement
     * @throws SQLException then connection error?
     */
    private static PreparedStatement preparedStatementUserUpdate(String time, boolean bot, int roles, String guild, String oldStatus, String newStatus) throws SQLException {
        connect();
        prepareStatement.execute();
        prepareStatement = connection.prepareStatement(String.format("INSERT INTO `userupdate`(`time`, `bot`, `roles`, `guild`, `oldStatus`, `newStatus`) VALUES (%s,%s,%s,%s,%s,%s)", time, bot, roles, guild, oldStatus, newStatus));
        return prepareStatement;
    }

    /**
     * sets prepared statement for member change event
     * @param time          time
     * @param bot           is bot?
     * @param roles         role count
     * @param guild         guild id
     * @param event         event name
     * @return              prepared Statement
     * @throws SQLException then connection error?
     */
    private static PreparedStatement preparedStatementMemberChange(String time, boolean bot, int roles, String guild, String event) throws SQLException {
        connect();
        prepareStatement.execute();
        prepareStatement = connection.prepareStatement(String.format("INSERT INTO `memberchange`(`time`, `bot`, `roles`, `guild`, `event`) VALUES (%s,%s,%s,%s,%s)", time, bot, roles, guild, event));
        return prepareStatement;
    }

    /**
     * sets prepared statement for message react event
     * @param time          time
     * @param channelID     channel id
     * @param bot           is bot?
     * @param roles         role count
     * @param guild         guild id
     * @param emoji         emoji name
     * @return              prepared statement
     * @throws SQLException then connection error?
     */
    private static PreparedStatement preparedStatementMessageReact(String time, String channelID, boolean bot, int roles, String guild, String emoji) throws SQLException {
        connect();
        prepareStatement.execute();
        prepareStatement = connection.prepareStatement(String.format("INSERT INTO `messagereact`(`time`, `channel_id`, `bot`, `roles`, `guild`, `emoji`)  VALUES (%s,%s,%s,%s,%s,%s)", time, channelID, bot, roles, guild, emoji));
        return prepareStatement;
    }

    private static PreparedStatement preparedStatementFeatureRequest(String time, String message, String user) throws SQLException {
        connect();
        prepareStatement.execute();
        prepareStatement = connection.prepareStatement(String.format("INSERT INTO `featurerequests` (`id`, `time`, `request`, `requested by`) VALUES (NULL,%s,%s,%s) %s,%s,%s,)", time, message, user));
        return prepareStatement;
    }

    /**
     * Deletes Data from Database
     * @param id        number of Element
     * @param table     table name
     * @return          a Statement of delete
     * @throws SQLException
     */
    static PreparedStatement deleteData(int id, String table) throws SQLException {
        connect();
        prepareStatement = connection.prepareStatement("DELETE FROM " + table + " WHERE `id` = " + id + ")");
        prepareStatement.execute();//
        return prepareStatement;
    }

    /**
     * Helps to get data from DataBase
     * @param category              category in DataBase
     * @param table                 a mySQL table
     * @return                      a resultSet for usage
     * @throws SQLException         throws in Error
     */
    private static ResultSet getData(String category, String table) throws SQLException {
        connect();
        Statement statement = null;
        statement = connection.createStatement();
        String sql = ("SELECT " +  category + " FROM `" + table + "`;");
        assert statement != null;


        ResultSet resultSet = statement.executeQuery(sql);
        resultSet.next();
        return resultSet;
    }

    /**
     * Class to get/set Data from Database
     */
    public static class MySQLUseDataManager {
        public static String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
        public static String getInt(String category, String table) throws SQLException {
            return String.valueOf(getData(category, table).getInt(1));

        }

        public static String getString(String category, String table) throws SQLException {
            return getData(category, table).getString(1);
        }

        public static void setUserUpdate(String time, boolean bot, int roles, String guild, String oldStatus, String newStatus) throws SQLException {
            SQLHandler.preparedStatementUserUpdate(time, bot, roles, guild, oldStatus, newStatus);
        }

        public static void setFeatureRequest(String time, String message, String user) throws SQLException {
            SQLHandler.preparedStatementFeatureRequest(time, message, user);
        }

        public static void setMemberChange(String time, boolean bot, int roles, String guild, String event) throws SQLException {
            SQLHandler.preparedStatementMemberChange(time, bot, roles, guild, event);
        }

        public static void setMessageReact(String time, String channelID, boolean bot, int roles, String guild, String emoji) throws SQLException {
            SQLHandler.preparedStatementMessageReact(time, channelID, bot, roles, guild, emoji);
        }

        public static void setMessageReceive(String time, String channelID, int length, boolean bot, int roles, String guild) throws SQLException {
            SQLHandler.preparedStatementMessageRecive(time, channelID, length, bot, roles, guild);
        }
    }
}

