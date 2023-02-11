package com.figuritas.panini;

public class Figurita implements Comparable <Figurita>{
	private String codigo; // incluye numJugador y seleccion
	private Integer numJugador;
	private Integer valorJugador;
	private Character letraGrupo;
	private Seleccion seleccion;
	private String nombreJugador;
	
	public Figurita (int num, Seleccion seleccion, char letra, String nombreJugador, Integer valorJugador ) {
		this.nombreJugador=nombreJugador;
		this.numJugador=num;
		this.seleccion=seleccion;
		this.letraGrupo=letra;
		this.valorJugador=valorJugador;
		generarCodigo(num, seleccion.toString());
	}

	private void generarCodigo(Integer num, String seleccion) {
		this.codigo= seleccion.substring(0, 3).toUpperCase() + num.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public String getCodigo() {
		return codigo;
	}

	public int getNumJugador() {
		return numJugador;
	}

	public Character getLetraGrupo() {
		return letraGrupo;
	}


	public String getNombreJugador() {
		return nombreJugador;
	}

	public Integer getValorJugador() {
		return valorJugador;
	}

	@Override
	public int compareTo(Figurita otra) {
		if ( this.getLetraGrupo().equals(otra.getLetraGrupo()) ) {
			if(this.seleccion.equals(otra.seleccion)) {
				return this.numJugador - otra.numJugador;
			} return this.getLetraGrupo().compareTo(otra.getLetraGrupo());
		}return this.getLetraGrupo().compareTo(otra.getLetraGrupo());
	}

	@Override
	public String toString() {
		return "*******\nFigurita: " + codigo + ", Grupo: " + letraGrupo + ", Jugador: " + numJugador + " " + nombreJugador
				+ ", Seleccion: " + seleccion + "]*******\n";
	}
}
