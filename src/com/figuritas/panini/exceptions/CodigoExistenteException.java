package com.figuritas.panini.exceptions;

public class CodigoExistenteException extends Exception {
	// solo para usuario admin, el usuario final puede repetir en su coleccion, aunque no la puede pegar 2 veces
	public CodigoExistenteException() {
		
	}
	
	public CodigoExistenteException(String msj) {
		super(msj);
	}
}
