/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.knnapp;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 *
 * @author TassioGustavo
 */
public class MainScreenController implements Initializable{

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }
    
    @FXML
    public void abreBuscarSerie(javafx.event.ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/BuscaSeries.fxml"));
        
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/styles/Styles.css");
        
       
        Stage stage = new Stage();
        stage.setTitle("DataSet");
        stage.setMaximized(false);
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void abreSair(javafx.event.ActionEvent event) {
        System.exit(0);
    }
    @FXML
    private void abreSobre(javafx.event.ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Informações");
        alert.setHeaderText("Sistema Desnvolvido por Tassio Gustavo");
        alert.setContentText("Sistema Desenvolvido como Teste e Aplicação do Algoritmo KNN de Recomendação.");
        alert.showAndWait();
    }
}
