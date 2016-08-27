package com.study.sid;

import java.io.*;


public class DotComGameHelper {
    public String gameUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");

        try {
            BufferedReader is = new BufferedReader(new InputStreamReader(
                        System.in));
            inputLine = is.readLine();

            if (inputLine.length() == 0) {
                return null;
            }
        } catch (IOException e) {
            System.out.println("Exception:" + e);
        }

        return inputLine;
    }
}
