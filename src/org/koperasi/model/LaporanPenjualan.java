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
@Table(name = "laporanpenjualan")
public class LaporanPenjualan 
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")    
    int id;
    @Column(name = "kodeBarang")    
    String kodeBarang;
    @Column(name = "namaBarang")
    String namaBarang;
    @Column(name = "jumlah")
    int jumlah;
    @Column(name = "totalHarga")
    double totalharga;
    @Column(name = "tanggal")
    String tanggal;

    public LaporanPenjualan() {
    }

    public LaporanPenjualan(String kodeBarang, String namaBarang, int jumlah, double totalharga, String tanggal) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.totalharga = totalharga;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    

}
