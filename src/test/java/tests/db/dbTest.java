package tests.db;

import dbEntities.CustomersTable;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class dbTest {

    public class DBTest extends BaseDBTest {

        private CustomersTable customersTable;

        @Test
        public void firstTest() {
            logger.info("Test is started...");

            ResultSet rs = customersTable.getCustomers();

            try {
                while (rs.next()) {
                    String userid = rs.getString("ID");
                    String firstName = rs.getString("firstname");
                    String lastName = rs.getString("lastname");
                    String email = rs.getString("email");
                    int age = rs.getInt("age");

                    logger.info("userid: " + userid);
                    logger.info("firstname: " + firstName);
                    logger.info("lastname: " + lastName);
                    logger.info("email: " + email);
                    logger.info("age: " + age);
                }
            } catch (SQLException throwables) {
                logger.error(throwables.getMessage());
            }

            logger.info("Test is completed...");
        }

        @Test
        public void customerByIdTest() {
            logger.info("Test is started...");

            ResultSet rs = customersTable.getCustomers();

            try {
                while (rs.next()) {
                    String userid = rs.getString("ID");
                    String firstName = rs.getString("firstname");
                    String lastName = rs.getString("lastname");
                    String email = rs.getString("email2");
                    int age = rs.getInt("age");

                    logger.info("userid: " + userid);
                    logger.info("firstname: " + firstName);
                    logger.info("lastname: " + lastName);
                    logger.info("email: " + email);
                    logger.info("age: " + age);
                }
            } catch (SQLException throwables) {
                logger.error(throwables.getMessage());
            }

            logger.info("Test is completed...");
        }
    }
}


