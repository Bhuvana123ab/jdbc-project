
import java.sql.*;

public class BusManagementSystem {
    // JDBC URL, username, and password of MySQL server
    static final String JDBC_URL = "jdbc:mysql://localhost:3306/BusManagementSystem";
    static final String USERNAME = "root";
    static final String PASSWORD = "Bhu@2002";

    // JDBC variables for opening, closing and managing connection
    private static Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {
            // Connect to the database
            connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);

            // Example: Retrieving all buses from the database
            retrieveAllBuses();

            // Close the connection
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void retrieveAllBuses() throws SQLException {
        String query = "SELECT * FROM buses";
        preparedStatement = connection.prepareStatement(query);

        // Execute the query and obtain the result set
        resultSet = preparedStatement.executeQuery();

        // Iterate over the result set and print each bus's details
        while (resultSet.next()) {
            int busId = resultSet.getInt("bus_id");
            String busName = resultSet.getString("bus_name");
            String busType = resultSet.getString("bus_type");
            int capacity = resultSet.getInt("capacity");

            System.out.println("Bus ID: " + busId);
            System.out.println("Bus Name: " + busName);
            System.out.println("Bus Type: " + busType);
            System.out.println("Capacity: " + capacity);
            System.out.println("------------------------");
        }

        // Close result set and statement
        resultSet.close();
        preparedStatement.close();
    }
}
