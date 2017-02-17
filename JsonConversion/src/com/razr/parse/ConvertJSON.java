package com.razr.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ConvertJSON {

	public static void main(String[] args) {
		ConvertJSON convertJson = new ConvertJSON();
		String url = "";
		
		if (args.length != 0) {
			url = args[0];
			if (convertJson.isValidURL(url)) {
				System.out.println("Requested URL:" + url);
				convertJson.displayJsonFromUrl(url);
			} else {
				System.out.println("Please check URL:" + args[0] + " is not a valid");
			}
		}
	}
	//String url = "https://dl.dropboxusercontent.com/u/2436323/cities.jsonl";
	//String url ="https://jsonplaceholder.typicode.com/posts/1";
	
	//String url ="http://cdn.crunchify.com/wp-content/uploads/code/jsonArray.txt";
	//String url ="http://mysafeinfo.com/api/data?list=englishmonarchs&format=json";
	//String url ="https://jsonplaceholder.typicode.com/posts";
	
	public void  displayJsonFromUrl(String url){      
        
       try {    	   
   			JSONArray jsonArray = new JSONArray(readAll(url));
    
   			int count = jsonArray.length(); 
   			System.out.println("Parsed JSON data");
   			for(int i=0 ; i< count; i++){   
   				JSONObject jsonObject = jsonArray.getJSONObject(i);  // get jsonObject @ i position 
   				System.out.println("jsonObject " + i + ": " + jsonObject);
   			}
   		} catch (JSONException e) {
   			e.printStackTrace();
   		}catch(Exception e){
   			
   		}		
	}	
	
	public boolean isValidURL(String urlString){
		try{
			URL url =new URL (urlString);
			url.toURI();
			return true;
		}catch(Exception e)
		{
			return false;
		}
	}
	
	 public  String readAll(String url) throws IOException {
		 InputStream is = null;
		 is = new URL(url).openStream();
         BufferedReader rd = new BufferedReader(new InputStreamReader(is));        

	        BufferedReader reader = new BufferedReader(rd);
	        StringBuilder sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }
	        return sb.toString();
	    }
}
