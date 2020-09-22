/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.knnapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.HttpURLConnection;


/**
 *
 * @author TassioGustavo
 */
public class BackgroundAcesso {
    
   public String executaManipulacao(){
        try{
            URL urls = new URL("http://pibbarretos.com/series_knn/buscaSeries.php");
            HttpURLConnection httpURLConnection = (HttpURLConnection)urls.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setDoOutput(true);
            
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
            
            String line = "", resposta = "";
            while((line = bufferedReader.readLine()) != null){
                resposta += line;
            }
            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();
            return resposta;
        }catch (MalformedURLException e) {
         System.out.println("Internet is not connected"+e.getMessage());
      } catch (IOException e) {
         System.out.println("Internet is not connected"+e.getMessage());
      }
        return null;
    }
    
}
