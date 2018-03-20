package org.koperasi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.koperasi.dao.LaporanPenjualanDao;
import org.koperasi.model.LaporanPenjualan;
import org.koperasi.model.Penjualan;
import org.koperasi.util.HibernateUtil;

/**
 *
 * @author Fujiatma Pratama
 */
public class LaporanPenjualanDaoImplHibernate implements LaporanPenjualanDao {

    @Override
    public void cariLaporanPenjualan(String tanggal) {

    }

    @Override
    public List<LaporanPenjualan> getAllLaporanPenjualan(String tanggal) {
        List<LaporanPenjualan> ks = new ArrayList<>();
        return ks;
    }

    @Override
    public void saveDataLaporanPenjualan(LaporanPenjualan lapJual) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(lapJual);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Penjualan> getAllLaporan() {
        List<Penjualan> ks = new ArrayList<>();
        return ks;
    }

}
