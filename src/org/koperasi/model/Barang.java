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
@Table(name = "Barang")
public class Barang 
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")        
    private int id;
    @Column(name = "kodeBarang")        
    private String kodeBarang;
    @Column(name = "namaBarang")
    private String namaBarang;
    @Column(name = "hargaSatuan")
    private double hargaSatuan;
    @Column(name = "stokBarang")
    private int stokBarang;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    

    public Barang() {
    }

    public Barang(String kodeBarang, String namaBarang, double hargaSatuan, int stokBarang) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaSatuan = hargaSatuan;
        this.stokBarang = stokBarang;
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

    public double getHargaSatuan() {
        System.out.println(hargaSatuan);
        return hargaSatuan;
     
    }

    public void setHargaSatuan(double hargaBarang) {
        this.hargaSatuan = hargaBarang;
    }

    public int getStokBarang() {
        return stokBarang;
    }

    public void setStokBarang(int stokBarang) {
        this.stokBarang = stokBarang;
    }
    
    
    
}
