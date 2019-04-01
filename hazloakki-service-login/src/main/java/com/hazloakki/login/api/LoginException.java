package com.hazloakki.login.api;

public class LoginException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7487913552705305740L;
	
	private final String id;

	public LoginException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static LoginException from(String message, String id) {
		return new LoginException(message, id);
	}

	public String getId() {
		return id;
	}

}
