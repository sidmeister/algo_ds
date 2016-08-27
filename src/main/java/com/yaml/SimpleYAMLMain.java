package com.yaml;

import java.io.*;
import java.util.*;

import org.yaml.snakeyaml.Yaml;


public class SimpleYAMLMain {


    public static void main(String[] args) {

        // The path of your YAML file.
        final String fileName = "/Users/srathi/Documents/eclipse/javaStudy/src/main/java/com/yaml/ini.yml";

        Yaml yaml = new Yaml();

        try {
            InputStream ios = new FileInputStream(new File(fileName));

            // Parse the YAML file and return the output as a series of Maps and Lists
            Map<String,String> Tresult = (Map<String,String>)yaml.load(ios);
            List<String> columnNames = new ArrayList<String>();
            List<String> columnDefs = new ArrayList<String>();
            for (Object name : Tresult.keySet()) {

                //key.add(name.toString());
                System.out.println(Tresult.get(name).toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
