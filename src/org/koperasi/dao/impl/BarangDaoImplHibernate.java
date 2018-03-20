package org.koperasi.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.koperasi.dao.BarangDao;
import org.koperasi.model.Barang;
import org.koperasi.util.HibernateUtil;

/**
 *
 * @author Fujiatma Pratama
 */
public class BarangDaoImplHibernate implements BarangDao {

    @Override
    public void saveDataBarang(String kodeBarang, String namaBarang, double hargaSatuan, int stokBarang) {
        Barang b = new Barang(kodeBarang, namaBarang, hargaSatuan, stokBarang);
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(b);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    public Barang cariDataBarang(String kodeBarang) {
        Barang barang = new Barang();
        for (Barang brg : getAllBarang()) {
            if (brg.getKodeBarang().equalsIgnoreCase(kodeBarang)) {
                barang = brg;
                break;
            }
        }
        return barang;
    }

    @Override
    public List<Barang> getAllBarang() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Barang> barangs = session.createCriteria(Barang.class).list();
        session.getTransaction().commit();
        for (Barang m : barangs) {
            System.out.println("nama :" + m.getKodeBarang());
        }
        return barangs;
    }

    @Override
    public void updateDataBarang(Barang b) {
        for (Barang barang : getAllBarang()) {
            if (barang.getId() == b.getId()) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                session.update(barang);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
            }
        }

    }

    @Override
    public void deleteDataBarang(Barang b) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(b);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateJumlahDataBarang(String kodeBarang, int stokBarang) {
        int id = 0;
        for (Barang barang : getAllBarang()) {
            if (barang.getKodeBarang().equalsIgnoreCase(kodeBarang)) {
                id = barang.getId();
            }
        }

        for (Barang barang : getAllBarang()) {
            if (barang.getId() == id) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                barang.setStokBarang(barang.getStokBarang() - stokBarang);
                session.update(barang);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
            }
        }
    }

    @Override
    public int getStockBarang(String kodeBarang) {
        int id = 0, stok = 0;
        for (Barang barang : getAllBarang()) {
            if (barang.getKodeBarang().equalsIgnoreCase(kodeBarang)) {
                id = barang.getId();
            }
        }

        for (Barang barang : getAllBarang()) {
            if (barang.getId() == id) {
                stok = barang.getStokBarang();
            }
        }
        return stok;
    }

}
