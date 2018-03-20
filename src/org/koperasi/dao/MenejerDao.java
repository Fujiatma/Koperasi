package org.koperasi.dao;

import java.util.List;
import org.koperasi.model.Menejer;

/**
 *
 * @author Fujiatma Pratama
 */
public interface MenejerDao 
{
      public void saveMenejer(Menejer menejer);
//    public String getPath();
//    public void getFoto(String nim);
      public List<Menejer> getAllMenejer();
//    public String getURLfoto();
    
}
