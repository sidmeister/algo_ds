package com.study.sid;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * Created by srathi on 7/25/16.
 */



    public class IpGeoCallableAll implements Callable <Integer>{

        private String ip;
        private  URL url;
        private ExecutorService pool;
        private  int count;
        public IpGeoCallableAll(//ExecutorService pool,
                                String ip) {
            //this.pool = pool;
            this.ip = ip;
        }

    @Override
    public Integer call() throws Exception {
            count = 0;
        List<Future<String>> results = new ArrayList<>();
            try {

                    System.out.println(Thread.currentThread().getName() + "is running ip" + ip);
                    url = new URL("http://dev-bi-quova-service.aws.hotwire.com/?ip=" + ip);
                    String contentType = "application/json";
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setInstanceFollowRedirects(false);
                    conn.setRequestMethod("GET");
                    conn.setRequestProperty("Content-Type", contentType);
                    conn.setDoOutput(true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String inputLine;
                    StringBuffer response = new StringBuffer();
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                    in.close();
                    count ++;
                //System.out.println(response.toString());*/
            } catch (Exception e) {
                e.printStackTrace();
            }
            return count;

    }
}
