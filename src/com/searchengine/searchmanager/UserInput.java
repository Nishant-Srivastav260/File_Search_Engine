package com.searchengine.searchmanager;

import java.util.ArrayList;
import java.util.List;

public class UserInput {
	
	private String fileName;
	private List<String> drives=new ArrayList<>();
	
	public void addDrives(String drive) {
		this.drives.add(drive);
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getDrives() {
		return drives;
	}

	public void setDrives(List<String> drives) {
		this.drives = drives;
	}
	

}
