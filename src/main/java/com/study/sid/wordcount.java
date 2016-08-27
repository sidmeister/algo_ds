package com.study.sid;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
public class wordcount { 
 public static void main(String[] args) throws Exception {
	long l = 798L;
	String s = "443309131649";
	String d1 = "9.839428E-4";
	String d = "2015-10-13T08:21:19.584Z";
	String search_date;
	String controlB = "\u0001";
	// create my string
	String fields = s + controlB + s;
	System.out.println(Math.round(Double.parseDouble(d1)*100.0)/100.0);
	System.out.println(fields);
	System.out.println();
	//String s = "357";
	 System.out.println(Double.parseDouble(d1));
	 SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); 
	 SimpleDateFormat dt1 = new SimpleDateFormat(""); 
	 search_date = dt1.format(dt.parse(d));
	 //System.out.println(java.sql.Timestamp.valueOf(search_date));
	 System.out.println(search_date);
	 	 
} 

}
