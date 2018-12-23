package ua.bondarenkojek.lessons.jdbs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

public class JdbcMain {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/bookshop";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        new LinkedList<>();
        Connection connection = null;
        Statement statement = null;
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            connection = DriverManager.getConnection(DB_URL, USER, PASS);

            PreparedStatement ps = connection.prepareStatement("INSERT INTO users (name, login, password) VALUES (?, ?, ?)");
            ps.setString(1, "Tolya");
            ps.setString(2, "TolyaLogin");
            ps.setString(3, "qwerty");
            ps.execute();

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            statement = connection.createStatement();
            String selectAll = "SELECT * FROM users";
            ResultSet rs = statement.executeQuery(selectAll);

            //STEP 5: Extract data from result set
            while (rs.next()) {
                //Retrieve by column name
                int id = rs.getInt("user_id");
                String name = rs.getString("name");
                String login = rs.getString("login");
                String password = rs.getString("password");
                String sex = rs.getString("sex");
                //Display values
                System.out.println("id: " + id
                        + " name: " + name
                        + " login: " + login
                        + " password: " + password
                        + " sex: " + sex);
            }
            //STEP 6: Clean-up environment
            rs.close();
            statement.close();
            connection.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
