package com.razr.test;

import com.razr.parse.ConvertJSON;

import junit.framework.TestCase;
import org.junit.Test;

import org.json.JSONException;

public class ConvertJSONTest extends TestCase{
	
	private String url;
	private String urlStr;
	private String nullStr;
	private String notValidJsonUrl;
	ConvertJSON convertJson =new ConvertJSON();
	
	public void setUp() throws Exception {
		super.setUp();
		url ="http://mysafeinfo.com/api/data?list=englishmonarchs&format=json";
		urlStr="razr";
		nullStr=null;
		notValidJsonUrl="https://dl.dropboxusercontent.com/u/2436323/cities.jsonl";
		}

	@Test
	public void testIsValidURL() {
		boolean expectedValue=true;
		boolean actualValue=convertJson.isValidURL(url);		
		assertEquals(expectedValue,actualValue);		
	}
	
	@Test
	public void testIsValidURLWithStr() {
		boolean expectedValue=false;
		boolean actualValue=convertJson.isValidURL(urlStr);		
		assertEquals(expectedValue,actualValue);		
	}
	
	@Test
	public void testIsValidURLWithNullStr() {
		boolean expectedValue=false;
		boolean actualValue=convertJson.isValidURL(nullStr);		
		assertEquals(expectedValue,actualValue);		
	}
	
	@Test(expected = JSONException.class)
	public void testrReadAllWithNotValidJsonUrl(){
		convertJson.displayJsonFromUrl(notValidJsonUrl);
		
	}
	

}
