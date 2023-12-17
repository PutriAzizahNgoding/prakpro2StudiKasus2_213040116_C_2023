/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
/**
 * @author Putri Azizah
 */
import javax.swing.*;
import dao.AplikasiBioDao;
import biodata.AplikasiBiodataFrame;
public class MainFrame extends JFrame { // Class Main untuk menjalankan program
    // Mendefinisikan field privat final bertipe AplikasiBioDao bernama bioDao 
    private final AplikasiBioDao bioDao; 
   // Mendefinisikan field privat final bertipe AplikasiBiodataFrame bernama bioFrame
    private final AplikasiBiodataFrame bioFrame; 

    public MainFrame() { // konstructor MainFrame tanpa argumen
        // Mengatur judul frame utama menjadi "Aplikasi Biodata"
        this.setTitle("Aplikasi Biodata");
        // Mengatur ukuran frame utama menjadi 400 px (lebar) x 500 px (tinggi)
        this.setSize(400, 500);
        // Menciptakan objek baru AplikasiBioDao dan menyimpannya di field bioDao
        this.bioDao = new AplikasiBioDao();
        //Menciptakan objek baru AplikasiBiodataFrame dengan argumen bioDao dan menyimpannya di field bioFrame
        this.bioFrame = new  AplikasiBiodataFrame(bioDao);
        // Menampilkan frame utama aplikasi (bioFrame)
        this.bioFrame.setVisible(true);
    }
    public static void main(String[] args) { // Method main yang merupakan titik awal program
        SwingUtilities.invokeLater(new Runnable() {// menjalankan kode di event dispatch thread (antarmuka pengguna responsif)
            public void run() { // Implementasi method run dari Runnable
                new MainFrame(); // Menciptakan objek baru MainFrame dan menjalankan constructor,
            }
        });
    }  }
