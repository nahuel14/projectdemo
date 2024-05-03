package com.correo.Exceptions;

public class CorreoException extends Exception {

	public CorreoException() {
	}

	public CorreoException(String message) {
		super(message);
	}

	public CorreoException(Throwable cause) {
		super(cause);
	}

	public CorreoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CorreoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
