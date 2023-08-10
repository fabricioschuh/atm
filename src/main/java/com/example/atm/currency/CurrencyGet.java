package com.example.atm.currency;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CurrencyGet {

    // host and path
    public static final String URL_GET = "https://v6.exchangerate-api.com/v6/a08e49e2a67fd6c172b27ceb/latest/";

    public void currencyConversion(String currency) throws Exception {
        try {

            URL url = new URL(URL_GET+currency);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : "
                        + conn.getResponseCode());
            }
            InputStreamReader in = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(in);
            String output;

//            https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java


            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            conn.disconnect();

        } catch (Exception e) {
            System.out.println("Exception in NetClientGet:- " + e);
        }
    }
}
