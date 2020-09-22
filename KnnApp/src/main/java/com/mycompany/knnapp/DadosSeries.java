/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.knnapp;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author TassioGustavo
 */
public class DadosSeries {
    
    private final SimpleIntegerProperty id;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty violencia;
    private final SimpleStringProperty acao;
    private final SimpleStringProperty comedia;
    private final SimpleStringProperty romance;
    private final SimpleStringProperty dEuclidiana;
    
    public DadosSeries(int id, String nome,String violencia,String romance,String acao, String comedia,String dEuclidiana){
        this.id = new SimpleIntegerProperty(id);
        this.nome = new SimpleStringProperty(nome);
        this.violencia = new SimpleStringProperty(violencia);
        this.romance = new SimpleStringProperty(romance);
        this.acao = new SimpleStringProperty(acao);
        this.comedia = new SimpleStringProperty(comedia);
        this.dEuclidiana = new SimpleStringProperty(dEuclidiana);
    }
    
    public SimpleIntegerProperty idProperty() {
        return id;
    }
    
    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public SimpleStringProperty violenciaProperty() {
        return violencia;
    }

    public SimpleStringProperty acaoProperty() {
        return acao;
    }

    public SimpleStringProperty comediaProperty() {
        return comedia;
    }

    public SimpleStringProperty getdEuclidiana() {
        return dEuclidiana;
    }

    public SimpleStringProperty romanceProperty() {
        return romance;
    }
    
    public String getDEuclidiana() {
        return dEuclidiana.get();
    }
    
    public int getId() {
        return id.get();
    }
    
    public String getNome() {
        return nome.get();
    }

    public String getViolencia() {
        return violencia.get();
    }

    public String getAcao() {
        return acao.get();
    }

    public String getComedia() {
        return comedia.get();
    }

    public String getRomance() {
        return romance.get();
    }
    
    public void setDEuclidiana(String dEuclidiana) {
        this.dEuclidiana.set(dEuclidiana);
    }
    
    public void setId(int id) {
        this.id.set(id);
    }
    
    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public void setViolencia(String violencia) {
        this.violencia.set(violencia);
    }

    public void setAcao(String acao) {
        this.acao.set(acao);
    }

    public void setComedia(String comedia) {
        this.comedia.set(comedia);
    }

    public void setRomance(String romance) {
        this.romance.set(romance);
    }
}
