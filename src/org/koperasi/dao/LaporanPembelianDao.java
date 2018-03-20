package org.koperasi.dao;

import java.util.List;
import org.koperasi.model.LaporanPembelian;
import org.koperasi.model.Pembelian;

/**
 *
 * @author Fujiatma Pratama
 */
public interface LaporanPembelianDao {

    public void cariLaporanPembelian(String tanggal);

    public List<LaporanPembelian> getAllLaporanPembelian(String tanggal);

    public void saveDataLaporanPembelian(LaporanPembelian lapBeli);

    public List<Pembelian> getAllLaporan();

}
