package org.koperasi.dao.impl;

/**
 *
 * @author Fujiatma Pratama
 */
import java.util.List;
import org.hibernate.Session;
import org.koperasi.dao.AkunDao;
import org.koperasi.model.Akun;
import org.koperasi.model.Menejer;
import org.koperasi.model.Pegawai;
import org.koperasi.util.HibernateUtil;


public class AkunDaoImplHibernate implements AkunDao {

    @Override
    public String login(String username, String password) {
        String str = "gagal";
        MenejerDaoImplHibernate menejerDao = new MenejerDaoImplHibernate();
        PegawaiDaoImplHibernate pegawaiDao = new PegawaiDaoImplHibernate();
        if (username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin123")) {
            str = "admin";
        }
        List<Menejer> menejers = menejerDao.getAllMenejer();
        List<Pegawai> pegawais = pegawaiDao.getAllPegawai();
        for (Pegawai pegawai : pegawais) {
            if (pegawai.getUsername().equalsIgnoreCase(username) && pegawai.getPassword().equalsIgnoreCase(password)) {
                str = "pegawai";
                break;
            }
        }
        for (Menejer menejer : menejers) {
            if (menejer.getUsername().equalsIgnoreCase(username) && menejer.getPassword().equalsIgnoreCase(password)) {
                str = "menejer";
                break;
            }
        }
        return str;
    }

    @Override
    public void updateAkun(String user, String role) {
        for (Akun akun : getAllAkun()) {
            if (akun.getId() == 1) {
                Session session = HibernateUtil.getSession();
                session.getTransaction().begin();
                akun.setUsername(user);
                akun.setRole(role);
                session.update(akun);
                session.getTransaction().commit();
                HibernateUtil.closeSession();
                break;
            }
        }
    }

    @Override
    public List<Akun> getAllAkun() {
        Session session = HibernateUtil.getSession();
        session.getTransaction().begin();
        List<Akun> akuns = session.createCriteria(Akun.class).list();
        session.getTransaction().commit();
        return akuns;
    }

    @Override
    public String getRole() {
        String str = null;
        for (Akun akun : getAllAkun()) {
            if (akun.getId() == 1) {
                str = akun.getRole();
                break;
            }
        }
        return str;
    }

    @Override
    public String getUser() {
        String str = null;
        for (Akun akun : getAllAkun()) {
            if (akun.getId() == 1) {
                str = akun.getUsername();
                break;
            }
        }
        return str;
    }

}
