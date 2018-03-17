package com.bridgeit.programs;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.bridgeit.utility.Utility;

public class Re {
	
	public static void main(String[] args)
	{
		
		String string = "Hello <<name>>, We have your full name as <<full name>> "
				+ "in our system. your contact number is 91-xxxxxxxxxx. "
				+ "Please,let us know in case of any clarification Thank you " + "BridgeLabz 01/01/2016.";
		System.out.println("Enter your name:");
		RegularEx();
		
	}
	
}
	class Ex()
	{
		Utility utility=new Utility();
		String string = "Hello <<name>>, We have your full name as <<full name>> "
				+ "in our system. your contact number is 91-xxxxxxxxxx. "
				+ "Please,let us know in case of any clarification Thank you " + "BridgeLabz 01/01/2016.";
		System.out.println("Enter your name:");
	public void regularEx(String string)
	{
		System.out.println("enter the name");
		String name=utility.inputString();
		String array[] = name.split(" ");
		if(utility.isName(name)==true)
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
		String mobile = utility.inputString();

		if (utility.isPhoneNumber(mobile) == true) {
			string = string.replace("xxxxxxxxxx", mobile);
		} else {
			System.out.println("Invalid number");
			regular(string);

		}

	}

}
