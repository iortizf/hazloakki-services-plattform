package com.hazloakki.negocio.api;

public class CategoriasNegociosException extends RuntimeException {
	private final String id;

	public CategoriasNegociosException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static CategoriasNegociosException from(String message, String id) {
		return new CategoriasNegociosException(message, id);
	}

	public String getId() {
		return id;
	}

}
