package com.figuritas.panini;

import static org.junit.Assert.*;

import org.junit.Test;

import com.figuritas.panini.exceptions.CodigoExistenteException;
import com.figuritas.panini.exceptions.FiguritaNoDisponibleException;
import com.figuritas.panini.exceptions.FiguritaRepetidaException;

public class TestFigurita {

	@Test
	public void queSePuedaCrearUnaFigurita() {
		Figurita figurita = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		
		String codigo= "ARG10";
		
		assertEquals(figurita.getLetraGrupo(), (Character)'C');
		assertEquals(figurita.getNumJugador(), 10);
		assertEquals(figurita.getNombreJugador(), "Messi");
		assertEquals(figurita.getValorJugador(), (Integer)50000000);
		assertEquals(figurita.getCodigo(), codigo);
		assertNotNull(figurita);
	}
	
	@Test
	public void queSePuedaCrearUnAdministrador() {
		Usuario usuarioAdm = new UsuarioAdministrador (1);
		assertNotNull(usuarioAdm);
		assertEquals(usuarioAdm.getId(), 1);
	}
	
	@Test
	public void queSePuedaCrearUnUsuarioFinal() {
		Usuario usuarioFinal = new UsuarioFinal(2);
		
		assertNotNull(usuarioFinal);
		assertEquals(usuarioFinal.getId(), 2);
	}
	
	@Test
	public void queUnAdministradorPuedaAgregarUnaFigurita() throws CodigoExistenteException {
		Usuario usuarioAdm = new UsuarioAdministrador (1);
		
		Figurita figurita = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		
		assertTrue(usuarioAdm.agregarFigurita(figurita));
		assertEquals(usuarioAdm.getCantidadFiguritasSinPegar(), (Integer)1);
	}
	@Test
	public void queUnUsuarioFinalPuedaAgregarUnaFigurita() throws CodigoExistenteException {
		Usuario usuarioFinal = new UsuarioFinal(2);
		Figurita figurita = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		assertTrue(usuarioFinal.agregarFigurita(figurita));
		assertEquals(usuarioFinal.getCantidadFiguritasSinPegar(), (Integer)1);
	}
	
	@Test
	public void queLasFiguritasAgregadasDeFormaDesordenadaQuedenOrdenadas() throws CodigoExistenteException {
		Usuario usuarioFinal = new UsuarioFinal(2);
		
		Figurita figurita1 = new Figurita(10, Seleccion.BRASIL, 'G', "Neymar", 38000000);
		Figurita figurita2 = new Figurita(1, Seleccion.BRASIL, 'G', "Becker", 15000000);
		Figurita figurita3 = new Figurita(10, Seleccion.ALEMANIA, 'E', "Gnabry", 25000000);
		Figurita figurita4 = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		
		usuarioFinal.agregarFigurita(figurita1);
		usuarioFinal.agregarFigurita(figurita2);
		usuarioFinal.agregarFigurita(figurita3);
		usuarioFinal.agregarFigurita(figurita4); 
		
		assertEquals(((UsuarioFinal) usuarioFinal).getFiguritas().get(0), figurita4 );
		assertEquals(((UsuarioFinal) usuarioFinal).getFiguritas().get(1), figurita3 );
		assertEquals(((UsuarioFinal) usuarioFinal).getFiguritas().get(2), figurita2 );
		assertEquals(((UsuarioFinal) usuarioFinal).getFiguritas().get(3), figurita1 );
		
		assertEquals(((UsuarioFinal) usuarioFinal).getCantidadFiguritasSinPegar(), (Integer)4);
	}
	
	@Test (expected = CodigoExistenteException.class)
	public void queUnAdministradorNoPuedaAgregarUnaFiguritaExistente() throws CodigoExistenteException {
		Usuario usuarioAdm = new UsuarioAdministrador (1);
		
		Figurita figurita1 = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		Figurita figurita2 = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		
		assertTrue(usuarioAdm.agregarFigurita(figurita1));	
		assertFalse(usuarioAdm.agregarFigurita(figurita2));
	}
	
	@Test
	public void queUnUsuarioFinalSiPuedaAgregarFiguritasExistentes() throws CodigoExistenteException {
		Usuario usuarioFinal = new UsuarioFinal(2);
		
		Figurita figurita1 = new Figurita(1, Seleccion.BRASIL, 'G', "Becker", 15000000);
		Figurita figurita2 = new Figurita(1, Seleccion.BRASIL, 'G', "Becker", 15000000);
		Figurita figurita3 = new Figurita(10, Seleccion.ALEMANIA, 'E', "Gnabry", 25000000);
		Figurita figurita4 = new Figurita(10, Seleccion.ALEMANIA, 'E', "Gnabry", 25000000);
		
		assertTrue(usuarioFinal.agregarFigurita(figurita1));		
		assertTrue(usuarioFinal.agregarFigurita(figurita2));		
		assertTrue(usuarioFinal.agregarFigurita(figurita3));		
		assertTrue(usuarioFinal.agregarFigurita(figurita4));	
		
		assertEquals(((UsuarioFinal) usuarioFinal).getCantidadFiguritasSinPegar(), (Integer)4);
	}
	
