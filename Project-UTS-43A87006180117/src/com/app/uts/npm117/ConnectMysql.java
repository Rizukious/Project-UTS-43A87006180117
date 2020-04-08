/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.npm117;

import com.app.uts.entity.npm117.Supplier;
import com.app.uts.entity.npm117.SupplierDataSource;

/**
 *
 * @author Rizky Wahyudi
 */
public class ConnectMysql {
    SupplierDataSource datasource = new SupplierDataSource();
    
    
    public static void main(String[] args) {
            //Pemanggilan method insert
            //new ConnectMysql().testInsert();
           
            //Pemanggilan method update
            //new ConnectMysql().testUpdate();
        
            //Pemanggilan method delete
            new ConnectMysql().testDelete();
    }
    
     //pembuatan method insert
    public void testInsert(){
        //pemanggilan kelas mahasiswa
        Supplier spr = new Supplier();
        spr.setIdSupplier("0002");
        spr.setNamaSupplier("Anggi sagita");
        spr.setAlamat("Jl. Kenangan");
        spr.setKota("Bandung");
        spr.setKodePost("17114");
        boolean sukses = datasource.insert(spr);
        //berhasil
        if (sukses) {
            System.out.println("Insert Data Berhasil!");
        }else{
            System.out.println("Insert Data Gagal!");
        }
    }
    
    //pembuatan method Update
    public void testUpdate(){
        //pemanggilan kelas getByID
        Supplier spr = datasource.getByID("0001");
        spr.setNamaSupplier("Rizkiiiiiii");
        boolean sukses = datasource.update(spr);
        //berhasil
        if (sukses) {
            System.out.println("Update Data Berhasil!");
        }else{
            System.out.println("Update Data Gagal!");
        }
    }
    
     //pembuatan method Delete
    public void testDelete(){
        //pemanggilan kelas getByID
        Supplier spr = datasource.getByID("0002");
        boolean sukses = datasource.delete(spr);
        //berhasil
        if (sukses) {
            System.out.println("Delete Data Berhasil!");
        }else{
            System.out.println("Delete Data Gagal!");
        }
    }
}
