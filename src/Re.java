import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgeit.utility.Utility;

public class Re {

	public static void main(String[] args)
	{
		//Utility utility=new Utility();
		Pattern p=Pattern.compile("(0|91)?[7-9][0-9]{9}");
		Matcher m=p.matcher(args[0]);
		if(m.find()&& m.group().equals(args[0]))
		{
			System.out.println("valid");
		}
		else
		{
			System.out.println("invalid");
		}
		
	}
	
	
	
	public void regularEx(String string)
	{
		System.out.println("enter the name");
		String name=inputString();
		String array[] = name.split(" ");
		if(isName(name)==true)
		{
			string = string.replace("<<name>>", array[0]);
			string = string.replace("<<full name>>", name);
		}
		else
		{
			System.out.println("invalid name");
			regularEx(string);
		}
		
	}
	public void regular(String string)
	{
		System.out.println("Enter your Mobile Number :");
		String mobile = inputString();

		if (isPhoneNumber(mobile) == true) {
			string = string.replace("xxxxxxxxxx", mobile);
		} else {
			System.out.println("Invalid number");
			regular(string);

		}

	}

}
