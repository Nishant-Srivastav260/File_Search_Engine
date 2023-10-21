package com.searchengine.searchmanager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileSearcher implements Runnable {

	private String filename;
	private String drive;
	private List<String> pathsFound;

	public String getFilename() {
		return filename;
	}

	public String getDrive() {
		return drive;
	}

	public List<String> getPathsFound() {
		return pathsFound;
	}

	public FileSearcher(String filename, String string) {
		super();
		this.filename = filename;
		this.drive = string;
		pathsFound = new ArrayList<>();
	}

	public void search(String fileName, String drive) {
		 //Step 1 - Rules
        //Check if file is available or not
        //If yes, then add to the collection
        //If not, Identify the folders inside that drive
        //Then take each folder, check if file is available in that folder
        //This has to be done until we reach the last folder
         
		File drives = new File(drive);
		
		//Step 3 - Convert the drive received into file object
		File[] listOfFiles = drives.listFiles();
		
		 //Step 4 - Check if the file exists in that folder
        //Step 4.1 Check if that particular file is a folder. If folder then check if file exists in that folder
		if (listOfFiles != null) {
			for (File file : listOfFiles) {
				 //To check if its a directory or not
				if (file.isDirectory()) {
					String content = file.toString();
					
					search(fileName, content);
				} else {
					if (file.getName().equalsIgnoreCase(fileName)) {
						System.out.println(file.getAbsolutePath());
						pathsFound.add(file.getAbsolutePath());
					}
				}
			}
		}
	}

	@Override
	public void run() {
		 //Always have the method that has to be first called
		search(this.getFilename(), this.getDrive());

	}

}
