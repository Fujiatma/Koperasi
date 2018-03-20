package org.koperasi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.koperasi.dao.PembelianDao;
import org.koperasi.model.Pembelian;
import org.koperasi.util.HibernateUtil;

/**
 *
 * @author Fujiatma Pratama
 */
public class PembelianDaoImplHibernate implements PembelianDao {

    @Override
    public void saveDBDataPembelianBarang(Pembelian p) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(p);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Pembelian> getAllPembelian() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Pembelian> belis = session.createCriteria(Pembelian.class).list();
        session.getTransaction().commit();
        return belis;
    }

    @Override
    public void deleteDataPembelian(Pembelian p) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(p);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateDataPembelian(Pembelian p) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(p);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Pembelian> getAllPembelianBerdasarkanTanggal(String tanggal) {
        List<Pembelian> allPembelian = new ArrayList<>();
        for (Pembelian pembelian : getAllPembelian()) {
            if (pembelian.getTanggalPembelian().equalsIgnoreCase(tanggal)) {
                allPembelian.add(pembelian);
            }
        }
        return allPembelian;
    }

}
