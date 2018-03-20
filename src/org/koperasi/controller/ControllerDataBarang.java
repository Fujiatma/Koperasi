package org.koperasi.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.koperasi.dao.BarangDao;
import org.koperasi.dao.impl.BarangDaoImplHibernate;
import org.koperasi.model.Barang;

/**
 *
 * @author Fujiatma Pratama
 */
public class ControllerDataBarang implements Initializable {

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    private TextField kodeBarangTF;
    @FXML
    private TextField namaBarangTF;
    @FXML
    private TextField hargaBarangTF;
    @FXML
    private TextField stokBarangTF;
    @FXML
    private TextField cariBarangTF;
    
    ////////////////////////////////////////////////////////////////////////////
    private BarangDao bDao;
    @FXML
    TableView<Barang> barangTV;          //Barang = nama kelas
    @FXML
    TableColumn<Barang, String> kodeBarangTV;    //kodeBarangTV = penamaan pada scenebuilder
    @FXML
    TableColumn<Barang, String> namaBarangTV;
    @FXML
    TableColumn<Barang, Double> hargaSatuanTV;
    @FXML
    TableColumn<Barang, Integer> stokTV;

    ObservableList<Barang> dataBarang;
    ////////////////////////////////////////////////////////////////////////////
    @FXML
    private MenuItem menuJual;
    ////////////////////////////////////////////////////////////////////////////

    private static String kodeBarang;
    private static String namaBarang;
    private static Double hargaSatuan;
    private static int stokBarang;

    public ControllerDataBarang() {
        bDao = new BarangDaoImplHibernate();
        barangTV = new TableView<>();

    }

    @FXML
    public void menuPenjualan(ActionEvent event) {
        System.out.println("no");
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/ViewDataPenjualan.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ControllerDataBarang.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void menuPembelian(ActionEvent event) throws IOException {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/ViewDataPembelian.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ioe) {

        }
    }

