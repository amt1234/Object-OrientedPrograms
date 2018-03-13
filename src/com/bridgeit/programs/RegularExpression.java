/******************************************************************************
 *  Purpose:Regular Expression Demonstration
 *  @author  Poonam
 *  @version 1.0
 *  @since   09-03-2018
 *
 ******************************************************************************/
package com.bridgeit.programs;

import java.util.*;
import java.text.SimpleDateFormat;

import com.bridgeit.utility.Utility;

public class RegularExpression {

	public static void main(String[] args) {
		Utility utility = new Utility();
		String str = "Hello <<name>>, We have your full name as <<full name>> "
				+ "in our system. your contact number is 91-xxxxxxxxxx. "
				+ "Please,let us know in case of any clarification Thank you " + "BridgeLabz 01/01/2016.";
		System.out.println("Enter your name:");
		String name = utility.inputString();
		String arr[] = name.split(" ");
		if(utility.isName(name)==true)
		{
			str = str.replace("<<name>>", arr[0]);
			str = str.replace("<<full name>>", name);
		}
		else
		{
			System.out.println("Invalid name");
		}
		System.out.println("Enter your Mob No.:");
		String mobile = utility.inputString();
		
		if(utility.isPhoneNumber(mobile)==true)
		{
			str = str.replace("xxxxxxxxxx", mobile);
		}
		else
		{
			System.out.println("Invalid number");
		}
		
		Date date = new Date(0);
		String d = new SimpleDateFormat().format(date);
		String d1[] = d.split(" ");
		
		str = str.replace("01/01/2016", d1[0]);
		System.out.println(str);

	}

}