	@Test
	public void queUnUsuarioFinalPuedaPegarUnaFigurita() throws CodigoExistenteException, FiguritaRepetidaException, FiguritaNoDisponibleException {
		
		Usuario usuarioFinal = new UsuarioFinal(2);
		
		Figurita figurita1 = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		
		usuarioFinal.agregarFigurita(figurita1);
		
		assertEquals(((UsuarioFinal) usuarioFinal).getCantidadFiguritasSinPegar(), (Integer)1);
		assertTrue(((UsuarioFinal) usuarioFinal).pegarFigurita(figurita1));
		assertEquals(((UsuarioFinal) usuarioFinal).getCantidadFiguritasSinPegar(), (Integer)0);
		assertTrue(((UsuarioFinal) usuarioFinal).figuritaEstaPegada(figurita1));
	}
	
	@Test (expected = FiguritaRepetidaException.class)
	public void queUnUsuarioFinalNoPuedaPegarUnaFiguritaRepetida() throws FiguritaRepetidaException, FiguritaNoDisponibleException, CodigoExistenteException {
		
		Usuario usuarioFinal = new UsuarioFinal(2);
		
		Figurita figurita1 = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		Figurita figurita2 = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		
		usuarioFinal.agregarFigurita(figurita1);
		usuarioFinal.agregarFigurita(figurita2);
		
		assertTrue(((UsuarioFinal) usuarioFinal).pegarFigurita(figurita1));
		assertFalse(((UsuarioFinal) usuarioFinal).pegarFigurita(figurita2));
	}
	
	@Test
	public void queSePuedaRealizarElIntercambioDeFiguritasEntreDosUsuariosFinales() throws CodigoExistenteException, FiguritaNoDisponibleException {
		Usuario usuarioFinal1 = new UsuarioFinal(1);
		Usuario usuarioFinal2 = new UsuarioFinal(2);
		
		Figurita figurita1 = new Figurita(10, Seleccion.FRANCIA, 'D', "Mbappé", 40000000);
		Figurita figurita2 = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);
		
		usuarioFinal1.agregarFigurita(figurita1);
		usuarioFinal2.agregarFigurita(figurita2);
		
		assertTrue(	((UsuarioFinal) usuarioFinal1).intercambiarFigurita(figurita1, figurita2, (UsuarioFinal) usuarioFinal2));
	}
	
	@Test (expected = FiguritaNoDisponibleException.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueNoLaTenga() throws FiguritaNoDisponibleException, CodigoExistenteException {
		Usuario usuarioFinal1 = new UsuarioFinal(1);
		Usuario usuarioFinal2 = new UsuarioFinal(2);
		
		Figurita figurita1 = new Figurita(10, Seleccion.FRANCIA, 'D', "Mbappé", 40000000);
		Figurita figurita2 = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);

		usuarioFinal2.agregarFigurita(figurita2);
		
		assertFalse(((UsuarioFinal) usuarioFinal1).intercambiarFigurita(figurita1, figurita2, (UsuarioFinal) usuarioFinal2));
		
	}
	
	@Test (expected = FiguritaNoDisponibleException.class)
	public void queNoSePuedaIntercambiarUnaFiguritaDeUnUsuarioQueYaLaHayaPegado() throws CodigoExistenteException, FiguritaNoDisponibleException, FiguritaRepetidaException {
		Usuario usuarioFinal1 = new UsuarioFinal(1);
		Usuario usuarioFinal2 = new UsuarioFinal(2);
		
		Figurita figurita1 = new Figurita(10, Seleccion.FRANCIA, 'D', "Mbappé", 40000000);
		Figurita figurita2 = new Figurita(10, Seleccion.ARGENTINA, 'C', "Messi", 50000000);

		usuarioFinal1.agregarFigurita(figurita1);
		usuarioFinal2.agregarFigurita(figurita2);
		
		((UsuarioFinal) usuarioFinal1).pegarFigurita(figurita1);
		assertEquals(((UsuarioFinal) usuarioFinal1).getCantidadFiguritasSinPegar(), (Integer)0);
		assertTrue(((UsuarioFinal) usuarioFinal1).figuritaEstaPegada(figurita1));
		assertFalse(((UsuarioFinal) usuarioFinal1).intercambiarFigurita(figurita1, figurita2, (UsuarioFinal) usuarioFinal2));
		
	}
}
