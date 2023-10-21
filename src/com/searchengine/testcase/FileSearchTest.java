package com.searchengine.testcase;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.searchengine.exception.InvalidRootFinderException;
import com.searchengine.main.SearchEngineConsole;
import com.searchengine.searchmanager.ISearchManager;
import com.searchengine.searchmanager.SearchManagerFactory;
import com.searchengine.searchmanager.UserInput;

public class FileSearchTest {

	@Test
	void testSearchForFile() {
		SearchEngineConsole test = new SearchEngineConsole();
		try {
			List<String> drives;
			drives = test.findDrives();
			UserInput ui = test.acceptSearchParameters();
			ISearchManager searchManger1 = SearchManagerFactory.create();
			List<String> actual = searchManger1.search(ui.getFileName(), ui.getDrives());
			List<String> excpect = new ArrayList<>();
			excpect.add("E:\\Search_Folder\\New.txt");
			assertEquals(excpect, actual);
		} catch (InvalidRootFinderException e) {
			
			e.printStackTrace();
		}

	}
}
