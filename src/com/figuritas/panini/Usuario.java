package com.figuritas.panini;

import com.figuritas.panini.exceptions.CodigoExistenteException;

public abstract class Usuario {
	
	private int id ;
	
	public Usuario (int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	abstract boolean agregarFigurita(Figurita figurita) throws CodigoExistenteException;
	abstract Integer getCantidadFiguritasSinPegar();

	@Override
	public String toString() {
		return "Usuario [numero id=" + id + "]";
	}
}
