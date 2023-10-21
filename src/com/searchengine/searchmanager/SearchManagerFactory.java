package com.searchengine.searchmanager;

import com.searchengine.exception.InvalidRootFinderException;

public class SearchManagerFactory {

	public static ISearchManager create() throws InvalidRootFinderException {
		return new SearchManager();
	}
}