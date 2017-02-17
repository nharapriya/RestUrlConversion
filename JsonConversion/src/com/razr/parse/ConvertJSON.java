package com.razr.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
			} 
		}
	}
		
	public void  displayJsonFromUrl(String url){      
        
       try {    	   
   			JSONArray jsonArray = new JSONArray(readAll(url));
    
   			int count = jsonArray.length(); 
   			System.out.println("Parsed JSON data");
   			for(int i=0 ; i< count; i++){   
   				JSONObject jsonObject = jsonArray.getJSONObject(i);   
   				System.out.println("jsonObject " + i + ": " + jsonObject);
   			}
   		} catch (JSONException e) {
   			e.printStackTrace();
   		}catch(Exception e){
   			
   		}		
	}	
	
	public boolean isValidURL(String urlString) {
		try {
			URL url = new URL(urlString);
			url.toURI();
			return true;
		} catch (Exception e) {
			System.out.println("Please check URL:" + urlString + " is not a valid url");
			return false;
		}
	}
	
	public  String readAll(String url)  {
		 InputStream is = null;
		 StringBuilder sb=null;
		 BufferedReader reader=null;
		 try{
		 is = new URL(url).openStream(); 
		 reader = new BufferedReader(new InputStreamReader(is));
	        sb = new StringBuilder();
	        String line = null;
	        while ((line = reader.readLine()) != null) {
	            sb.append(line);
	        }	        
	        
	    }catch(IOException e){
	    	System.out.println("Unable read data from URL:"+url);
	    	e.printStackTrace();
	    }finally{
	    	if(reader != null) {
	            try {
	                reader.close();
	            } catch (IOException ioe) {
	            	System.out.println("Unable to close reader object:");
	                ioe.printStackTrace();
	            }
	    	}
	    }
		 return sb.toString();
	}
}
