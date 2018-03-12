package com.bridgeit.programs;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

public class Add {
	public static void main(String args[]) throws Exception
	{
		JSONObject obj=new JSONObject();
		obj.put("name", "poonam");
		obj.put("id", (new Integer(20)));
		System.out.println(obj);
		
		PrintWriter printwriter=new PrintWriter("first.txt");
		printwriter.write(obj.toJSONString());
		
	}

}
