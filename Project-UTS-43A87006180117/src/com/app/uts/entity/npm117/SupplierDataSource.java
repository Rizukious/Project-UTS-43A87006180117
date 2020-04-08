/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.entity.npm117;

import com.app.uts.npm117.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rizky Wahyudi
 */
public class SupplierDataSource {
     private Connection connection;
     
     public SupplierDataSource(){
         connection = ConnectionUtil.getConnection();
     }
     
     public List<Supplier> getALL(){
        List<Supplier> list = new ArrayList<>();
        String sql = "SELECT * FROM Supplier";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            Supplier spr;
            while (rs.next()) {   
                spr = new Supplier();
                spr.setIdSupplier(rs.getString("IdSupplier"));
                spr.setNamaSupplier(rs.getString("NamaSupplier"));
                spr.setAlamat(rs.getString("Alamat"));
                spr.setKota(rs.getString("Kota"));
                spr.setKodePost(rs.getString("KodePost"));
                list.add(spr);
            }
        } catch (Exception e) {
            System.out.println("Error get All"+e.getMessage());
        }
        return list;
    }
    
    //mengambil data tunggal / 1 id saja
    public Supplier getByID(String IdSupplier){
        //? adalah parameter yang di berikan sebagai ganti isi
        String sql = "SELECT * FROM Supplier WHERE IdSupplier = ?";
        Supplier spr = null;
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pengisian parameter ?
            statement.setString(1, IdSupplier);
            //ditampung dalam resutset
            ResultSet rs = statement.executeQuery();
            //Pengecekan data rs
            //pakai if karena data tunggal, tidak perlu pakai while
            if (rs.next()) {
                spr = new Supplier();
                spr.setIdSupplier(rs.getString("IdSupplier"));
                spr.setNamaSupplier(rs.getString("NamaSupplier"));
                spr.setAlamat(rs.getString("Alamat"));
                spr.setKota(rs.getString("Kota"));
                spr.setKodePost(rs.getString("KodePost"));
            }
        } catch (Exception e) {
        }
        return spr;
    }
    
    //Pembuatan Kelas Manipulasi database Insert
    public boolean insert(Supplier spr){
        boolean status = false;
        String sql = "INSERT INTO Supplier VALUES (?,?,?,?,?)";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            statement.setString(1, spr.getIdSupplier());
            statement.setString(2, spr.getNamaSupplier());
            statement.setString(3, spr.getAlamat());
            statement.setString(4, spr.getKota());
            statement.setString(5, spr.getKodePost());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Update
    public boolean update(Supplier spr){
        boolean status = false;
        String sql = "UPDATE Supplier SET NamaSupplier=?, Alamat=?, Kota=?, KodePost=? " +
                "WHERE IdSupplier=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Update, nim jadi dipaling akhir
            statement.setString(1, spr.getNamaSupplier());
            statement.setString(2, spr.getAlamat());
            statement.setString(3, spr.getKota());
            statement.setString(4, spr.getKodePost());
            statement.setString(5, spr.getIdSupplier());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
    
    //Pembuatan Kelas Manipulasi database Delete
    public boolean delete(Supplier spr){
        boolean status = false;
        String sql = "DELETE FROM Supplier WHERE IdSupplier=?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            //Pemasukan parameter dikarenakan semua varchar di setString
            //Delete, hanya 1 parameter saja
            statement.setString(1, spr.getIdSupplier());
            //ExecuteQuery ialah yang menghasilkan result row
            //ExecuterUpdate ialah untuk melakukan manipulasi (CRUD)
            //ditampung di intresult
            int result = statement.executeUpdate();
            //input lebih dari 0 berhasil
            status = result > 0;
        } catch (Exception e) {
        }
        return status;
    }
}
