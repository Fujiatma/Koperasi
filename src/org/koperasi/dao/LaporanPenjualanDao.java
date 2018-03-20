package org.koperasi.dao;

import java.util.List;
import org.koperasi.model.LaporanPenjualan;
import org.koperasi.model.Penjualan;

/**
 *
 * @author Fujiatma Pratama
 */
public interface LaporanPenjualanDao 
{
    public void cariLaporanPenjualan(String tanggal);
    public List<LaporanPenjualan> getAllLaporanPenjualan(String tanggal);
    public void saveDataLaporanPenjualan(LaporanPenjualan lapJual);
    public List<Penjualan> getAllLaporan();
}
