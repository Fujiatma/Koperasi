package org.koperasi.dao;

/**
 *
 * @author Fujiatma Pratama
 */
import java.util.List;
import org.koperasi.model.Akun;

public interface AkunDao {
    public void updateAkun(String user, String role);
    public String login(String username, String password);
    public List<Akun> getAllAkun();
    public String getRole();
    public String getUser();
}
