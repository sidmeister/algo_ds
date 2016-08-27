package com.yaml;

import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by srathi on 8/1/16.
 */
public class SchemaRead {

    public static void main(String[] args) throws FileNotFoundException, YamlException {

        DWTable table;
        DWColumn column;
        List<DWColumn> columnList = new ArrayList<DWColumn>();
        String[] columnDefs = null;
        String[] columnNames = null;
        int i =0;
        YamlReader reader = new YamlReader(new FileReader("/Users/srathi/Documents/eclipse/javaStudy/src/main/java/com/yaml/Contact.yml"));
        Schema schema;
        schema = reader.read(Schema.class);
        for(Object c : schema.tables)
        {
            table = (DWTable)c;
            if (table.name.equals(new String("int_gcs_search"))) {
                columnDefs = new String [table.columns.size()];
                columnNames = new String [table.columns.size()];
               for (Object col : table.columns)
               {
                   column = (DWColumn) col;
                   System.out.println(column.name);
                   columnDefs[i] =  column.datatype;
                   columnNames[i] = column.name;
                   i++;
               }
            }
        }
        for (int j=0;j<columnDefs.length;j++)
        {
            System.out.println(columnDefs[j]);
        }
    }
}
