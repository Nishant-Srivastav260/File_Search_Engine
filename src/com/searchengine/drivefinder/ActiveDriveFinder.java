package com.searchengine.drivefinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.searchengine.exception.UnableToGetDrivesException;

public class ActiveDriveFinder implements IDriveFinder {

	// Detect Drives
	// Abstraction - Detect Drives
	// Abstraction - Visible Structure and Behaviour of an Object
	// Helps you to hide implementation

	@Override
	public List<String> findDrives() {
		// 1. Initialize the Variables
		List<String> drives = new ArrayList<String>();

		// 2. Get all the drives in the system
		try {
			File[] roots = File.listRoots();

			// Step 3 - Iterate the roots and get the name for active drives
			for (File root : roots) {
				if (root.canRead())
					drives.add(root.getAbsolutePath());
			}
		} catch (Exception ex) {
			throw new UnableToGetDrivesException("Unable To Detect Drives");
		}

		// 3. Return the drives
		return drives;
	}

}
