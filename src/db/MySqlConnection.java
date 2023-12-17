/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

/**
 *
 * @author Putri Azizah
 */

// untuk membuat koneksi ke database.
import java.sql.Connection;
//intuk mendapatkan koneksi database menggunakan JDBC.
import java.sql.DriverManager;

//Memdeklarasikan class publik bernama MySqlConnection.
public class MySqlConnection {
   //Mendeklarasikan variabel final private DB_URL, menyimpan URL untuk koneksi database MySQL lokal dengan schema aplikasibiodataApp.
    private final static String DB_URL = "jdbc:mysql://localhost:3306/aplikasibiodatapp";
     //Mendeklarasikan variabel final private DB_USER, menyimpan username untuk koneksi ke database MySQL
    private final static String DB_USER = "root";
    // Mendeklarasikan variabel final private DB_PASS, menyimpan password untuk koneksi ke database MySQL
    private final static String DB_PASS = "";

   //Mendeklarasikan variabel static private instance MySqlConnection untuk menyimpan instance tunggal dari class(singleton pattern).
    private static MySqlConnection instance;

   // Mendeklarasikan method static publik getInstance yang mengembalikan instance dari class MySqlConnection.
    public static MySqlConnection getInstance() {
      //Memeriksa apakah instance belum dibuat (null).
       if (instance == null) {
           // jika instance belum ada, buat instance baru dari class MySqlConnection.
           instance = new MySqlConnection();
      }
       //Kembalikan instance yang ada (baru atau sebelumnya dibuat).
       return instance;
}
    //Mendeklarasikan method publik getConnection yang mengembalikan objek Connection untuk koneksi ke database.
    public Connection getConnection() {
      // Mendeklarasikan variabel connection bertipe Connection dan diinisialisasi null.
      Connection connection = null;
       //blok try untuk menangani kemungkinan error.
      try {
       // Menggunakan class Class.forName untuk mendaftarkan driver MySQL JDBC ke DriverManager.
        Class.forName("com.mysql.cj.jdbc.Driver");
        //Menggunakan DriverManager untuk mendapatkan koneksi ke database dengan URL, username, dan password
        connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
      } catch(Exception e) {
         //Menampilkan stack trace dari Exception yang terjadi.
         e.printStackTrace();
      }
       //Kembalikan objek connection yang berisi koneksi ke database (null jika terjadi error).
      return connection;
  
    }

}
