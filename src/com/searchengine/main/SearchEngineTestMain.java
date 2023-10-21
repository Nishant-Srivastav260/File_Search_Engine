package com.searchengine.main;

import java.util.List;

import com.searchengine.searchmanager.UserInput;

public class SearchEngineTestMain {

	public static void main(String[] args) {

		// Displaying welcome message
		SearchEngineConsole.displayWelcomeMessage();

		// Finding Drives
		List<String> drive = SearchEngineConsole.findDrives();

		for (String d : drive) {
			System.out.println(d);
		}

		// Accept Search Parameter
		UserInput ui = SearchEngineConsole.acceptSearchParameters();
		
		
		//Check logs for previous result if present print from there else do another search
		List<String> searchFromLog = SearchEngineConsole.searchLogCheck(ui.getFileName());
		if(!searchFromLog.isEmpty()) {
			searchFromLog.stream().forEach(System.out::println);
		}
		else {
			List<String> searchResult = SearchEngineConsole.searchForFile(ui.getFileName(), ui.getDrives());
			searchResult.stream().forEach(System.out::println);
		}


	}
}
