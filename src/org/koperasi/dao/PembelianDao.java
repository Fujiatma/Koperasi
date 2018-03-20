package org.koperasi.dao;

import java.util.List;
import org.koperasi.model.Pembelian;

/**
 *
 * @author Fujiatma Pratama
 */
public interface PembelianDao {

    public void saveDBDataPembelianBarang(Pembelian p);

    public List<Pembelian> getAllPembelian();
    public List<Pembelian> getAllPembelianBerdasarkanTanggal(String tanggal);

    public void deleteDataPembelian(Pembelian p);

    public void updateDataPembelian(Pembelian p);

    //public void totalPembelian(Pembelian p);
}
