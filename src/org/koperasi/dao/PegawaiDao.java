package org.koperasi.dao;

import java.util.List;
import org.koperasi.model.Pegawai;

/**
 *
 * @author Fujiatma Pratama
 */
public interface PegawaiDao 
{
    public void savePegawai(Pegawai pegawai);
//    public String getPath();
//    public void getFoto(String nim);
    public List<Pegawai> getAllPegawai();
//    public String getURLfoto();
    
}
