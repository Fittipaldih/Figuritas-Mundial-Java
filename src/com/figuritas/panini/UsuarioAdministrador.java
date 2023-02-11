package com.figuritas.panini;

import java.util.TreeSet;

import com.figuritas.panini.exceptions.CodigoExistenteException;

import java.util.Set;

public class UsuarioAdministrador extends Usuario{
	Set <Figurita> figuritasAdm;
	
	public UsuarioAdministrador(int id) {
		super(id);
		figuritasAdm = new TreeSet<>();
	}

	public Set<Figurita> getFiguritas() {
		return figuritasAdm;
	}
	
	@Override
	public Integer getCantidadFiguritasSinPegar() {
		return figuritasAdm.size();
	}

	@Override
	boolean agregarFigurita(Figurita figurita) throws CodigoExistenteException {
		if ( figuritasAdm.add(figurita)) {
			return true;
		}
		else {
		throw new CodigoExistenteException("Ya existe figurita con ese codigo en la Base de Datos");
		}
	}
}
