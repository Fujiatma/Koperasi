package org.koperasi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Fujiatma Pratama
 */

@Entity
@Table(name = "Pembelian")
public class Pembelian 
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")        
    private int id;
    @Column(name = "kodeBarang")    
    String kodeBarang;
    @Column(name = "namaBarang")
    String namaBarang;
    @Column(name = "hargaBarang")
    double hargaBarang;
    @Column(name = "jumlah")
    int jumlah;
    @Column(name = "totalHarga")
    double totalharga;
    @Column(name = "tanggalPembelian")
    String tanggalPembelian;

    public Pembelian(String kodeBarang, String namaBarang, double hargaBarang, int jumlah, double totalharga, String tanggalPembelian) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlah = jumlah;
        this.totalharga = totalharga;
        this.tanggalPembelian = tanggalPembelian;
    }

    public Pembelian() {
    }
    
    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    public double getHargaBarang() {
        return hargaBarang;
    }

    public void setHargaBarang(double hargaBarang) {
        this.hargaBarang = hargaBarang;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public double getTotalharga() {
        return totalharga;
    }

    public void setTotalharga(double totalharga) {
        this.totalharga = totalharga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggalPembelian() {
        return tanggalPembelian;
    }

    public void setTanggalPembelian(String tanggalPembelian) {
        this.tanggalPembelian = tanggalPembelian;
    }
    
    

}
