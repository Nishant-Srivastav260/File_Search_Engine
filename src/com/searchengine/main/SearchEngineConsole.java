package com.searchengine.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.searchengine.drivefinder.DriveFinderFactory;
import com.searchengine.searchhistory.SearchHistoryManager;
import com.searchengine.searchmanager.SearchManagerFactory;
import com.searchengine.searchmanager.UserInput;

public class SearchEngineConsole {

	/*
	 * Documents - Knowledge, Take Decisions for my Projects....
	 *
	 * 1. Problem to Solve: Use Case : Purpose Easy access to documents across large
	 * document repositories Quick results - Fast Search when i search for documents
	 *
	 * 2. Solution: Get to know the Document to be Searched : Enable Quick - Search
	 * across the locations Statistics and Analytics - Analyse the Pattern of Search
	 * and improve user experience
	 *
	 * 3. Features, Tasks/Steps, Rules (Business, Data, UI, NFR) ---Features Search
	 * for File View Search Results
	 *
	 * ---Always make it a practice to write down the steps of the solution for any
	 * problem---- 1. Detect the Drives in the System 2. Show the Drives available
	 * in the System (Active and All) 3. Accept the file to be searched 4. Ask If
	 * Search has to be done across all drives or Active Drives 5. Search for File
	 * in the Drives selected 6. Show the Result
	 *
	 * ---Rules Business Rule 1. 10 Searches a day
	 *
	 * Data Rule 1. File Name - Can be AlphaNumeric, Cannot be null, 100 Character
	 * Long Max 2. User Id - should be Unique, 50 Max Length
	 *
	 * UI Rule 1. Success Message should be in green colour
	 *
	 * 3. Effort Estimate a. Tasks - Estimate effort in hours
	 *
	 * 4. Timeline - *********
	 *
	 */

	/*
	 * --Task BreakDown 1. Detect the Drives in the System detectDrives(); 2. Show
	 * the Drives available in the System (Active and All) 3. Accept the file to be
	 * searched 4. Ask If Search has to be done across all drives or Active Drives
	 * 5. Search for File in the Drives selected 6. Show the Result
	 *
	 */

	/*
	 * Key Learning 1. Problem Understanding 2. Problem Solving - English like 3.
	 * Solution and Task Break Down 4. Tech OO Programming Design Principles and
	 * Patterns Interfaces Factories - Abstraction and Implementation Exception
	 * Handling File Handling Threads - Multi-Threading Collections Static Language
	 * Essentials 5. Unit Testable Code Break down into smaller units of code 6.
	 * Code Best Practices Comments Organization of Code 7. Packaging Group Classes
	 * and Interfaces
	 */

	// Step 1 : Display Welcome message
	public static void displayWelcomeMessage() {
		System.out.println("Welcome to the search engine");
	}

	// Step 2 Find Drives from System: The type should be chosen by the user
	// Implemented Factory Design pattern- Coding to the interface....makes our code
	// flexible
	public static List<String> findDrives() {

		List<String> drives = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter you choice : ALL or ACTIVE");
		String choice = sc.next();

		drives = DriveFinderFactory.create(choice).findDrives();

		return drives;
	}

	// Accept Search Parameters from User
	public static UserInput acceptSearchParameters() {
		Scanner sc1 = new Scanner(System.in);
		UserInput ui = new UserInput();
		System.out.println("Enter file name");
		String fileName = sc1.nextLine();
		ui.setFileName(fileName);
		System.out.println("Mention the number of drives to search from");
		int num = sc1.nextInt();
		System.out.println("Mention the name of drives to search from");
		for (int i = 0; i < num; i++) {
			String s = sc1.next();
			ui.addDrives(s.concat(":\\"));
		}
		return ui;
	}

	// Step 4: Search for Files
	public static List<String> searchForFile(String fileName, List<String> drives) {

		List<String> listOfDirectory = SearchManagerFactory.create().search(fileName, drives);
		SearchHistoryManager history = new SearchHistoryManager();
		history.logSearchResult(listOfDirectory);
		return listOfDirectory;
	}

	// Step 5 : checking logs to see if the file getting searched is already present
	// in the logs
	public static List<String> searchLogCheck(String fileName) {
		SearchHistoryManager sh = new SearchHistoryManager();
		List<String> logs = sh.logCheck(fileName);

		return logs;
	}

}
