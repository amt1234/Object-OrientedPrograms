/******************************************************************************
 *  Purpose: Object Oriented programs utility
 *  @author  Poonam
 *  @version 1.0
 *  @since   09-03-2018
 *
 ******************************************************************************/
package com.bridgeit.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;

import com.bridgeit.programs.DeckOfCardQueue;

public class Utility {
	static Scanner scanner;

	public Utility() {
		scanner = new Scanner(System.in);
	}

	// INPUT STRING
	public static String inputString() {
		try {
			return scanner.next();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "";
	}

	// INPUT Integer
	public static int inputInteger() {
		try {
			return scanner.nextInt();
		} catch (Exception e) {
			System.out.println(e);
		}
		return 0;
	}

	public boolean isPhoneNumber(String mobile) {
		boolean isValid = false;
		String expression = "\\+\\d(-\\d{3}){2}-\\d{4}";

		CharSequence inputStr = mobile;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}

		return false;

	}

	public boolean isName(String name) {
		boolean isValid = false;
		String expression = "/[a-z]+/";

		CharSequence inputStr = name;
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(inputStr);
		if (matcher.matches()) {
			isValid = true;
		}

		return false;

	}

	/**
	 * @throws IOException
	 *             writing data for inventory management
	 */
	public void writingData() throws IOException {
		Scanner sc = new Scanner(System.in);
		File file = new File("File.json");
		FileWriter fw = new FileWriter(file);

		JSONObject obj1 = new JSONObject();
		JSONObject obj2 = new JSONObject();
		JSONObject obj3 = new JSONObject();
		System.out.println("enter the name of rice");
		String name = sc.next();

		System.out.println("enter the weight of rice");
		Integer weight = sc.nextInt();

		System.out.println("enter the price of rice");
		Integer price = sc.nextInt();

		obj1.put("Name", name);
		obj1.put("Weight", weight);
		obj1.put("Price", price);

		System.out.println("enter the name of pulse");
		String name1 = sc.next();

		System.out.println("enter the weight of pulse");
		Integer weight1 = sc.nextInt();

		System.out.println("enter the price of pulse");
		Integer price1 = sc.nextInt();

		obj2.put("Name", name1);
		obj2.put("Weight", weight1);
		obj2.put("Price", price1);

		System.out.println("enter the name of wheath");
		String name3 = sc.next();

		System.out.println("enter the weight of wheath");
		Integer weight3 = sc.nextInt();

		System.out.println("enter the price of wheath");
		Integer price3 = sc.nextInt();

		obj3.put("Name", name3);
		obj3.put("Weight", weight3);
		obj3.put("Price", price3);

		JSONObject items = new JSONObject();

		items.put("rice", obj1);
		items.put("pulses", obj2);
		items.put("wheat", obj3);
		fw.write(JSONValue.toJSONString(items));
		fw.flush();
		fw.close();
	}

	/**
	 * @throws IOException
	 * @throws ParseException
	 * @throws Exception
	 *             Reading data for inventory management
	 */
	public void readingData() throws IOException, ParseException, Exception {
		File file = new File("File.json");
		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONObject obj = (JSONObject) parser.parse(filereader);
		Iterator iterator = obj.keySet().iterator();
		while (iterator.hasNext()) {
			String topkey = (String) iterator.next();
			JSONObject jsonObject1 = (JSONObject) obj.get(topkey);
			Iterator iterator1 = jsonObject1.keySet().iterator();

			while (iterator1.hasNext()) {
				String key = (String) iterator1.next();
				System.out.println(key + " : " + jsonObject1.get(key));
			}
			System.out.println("The Toatal cost of " + jsonObject1.get("Name") + " is: "
					+ Integer.parseInt(jsonObject1.get("Price").toString())
							* Integer.parseInt(jsonObject1.get("Weight").toString()));
		}
	}

	/**
	 * @throws IOException
	 * @throws ParseException
	 * @throws Exception
	 * calculate total cost of share
	 */
	public void calculateStockReport() throws IOException, ParseException, Exception {
		File file = new File("StackReport.json");
		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray arr = (JSONArray) parser.parse(filereader);
		long total = 0;
		Iterator itr = arr.iterator();
		System.out.print("company Name \t share Price \t number of shares \t\t Total cost \n");
		while (itr.hasNext()) {
			JSONObject obj = (JSONObject) itr.next();
			Iterator iterator = obj.keySet().iterator();
			while (iterator.hasNext()) {
				String topkey = (String) iterator.next();
				JSONObject jsonObject1 = (JSONObject) obj.get(topkey);

				long price = (long) jsonObject1.get("Price");
				long shares = (long) jsonObject1.get("NumShare");
				total += price * shares;

				System.out.println(topkey + "\t\t\t" + price + "\t\t\t" + shares + "\t\t\t" + (price * shares));
			}
		}
		System.out.println("\n Total cost of share is : " + total);
	}

