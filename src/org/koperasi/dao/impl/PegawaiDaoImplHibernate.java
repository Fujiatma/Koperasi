package org.koperasi.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.koperasi.dao.PegawaiDao;
import org.koperasi.model.Barang;
import org.koperasi.model.Pegawai;
import org.koperasi.util.HibernateUtil;

/**
 *
 * @author Fujiatma Pratama
 */
public class PegawaiDaoImplHibernate implements PegawaiDao {

    @Override
    public void savePegawai(Pegawai pegawai) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(pegawai);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Pegawai> getAllPegawai() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Pegawai> pegawais = session.createCriteria(Pegawai.class).list();
        session.getTransaction().commit();
        for (Pegawai m : pegawais) {
            System.out.println("nama :" + m.getNama());
        }
        return pegawais;
    }

}
