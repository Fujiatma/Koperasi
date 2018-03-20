package org.koperasi.controller;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import org.koperasi.dao.LaporanPembelianDao;
import org.koperasi.dao.PembelianDao;
import org.koperasi.dao.impl.PembelianDaoImplHibernate;
import org.koperasi.model.LaporanPembelian;
import org.koperasi.model.Pembelian;

/**
 *
 * @author Fujiatma Pratama
 */
public class ControllerLaporanPembelian implements Initializable {

    @FXML
    private DatePicker datePickTanggalAwal;
    @FXML
    private DatePicker datePickTanggalAkhir;

    private PembelianDao beliDao;
    private List<Pembelian> pembelians;
    ObservableList<Pembelian> dataPembelian;

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    TableView<Pembelian> LPembelianTV;
    @FXML
    TableColumn<Pembelian, String> kodeBarangLBeliTV;
    @FXML
    TableColumn<Pembelian, String> namaLBeliTV;
    @FXML
    TableColumn<Pembelian, Double> hargaLBeliTV;
    @FXML
    TableColumn<Pembelian, Integer> jumlahLBeliTV;
    @FXML
    TableColumn<Pembelian, String> tanggalLBeliTV;

    ObservableList<Pembelian> dataBeliBarang;

    ////////////////////////////////////////////////////////////////////////////
    public ControllerLaporanPembelian() {
        beliDao = new PembelianDaoImplHibernate();
        LPembelianTV = new TableView<>();
    }

    ////////////////////////////////////////////////////////////////////////////
    public void loadTabelView() {
        String tanggal = (String) ((TextField) datePickTanggalAwal.getEditor()).getText();
        List<Pembelian> allPembelian = beliDao.getAllPembelianBerdasarkanTanggal(tanggal);
        dataPembelian = FXCollections.observableArrayList(allPembelian);
        kodeBarangLBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, String>("kodeBarang"));
        namaLBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, String>("namaBarang"));
        jumlahLBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, Integer>("jumlah"));
        hargaLBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, Double>("totalharga"));
        tanggalLBeliTV.setCellValueFactory(new PropertyValueFactory<Pembelian, String>("tanggalPembelian"));
        LPembelianTV.setItems(dataPembelian);
        pembelian = allPembelian;

    }

    List<Pembelian> pembelian = new ArrayList();

    @FXML
    public void cariLaporan(ActionEvent event) {
        loadTabelView();
    }

    ////////////////////////////////////////////////////////////////////////////
    @FXML
    public void cetakPDFPembelian(ActionEvent event) throws IOException, DocumentException {
        Document document = new Document();
        try {

            for (Pembelian p : pembelian) {
                String tanggal = p.getTanggalPembelian();
                String kodeBarang = p.getKodeBarang();
                String namaBarang = p.getNamaBarang();
                int jumlahBarang = p.getJumlah();
                double totalHarga = p.getTotalharga();
                PdfWriter.getInstance(document, new FileOutputStream("D:/Laporan Pembelian.pdf"));
                document.open();
                Paragraph para = new Paragraph("Tanggal : " + tanggal + "\nKode Barang : " + kodeBarang + "\nNama Barang : " + namaBarang + "\nJumlah Barang : " + jumlahBarang + "\nHarga Total : " + totalHarga);
                document.add(para);
                JOptionPane.showMessageDialog(null, "Laporan sudah Tersimpan dalam Bentuk PDF");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        document.close();
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
    public void menuDataBarang(ActionEvent event) throws IOException {
        try {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/koperasi/view/viewDataBarang.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.show();
        } catch (IOException ioe) {

        }
    }

    @FXML
    public void menuLogout(ActionEvent event) {
        System.out.println("dipanggil");
        int confirm = JOptionPane.showConfirmDialog(null, "Anda Yakin ingin Logout?");
        if (confirm == JOptionPane.OK_OPTION) {
            System.out.println("dipanggilnya");
                ((Node) (event.getSource())).getScene().getWindow().hide();
            try {
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
    public void initialize(URL location, ResourceBundle resources) {

    }

}
