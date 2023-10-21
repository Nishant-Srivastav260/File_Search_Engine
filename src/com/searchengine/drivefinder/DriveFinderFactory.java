package com.searchengine.drivefinder;

import com.searchengine.exception.InvalidDriveChoiceException;

public class DriveFinderFactory {

	public static IDriveFinder create(String choice) {
		
		IDriveFinder finder = null;
		
		if (choice.equalsIgnoreCase("ALL")) {
			finder =new SystemDriveFinder() ;
			}
		
			else if(choice.equalsIgnoreCase("ACTIVE")) {
				finder =new ActiveDriveFinder();
			}
				else
					throw new InvalidDriveChoiceException();
				
				return finder;
			}
		
	}

