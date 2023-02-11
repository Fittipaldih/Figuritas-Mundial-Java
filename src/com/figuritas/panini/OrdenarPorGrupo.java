package com.figuritas.panini;

import java.util.Comparator;

public class OrdenarPorGrupo implements Comparator <Figurita>{

	public int compare(Figurita o1, Figurita o2) {
		if ( o1.getLetraGrupo().compareTo(o2.getLetraGrupo()) == 1) {
			return 1;
		} else if ( o2.getLetraGrupo().compareTo(o1.getLetraGrupo()) == 1) {
			return -1;
	 } return 0;
	}
}
