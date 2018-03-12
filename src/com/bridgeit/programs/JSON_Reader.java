package com.bridgeit.programs;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSON_Reader
	{
	    public static void main(String args[])
	    {
	        JSONParser parser = new JSONParser();
	        try
	        {
	            Object object = parser
	                    .parse(new FileReader("inventory.json"));
	            
	            //convert Object to JSONObject
	            JSONObject jsonObject = (JSONObject)object;
	            
	            //Reading the String
	            /*String name = (String) jsonObject.get("Name");
	            Long age = (Long) jsonObject.get("Age");*/
	            String name=(String) jsonObject.get("name");
				Integer weight=(Integer) jsonObject.get("weight");
				Integer price=(Integer) jsonObject.get("price");
				System.out.println(name+" "+weight+" "+price);
	            //Reading the array
	            JSONArray rice = (JSONArray)jsonObject.get("rice");
	            
	            //Printing all the values
	            System.out.println("Name: " + name);
	            System.out.println("weight: " + weight);
	            System.out.println("price: " + price);
	           System.out.println("rice:");
	            for(Object country : rice)
	            {
	                System.out.println("\t"+country.toString());
	            }
	        }
	        catch(FileNotFoundException fe)
	        {
	            fe.printStackTrace();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
	    }
}
