package com.study.sid;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by srathi on 7/25/16.
 */
public class IpGeoClient  {

    private String ip;

    public IpGeoClient(String ip) {
        this.ip = ip;
    }


    public void response() throws java.net.MalformedURLException, java.io.UnsupportedEncodingException , java.io.IOException {

        URL url = new URL("http://dev-bi-quova-service.aws.hotwire.com/ip?ip=" + ip);
        String contentType = "application/json";
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", contentType);
        //conn.setRequestProperty("Content-Length",
        //        String.valueOf(encodedData.length()));
        conn.setDoOutput(true);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        System.out.println(response.toString());

    }
}
