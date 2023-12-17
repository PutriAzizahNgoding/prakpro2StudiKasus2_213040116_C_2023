/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionListener;
/**
 * @author Putri Azizah
 */
import java.awt.event.*; // Mengimpor semua class-class di package untuk menangani event AWT
import javax.swing.JFrame; // Mengimpor class JFrame untuk membuat window utama aplikasi
import javax.swing.JOptionPane; // Mengimpor class JOptionPane untuk menampilkan dialog konfirmasi
// Mengimpor class AplikasiBiodataFrame dari package biodata (presumably berisi frame utama aplikasi)
import biodata.AplikasiBiodataFrame;
// Deklarasi class KeluarActionListener yang mengimplementasi interface WindowListener
public class KeluarActionListener implements WindowListener {
	// Mendefinisikan field bioFrame bertipe private final AplikasiBiodataFrame untuk menyimpan referensi ke frame utama aplikasi
	private final  AplikasiBiodataFrame bioFrame;
        // Constructor KeluarActionListener yang menerima argumen bioFrame, menyimpannya ke field bioFrame
	public  KeluarActionListener(AplikasiBiodataFrame bioFrame) {
		this.bioFrame = bioFrame;
	}
	// Implementasi method windowClosing dari interface WindowListener yang di-trigger saat window utama akan ditutup
	public void windowClosing(WindowEvent e) {
         // Menampilkan dialog konfirmasi ke bioFrame dengan pesan "Apakah anda yakin ingin keluar aplikasi?" dan pilihan Yes/No
           int confirmation = JOptionPane.showConfirmDialog(this.bioFrame,
				"Apakah anda yakin ingin keluar aplikasi?",
				"Form Biodata",
				JOptionPane.YES_NO_OPTION);
            // Jika pengguna memilih Yes, maka panggil System.exit(0) untuk keluar dari program
                if (confirmation == JOptionPane.YES_OPTION) {	
			System.exit(0);
		} else {
			// defaultCloseOperation bioFrame menjadi JFrame.DO_NOTHING_ON_CLOSE untuk mencegah penutupan window
			this.bioFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}
	// Implementasi method windowOpened dari interface WindowListener yang di-trigger saat window utama dibuka 
	public void windowOpened(WindowEvent e) {
	}
        // Implementasi method windowClosed dari interface WindowListener yang di-trigger saat window utama ditutup 
	public void windowClosed(WindowEvent e) {
	}
        // Implementasi method windowIconified dari interface WindowListener yang di-trigger saat window utama diminimalkan
	public void windowIconified(WindowEvent e) {	
	}
    // Implementasi method windowDeiconified dari interface WindowListener yang di-trigger saat window utama dimaksimalkan dari state minim 
	public void windowDeiconified(WindowEvent e) {
	}
	// Implementasi method windowActivated dari interface WindowListener yang di-trigger saat window utama menjadi aktif 
	public void windowActivated(WindowEvent e) {	
	}
        // Implementasi method windowDeactivated dari interface WindowListener yang di-trigger saat window utama tidak aktif 
	public void windowDeactivated(WindowEvent e) {
	}
}

