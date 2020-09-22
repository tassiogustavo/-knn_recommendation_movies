/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.mycompany.knnapp;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author TassioGustavo
 */
public class BuscaSeriesController implements Initializable{
    
    ObservableList<DadosSeries> list;
    
    @FXML
    private TableView<DadosSeries> tabela;
    @FXML
    private TableColumn<DadosSeries,String> tcNome;
    @FXML
    private TableColumn<DadosSeries,String> tcViolencia;
    @FXML
    private TableColumn<DadosSeries,String> tcRomance;
    @FXML
    private TableColumn<DadosSeries,String> tcAcao;
    @FXML
    private TableColumn<DadosSeries,String> tcComedia;
    @FXML
    private TableColumn<DadosSeries,String> tcDEuclidiana;
    @FXML
    private Label txtPrimeiroRecomendado;
    @FXML
    private Label txtSegundoRecomendado;
    @FXML
    private Label txtTerceiroRecomendado;
    @FXML
    private Label txtSerieEscolhida;
    ArrayList<DadosSeries> listaDadosSeries;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            tcNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
            tcViolencia.setCellValueFactory(new PropertyValueFactory<>("violencia"));
            tcRomance.setCellValueFactory(new PropertyValueFactory<>("romance"));
            tcAcao.setCellValueFactory(new PropertyValueFactory<>("acao"));
            tcComedia.setCellValueFactory(new PropertyValueFactory<>("comedia"));
            tcDEuclidiana.setCellValueFactory(new PropertyValueFactory<>("dEuclidiana"));
            
            tcAcao.setSortable(false);
            tcNome.setSortable(false);
            tcComedia.setSortable(false);
            tcViolencia.setSortable(false);
            tcRomance.setSortable(false);
            tcDEuclidiana.setSortable(false);
            
            tabela.setItems(listaDadosSeries());      
            
            alteraLabelsResultado("", "", "", "");
            
            tabela.setOnMouseClicked((MouseEvent event) -> {
                if(event.getClickCount() == 2){
                    try{
                        DadosSeries serieAssistida = new DadosSeries(tabela.getSelectionModel().getSelectedItem().getId(),
                                tabela.getSelectionModel().getSelectedItem().getNome(),
                                tabela.getSelectionModel().getSelectedItem().getViolencia(),
                                tabela.getSelectionModel().getSelectedItem().getRomance(),
                                tabela.getSelectionModel().getSelectedItem().getAcao(),
                                tabela.getSelectionModel().getSelectedItem().getComedia(), "");
                        KNNAlgorithm knn = new KNNAlgorithm();
                        tabela.setItems(listaSeriesAlgoritmoExecutado(knn.findKNNs(listaDadosSeries, serieAssistida)));
                        tcDEuclidiana.setSortable(true);
                        tcDEuclidiana.setSortType(TableColumn.SortType.ASCENDING);
                        tabela.getSortOrder().add(tcDEuclidiana);
                        tabela.sort();
                        tcDEuclidiana.setSortable(false);
                        alteraLabelsResultado(tabela.getSelectionModel().getTableView().getItems().get(1).getNome(),
                                tabela.getSelectionModel().getTableView().getItems().get(2).getNome(),
                                tabela.getSelectionModel().getTableView().getItems().get(3).getNome(),
                                tabela.getSelectionModel().getTableView().getItems().get(0).getNome());
                    }catch(Exception ex){
                        System.out.println(ex.getMessage());
                    }
                }
            });
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private void alteraLabelsResultado(String primeiroRec, String segundoRec, String terceiroRec, String escolha){
        txtPrimeiroRecomendado.setText(primeiroRec);
        txtSegundoRecomendado.setText(segundoRec);
        txtTerceiroRecomendado.setText(terceiroRec);
        txtSerieEscolhida.setText(escolha);
    }
    private ObservableList<DadosSeries> listaSeriesAlgoritmoExecutado(ArrayList<DadosSeries> listaSeries){
        return list = FXCollections.observableArrayList(listaSeries);
    }
    
    private ObservableList<DadosSeries> listaDadosSeries(){
        BackgroundAcesso ba = new BackgroundAcesso();
        
        return list = FXCollections.observableArrayList(processFinish(ba.executaManipulacao()));
    }
    
    private ArrayList<DadosSeries> processFinish(String output){
        ArrayList<DadosSeries> dataset = new ArrayList<>();
        if(output == null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setHeaderText("Ocorreu um na Busca dos Dados.");
            alert.showAndWait();
        }else {
            try{
                JSONObject jsonObject = new JSONObject(output);
                JSONArray jsonArray = jsonObject.getJSONArray("Resposta");
                int count = 0;
                JSONObject jo;
                DadosSeries ds;
                while(count < jsonArray.length()){
                    jo = jsonArray.getJSONObject(count);
                    ds = new DadosSeries(jo.getInt("id"),
                            jo.getString("nome"),
                            jo.getString("violencia"),
                            jo.getString("romance"),
                            jo.getString("acao"),
                            jo.getString("comedia"), "-");
                    dataset.add(ds);
                    count++;
                }
            }catch(JSONException ex){
                System.out.println(ex.getMessage());
            }
        }
        listaDadosSeries = dataset;
        return dataset;
    }
}
