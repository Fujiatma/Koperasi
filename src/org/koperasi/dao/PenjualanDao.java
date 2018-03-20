package org.koperasi.dao;

import java.util.List;
import org.koperasi.model.Penjualan;

/**
 *
 * @author Fujiatma Pratama
 */
public interface PenjualanDao 
{
    public void saveDBDataPenjualanBarang(Penjualan p);

    public List<Penjualan> getAllPenjualan();
    public List<Penjualan> getAllPenjualanBerdasarkanTanggal(String tanggal);

    public void deleteDataPenjualan(Penjualan p);

    public void updateDataPenjualan(Penjualan p);
    
}
