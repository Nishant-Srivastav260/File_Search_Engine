package com.searchengine.searchmanager;

import java.util.List;

public interface ISearchManager {
	
	public List<String> search(String fileName, List<String> drives);
}
