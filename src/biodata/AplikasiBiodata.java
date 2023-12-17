/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package biodata;

/**
 *
 * @author Putri Azizah
 */

public class AplikasiBiodata {
    private String id; // Mendefinisikan field privat bertipe String bernama id
    private String nama;  // Mendefinisikan field privat bertipe String bernama nama
    private String noTelepon; // Mendefinisikan field privat bertipe String bernama noTelepon 
    private String jenisKelamin;  // Mendefinisikan field privat bertipe String bernama jenisKelamin
    private String alamat;    // Mendefinisikan field privat bertipe String bernama alamat 
   
    public void setId(String id) { // method setter Id
        this.id = id;
    }
    public String getId() { // method getter Id 
        return this.id;
    } 
    public void setNama(String nama) { // method setter Nama
        this.nama = nama;
    }
    public String getNama() {  // method getter Nama
        return this.nama;
    } 
    public void setNoTelepon(String noTelepon) { // method setter NoTelepon
        this.noTelepon = noTelepon;
    }
    public String getNoTelepon() {  // method getter NoTelepon
        return this.noTelepon;
    }
    public void setJenisKelamin(String jenisKelamin) { // method setter JenisKelamin
        this.jenisKelamin = jenisKelamin;
    }
    public String getJenisKelamin() { // method getter JenisKelamin
        return this.jenisKelamin;
    }
    public void setAlamat(String alamat) { // method setter Alamat
        this.alamat = alamat;
    }
    public String getAlamat() { // method getter Alamat
        return this.alamat;
    }
}