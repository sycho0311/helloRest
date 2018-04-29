package kr.ac.hansung.cse.exception;

public class UserDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = -3312437843437623808L;

	private String userName;
	
	public UserDuplicatedException(String userName) {
		super();
		this.userName = userName;
	}
	
	public String getUserName() {
		return userName;
	}
	
}
