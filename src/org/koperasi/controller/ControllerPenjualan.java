package org.koperasi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.koperasi.dao.BarangDao;
import org.koperasi.dao.PenjualanDao;
import org.koperasi.dao.impl.BarangDaoImplHibernate;
import org.koperasi.dao.impl.PenjualanDaoImplHibernate;
import org.koperasi.model.Barang;
import org.koperasi.model.Penjualan;

/**
 *
 * @author Fujiatma Pratama
 */
public class ControllerPenjualan implements Initializable {

    @FXML
    private TextField kodeBarangPenjualanTF;
    @FXML
    private TextField namaBarangpenjualanTF;
    @FXML
    private TextField hargaBarangPenjualanTF;
    @FXML
    private TextField jumlahBarangPenjualanTF;
    @FXML
    private TextField uangPembeliTF;
    @FXML
    private TextField uangKembalianTF;
    @FXML
    private TextField TotalPenjualanTF;
    @FXML
    private Button cariBarang;

    @FXML
    private Button btnTambahUbah;
    ////////////////////////////////////////////////////////////////////////////

    private PenjualanDao jualDao;
    @FXML
    TableView<Penjualan> penjualanTV;
    @FXML
    TableColumn<Penjualan, String> kodeBarangJualTV;
    @FXML
    TableColumn<Penjualan, String> namaBarangJualTV;
    @FXML
    TableColumn<Penjualan, Double> hargaBarangJualTV;
    @FXML
    TableColumn<Penjualan, Integer> jumlahBarangJualTV;
    @FXML
    TableColumn<Penjualan, Double> totalHargaJualTV;
    @FXML
    TableColumn<Penjualan, String> tanggalJualTV;
    @FXML
    private DatePicker datePickJual;

    ObservableList<Penjualan> dataPenjualan;
    private BarangDao bDao;
    private List<Penjualan> penjualans;

