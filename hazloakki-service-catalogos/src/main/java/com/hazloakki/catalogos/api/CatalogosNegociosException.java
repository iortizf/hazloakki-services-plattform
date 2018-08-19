package com.hazloakki.catalogos.api;

public class CatalogosNegociosException extends RuntimeException {
	private final String id;

	public CatalogosNegociosException(String message, String id) {
		super(message);
		this.id = id;
	}

	public static CatalogosNegociosException from(String message, String id) {
		return new CatalogosNegociosException(message, id);
	}

	public String getId() {
		return id;
	}

}
