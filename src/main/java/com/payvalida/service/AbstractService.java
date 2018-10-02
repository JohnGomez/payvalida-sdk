package com.payvalida.service;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public abstract class AbstractService<T> {

    //TODO: properties
    private static final String URL_API = "https://sandbox-api-merchants.payvalida.com/api/v2/";

    public String get(String path, Map<String, String> queryParameters) {
        String urlQuery = "";

        if(queryParameters != null) {
            urlQuery = factoryUrlQueryParameters(queryParameters);
        }

        HttpURLConnection con = execute(path, urlQuery, null);

        try {
            if (con.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + con.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
            con.disconnect();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String post (String path, T object) {
        Gson gson = new Gson();
        String body = gson.toJson(object);

        HttpURLConnection con = execute(path, null, body);

        return null;
    }

    private String factoryUrlQueryParameters(Map<String, String> queryParameters) {
        StringBuilder urlQuery = new StringBuilder("?");

        for(String key: queryParameters.keySet()) {
            urlQuery.append(key);
            urlQuery.append("=");
            urlQuery.append(queryParameters.get(key));
            urlQuery.append("&");
        }

        int last = urlQuery.length();
        last--;
        urlQuery.deleteCharAt(last);

       return urlQuery.toString();
    }

    private HttpURLConnection execute(String path, String querys, String jsonody) {

        try {
            URL url = new URL(URL_API + path + querys);
            return (HttpURLConnection) url.openConnection();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
