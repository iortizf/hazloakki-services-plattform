package com.hazloakki.ofertas.api;

public class OfertasException extends RuntimeException {
	private final String id;

	public OfertasException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static OfertasException from(String message, String id) {
		return new OfertasException(message, id);
	}

	public String getId() {
		return id;
	}

}
