package org.koperasi.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.koperasi.dao.MenejerDao;
import org.koperasi.model.Menejer;
import org.koperasi.util.HibernateUtil;

/**
 *
 * @author Fujiatma Pratama
 */
public class MenejerDaoImplHibernate implements MenejerDao
{

   @Override
    public void saveMenejer(Menejer menejer) {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        session.save(menejer);
        session.getTransaction().commit();
        HibernateUtil.closeSession();
    }

    @Override
    public List<Menejer> getAllMenejer() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Menejer> menejers = session.createCriteria(Menejer.class).list();
        session.getTransaction().commit();
        for (Menejer m : menejers) {
            System.out.println("nama :" + m.getNama());
        }
        return menejers;
    }
}
