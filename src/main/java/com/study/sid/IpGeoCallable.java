package com.study.sid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

/**
 * Created by srathi on 7/25/16.
 */



    public class IpGeoCallable implements Callable{


        private String ip;
        private  URL url;
        public IpGeoCallable(String ip) {
            this.ip = ip;
        }

    @Override
    public Object call() throws Exception {
            try {
                System.out.println(Thread.currentThread().getName() + "is running ip" + ip);
                url = new URL("http://dev-bi-quova-service.aws.hotwire.com/?ip=" + ip);
                String contentType = "application/json";
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setInstanceFollowRedirects(false);
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Content-Type", contentType);

                conn.setDoOutput(true);
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();
                //System.out.println(response.toString());*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;

    }
}
