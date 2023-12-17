/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;
/**
 * @author Putri Azizah
 */
import javax.swing.table.*;
import java.util.List;

public class BiodataTableModel extends AbstractTableModel {
    private String[] columnNames = { "Nama", "Nomor HP", "Jenis Kelamin", "Alamat" };
    private List<AplikasiBiodata> data;
    public BiodataTableModel(List<AplikasiBiodata> data) {
        this.data = data;
    }
    public int getColumnCount() {
        return columnNames.length;
    }
    public int getRowCount() {
        return data.size();
    }
    public String getColumnName(int col) {
        return columnNames[col];
    }
    public Object getValueAt(int row, int col) {
        AplikasiBiodata rowItem = data.get(row);
        String value = "";
        switch (col) {
            case 0:
                value = rowItem.getNama();
                break;
            case 1:
                value = rowItem.getNoTelepon();
                break;
            case 2:
                value = rowItem.getJenisKelamin();
                break;
            case 3:
                value = rowItem.getAlamat();
                break;
        }
        return value;
    }
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    public void add(AplikasiBiodata value) {
        data.add(value);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
    public void delete(AplikasiBiodata value) {
        int i = 0;
        for (AplikasiBiodata ApkBio : data) {
            if ( ApkBio.getId().equals(value.getId())) {
                data.remove(i);      
                break;
            }
       
            i++;
        }
        fireTableRowsDeleted(data.size() - 1,
                data.size() - 1);
    }
}

