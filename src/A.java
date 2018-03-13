import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import com.bridgeit.utility.Utility;

public class A {

	public static void main(String[] args)throws Exception
	{
		//JSONObject jsonobject=new JSONObject();
		PrintWriter printwriter=new PrintWriter("first.json");
	        Map myMap = new HashMap();

	       Utility utility=new Utility();
	        System.out.println("Enter your name of rice;");
	        String firstName = utility.inputString();
	       
	        System.out.println("Enter weight of rice");
	       Integer weight = utility.inputInteger();
	       
	     
	        
	        System.out.println("Enter price of rice;");
	        Integer price = utility.inputInteger();
	       

	        myMap.put("firstName",firstName);
	        myMap.put("weight",weight);
	        myMap.put("price",price);
	      
try
{
	     Object   obj=JSONValue.toJSONString(myMap);
	            
	            		JSONObject jsonObject=(JSONObject) obj;
	           // System.out.println(jsonObject);
	            
	            
	            /*String jsonText = JSONValue.toJSONString(myMap);  
	            System.out.print(jsonText); 
	            Object   obj=JSONValue.toJSONString(myMap);
	            jsonobject=(JSONObject) obj;
	           */
	           printwriter.write(jsonObject.toJSONString());
	           printwriter.flush();
	           System.out.println("sucessfully");
	        printwriter.close();   
	   //    utility.inventory(jsonObject);
}
catch(Exception e)
{
	System.out.println("exception");
}
	      
	}

	
}
