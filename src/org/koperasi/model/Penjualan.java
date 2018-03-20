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
@Table(name = "Penjualan")
public class Penjualan 
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")    
    int id;
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
    @Column(name = "tanggalPenjualan")
    String tanggalPenjualan;

    public Penjualan() {
    }

    public Penjualan(String kodeBarang, String namaBarang, double hargaBarang, int jumlah, double totalharga, String tanggalPenjualan) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlah = jumlah;
        this.totalharga = totalharga;
        this.tanggalPenjualan = tanggalPenjualan;
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

    public String getTanggalPenjualan() {
        return tanggalPenjualan;
    }

    public void setTanggalPenjualan(String tanggalPenjualan) {
        this.tanggalPenjualan = tanggalPenjualan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
}
