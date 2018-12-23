package com.ugrow.internet.Entity;

public class BackMaterial {
	private int id;
	private String title;
	private String url;
	private int fileType;
	
	private String[] fileTypelist= {"文件","软件"};
	
	public String getFileTypelist() {
		return fileTypelist[fileType];
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getFileType() {
		return fileType;
	}
	public void setFileType(int fileType) {
		this.fileType = fileType;
	}
	

}
