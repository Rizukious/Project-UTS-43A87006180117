/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.uts.entity.npm117;

/**
 *
 * @author Rizky Wahyudi
 */
public class Supplier {
    //pembuatan variable
    private String IdSupplier;
    private String NamaSupplier;
    private String Alamat;
    private String Kota;
    private String KodePost;
    
    public Supplier(){
        
    }
    
    //pembuatan constructor
    public Supplier(String IdSupplier, String NamaSupplier, String Alamat, String Kota, String KodePost) {
        this.IdSupplier = IdSupplier;
        this.NamaSupplier = NamaSupplier;
        this.Alamat = Alamat;
        this.Kota = Kota;
        this.KodePost = KodePost;
    }

    public String getIdSupplier() {
        return IdSupplier;
    }

    public void setIdSupplier(String IdSupplier) {
        this.IdSupplier = IdSupplier;
    }

    public String getNamaSupplier() {
        return NamaSupplier;
    }

    public void setNamaSupplier(String NamaSupplier) {
        this.NamaSupplier = NamaSupplier;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getKota() {
        return Kota;
    }

    public void setKota(String Kota) {
        this.Kota = Kota;
    }

    public String getKodePost() {
        return KodePost;
    }

    public void setKodePost(String KodePost) {
        this.KodePost = KodePost;
    }
    
    
}
