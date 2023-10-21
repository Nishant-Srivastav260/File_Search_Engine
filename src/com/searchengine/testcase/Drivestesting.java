package com.searchengine.testcase;


import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.searchengine.exception.InvalidRootFinderException;
import com.searchengine.main.SearchEngineConsole;

class Drivestesting {

	@Test
	void testFindDrives() {
		
		try {
			List<String> actual = SearchEngineConsole.findDrives();
			List<String> excepted = new ArrayList<>();
			excepted.add("C:\\");
			excepted.add("D:\\");
			excepted.add("E:\\");
			assertEquals(excepted, actual);
		} catch (InvalidRootFinderException e) {

			e.printStackTrace();
		}

	}

}
