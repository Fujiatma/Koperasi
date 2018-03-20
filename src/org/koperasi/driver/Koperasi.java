package org.koperasi.driver;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Fujiatma Pratama
 */
public class Koperasi extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception 
    {
        Parent parent = FXMLLoader.load(getClass().getResource("/org/koperasi/view/ViewLogin.fxml"));
        Scene scene = new Scene(parent, 500, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
}
