package com.study.sid;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class regExtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "s3://hwbizintelligence-dev/data/input/rawdata/omniture/hotwirecom/dt=2016-01-26/lkp_files/languages.tsv";
		String visidlow = "http://www.bing.com/search?q=cheap+hotels+price+comparison+ho+chi+minh+city+vietname&qs=n&form=QBRE&pq=";
		//cheap+hotels+price+comparison+ho+chi+minh+city+vietname&sc=0-0&sp=-1&sk=&cvid=3E87CE3351034FBAB3137768D6D3F8CD";
		//String pattern = "^(.*)/(.*tsv)";
		String pattern = "[0-9]";
	    Pattern r = Pattern.compile(pattern);
	    Matcher m = r.matcher(visidlow);
	    System.out.println(m.find());
	    if (m.find())
	    {
			System.out.println("Invalid record");
	    }
	

	}

}
