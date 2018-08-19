package com.hazloakki.cuenta.api;

public class CuentaException extends RuntimeException {
	private final String id;

	public CuentaException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static CuentaException from(String message, String id) {
		return new CuentaException(message, id);
	}

	public String getId() {
		return id;
	}

}
