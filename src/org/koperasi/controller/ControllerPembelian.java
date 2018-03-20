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
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.koperasi.dao.BarangDao;
import org.koperasi.dao.PembelianDao;
import org.koperasi.dao.impl.BarangDaoImplHibernate;
import org.koperasi.dao.impl.PembelianDaoImplHibernate;
import org.koperasi.model.Barang;
import org.koperasi.model.Pembelian;

/**
 *
 * @author Fujiatma Pratama
 */
public class ControllerPembelian implements Initializable {

    @FXML
    private TextField kodeBarangBeliTF;
    @FXML
    private TextField namaBarangBeliTF;
    @FXML
    private TextField hargaBarangBeliTF;
    @FXML
    private TextField jumlahBarangBeliTF;
    @FXML
    private TextField totalPembelianTF;
    @FXML
    private DatePicker datePickBeli;

    private List<Pembelian> pembelians;
    ////////////////////////////////////////////////////////////////////////////

    private PembelianDao beliDao;
    @FXML
    TableView<Pembelian> pembelianTV;
    @FXML
    TableColumn<Pembelian, String> kodeBarangBeliTV;
    @FXML
    TableColumn<Pembelian, String> namaBarangBeliTV;
    @FXML
    TableColumn<Pembelian, Double> hargaBarangBeliTV;
    @FXML
    TableColumn<Pembelian, Integer> jumlahBarangBeliTV;
    @FXML
    TableColumn<Pembelian, Double> totalHargaBeliTV;
    @FXML
    TableColumn<Pembelian, String> tanggalPembelianTV;
    @FXML
    private Button btnTambahUbah;

    ObservableList<Pembelian> dataPembelian;
    private BarangDao bDao;

    public ControllerPembelian() {
        beliDao = new PembelianDaoImplHibernate();
        pembelianTV = new TableView<>();
        pembelians = new ArrayList<>();
        bDao = new BarangDaoImplHibernate();

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void tambahPembelian(ActionEvent event) {
        String kodeBarang, namaBarang, tanggalBeli;
        int jumlahBarang;
        double totalHargaBeli, hargaSatuan;

        kodeBarang = kodeBarangBeliTF.getText();
        namaBarang = namaBarangBeliTF.getText();
        hargaSatuan = Double.parseDouble(hargaBarangBeliTF.getText());
        jumlahBarang = Integer.parseInt(jumlahBarangBeliTF.getText());
        tanggalBeli = (String) (((TextField) datePickBeli.getEditor()).getText());
        totalHargaBeli = hargaSatuan * jumlahBarang;

        Pembelian pembelian = new Pembelian(kodeBarang, namaBarang, hargaSatuan, jumlahBarang, totalHargaBeli, tanggalBeli);
        int i = 0;
        for (Pembelian beli : pembelians) {
            if (beli.getKodeBarang().equalsIgnoreCase(kodeBarang)) {
                pembelians.set(i, pembelian);
            }
            i++;
        }
        if (btnTambahUbah.getText().equalsIgnoreCase("Tambah")) {
            pembelians.add(pembelian);
        }

        loadTabelView();
        kodeBarangBeliTF.setText("");
        namaBarangBeliTF.setText("");
        hargaBarangBeliTF.setText("");
        jumlahBarangBeliTF.setText("");
        datePickBeli.getEditor().setText("");
        btnTambahUbah.setText("Tambah");

    }

    public void loadTabelView() {

        dataPembelian = FXCollections.observableArrayList(pembelians);
        kodeBarangBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, String>("kodeBarang"));
        namaBarangBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, String>("namaBarang"));
        hargaBarangBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, Double>("hargaBarang"));
        jumlahBarangBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, Integer>("jumlah"));
        totalHargaBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, Double>("totalharga"));
        tanggalPembelianTV.setCellValueFactory(new PropertyValueFactory<Pembelian, String>("tanggalPembelian"));
        pembelianTV.setItems(dataPembelian);
    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void ubahPembelian(ActionEvent event) {
        Pembelian pembelian = pembelianTV.getSelectionModel().getSelectedItem();
        kodeBarangBeliTF.setText(pembelian.getKodeBarang());
        namaBarangBeliTF.setText(pembelian.getNamaBarang());
        hargaBarangBeliTF.setText("" + pembelian.getHargaBarang());
        jumlahBarangBeliTF.setText("" + pembelian.getJumlah());
        datePickBeli.getEditor().setText(pembelian.getTanggalPembelian());
        btnTambahUbah.setText("Ubah");

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void hapusPembelian(ActionEvent event) {
        Pembelian pembelian = pembelianTV.getSelectionModel().getSelectedItem();
        int i = 0;
        List<Pembelian> tmpPembelians = pembelians;
        for (Pembelian beli : tmpPembelians) {
            if (beli.getKodeBarang().equalsIgnoreCase(pembelian.getKodeBarang())) {
                break;
            }
            i++;
        }
        for (int j = i; j < tmpPembelians.size() - 1; j++) {
            if (j == tmpPembelians.size() - 1) {
                tmpPembelians.set(j, null);
            } else {
                tmpPembelians.set(j, tmpPembelians.get(j + 1));
            }
        }
        pembelians = new ArrayList<>();
        for (int k = 0; k < tmpPembelians.size() - 1; k++) {
            pembelians.add(tmpPembelians.get(k));
        }
        loadTabelView();
        //System.out.println(i);

    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void totalPembelian(ActionEvent event) {
        double total = 0;
        for (Pembelian pembelian : pembelians) {
            total += pembelian.getTotalharga();
        }
        totalPembelianTF.setText("" + total);
    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void simpanPembelian(ActionEvent event) {
        boolean bisaSave = true;
        String kodeDup = "";
        for (Pembelian pembelian : pembelians) {
            for (Barang barang : bDao.getAllBarang()) {
                if (barang.getKodeBarang().equalsIgnoreCase(pembelian.getKodeBarang())) {
                    bisaSave = false;
                    kodeDup += (pembelian.getKodeBarang() + ", ");
                }
            }
        }

        for (Pembelian pembelian : pembelians) {
            String kodeBarang = pembelian.getKodeBarang();
            String namaBarang = pembelian.getNamaBarang();
            double hargaBarang = pembelian.getHargaBarang();
            int jumlah = pembelian.getJumlah();
            double totalHarga = pembelian.getTotalharga();
            String tanggalBeli = pembelian.getTanggalPembelian();
            Pembelian beli = new Pembelian(kodeBarang, namaBarang, hargaBarang, jumlah, totalHarga, tanggalBeli);
            if (bisaSave) {
                beliDao.saveDBDataPembelianBarang(beli);
                bDao.saveDataBarang(kodeBarang, namaBarang, hargaBarang, jumlah);
            } else {
                JOptionPane.showConfirmDialog(null, "Barang dengan kode " + kodeDup + " sudah ada");

            }

        }

    }

    ////////////////////////////////////////////////////////////////////////////
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/viewLaporanPembelian.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ioe) {

        }
    }

    ////////////////////////////////////////////////////////////////////////////
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
    @Override
    public void initialize(URL location, ResourceBundle resources
    ) {

    }

}
