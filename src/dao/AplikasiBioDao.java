/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

/**
 * @author Putri Azizah
 */
import db.MySqlConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
import biodata.AplikasiBiodata;

public class AplikasiBioDao {
    public int insert(AplikasiBiodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(
                    "Insert into biodata(id, nama, no_telepon, jenis_kelamin, alamat) values (?, ?, ?, ?, ?)");
            statement.setString(1, biodata.getId()); 
            statement.setString(2, biodata.getNama()); 
            statement.setString(3, biodata.getNoTelepon()); 
            statement.setString(4, biodata.getJenisKelamin()); 
            statement.setString(5, biodata.getAlamat()); 
            result = statement.executeUpdate();
            System.out.println("Insert data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public int delete(AplikasiBiodata biodata) {
        int result = -1;
        try (Connection connection = MySqlConnection.getInstance().getConnection()) {
            PreparedStatement statement = connection.prepareStatement("delete from biodata where id = ?");
            statement.setString(1, biodata.getId()); 
            result = statement.executeUpdate();
            System.out.println("Delete data: " + biodata.getId() + " " + biodata.getNama() + " "
                    + biodata.getNoTelepon() + " " + biodata.getJenisKelamin() + " " + biodata.getAlamat());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<AplikasiBiodata> findAll() {
        List<AplikasiBiodata> list = new ArrayList<>();
        try (
                Connection connection = MySqlConnection.getInstance().getConnection();   
                Statement statement = connection.createStatement();) {
            try (ResultSet resultSet = statement.executeQuery("select * from biodata order by nama asc")) {
                while (resultSet.next()) {
                    AplikasiBiodata biodata = new AplikasiBiodata();
                    biodata.setId(resultSet.getString("id")); 
                    biodata.setNama(resultSet.getString("nama"));
                    biodata.setNoTelepon(resultSet.getString("no_telepon")); 
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin")); 
                    biodata.setAlamat(resultSet.getString("alamat")); 
                    list.add(biodata);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public AplikasiBiodata select(String column, String value) {
        AplikasiBiodata biodata = new AplikasiBiodata();
        try (            
                Connection connection = MySqlConnection.getInstance().getConnection();
                Statement statement = connection.createStatement();
            ) {
            try (ResultSet resultSet = statement.executeQuery("select * from biodata where " + column+ " = '" + value + "'");) {
                while (resultSet.next()) { 
                    biodata.setId(resultSet.getString("id")); 
                    biodata.setNama(resultSet.getString("nama")); 
                    biodata.setNoTelepon(resultSet.getString("no_telepon")); 
                    biodata.setJenisKelamin(resultSet.getString("jenis_kelamin")); 
                    biodata.setAlamat(resultSet.getString("alamat")); 
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return biodata;
    } }