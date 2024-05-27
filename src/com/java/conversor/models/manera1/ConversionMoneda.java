package com.java.conversor.models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionMoneda {
    HttpClient client = HttpClient.newHttpClient();
    double cambio;

    public void tasaConversion(String valorBase,String valorSalida,double cantidad){
        String direccion = "https://v6.exchangerate-api.com/v6/552f94cd15272d10d124f1d1/pair/"+valorBase+"/"+valorSalida+"/"+cantidad;

        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .setPrettyPrinting()
                .create();

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            System.out.println(json);

            ExchangerateApi recuperacionExchangerate = gson.fromJson(json,ExchangerateApi.class);
            //System.out.println(recuperacionExchangerate);

            cambio = recuperacionExchangerate.conversion_result();
            System.out.println("El valor $"+cantidad+" ["+valorBase.toUpperCase()+"] corresponde al valor final de $"+cambio+" ["+valorSalida.toUpperCase()+"]");

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
