package com.example.tftguide.Proxy;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class ProxyUtil {

    public String getHtmlPageFromUrlViaProxy(String urlToParse) throws IOException {

        Response response = null;
        String responseString = null;
        try {
            OkHttpClient client = new OkHttpClient.Builder()
                    .build();

            Request request = new Request.Builder()
                    .url(urlToParse)
                    .addHeader("Connection", "close")
                    .get().build();

            response = client.newCall(request).execute();

//                if (response != null || response.code() != 200 || !response.isSuccessful()) {
//
//                }
            responseString = response.body().string();


        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseString;

    }

}
