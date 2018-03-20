package org.koperasi.dao;

import java.util.List;
import org.koperasi.model.Barang;

/**
 *
 * @author Fujiatma Pratama
 */
public interface BarangDao 
{
    public void saveDataBarang(String kodeBarang, String namaBarang, double hargaSatuan, int stokBarang);
    public Barang cariDataBarang(String kodeBarang);
    public List<Barang> getAllBarang();
    public void updateDataBarang(Barang b);
    public void updateJumlahDataBarang(String kodeBarang,int stokBarang);
    public void deleteDataBarang(Barang b);
    public int getStockBarang(String kodeBarang);
}
