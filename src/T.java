import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.bridgeit.utility.Utility;

public class T {
	public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);

		System.out.println("enter doctor name");
		String name=sc.nextLine();
		JSONArray array=new JSONArray();
		JSONObject root=new JSONObject();
		JSONObject child=new JSONObject();
		/*while (true)

		{*/
			System.out.println("enter patient name");
			String patient=sc.nextLine();
			
			/*if(name.length()==0)
			{
				break;
			}*/
			System.out.println("enter date");
			String date=sc.nextLine();
			//Date date=new Date();
			//String d = new SimpleDateFormat().format(date);
			
			
			child.put("Date", date);
			child.put("Patient_name", patient);
			
			
			array.add(child);
		//}
			
			root.put(name, array);
			File file=new File("Appointment.json");
			
			try
			{
				PrintWriter writer=new PrintWriter(file);
				writer.print(root.toJSONString());
			}catch(Exception e)
			{
				System.out.println(e.toString());
			}
			
		
	}
}
