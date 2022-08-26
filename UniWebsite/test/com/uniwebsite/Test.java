package com.uniwebsite;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import com.uniwebsite.client.GreetingService;
import com.uniwebsite.server.GreetingServiceImpl;

public class Test {

	static GreetingServiceImpl test;
	
	@BeforeAll
	public static void init() {
		GreetingService i = mock(GreetingService.class);
		test = new GreetingServiceImpl();
		test.setMock(i);
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Registrazione Studente")
	public void testRegistrazioneStudente() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("email");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		dati.add("matricola");
		assertEquals("successo", test.registrazioneStudente(dati));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Registrazione Docente")
	public void testRegistrazioneDocente() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("email");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		assertEquals("successo", test.registrazioneDocente(dati));
	}
}
