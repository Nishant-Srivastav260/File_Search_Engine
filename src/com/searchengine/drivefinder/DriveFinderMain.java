package com.searchengine.drivefinder;

import java.io.File;
import java.util.List;

import com.searchengine.main.SearchEngineConsole;

public class DriveFinderMain {
	
	public static void main(String[] args) {
		
		//SearchEngineConsole s1 =new SearchEngineConsole();
		
		SearchEngineConsole.displayWelcomeMessage();
		
		List<String> drive =SearchEngineConsole.findDrives();
		
		for(String d : drive) {
			System.out.println(d);
		}
		
		
		
	}

}
