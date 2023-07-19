package com.example.atm.service;

import java.io.BufferedReader;
import java.io.IOException;

public class Util {
    public static String jsonParser(BufferedReader buffereReader) throws IOException {
        String response, jsonParser = "";
        while ((response = buffereReader.readLine()) != null) {
            jsonParser += response;
        }
        return jsonParser;
    }
}
