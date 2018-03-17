/******************************************************************************
 *  Purpose:Regular Expression Demonstration
 *  @author  Poonam
 *  @version 1.0
 *  @since   09-03-2018
 *
 ******************************************************************************/
package com.bridgeit.programs;

import java.util.Date;
import java.text.SimpleDateFormat;

import com.bridgeit.utility.Utility;

public class RegularExpression {

	public static void main(String[] args) {
		Utility utility = new Utility();
		String string = "Hello <<name>>, We have your full name as <<full name>> "
				+ "in our system. your contact number is 91-xxxxxxxxxx. "
				+ "Please,let us know in case of any clarification Thank you " + "BridgeLabz 01/01/2016.";
		System.out.println("Enter your name:");
		String name = utility.inputString();
		String array[] = name.split(" ");

		if (utility.isName(name) == true) {
			string = string.replace("<<name>>", array[0]);
			string = string.replace("<<full name>>", name);
		} else {

			System.out.println("Invalid name");
			utility.nameValidation(string);
		}

		System.out.println("Enter your Mobile Number :");
		String mobile = utility.inputString();

		if (utility.isPhoneNumber(mobile) == true) {
			string = string.replace("xxxxxxxxxx", mobile);
		} else {
			System.out.println("Invalid number");
			utility.mobileValidation(string);

		}

		Date date = new Date();
		String d = new SimpleDateFormat().format(date);
		String d1[] = d.split(" ");

		string = string.replace("01/01/2016", d1[0]);
		System.out.println(string);

	}

}
