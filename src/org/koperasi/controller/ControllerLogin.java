package org.koperasi.controller;
import java.io.IOException;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import org.koperasi.dao.AkunDao;
import org.koperasi.dao.impl.AkunDaoImplHibernate;




/**
 *
 * @author Fujiatma Pratama
 */
public class ControllerLogin implements Initializable
{


    @FXML
    private TextField usernameTF;
    @FXML
    private PasswordField passwordPF;
    @FXML
    private Label labelAkunInvalid;
	
    private AkunDao aDao;

    public TextField getUsernameTF() {
        return usernameTF;
    }

    public ControllerLogin() {
        aDao = new AkunDaoImplHibernate();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public String getUser(){
        String username = usernameTF.getText();
        return username;
    }
    @FXML
    private void login(ActionEvent event) throws IOException {
        String username = usernameTF.getText();
        String pass = passwordPF.getText();
        String role = aDao.login(username, pass);
        aDao.updateAkun(username, role);
        if (role.equalsIgnoreCase("admin")) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parentDari = FXMLLoader.load(getClass().getResource("/org/koperasi/view/ViewDataBarang.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parentDari);
            stage.setScene(scene);
            stage.show();
        } else if (role.equalsIgnoreCase("pegawai")) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parentDari = FXMLLoader.load(getClass().getResource("/org/koperasi/view/ViewDataBarang.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parentDari);
            stage.setScene(scene);
            stage.show();
        } else if (role.equalsIgnoreCase("menejer")) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent parentDari = FXMLLoader.load(getClass().getResource("/org/koperasi/view/ViewDataBarang.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(parentDari);
            stage.setScene(scene);
            stage.show();
        } else if (role.equalsIgnoreCase("gagal")) {
            labelAkunInvalid.setVisible(true);
        }

    }
}