    ////////////////////////////////////////////////////////////////////////////
    public ControllerPenjualan() {
        jualDao = new PenjualanDaoImplHibernate();
        penjualanTV = new TableView<>();
        penjualans = new ArrayList<>();
        bDao = new BarangDaoImplHibernate();

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void tambahPenjualan(ActionEvent event) {
        String kodeBarang, namaBarang, tanggalJual;
        int jumlahBarang;
        double totalHargaJual, hargaSatuan;

        kodeBarang = kodeBarangPenjualanTF.getText();
        namaBarang = namaBarangpenjualanTF.getText();
        hargaSatuan = Double.parseDouble(hargaBarangPenjualanTF.getText());
        jumlahBarang = Integer.parseInt(jumlahBarangPenjualanTF.getText());
        tanggalJual = (String) (((TextField) datePickJual.getEditor()).getText());
        totalHargaJual = hargaSatuan * jumlahBarang;

        Penjualan penjualan = new Penjualan(kodeBarang, namaBarang, hargaSatuan, jumlahBarang, totalHargaJual, tanggalJual);
        int i = 0;
        for (Penjualan jual : penjualans) {
            if (jual.getKodeBarang().equalsIgnoreCase(kodeBarang)) {
                penjualans.set(i, penjualan);
            }
            i++;
        }
        if (btnTambahUbah.getText().equalsIgnoreCase("Tambah")) {
            penjualans.add(penjualan);
        }

        loadTabelView();
        kodeBarangPenjualanTF.setText("");
        namaBarangpenjualanTF.setText("");
        hargaBarangPenjualanTF.setText("");
        jumlahBarangPenjualanTF.setText("");
        datePickJual.getEditor().setText("");
        btnTambahUbah.setText("Tambah");
    }

    public void loadTabelView() {

        dataPenjualan = FXCollections.observableArrayList(penjualans);
        kodeBarangJualTV.setCellValueFactory(new PropertyValueFactory<Penjualan, String>("kodeBarang"));
        namaBarangJualTV.setCellValueFactory(new PropertyValueFactory<Penjualan, String>("namaBarang"));
        hargaBarangJualTV.setCellValueFactory(new PropertyValueFactory<Penjualan, Double>("hargaBarang"));
        jumlahBarangJualTV.setCellValueFactory(new PropertyValueFactory<Penjualan, Integer>("jumlah"));
        totalHargaJualTV.setCellValueFactory(new PropertyValueFactory<Penjualan, Double>("totalharga"));
        tanggalJualTV.setCellValueFactory(new PropertyValueFactory<Penjualan, String>("tanggalPenjualan"));
        penjualanTV.setItems(dataPenjualan);
    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void ubahPenjualan(ActionEvent event) {
        Penjualan penjualan = penjualanTV.getSelectionModel().getSelectedItem();
        kodeBarangPenjualanTF.setText(penjualan.getKodeBarang());
        namaBarangpenjualanTF.setText(penjualan.getNamaBarang());
        hargaBarangPenjualanTF.setText("" + penjualan.getHargaBarang());
        jumlahBarangPenjualanTF.setText("" + penjualan.getJumlah());
        datePickJual.getEditor().setText(penjualan.getTanggalPenjualan());
        btnTambahUbah.setText("Ubah");

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void hapusPenjualan(ActionEvent event) {
        Penjualan penjualan = penjualanTV.getSelectionModel().getSelectedItem();
        int i = 0;
        List<Penjualan> tmpPenjualans = penjualans;
        for (Penjualan jual : tmpPenjualans) {
            if (jual.getKodeBarang().equalsIgnoreCase(penjualan.getKodeBarang())) {
                break;
            }
            i++;
        }
        for (int j = i; j < tmpPenjualans.size() - 1; j++) {
            if (j == tmpPenjualans.size() - 1) {
                tmpPenjualans.set(j, null);
            } else {
                tmpPenjualans.set(j, tmpPenjualans.get(j + 1));
            }
        }
        penjualans = new ArrayList<>();
        for (int k = 0; k < tmpPenjualans.size() - 1; k++) {
            penjualans.add(tmpPenjualans.get(k));
        }
        loadTabelView();
        //System.out.println(i);
    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void totalPenjualan(ActionEvent event) {
        double total = 0;
        for (Penjualan penjualan : penjualans) {
            total += penjualan.getTotalharga();
        }
        TotalPenjualanTF.setText("" + total);

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void hitungPenjualan(ActionEvent event) {
        double uangPembeli, uangKembalian, totalPenjualan;
        uangPembeli = Double.parseDouble(uangPembeliTF.getText());
        totalPenjualan = Double.parseDouble(TotalPenjualanTF.getText());
        uangKembalian = uangPembeli - totalPenjualan;

        if (uangKembalian <= 0) {
            JOptionPane.showConfirmDialog(null, "Uang Anda Kurang!! Tambahkan Uang Anda!!");
        } else {
            uangKembalianTF.setText(String.valueOf(uangKembalian));
        }
//        uangKembalian = Double.parseDouble(uangKembalianTF.getText());

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void simpanPenjualan(ActionEvent event) {
        boolean bisaSave = true;
        String kodeDup = "";
        for (Penjualan penjualan : penjualans) {
            for (Barang barang : bDao.getAllBarang()) {
                if (barang.getKodeBarang().equalsIgnoreCase(penjualan.getKodeBarang())) {
                    bisaSave = false;
                    kodeDup += (penjualan.getKodeBarang() + ", ");
                }
            }
        }

        for (Penjualan penjualan : penjualans) {
            String kodeBarang = penjualan.getKodeBarang();
            String namaBarang = penjualan.getNamaBarang();
            double hargaBarang = penjualan.getHargaBarang();
            int jumlah = penjualan.getJumlah();
            double totalHarga = penjualan.getTotalharga();
            String tanggalJual = penjualan.getTanggalPenjualan();
            Penjualan jual = new Penjualan(kodeBarang, namaBarang, hargaBarang, jumlah, totalHarga, tanggalJual);
            if (bDao.getStockBarang(kodeBarang) < jumlah) {
                JOptionPane.showMessageDialog(null, "Stok barang " + namaBarang + " tidak cukup, stok barang tinggal " + bDao.getStockBarang(kodeBarang));
            } else {
                jualDao.saveDBDataPenjualanBarang(jual);
                bDao.updateJumlahDataBarang(kodeBarang, jumlah);
                JOptionPane.showMessageDialog(null, "Barang dengan kode " + kodeDup + " sudah dikurangi");
            }

        }

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void menuPembelian(ActionEvent event) {
        System.out.println("no");
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/ViewDataPembelian.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
        }
    }

    @FXML
    public void menuDataBarang(ActionEvent event) throws IOException {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/ViewDataBarang.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ioe) {

        }
    }

    @FXML
    public void menuItemLPenjualan(ActionEvent event) throws IOException {
        System.out.println("dipanggilnya");
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/viewLaporanPenjualan.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ioe) {

        }
    }

    @FXML
    public void menuItemLPembelian(ActionEvent event) throws IOException {
        System.out.println("dipanggilnya");
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/ViewLaporanPembelian.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ioe) {

        }
    }

    public void menuLogout(ActionEvent event) throws IOException {
        System.out.println("dipanggil");
        int confirm = JOptionPane.showConfirmDialog(null, "Anda Yakin ingin Logout?");
        if (confirm == JOptionPane.OK_OPTION) {
            System.out.println("dipanggilnya");
            try {
                ((Node) (event.getSource())).getScene().getWindow().hide();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/ViewLogin.fxml"));
                Parent root1 = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (IOException ioe) {

            }

        }
    }
    ////////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField cariBarangTF;

    public void loadTabelBerdasarkanNamaBarang() {
        String namabarang = cariBarangTF.getText();
       // List<Barang> barangs = bDao.
        boolean adaKode = false;
        for (Barang barang : bDao.getAllBarang()) {
            if (namabarang.equalsIgnoreCase(barang.getNamaBarang())) {
                adaKode = true;
                if (adaKode) {
                    kodeBarangPenjualanTF.setText(barang.getKodeBarang());
                    namaBarangpenjualanTF.setText(barang.getNamaBarang());
                    hargaBarangPenjualanTF.setText(String.valueOf(barang.getHargaSatuan()));
                } else 
                {
                   JOptionPane.showInternalMessageDialog(null, "Nama barang " + namabarang + " tidak ada");
                }
            }

        }

    }

    @FXML
    public void cariBarang(ActionEvent event) {
        loadTabelBerdasarkanNamaBarang();

    }

    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
