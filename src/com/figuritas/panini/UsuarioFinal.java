package com.figuritas.panini;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.figuritas.panini.exceptions.CodigoExistenteException;
import com.figuritas.panini.exceptions.FiguritaNoDisponibleException;
import com.figuritas.panini.exceptions.FiguritaRepetidaException;

public class UsuarioFinal extends Usuario {
	List <Figurita> misFiguritas;
	Set <Figurita> misFiguritasPegadas;
	
	public UsuarioFinal(int id) {
		super(id);
		misFiguritas = new ArrayList<>();
		misFiguritasPegadas = new HashSet<>();
	}

	public List<Figurita> getFiguritas() {
		return misFiguritas;
	}
	
	boolean tengoLaFigurita(Figurita figurita) throws FiguritaNoDisponibleException {
		if( this.getFiguritas().contains(figurita)) {
			return true;
		}else {
			throw new FiguritaNoDisponibleException("No tienes esa figurita en tu coleccion");
		}
	}
	boolean pegarFigurita(Figurita figurita) throws FiguritaRepetidaException, FiguritaNoDisponibleException{
		if(	tengoLaFigurita(figurita) && misFiguritasPegadas.add(figurita)) {
			misFiguritas.remove(figurita);
			return true;
		} else {
			throw new FiguritaRepetidaException("No se puede pegar la misma figurita 2 veces");
		}
	}

	boolean intercambiarFigurita(Figurita figuritaDoy, Figurita figuritaRecibo, UsuarioFinal otroUsuario) throws FiguritaNoDisponibleException, CodigoExistenteException {
		if(	this.tengoLaFigurita(figuritaDoy) && otroUsuario.tengoLaFigurita(figuritaRecibo)){
			otroUsuario.agregarFigurita(figuritaDoy);
			misFiguritas.remove(figuritaDoy);
				misFiguritas.add(figuritaRecibo);
				otroUsuario.getFiguritas().remove(figuritaRecibo);
			return true;	
		} else {
			throw new FiguritaNoDisponibleException("No puedes intercambiar figurita ya pegada / que no poseas");
		}
	}

	public boolean figuritaEstaPegada(Figurita figurita) {
		if ( misFiguritasPegadas.contains(figurita)) {
		return true;
		} return false;
	}

	@Override
	public Integer getCantidadFiguritasSinPegar() {
		return misFiguritas.size();
	}
	
	@Override
	boolean agregarFigurita(Figurita figurita) throws CodigoExistenteException {
		if ( misFiguritas.add(figurita)) {
		   Collections.sort(misFiguritas);
			return true;
		} else {
			throw new CodigoExistenteException ("No se pudo agregar a la coleccion");
		}
	}
}
