/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author Putri Azizah
 */

import javax.swing.*;
import java.util.*;
import dao.AplikasiBioDao;
import ActionListener.SimpanActionListener;
import ActionListener.HapusActionListener;
import ActionListener.KeluarActionListener;

public class AplikasiBiodataFrame extends JFrame {
    private List<AplikasiBiodata> biodataList; 
    private final JTextField textFieldNama; 
    private final JTextField textFieldHP;
    private final JRadioButton jenisLaki; 
    private final JRadioButton jenisPerempuan; 
    private final JTextArea txtOutput; 
    private final BiodataTableModel tableModelApp; 
    private final JTable table; 
    private final AplikasiBioDao bioDao; 

    public AplikasiBiodataFrame(AplikasiBioDao bioDao) {
        
        this.bioDao = bioDao;
        this.biodataList = this.bioDao.findAll();
        
        JLabel labelHeader = new JLabel("Form Biodata", JLabel.CENTER);
        labelHeader.setBounds(0, 20, 350, 10);

        JLabel labelNama = new JLabel("Nama: ");
        labelNama.setBounds(15, 40, 350, 10);

        textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JLabel labelHP = new JLabel("Nomor HP: ");
        labelHP.setBounds(15, 100, 350, 10);

        textFieldHP = new JTextField();
        textFieldHP.setBounds(15, 120, 350, 30);
    
        JLabel labelRadio = new JLabel("Jenis Kelamin:");
        labelRadio.setBounds(15, 160, 350, 10);

        jenisLaki = new JRadioButton("Laki-Laki", true);
        jenisLaki.setBounds(15, 180, 350, 30);

        jenisPerempuan = new JRadioButton("Perempuan");
        jenisPerempuan.setBounds(15, 210, 350, 30);
    
        ButtonGroup bg = new ButtonGroup();
        bg.add(jenisLaki);
        bg.add(jenisPerempuan);

        JLabel labelAlamat = new JLabel("Alamat: ");
        labelAlamat.setBounds(15, 240, 350, 30);

        txtOutput = new JTextArea("");
        txtOutput.setBounds(15, 270, 350, 100);
  
        JButton simpanButton = new JButton("Simpan");
        simpanButton.setBounds(15, 380, 100, 40);

        JButton hapusButton  = new JButton("Hapus");
        hapusButton.setBounds(120, 380, 100, 40);

        table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 440,500,200);

        tableModelApp = new BiodataTableModel(biodataList);
        table.setModel(tableModelApp);

        SimpanActionListener simpanListener = new SimpanActionListener(this,bioDao);
        simpanButton.addActionListener(simpanListener);

        HapusActionListener hapusListener = new HapusActionListener(this,bioDao);
        hapusButton .addActionListener(hapusListener);
       
        KeluarActionListener keluarActionListener = new KeluarActionListener(this);
        this.addWindowListener(keluarActionListener);
       
        this.add(labelHeader);
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelHP);
        this.add(textFieldHP);
        this.add(labelRadio);
        this.add(jenisLaki);
        this.add(jenisPerempuan);
        this.add(labelAlamat);
        this.add(txtOutput);
        this.add(simpanButton);
        this.add(hapusButton );
        this.add(scrollableTable);
     
        this.setSize(550, 1000);
        this.setLayout(null);
    }
    public String getNama() {
      
        return textFieldNama.getText();
    }
    public JTextField getNamaTextField() {
          return textFieldNama;
    }
    public String getNoTelepon() {
        return textFieldHP.getText();
    }
    public JTextField getNoTeleponTextField() {
        return textFieldHP;
    }
    public JRadioButton getJenisLaki() {
        return jenisLaki;
    }
    public JRadioButton getJenisPerempuan() {
        return jenisPerempuan;
    } 
    public String getAlamat() {
        return txtOutput.getText();
    }
    public JTextArea getAlamatTextField() {
        return txtOutput;
    }
    public BiodataTableModel getTableModel() {
        return this. tableModelApp;
    }
    public JTable getTable() {
        return this.table;
    }
    public void addBiodata(AplikasiBiodata biodata) {
        
         tableModelApp.add(biodata);
        textFieldNama.setText("");
        textFieldHP.setText("");
        txtOutput.setText("");
    }
    public void deleteBiodata(AplikasiBiodata biodata) {
         tableModelApp.delete(biodata);
    }
    public void showAlertAllEmpty() {

        JOptionPane.showMessageDialog(AplikasiBiodataFrame.this, "Nama, telepon dan alamat belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }
    public void showAlertNameEmpty() {
       
        JOptionPane.showMessageDialog(AplikasiBiodataFrame.this, "Nama belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }
    public void showAlertTelephoneEmpty() {
        JOptionPane.showMessageDialog(AplikasiBiodataFrame.this, "Telepon belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }
    public void showAlertAddressEmpty() {
        JOptionPane.showMessageDialog(AplikasiBiodataFrame.this, "Alamat belum terisi", "Perhatian",
                JOptionPane.WARNING_MESSAGE);
    }
    public void showAlertSuccess(String message) {
        JOptionPane.showMessageDialog(AplikasiBiodataFrame.this, "Data " + message, "Perhatian",
                JOptionPane.INFORMATION_MESSAGE);
    }
    public void showAlertFailed(String message) {
        JOptionPane.showMessageDialog(AplikasiBiodataFrame.this, "Data " + message, "Perhatian",
                JOptionPane.ERROR_MESSAGE);
    }
    public int showConfirmation(String message) {
        return JOptionPane.showConfirmDialog(AplikasiBiodataFrame.this,
                "Apakah anda yakin ingin " + message + " data?", "Konfirmasi", JOptionPane.YES_NO_OPTION);
    }


}
