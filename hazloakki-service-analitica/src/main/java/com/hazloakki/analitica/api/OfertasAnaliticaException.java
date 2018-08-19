package com.hazloakki.analitica.api;

public class OfertasAnaliticaException extends RuntimeException {
	private final String id;

	public OfertasAnaliticaException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static OfertasAnaliticaException from(String message, String id) {
		return new OfertasAnaliticaException(message, id);
	}

	public String getId() {
		return id;
	}

}
