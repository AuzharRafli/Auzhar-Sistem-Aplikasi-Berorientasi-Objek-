package connect_database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {
 public static void main(String[] args){
  System.out.println("======= Contoh Koneksi JDBC dengan MySQL ======= ");
  
  try {
   Class.forName("com.mysql.jdbc.Driver");
  } catch (ClassNotFoundException ex) {
   System.out.println("MySQL JDBC Driver tidak ditemukan");
   ex.printStackTrace();
  }
  
  System.out.println("MySQL JDBC Driver berhasil didaftarkan");
  Connection connection = null;
  
  try {
   connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasiswa","root", "");
  } catch (SQLException ex) {
   System.out.println("Gagal Membuat koneksi.");
   ex.printStackTrace();
  }
  
  if(connection != null){
   System.out.println("Selamat, Anda telah berhasil membuat koneksi ke database MySQL");
  }else{
   System.out.println("Maaf, Anda gagal membuat koneksi");
  }
  
  try {
   connection.close();
  } catch (SQLException ex) {
   System.out.println("Gagal untuk membuat koneksi");
   ex.printStackTrace();
  }
  
 }
}