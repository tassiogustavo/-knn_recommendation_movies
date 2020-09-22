package com.mycompany.knnapp;

import java.util.ArrayList;
import javafx.beans.property.SimpleStringProperty;

public class KNNAlgorithm {
    public ArrayList<DadosSeries> findKNNs(ArrayList<DadosSeries> listDadosSeries, DadosSeries serieAssistida){
        
        ArrayList<DadosSeries> listaSeries = new ArrayList<>();
        DadosSeries ds;
        
        for (int i = 0; i < listDadosSeries.size(); i++) {
            double somatório = 0, dEuclidiana;
            somatório += Math.pow(Double.parseDouble(serieAssistida.getViolencia()) - Double.parseDouble(listDadosSeries.get(i).getViolencia()), 2);
            somatório += Math.pow(Double.parseDouble(serieAssistida.getRomance()) - Double.parseDouble(listDadosSeries.get(i).getRomance()), 2);
            somatório += Math.pow(Double.parseDouble(serieAssistida.getAcao()) - Double.parseDouble(listDadosSeries.get(i).getAcao()), 2);
            somatório += Math.pow(Double.parseDouble(serieAssistida.getComedia()) - Double.parseDouble(listDadosSeries.get(i).getComedia()), 2);
    
            
            dEuclidiana = Math.sqrt(somatório);
            SimpleStringProperty dEuclidianaProperty = new SimpleStringProperty(String.valueOf(dEuclidiana));
            ds = new DadosSeries(listDadosSeries.get(i).getId(), listDadosSeries.get(i).getNome(),
                    listDadosSeries.get(i).getViolencia(), listDadosSeries.get(i).getRomance(), 
                    listDadosSeries.get(i).getAcao(), listDadosSeries.get(i).getComedia(), String.valueOf(dEuclidiana));
            
            listaSeries.add(ds);
        }
        return listaSeries;
    }
}
