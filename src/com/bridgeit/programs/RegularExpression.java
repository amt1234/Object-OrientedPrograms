/******************************************************************************
 *  Purpose:Regular Expression Demonstration
 *  @author  Poonam
 *  @version 1.0
 *  @since   09-03-2018
 *
 ******************************************************************************/
package com.bridgeit.programs;

import java.sql.Date;
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
		System.out.println("Enter your Mob No.:");
		String mob = utility.inputString();

		Date date = new Date(0);
		String d = new SimpleDateFormat().format(date);
		String d1[] = d.split(" ");
		str = str.replace("<<name>>", arr[0]);
		str = str.replace("<<full name>>", name);
		str = str.replace("xxxxxxxxxx", mob);
		str = str.replace("01/01/2016", d1[0]);
		System.out.println(str);

	}

}
