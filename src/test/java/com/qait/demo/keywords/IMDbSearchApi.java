package com.qait.demo.keywords;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class IMDbSearchApi {
	public  JSONObject searchForMovie(String movieName) throws Exception{
		movieName.replace(" ", "%");
		String Resturl="http://www.omdbapi.com/?t=";
		URL url = new URL(Resturl);
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");

	        if (conn.getResponseCode() != 200) {
	            throw new RuntimeException("Failed : HTTP error code : "
	                    + conn.getResponseCode());
	        }

	        BufferedReader in = new BufferedReader(
	                new InputStreamReader(conn.getInputStream()));
	        String inputLine;
	        StringBuffer response = new StringBuffer();

	        while ((inputLine = in.readLine()) != null) {
	            response.append(inputLine);
	            System.out.println(inputLine);
	        }
	        in.close();
	        String res=new String(response);
	        
	        JSONObject obj=new JSONObject(res);
	        return obj;
	}
}
	        

	