    @FXML
    public void menuItemLPenjualan(ActionEvent event) throws IOException {
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
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/viewLaporanPembelian.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ioe) {

        }
    }
    
    @FXML
    public void menuLogout(ActionEvent event) throws IOException{
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
    public void tambahBarang(ActionEvent event) {
        JOptionPane.showConfirmDialog(null, "Data Barang Berhasil Ditambah");
        String kodeBarang = (kodeBarangTF.getText().toString());
        String namaBarang = namaBarangTF.getText();
        double hargaSatuan = Double.parseDouble(hargaBarangTF.getText());
        int stokBarang = Integer.parseInt(stokBarangTF.getText());
        Barang b = new Barang(kodeBarang, namaBarang, hargaSatuan, stokBarang);
        bDao.saveDataBarang(kodeBarang, namaBarang, hargaSatuan, stokBarang);
        dataBarang.add(b);
        loadData();

    }

    private void inisialisiAwalInputan() {
        kodeBarangTF.setText("");
        namaBarangTF.setText("");
        hargaBarangTF.setText("");
        stokBarangTF.setText("");

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void updateBarang(ActionEvent event) {

        Object value1, value2;
        int value3, value4, value5;
        String val1, val2, val3, val4, val5;
        Barang brg = barangTV.getSelectionModel().getSelectedItem();
        if (barangTV.getSelectionModel().getSelectedItem() != null) {
            System.out.println("barang nama " + brg.getNamaBarang());

        }
        value1 = brg.getHargaSatuan();
        value2 = brg.getStokBarang();
        kodeBarangTF.setText(brg.getKodeBarang());
        namaBarangTF.setText(brg.getNamaBarang());
        hargaBarangTF.setText(value1.toString());
        stokBarangTF.setText(value2.toString());

        kodeBarang = brg.getKodeBarang();
        namaBarang = brg.getNamaBarang();
        hargaSatuan = brg.getHargaSatuan();
        stokBarang = brg.getStokBarang();

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void simpanPerubahan(ActionEvent event) {
        System.out.println(kodeBarang + "+++" + namaBarang + "+" + hargaSatuan);
        String kodeBarang = kodeBarangTF.getText();
        String namaBarang = namaBarangTF.getText();
        double hargaSatuan = Double.parseDouble(hargaBarangTF.getText());
        int stokBarang = Integer.parseInt(stokBarangTF.getText());
        Barang barang = new Barang(kodeBarang, namaBarang, hargaSatuan, stokBarang);
        bDao.updateDataBarang(barang);
        loadData();

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void hapusBarang(ActionEvent event) {

        Object value1, value2;
        int value3, value4, value5;
        String val1, val2, val3, val4, val5;
        Barang brg = barangTV.getSelectionModel().getSelectedItem();
        value1 = brg.getHargaSatuan();
        value2 = brg.getStokBarang();
        kodeBarangTF.setText(brg.getKodeBarang());
        namaBarangTF.setText(brg.getNamaBarang());
        hargaBarangTF.setText(value1.toString());
        stokBarangTF.setText(value2.toString());

        kodeBarang = brg.getKodeBarang();
        namaBarang = brg.getNamaBarang();
        hargaSatuan = brg.getHargaSatuan();
        stokBarang = brg.getStokBarang();

        String konfirm = "Apakah Anda Ingin Menghapus Data Barang Ini???";

        int confirm = JOptionPane.showConfirmDialog(null, konfirm, "Select an Option", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String kodeBarang = kodeBarangTF.getText();
            String namaBarang = namaBarangTF.getText();
            double hargaSatuan = Double.parseDouble(hargaBarangTF.getText());
            int stokBarang = Integer.parseInt(stokBarangTF.getText());
            bDao.deleteDataBarang(brg);
            loadData();
            inisialisiAwalInputan();
        }
    }
    ////////////////////////////////////////////////////////////////////////////

    public void loadData() {
        List<Barang> barangs = bDao.getAllBarang();
        for (Barang m : barangs) {
            System.out.println("nama :" + m.getKodeBarang());
        }
        dataBarang = FXCollections.observableArrayList(barangs);
        kodeBarangTV.setCellValueFactory(new PropertyValueFactory<Barang, String>("kodeBarang"));
        namaBarangTV.setCellValueFactory(new PropertyValueFactory<Barang, String>("namaBarang"));
        hargaSatuanTV.setCellValueFactory(new PropertyValueFactory<Barang, Double>("hargaSatuan"));
        stokTV.setCellValueFactory(new PropertyValueFactory<Barang, Integer>("stokBarang"));
        barangTV.setItems(dataBarang);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) //Perintah untuk memampukan program "Apa yang perlu ditampikan setelah diRun"
    {
        loadData();
    }
    ////////////////////////////////////////////////////////////////////////////
    public void loadTabelBerdasarkanKodeBarang() {
        String kode = cariBarangTF.getText();
        //List<Barang> barangs = bDao.
        boolean adaKode = false;
        for (Barang barang : bDao.getAllBarang()) {
            if (kode.equalsIgnoreCase(barang.getKodeBarang())) {
                adaKode = true;
            }
        }
        if (adaKode) {
            dataBarang = FXCollections.observableArrayList(bDao.cariDataBarang(kode));
            kodeBarangTV.setCellValueFactory(new PropertyValueFactory<Barang, String>("kodeBarang"));
            namaBarangTV.setCellValueFactory(new PropertyValueFactory<Barang, String>("namaBarang"));
            hargaSatuanTV.setCellValueFactory(new PropertyValueFactory<Barang, Double>("hargaSatuan"));
            stokTV.setCellValueFactory(new PropertyValueFactory<Barang, Integer>("stokBarang"));
            barangTV.setItems(dataBarang);
        } else {
            JOptionPane.showConfirmDialog(null, "Kode " + kode + " tidak ada");
        }

    }

    @FXML
    public void cariBarang(ActionEvent event) {
        loadTabelBerdasarkanKodeBarang();

    }

}
