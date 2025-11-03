package mysql_jdbc;

//Import necessary JDBC classes
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class TableDataPrinter {
	
	// Define JDBC connection parameters
    static final String URL = "jdbc:mysql://localhost:3306/demodb"; // Replace 'testdb' with your database name
    static final String USER = "root"; // Replace with your MySQL username
    static final String PASSWORD = "root"; // Replace with your MySQL password

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Specify the table name you want to print data from
        String tableName = "employees"; // Replace 'users' with your table name

        // Call the method to print data from the specified table
        printTableData(tableName);

	}
	/**
     * Connects to the database and prints all data from the specified table.
     * The method dynamically handles any table structure.
     *
     * @param tableName the name of the table to retrieve data from
     */
    public static void printTableData(String tableName) {
        // Formulate the SQL query to select all data from the table
        String query = "SELECT * FROM " + tableName;

        // Use try-with-resources to manage database resources
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            System.out.println("Connected to the database successfully.");

            // Retrieve metadata about the result set
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount(); // Get the number of columns

            // Print column names as headers
            for (int i = 1; i <= columnCount; i++) {
                // Get and print the column name
                System.out.print(metaData.getColumnName(i) + "\t");
            }
            System.out.println(); // Move to the next line after printing all column names

            // Loop through the result set and print each row of data
            while (rs.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    // Get the value of the current column as an Object
                    Object value = rs.getObject(i);
                    // Print the value followed by a tab character
                    System.out.print(value + "\t");
                }
                System.out.println(); // Move to the next line after printing all columns of the current row
            }

        } catch (SQLException e) {
            // Handle any SQL exceptions that occur during data retrieval
            System.err.println("Error retrieving data from table: " + tableName);
            e.printStackTrace();
        }
    }

}
