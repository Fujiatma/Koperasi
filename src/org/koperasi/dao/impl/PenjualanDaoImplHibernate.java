package org.koperasi.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.koperasi.dao.PenjualanDao;
import org.koperasi.model.Penjualan;
import org.koperasi.util.HibernateUtil;

/**
 *
 * @author Fujiatma Pratama
 */
public class PenjualanDaoImplHibernate implements PenjualanDao
{

    @Override
    public void saveDBDataPenjualanBarang(Penjualan p) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(p);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Penjualan> getAllPenjualan() 
    { Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Penjualan> juals = session.createCriteria(Penjualan.class).list();
        session.getTransaction().commit();
        return juals;
       
    }

    @Override
    public void deleteDataPenjualan(Penjualan p)
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.delete(p);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public void updateDataPenjualan(Penjualan p) 
    {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.update(p);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Penjualan> getAllPenjualanBerdasarkanTanggal(String tanggal) {
        List<Penjualan> allPenjualan = new ArrayList<>();
        for(Penjualan penjualan : getAllPenjualan()){
            if(penjualan.getTanggalPenjualan().equalsIgnoreCase(tanggal)){
                allPenjualan.add(penjualan);
            }
        }
        return allPenjualan;
    }
    
}
