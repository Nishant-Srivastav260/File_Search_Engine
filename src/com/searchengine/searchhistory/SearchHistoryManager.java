package com.searchengine.searchhistory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

//It has to create threads. The number of threads will be equal to the number drives
//the user has selected
//call the search() which is in file searcher
public class SearchHistoryManager {
	
	
	public List<String> logCheck(String fileName) {
		
		List<String> path= new ArrayList<>();
	
	File file = new File("D:\\Search Engine\\Search_History_Logger/Search_History.txt");

	try {
	    Scanner scanner = new Scanner(file);

	    //now read the file line by line...
	    int lineNum = 0;
	    while (scanner.hasNextLine()) {
	        String line = scanner.nextLine();
	        lineNum++;
	        if(line.contains(fileName)) { 
	            //System.out.println(" i found it on line " +lineNum);
	            path.add(line.substring(6));   
	        }
	    }
	} catch(FileNotFoundException e) {  
	    e.getMessage();
	}
	
	
	
	return path;
	
	}
	
	public void logSearchResult(List<String> searchResult) {
		Logger logger = Logger.getLogger("MyLog");  
	    FileHandler fh;  

	    try {  

	        // This block configure the logger with handler and formatter  
	        fh = new FileHandler("D:\\Search Engine\\Search_History_Logger/Search_History.txt", true);  
	        logger.addHandler(fh);
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fh.setFormatter(formatter);  

	        // the following statement is used to log any messages 
	        searchResult.stream().forEach(result -> logger.info(result));
	          

	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	}
		
	}


