/******************************************************************************
 *  Purpose: Address Book Problem.

 *  @author  Poonam
 *  @version 1.0
 *  @since   13-03-2018
 *
 ******************************************************************************/
package com.bridgeit.programs;

import com.bridgeit.utility.Utility;

public class AddressBookProblem {

	public static void main(String[] args) throws Exception {
		Utility utility=new Utility();
		while (true) {
			System.out.println("Enter your choice:");
			System.out.println("1. Add user");
			System.out.println("2. Edit Information");
			System.out.println("3. Delete Information");
			System.out.println("4. Display Details");
			System.out.println("5. Exit");
			int choice = utility.inputInteger();
			switch (choice) {
			case 1:
				utility.addUser();
				break;
			case 2:
				utility.editInformation();
				break;

			case 3:
				utility.deleteUser();
				break;
			case 4:
				utility.displayReprt();
				break;
			default:
				return;
			}
	}

}
}
