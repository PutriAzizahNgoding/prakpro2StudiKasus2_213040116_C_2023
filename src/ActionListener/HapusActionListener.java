/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionListener;
/**
 * @author Putri Azizah
 */
// Impor class AplikasiBiodata untuk menyimpan data biodata.
import biodata.AplikasiBiodata; 
// Impor class AplikasiBiodataFrame untuk mengakses komponen frame aplikasi biodata.
import biodata.AplikasiBiodataFrame;
import dao.AplikasiBioDao; // Impor class AplikasiBioDao untuk mengakses database biodata.
import java.awt.event.*; // Impor library ActionListener untuk menangani event klik pada tombol.

// Deklarasi class HapusActionListener yang implements ActionListener.
public class HapusActionListener implements ActionListener { 
  // Deklarasi variable bioFrame untuk menyimpan referensi ke frame aplikasi biodata.
  private final AplikasiBiodataFrame bioFrame; 
  // Deklarasi variable bioDao untuk menyimpan referensi ke objek DAO untuk akses database biodata.
  private final AplikasiBioDao bioDao; 
  // Konstruktor yang menerima referensi ke frame dan DAO.
  public HapusActionListener(AplikasiBiodataFrame bioFrame, AplikasiBioDao bioDao) { 
    this.bioFrame = bioFrame;
    this.bioDao = bioDao;
  }
  public void actionPerformed(ActionEvent e) { // Method actionPerformed dipanggil ketika tombol delete diklik.
    int row = this.bioFrame.getTable().getSelectedRow(); // Mendapatkan baris yang dipilih pada tabel biodata.
    int column = this.bioFrame.getTable().getSelectedColumn(); // Mendapatkan kolom yang dipilih pada tabel biodata.
    if (row == -1 || column == -1) {  // Cek apakah ada baris dan kolom yang dipilih.
      // Tampilkan pesan error jika tidak ada baris/kolom yang dipilih.
      this.bioFrame.showAlertFailed("tidak ada yang dihapus"); 
      return; // Hentikan eksekusi method.
    } else { // Jika ada baris dan kolom yang dipilih, lanjutkan eksekusi.
      // Mendapatkan nilai pada baris dan kolom yang dipilih.
      String newValue = (String) this.bioFrame.getTable().getModel().getValueAt(row, column); 
      // Deklarasi objek AplikasiBiodata untuk menyimpan ID data yang akan dihapus.
      AplikasiBiodata id = new AplikasiBiodata(); 
      String col = ""; // Deklarasi variable untuk menyimpan nama kolom yang digunakan untuk pencarian.
      switch (column) { // Switch statement untuk menentukan nama kolom berdasarkan indeks kolom yang dipilih.
        case 0:
          col = "nama"; // Jika kolom 0 dipilih, gunakan nama kolom "nama".
          break;
        case 1:
          col = "no_telepon"; // Jika kolom 1 dipilih, gunakan nama kolom "no_telepon".
          break;
        case 2:
          col = "jenis_kelamin"; // Jika kolom 2 dipilih, gunakan nama kolom "jenis_kelamin".
          break;
        case 3:
          col = "alamat"; // Jika kolom 3 dipilih, gunakan nama kolom "alamat".
          break;
        default: // Jika kolom tidak valid, tampilkan pesan error.
          System.out.println("Kolom tidak ditemukan");
          break;
      }
      id = this.bioDao.select(col, newValue); // Cari data berdasarkan nama kolom dan nilai yang dipilih.
      int confirmation = this.bioFrame.showConfirmation("hapus"); // Tampilkan konfirmasi penghapusan data.
      if (confirmation == 1) { // Jika konfirmasi tidak dikonfirmasi (pencet tombol "Tidak"), tampilkan pesan gagal.
        this.bioFrame.showAlertFailed("tidak dihapus");
        return;
      } else { // Jika konfirmasi dikonfirmasi (pencet tombol "Ya"), lanjutkan penghapusan.
        this.bioFrame.deleteBiodata(id); // Hapus data dari frame aplikasi biodata.
        this.bioDao.delete(id); // Hapus data dari database biodata.
        this.bioFrame.showAlertSuccess("dihapus"); // Tampilkan pesan sukses penghapusan data.
      }
    }
  }  }


