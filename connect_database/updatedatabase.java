package connect_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class updatedatabase {
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mahasiswa";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        try {
            updateRecord();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static void updateRecord() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        int recordCount = 0;

        String updateTableQuery = "UPDATE mahasiswa"
                + " SET nama_mahasiswa = 'Auzhar Rafli' "
                + " WHERE id = '001'";

        try {
            // membuat object connection
            connection = getDatabaseConnection();

            // membuat object statement
            statement = connection.createStatement();

            System.out.println(updateTableQuery);

            // eksekusi update table query
            statement.execute(updateTableQuery);

            // tampilkan jumlah record yang ter-update
            recordCount = statement.getUpdateCount();

            System.out.println(recordCount
                    + " Record berhasil di update di tabel mahasiswa");

        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }

    public static Connection getDatabaseConnection() {
        Connection connection = null;

        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            connection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return connection;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return connection;
    }
}
