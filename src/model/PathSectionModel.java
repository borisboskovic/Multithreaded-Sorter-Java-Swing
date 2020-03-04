package model;

public class PathSectionModel {

	private int number;
	private String path;
	private String message;

	public PathSectionModel(int number) {
		this.number = number;
		this.path = "";
		this.message = "Test message! This should be deleted.";
	}

	public PathSectionModel(int number, String path) {
		this.number = number;
		this.path = path;
		this.message = "Test message! This should be deleted.";
	}
	
	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
