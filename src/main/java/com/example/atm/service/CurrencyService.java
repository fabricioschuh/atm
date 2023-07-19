package com.example.atm.service;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyService {
    static String webService = "https://v6.exchangerate-api.com/v6/a08e49e2a67fd6c172b27ceb/latest/";

    //standard is dollar
    public BigDecimal currencyConversion() throws Exception {
        String urlRequest = webService + "USD";

        try {
            URL url = new URL(urlRequest);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            //in case response is not OK
            if (connection.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code : " + connection.getResponseCode());
            }

            BufferedReader response = new BufferedReader(new InputStreamReader((connection.getInputStream())));
            String jsonParser = Util.jsonParser(response);

            Gson gson = new Gson();

            //TODO
            BigDecimal value = gson.fromJson(jsonParser, BigDecimal.class);

            return value;
        } catch (Exception e) {
            throw new Exception("ERROR: " + e);
        }
    }
}
