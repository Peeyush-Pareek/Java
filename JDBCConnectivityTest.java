package mysql_jdbc;
// Import necessary JDBC classes
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnectivityTest {
	// Define JDBC connection parameters
    static final String URL = "jdbc:mysql://localhost:3306"; // Connect to MySQL server (no specific database)
    static final String USER = "root"; // Replace with your MySQL username
    static final String PASSWORD = "root"; // Replace with your MySQL password

    public static void main(String[] args) {
        // Call the method to test the connection
        testConnection();
    }

    /**
     * Tests JDBC connectivity by connecting to the MySQL server and listing all available databases.
     */
    public static void testConnection() {
        // Use try-with-resources to ensure the connection is closed automatically
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to MySQL server successfully.");

            // Get metadata from the connection to access database information
            DatabaseMetaData metaData = conn.getMetaData();

            // Retrieve a list of all available databases (catalogs)
            try (ResultSet catalogs = metaData.getCatalogs()) {
                System.out.println("Available Databases:");
                // Loop through the result set and print each database name
                while (catalogs.next()) {
                    String dbName = catalogs.getString(1); // Get the database name from the first column
                    System.out.println("- " + dbName);
                }
            }

            // Optionally, you can list tables in each database by uncommenting the following code

            try (ResultSet catalogs = metaData.getCatalogs()) {
                while (catalogs.next()) {
                    String dbName = catalogs.getString(1);
                    System.out.println("\nTables in Database: " + dbName);

                    // Establish a new connection to the specific database
                    try (Connection dbConn = DriverManager.getConnection(URL + "/" + dbName, USER, PASSWORD)) {
                        DatabaseMetaData dbMetaData = dbConn.getMetaData();
                        String[] types = {"TABLE"}; // We are interested in tables only

                        // Retrieve a list of tables in the current database
                        try (ResultSet tables = dbMetaData.getTables(dbName, null, "%", types)) {
                            while (tables.next()) {
                                String tableName = tables.getString("TABLE_NAME"); // Get table name
                                System.out.println("- " + tableName);
                            }
                        }
                    }
                }
            }


        } catch (SQLException e) {
            // Handle any SQL exceptions that occur during the connection
            System.err.println("Connection failed.");
            e.printStackTrace();
        }
    }

}
