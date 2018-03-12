/******************************************************************************
 *  Purpose:JSON Inventory Data Management of Rice, Pulses and Wheats

 *  @author  Poonam
 *  @version 1.0
 *  @since   05-03-2018
 *
 ******************************************************************************/
package com.bridgeit.programs;

import com.bridgeit.utility.Utility;

public class Inventary {
	public static void main(String args[]) throws Exception {
		Utility utility = new Utility();

		utility.writingData();
		utility.readingData();
	}

}
