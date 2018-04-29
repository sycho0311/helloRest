package kr.ac.hansung.cse.exception;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2006875985431069011L;
	
	private long userId;
	
	public UserNotFoundException(long userId) {
		this.userId = userId;
	}
	
	public long getUserId() {
		return userId;
	}
}
