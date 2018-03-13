/******************************************************************************
 *  Purpose: This programme is used to manage a list of Doctors associated with the Clinique.

 *  @author  Poonam
 *  @version 1.0
 *  @since   13-03-2018
 *
 ******************************************************************************/
package com.bridgeit.programs;

import com.bridgeit.utility.Utility;

public class CliniqueManagement {

	
	public static void main(String[] args) throws Exception {
		Utility utility = new Utility();
		while (true) {
			System.out.println("Enter 1 to Add Doctors");
			System.out.println("Enter 2 to Add Patients");
			System.out.println("Enter 3 to Search Doctor");
			System.out.println("Enter 4 to Search Patient");
			System.out.println("Enter 5 to Take an appoitment");
			int choice = utility.inputInteger();
			switch (choice) {
			case 1:
				utility.addDoctors();
				break;
			case 2:
				utility.addPatients();
				break;
			case 3:
				utility.searchDoctor();
				break;
			case 4:
				utility.searchPatient();
				break;
			case 5:
				utility.takeAppointment();
				break;
			default:
				System.out.println("Invalid case");

			}
		}
	}

}