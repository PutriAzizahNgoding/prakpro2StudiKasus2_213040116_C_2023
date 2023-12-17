/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ActionListener;
/**
 * @author Putri Azizah
 */
import java.awt.event.*;
import java.util.UUID;
import biodata.AplikasiBiodata;
import biodata.AplikasiBiodataFrame;
import dao.AplikasiBioDao;
public class SimpanActionListener implements ActionListener {
    private final AplikasiBiodataFrame bioFrame; 
    private final AplikasiBioDao bioDao; 
    public SimpanActionListener(AplikasiBiodataFrame bioFrame, AplikasiBioDao bioDao) {
        this.bioFrame  = bioFrame;
        this.bioDao = bioDao;
    }
    public void actionPerformed(ActionEvent e) {
        String jenisKelamin = "";
        if (bioFrame.getJenisLaki().isSelected()) {
            jenisKelamin = bioFrame.getJenisLaki().getText();
            bioFrame.getJenisLaki().setSelected(false);
        }
        if (bioFrame.getJenisPerempuan().isSelected()) {
            jenisKelamin = bioFrame.getJenisPerempuan().getText();
            bioFrame.getJenisPerempuan().setSelected(false);
        }
        String nama = bioFrame.getNama();
        String telepon = bioFrame.getNoTelepon();
        String alamat = bioFrame.getAlamat();
        if (nama.equalsIgnoreCase("") && telepon.equalsIgnoreCase("") && alamat.equalsIgnoreCase("")) {
            this.bioFrame.showAlertAllEmpty();
            return;
        } else {
            if (nama.equalsIgnoreCase("")) {
                this.bioFrame.showAlertNameEmpty();
                return;
            }
            if (telepon.equalsIgnoreCase("")) {
            
                this.bioFrame.showAlertTelephoneEmpty();
                return;
            }
            if (alamat.equalsIgnoreCase("")) {
         
                this.bioFrame.showAlertAddressEmpty();
                return;
            } }
        int confirmation = this.bioFrame.showConfirmation("tambah");
        if (confirmation == 0) {
            AplikasiBiodata biodata = new AplikasiBiodata();
            biodata.setId(UUID.randomUUID().toString());
            biodata.setNama(nama);
            biodata.setNoTelepon(telepon);
            biodata.setJenisKelamin(jenisKelamin);
            biodata.setAlamat(alamat);
            this.bioFrame.addBiodata(biodata);
            this.bioDao.insert(biodata);
            this.bioFrame.showAlertSuccess("Data ditambahkan");
        } else {  
            this.bioFrame.showAlertFailed("Data tidak ditambahkan");
        }
        this.bioFrame.getNamaTextField().setText("");
        this.bioFrame.getNoTeleponTextField().setText("");
        this.bioFrame.getAlamatTextField().setText("");
    }  }

