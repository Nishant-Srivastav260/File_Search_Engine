package com.searchengine.drivefinder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SystemDriveFinder implements IDriveFinder{

	@Override
	public List<String> findDrives() {
		
List<String> drives= new ArrayList<>();
		
		File[] allDrives = File.listRoots();
		
		for(File d : allDrives) {
			
				drives.add(d.getPath());
		}
		
		return drives;
	}
	}