	/**
	 * Shuffle the cards using Random method and then distribute 9 Cards to 4
	 * Players using 2D array
	 */
	public void deckCards() {
		String SUITS[] = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String RANKS[] = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		int size = SUITS.length * RANKS.length;
		String deck[] = new String[size];
		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
			}
		}
		for (int i = 0; i < size; i++) {
			int random = i + (int) (Math.random() * (size - i));
			String temp = deck[random];
			deck[random] = deck[i];
			deck[i] = temp;
		}

		String arr[][] = new String[SUITS.length][9];
		for (int i = 0; i < SUITS.length; i++) {
			System.out.println("Player " + (i + 1));
			for (int j = 0; j < 9; j++) {
				arr[i][j] = deck[i + j];
				System.out.println(arr[i][j] + ", ");
			}
			System.out.println();
		}
	}

	/**
	 * Shuffle the cards using Random method and then distribute 9 Cards to 4
	 * Players using queue
	 * 
	 */
	public void deckOfCardQueue() {
		DeckOfCardQueue queue = new DeckOfCardQueue();

		String[] suit = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		int size = suit.length * rank.length;
		String[] deck = new String[size];
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < suit.length; j++) {
				deck[suit.length * i + j] = rank[i] + " of " + suit[j];
			}
		}
		for (int i = 0; i < size; i++) {
			int random = i + (int) (Math.random() * (size - i));
			String temp = deck[random];
			deck[random] = deck[i];
			deck[i] = temp;
		}
		String array[][] = new String[suit.length][9];

		for (int i = 0; i < suit.length; i++) {
			System.out.println("Player " + (i + 1));
			for (int j = 0; j < 9; j++) {
				array[i][j] = deck[i + j];
				queue.push(array[i][j]);
			}
			System.out.println();

		}

		String[][] arrayDeck = queue.printBubble(array);
		for (int i = 0; i < suit.length; i++) {
			System.out.println("Player " + (i + 1));
			for (int j = 0; j < 9; j++) {
				System.out.println(arrayDeck[i][j] + ", ");
			}
			System.out.println();
		}
	}

	/**
	 * @throws IOException
	 * @throws ParseException
	 * @throws Exception
	 * create an account
	 */
	public void createAcc() throws IOException, ParseException, Exception {
		File file = new File("Demo.json");

		JSONArray array = new JSONArray();

		boolean check = true;
		while (check == true) {
			System.out.println("Want to add user: y or n");
			char character = scanner.next().charAt(0);
			if (character == 'y') {

				FileReader filereader = new FileReader(file);
				JSONParser parser = new JSONParser();
				JSONArray array1 = (JSONArray) parser.parse(filereader);
				JSONObject json = new JSONObject();
				System.out.println("Enter name");
				String name = inputString();
				System.out.println("Enter balance");
				int bal = inputInteger();
				json.put("Name", name);
				json.put("Balance", bal);
				json.put("ShareCount", 100);

				array1.add(json);
				FileWriter filewriter = new FileWriter(file);
				filewriter.write(JSONArray.toJSONString(array1));
				filewriter.flush();
				filewriter.close();

			} else {
				check = false;
			}
		}

	}

	/**
	 * @throws IOException
	 * @throws ParseException
	 * @throws Exception
	 * display an information
	 */
	public <E> void display() throws IOException, ParseException, Exception {
		File file = new File("Demo.json");
		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray array1 = (JSONArray) parser.parse(filereader);
		Iterator<E> itrator = array1.iterator();
		while (itrator.hasNext()) {
			JSONObject object = (JSONObject) itrator.next();
			System.out.println(object);
		}
	}

	/**
	 * @throws IOException
	 * @throws ParseException            
	 * @throws Exception
	 * to sale shares
	 */

	public void saleShare() throws IOException, ParseException, Exception {
		File file = new File("Demo.json");
		File file1 = new File("Demo1.json");

		// reading demo file
		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray stock = (JSONArray) parser.parse(filereader);
		// reading demo1 file

		FileReader filereader1 = new FileReader(file1);
		JSONParser parser1 = new JSONParser();
		JSONArray share = (JSONArray) parser1.parse(filereader1);

		System.out.println("Enter the user");
		String name = inputString();
		Iterator itr = stock.iterator();
		Iterator itr1 = share.iterator();
		boolean flag = false;
		while (itr.hasNext()) {
			JSONObject jsonobject = (JSONObject) itr.next();
			if (jsonobject.get("Name").equals(name)) {
				System.out.println("Enter the share sysmbol to sale share:[@,!,#]");
				String symbol = inputString();
				System.out.println("Enter the number of share to sale");
				int count = inputInteger();
				while (itr1.hasNext()) {
					JSONObject jsonobject1 = (JSONObject) itr1.next();
					if (jsonobject1.get("Symbol").equals(symbol)) {
						int balance = Integer.parseInt(jsonobject.get("Balance").toString());
						int price = Integer.parseInt(jsonobject1.get("Price").toString());
						int noShare = Integer.parseInt(jsonobject.get("ShareCount").toString());
						int stockShare = Integer.parseInt(jsonobject1.get("Count").toString());
						int saleprize = count * price;
						int newbal = balance + saleprize;
						int sharecountcus = noShare - count;
						int sharecountstock = stockShare + count;
						jsonobject.remove("Balance");
						jsonobject.remove("ShareCount");
						jsonobject1.remove("Count");

						jsonobject.put("Balance", newbal);
						jsonobject.put("ShareCount", sharecountcus);
						jsonobject1.put("Count", sharecountstock);
						Date d = new Date();
						String date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(d);
						System.out.println("Date " + date);
						flag = true;
						break;
					}

				}
			}

			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(stock));
			fs.flush();
			fs.close();
		}
		if (flag == false) {
			System.out.println("User name not exits");
		}
		FileWriter fw = new FileWriter(file1);
		fw.write(JSONValue.toJSONString(share));
		fw.flush();
		fw.close();

	}

	/**
	 * @throws IOException
	 * @throws ParseException
	 * @throws Exception
	 *   to buy shares
	 */

	public void buyShare() throws IOException, ParseException, Exception {
		File file = new File("Demo.json");
		File file1 = new File("Demo1.json");

		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray stock = (JSONArray) parser.parse(filereader);
		// reading file

		FileReader filereader1 = new FileReader(file1);
		JSONParser parser1 = new JSONParser();
		JSONArray share = (JSONArray) parser1.parse(filereader1);

		System.out.println("Enter the user");
		String name = inputString();
		Iterator itr = stock.iterator();
		Iterator itr1 = share.iterator();
		boolean flag = false;
		while (itr.hasNext()) {
			JSONObject jsonobject = (JSONObject) itr.next();
			if (jsonobject.get("Name").equals(name)) {
				System.out.println("Enter the share sysmbol to buy share:[@,!,#]");
				String symbol = inputString();

				while (itr1.hasNext()) {
					JSONObject jsonobject1 = (JSONObject) itr1.next();
					if (jsonobject1.get("Symbol").equals(symbol)) {
						System.out.println("Enter the amount");
						int amount = inputInteger();
						int balance = Integer.parseInt(jsonobject.get("Balance").toString());
						int price = Integer.parseInt(jsonobject1.get("Price").toString());
						int noShare = Integer.parseInt(jsonobject.get("ShareCount").toString());
						int stockShare = Integer.parseInt(jsonobject1.get("Count").toString());
						int numofshare = amount / price;
						int newbal = balance - amount;
						int sharecountcus = noShare + numofshare;
						int sharecountstock = stockShare - numofshare;
						jsonobject.remove("Balance");
						jsonobject.remove("ShareCount");
						jsonobject1.remove("Count");

						jsonobject.put("Balance", newbal);
						jsonobject.put("ShareCount", sharecountcus);
						jsonobject1.put("Count", sharecountstock);
						Date d = new Date();
						String date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a").format(d);
						System.out.println("Date " + date);
						flag = true;
						break;
					}
				}

			}
			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(stock));
			fs.flush();
			fs.close();
		}
		if (flag == false) {
			System.out.println("User name not exits");
		}
		FileWriter fw = new FileWriter(file1);
		fw.write(JSONValue.toJSONString(share));
		fw.flush();
		fw.close();
	}

	/**
	 * @return Add doctors record by name, id, specialization and availability
	 */
	public void addDoctors() {
		System.out.println("Enter number of doctors :");

		int num0fDoctor = inputInteger();
		JSONArray array = new JSONArray();
		for (int i = 0; i < num0fDoctor; i++) {
			JSONObject json = new JSONObject();
			System.out.println("Enter name of doctor");
			String name = inputString();
			json.put("Doctor_Name", name);
			System.out.println("Enter I.D doctor");
			int id = inputInteger();
			json.put("Doctor_ID", id);
			System.out.println("Enter Specialization of doctor");
			String specilization = scanner.next();
			json.put("Doctor_Specialization", specilization);
			System.out.println("Enter Availablity of doctor");
			String available = scanner.next();
			json.put("Doctor_Availiablity", available);
			array.add(json);
		}
		try {
			System.out.println("Data has been uploaded :");
			FileWriter jsonFileWriter = new FileWriter("doctor.json");
			jsonFileWriter.write(array.toJSONString());
			jsonFileWriter.flush();
			jsonFileWriter.close();
			System.out.println("Doctor Added:" + array);
		} catch (IOException e) {
			System.out.println("exception");
		}
	}

	/**
	 * Add Patients record by name, id,mobile number and age
	 */
	public void addPatients() {
		System.out.println("Enter number of Patients: ");
		int num0fPatients = inputInteger();
		JSONArray array = new JSONArray();
		for (int i = 0; i < num0fPatients; i++) {
			JSONObject json1 = new JSONObject();
			System.out.println("Enter name of Patient");
			String name = inputString();
			json1.put("Patient_Name", name);

			System.out.println("Enter I.D Patient");
			int id = inputInteger();
			json1.put("Patient_ID", id);

			System.out.println("Enter mobile number of Patient");
			int mobileNumber = inputInteger();
			json1.put("Patient_mobileNumber", mobileNumber);

			System.out.println("Enter  Patient age");
			int age = inputInteger();
			json1.put("Patient_ID", age);
			array.add(json1);
		}
		try {
			System.out.println("Data has been uploaded :");
			FileWriter jsonFileWriter = new FileWriter("Patient.json");
			jsonFileWriter.write(array.toJSONString());
			jsonFileWriter.flush();
			jsonFileWriter.close();
			System.out.println("Patient Added:" + array);
		} catch (IOException e) {
			System.out.println("exception");

		}

	}

	/**
	 * @throws Exception
	 *  search Doctor by there name
	 */
	public void searchDoctor() throws Exception {

		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(new FileReader("doctor.json"));
			System.out.println("Search Doctor_Name :");
			String name = inputString();
			for (Object obj : array) {
				JSONObject object = (JSONObject) obj;
				String string = (String) object.get("Doctor_Name");
				if (name.equals(string)) {
					System.out.println("Doctor_founded" + object);
				} else {
					System.out.println("Not Found !");
				}
			}
		} catch (IOException e) {
			System.out.println("exception");
		}
	}

	/**
	 * @throws Exception
	 * 
	 *search patient by there name
	 */
	public void searchPatient() throws Exception {
		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(new FileReader("Patient.json"));
			System.out.println("Search Patient_Name :");
			String name = inputString();
			for (Object obj : array) {
				JSONObject object = (JSONObject) obj;
				String string = (String) object.get("Patient_Name");
				if (name.equals(string)) {
					System.out.println("Patient_founded" + object);
				} else {
					System.out.println("Not Found !");
				}
			}
		} catch (IOException e) {
			System.out.println("exception");
		}
	}

	/**
	 * take an appointment of doctor with date and generate report
	 */
	public void takeAppointment() {
		System.out.println("Please enter Patient_Name");
		String patient_name = inputString();
		System.out.println("Enter Doctor_Name for to take an Appointment");
		String doctername = inputString();
		System.out.println("Enter the date");
		String stringDate = inputString();

		String doctorInfo = null;

		try {
			JSONParser parser = new JSONParser();
			JSONArray array = (JSONArray) parser.parse(new FileReader("doctor.json"));
			for (int i = 0; i < array.size(); i++) {
				JSONObject obj = (JSONObject) array.get(i);
				String doctorName = (String) obj.get("Doctor_Name");

				if (doctorName.equals(doctername)) {
					doctorInfo = doctorName;
				} else {
					System.out.println("doctors not found in this name");
				}
			}
			JSONArray appointmentFileObj = new JSONArray();

			JSONObject obj1 = new JSONObject();

			obj1.put("Doctor_Name", doctorInfo);

			obj1.put("Patient_Name", patient_name);
			obj1.put("Booking Date ", (stringDate));
			appointmentFileObj.add(obj1);
			FileWriter filewriter = new FileWriter("Appointment.json");
			filewriter.write(appointmentFileObj.toJSONString());
			filewriter.flush();
			filewriter.close();
			System.out.println("hello " + patient_name + " Your Appointment is fixed  With Doctor " + doctorInfo
					+ " on: " + (stringDate));
			System.exit(0);

		} catch (Exception e) {
			System.out.println("exception");
		}
	}
	
	public void addUser() throws Exception
	{
		File file=new File("AddressBook.json");
		boolean check = true;
		while (check == true) {
			System.out.println(" add user: y or n");
			char character = scanner.next().charAt(0);
			if (character == 'y') {

				FileReader filereader = new FileReader(file);
				JSONParser parser = new JSONParser();
				JSONArray array1 = (JSONArray) parser.parse(filereader);
				JSONObject json = new JSONObject();
				
				System.out.println("Enter full name");
				String name = inputString();
				System.out.println("Enter Address");
				String address = inputString();
				System.out.println("Enter City");
				String city= inputString();
				System.out.println("Enter state");
				String state = inputString();
				System.out.println("Enter ZIP");
				int zip = inputInteger();
				
				json.put("Name", name);
				json.put("Address", address);
				json.put("City", city);
				json.put("State", state);
				json.put("ZIP", zip);

				array1.add(json);
				FileWriter filewriter = new FileWriter(file);
				filewriter.write(JSONArray.toJSONString(array1));
				filewriter.flush();
				filewriter.close();

			} else {
				check = false;
			}
	}
	}
	public void editInformation() throws IOException, Exception
	{
		File file = new File("AddressBook.json");

		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray book = (JSONArray) parser.parse(filereader);
		

		System.out.println("Enter the user name for edit information");
		String name = inputString();
		Iterator itr = book.iterator();
		
		boolean flag = false;
		while (itr.hasNext()) {
			JSONObject jsonobject = (JSONObject) itr.next();
			if (jsonobject.get("Name").equals(name)) 
			{
				
				
				System.out.println("Enter the Address");
				String newaddress=inputString();
				String address = (String) jsonobject.get("Address");
				
				System.out.println("Enter the city");
				String newcity=inputString();
				String city = (String) jsonobject.get("City");
				
				System.out.println("Enter the State");
				String newstate=inputString();
				String state = (String) jsonobject.get("State");
				
				jsonobject.remove("Address");
				jsonobject.remove("City");
				jsonobject.remove("State");
				

				jsonobject.put("Address", newaddress);
				jsonobject.put("City", newcity);
				jsonobject.put("State", newstate);
				
				System.out.println("edit information sucessfully");
				
			}
			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(book));
			fs.flush();
			fs.close();
			flag=true;
		}
		if (flag == false) {
			System.out.println("User name not exits");
		}
		
		}
	
	public void deleteUser() throws Exception
	{
		File file = new File("AddressBook.json");

		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray bookarray = (JSONArray) parser.parse(filereader);
		try
		{

		System.out.println("Enter the user name for delete ");
		String name = inputString();
		Iterator itr = bookarray.iterator();
		
		boolean flag = false;
		while (itr.hasNext()) {
			JSONObject jsonobject = (JSONObject) itr.next();
			if (jsonobject.get("Name").equals(name)) 
			{
				for(int i=0;i<bookarray.size();i++)
				{
					if(bookarray.get(i).equals(jsonobject))
							{
								bookarray.remove(i);
								break;
						
							}
				}
			
				System.out.println("delete user information sucessfully");
				
			}
			FileWriter fs = new FileWriter(file);
			fs.write(JSONValue.toJSONString(bookarray));
			fs.flush();
			fs.close();
			flag=true;
			}
		if (flag == false) {
			System.out.println("User name not exits");
		}
		}
		catch(Exception e)
		{
			System.out.println(" ");
		}
		
	}
	
	public <E> void displayReprt() throws IOException, ParseException, Exception {
		File file = new File("AddressBook.json");
		FileReader filereader = new FileReader(file);
		JSONParser parser = new JSONParser();
		JSONArray array1 = (JSONArray) parser.parse(filereader);
		Iterator<E> itrator = array1.iterator();
		while (itrator.hasNext()) {
			JSONObject object = (JSONObject) itrator.next();
			System.out.println(object);
			}
	}
	
}
