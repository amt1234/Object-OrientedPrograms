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
			System.out.println("Enter 6 to Exit");
			int choice = utility.inputInteger();
			switch (choice) {
			case 1:
				utility.addDoctors();
				break;
			case 2:
				utility.addPatients();
				break;
			case 3:
				utility.searchDoctorm();
				break;
			case 4:
				utility.searchPatientm();
				break;
			case 5:
				utility.takeAppointment1();
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid case");

			}
		}
	}

}