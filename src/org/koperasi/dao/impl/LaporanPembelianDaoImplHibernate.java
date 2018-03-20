package org.koperasi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.koperasi.dao.LaporanPembelianDao;
import org.koperasi.model.LaporanPembelian;
import org.koperasi.model.Pembelian;
import org.koperasi.util.HibernateUtil;

/**
 *
 * @author Fujiatma Pratama
 */
public class LaporanPembelianDaoImplHibernate implements LaporanPembelianDao
{

    @Override
    public void cariLaporanPembelian(String tanggal) {

    }

    @Override
    public List<LaporanPembelian> getAllLaporanPembelian(String tanggal) {
        List<LaporanPembelian> ks = new ArrayList<>();
        return ks;
    }

    @Override
    public void saveDataLaporanPembelian(LaporanPembelian lapBeli) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(lapBeli);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Pembelian> getAllLaporan() {
        List<Pembelian> ks = new ArrayList<>();
        return ks;
    }
    
}
