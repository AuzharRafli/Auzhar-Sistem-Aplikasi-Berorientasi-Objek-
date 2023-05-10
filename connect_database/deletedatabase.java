package connect_database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class deletedatabase {
 
 private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
 private static final String DB_CONNECTION = "jdbc:mysql://localhost:3306/mahasiswa";
 private static final String DB_USER = "root";
 private static final String DB_PASSWORD = "";
 
 public static void main(String[] args){
  try {
   deleteRecord();
  } catch (SQLException ex) {
   ex.printStackTrace();
  }
 }
 
 public static void deleteRecord() throws SQLException{
  Connection connection = null;
  Statement statement = null;
  int countRecordDeleted = 0;
 
  String deleteTableQuery = "DELETE FROM mahasiswa WHERE id = '001'";
 
  try {
   connection = getDatabaseConnection();
   statement = connection.createStatement();
 
   System.out.println(deleteTableQuery);
 
   // execute delete SQL stetement
   statement.executeUpdate(deleteTableQuery);
   
   countRecordDeleted = statement.getUpdateCount();
 
   System.out.println(countRecordDeleted+" Record berhasil di delete dari TBL_USER!");
 
  } catch (SQLException ex) {
 
   System.out.println(ex.getMessage());
 
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