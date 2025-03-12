import java.sql.*;

public class FetchEmployeeData {

    public static void main(String[] args) {
        // Database connection variables
        String jdbcURL = "jdbc:mysql://localhost:3306/your_database_name"; // Update with your DB URL
        String username = "your_username"; // Update with your DB username
        String password = "your_password"; // Update with your DB password

        // SQL query to fetch data from the Employee table
        String query = "SELECT EmpID, Name, Salary FROM Employee";

        // Establishing the connection
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            // Print column headers
            System.out.println("EmpID\tName\tSalary");

            // Fetching and displaying the results
            while (resultSet.next()) {
                int empID = resultSet.getInt("EmpID");
                String name = resultSet.getString("Name");
                double salary = resultSet.getDouble("Salary");

                // Display each record
                System.out.println(empID + "\t" + name + "\t" + salary);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
