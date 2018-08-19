package com.hazloakki.negocio.api;

public class NegocioException extends RuntimeException {
	private final String id;

	public NegocioException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static NegocioException from(String message, String id) {
		return new NegocioException(message, id);
	}

	public String getId() {
		return id;
	}

}
