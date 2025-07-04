package com.devsuperior.bds04.services.exceptions;

import java.io.Serial;

public class DatabaseException extends RuntimeException {
	@Serial
	private static final long serialVersionUID = 1L;

	public DatabaseException(String msg) {
		super(msg);
	}
}
