package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataBaseService {
    Logger logger = LoggerFactory.getLogger(DataBaseService.class);

    static final String HOST = "localhost";
    static final String PORT = "5432";
    static final String USER = "...";
    static final String PSW = "...";
    static final String DATABASE_NAME = "postgres";

    static final String JDBC = "jdbc:postgresql://" + HOST + ":" + PORT + "/" + DATABASE_NAME;
// выше это так вы подключаемся к базе
    Connection connection = null;
    Statement statement = null;

    public DataBaseService() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            logger.info(e.toString());
            return;
        }

        try {
            connection = DriverManager.getConnection(JDBC, USER, PSW);
        } catch (SQLException throwables) {
            logger.info(throwables.toString());
        }

        if (connection != null) {
            logger.info("You successfully connected to database.");
        } else {
            logger.info("Something went wrong...");
        }
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            logger.info(throwables.toString());
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
    public Statement getStatement() {
        try {
            if (statement == null) {
                statement = getConnection().createStatement();
            }
        } catch (SQLException ex) {
            logger.info("Не удалось создать Statement...");
        }

        return statement;
    }

    public void executeSQL(String sql) {
        try {
            logger.info("Result of executing of the request: " + getStatement().execute(sql));
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }

    }

    public ResultSet executeQuery(String sql) {
        try {
            return getStatement().executeQuery(sql);
        } catch (SQLException ex) {
            logger.info(ex.getMessage());
        }

        return null;
    }


}