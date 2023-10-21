package com.searchengine.searchmanager;

import java.util.ArrayList;
import java.util.List;

import com.searchengine.exception.UnableToExececuteException;

public class SearchManager implements ISearchManager {

	private List<String> pathFound = new ArrayList<>();

	@Override
	public List<String> search(String fileName, List<String> drives) {

		Thread[] thread = new Thread[drives.size()];
		FileSearcher[] searches = new FileSearcher[drives.size()];

		
		//Iterate through the threads
		for (int i = 0; i < drives.size(); i++) {
			FileSearcher fileSearcher = new FileSearcher(fileName, drives.get(i));
			//Store the File Searcher object to access it later for getting the results
			searches[i] = fileSearcher;
			thread[i] = new Thread(fileSearcher);
			thread[i].start();
		}

		
		//Wait for the threads to execute
		for (Thread thread1 : thread) {
			try {
				thread1.join(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		//Get the Results
		for (int i = 0; i < searches.length; i++) {
			for (String path : searches[i].getPathsFound()) {
				pathFound.add(path);
			}
		}

		return pathFound;
	}

}
