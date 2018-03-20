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
@Table(name = "laporanpembelian")
public class LaporanPembelian 
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")        
    private int id;
    @Column(name = "tanggal")        
    private String tanggal;
    @Column(name = "kodeBarang")        
    private String kodeBarang;
    @Column(name = "namaBarang")
    private String namaBarang;
    @Column(name = "jumlah")
    private int jumlah;
    @Column(name = "totalHarga")
    private double totalHarga;

    public LaporanPembelian() {
    }

    public LaporanPembelian(int id, String tanggal, String kodeBarang, String namaBarang, int jumlah, double totalHarga) {
        this.id = id;
        this.tanggal = tanggal;
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.jumlah = jumlah;
        this.totalHarga = totalHarga;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
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

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }
    
    
    
}
    