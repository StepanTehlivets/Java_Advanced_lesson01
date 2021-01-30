package ua.academy.lgs;

public class WrongTimeInputException extends Exception {
	private String message;
	WrongTimeInputException(String message){
		super();
		this.message=message;
	}
	public String getMessage() {
		return message;
	}
}
