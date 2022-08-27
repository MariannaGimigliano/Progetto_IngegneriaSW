package com.uniwebsite;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
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
	
	// TEST SUI METODI UTENTE
	
	@org.junit.jupiter.api.Test
	@DisplayName("Registrazione Studente")
	public void testRegistrazioneStudente() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("emailStud");
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
		dati.add("emailDoc");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		assertEquals("successo", test.registrazioneDocente(dati));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Registrazione Segreteria")
	public void testRegistrazioneSegreteria() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("emailSeg");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		assertEquals("successo", test.registrazioneSegreteria(dati));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Aggiornamento Studente")
	public void testAggiornamentoStudente() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("emailStud3");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		dati.add("matricola");
		assertEquals("successo", test.registrazioneStudente(dati));
		
		dati.set(1, "nuovaPassword");
		dati.set(3, "nuovoCognome");
		assertEquals("successo", test.aggiornaStudente(dati, dati.get(0)));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Aggiornamento Docente")
	public void testAggiornamentoDocente() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("emailDoc2");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		assertEquals("successo", test.registrazioneDocente(dati));
		
		dati.set(1, "nuovaPassword");
		dati.set(2, "nuovoNome");
		assertEquals("successo", test.aggiornaDocente(dati, dati.get(0)));
	}
	
	
	// TEST SUI METODI CORSI
	
	@org.junit.jupiter.api.Test
	@DisplayName("Creazione Corso")
	public void testCreazioneCorso() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("corso");
		dati.add("docente");
		dati.add("descrizione");
		dati.add("dataInizio");
		dati.add("dataFine");
		assertEquals("successo", test.creazioneCorso(dati));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Aggiornamento Corso")
	public void testAggiornamentoCorso() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("corso2");
		dati.add("docente");
		dati.add("descrizione");
		dati.add("dataInizio");
		dati.add("dataFine");
		assertEquals("successo", test.creazioneCorso(dati));
		
		dati.set(3, "nuovaDataInizio");
		dati.set(4, "nuovaDataFine");
		assertEquals("successo", test.aggiornaCorso(dati, dati.get(0)));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Eliminazione Corso")
	public void testEliminazioneCorso() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("corso3");
		dati.add("docente");
		dati.add("descrizione");
		dati.add("dataInizio");
		dati.add("dataFine");
		assertEquals("successo", test.creazioneCorso(dati));
		
		assertEquals("successo", test.eliminaCorso(dati.get(0)));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Iscrizione Corso")
	public void testIscrizioneCorso() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("email");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		dati.add("matricola");
		assertEquals("successo", test.registrazioneStudente(dati));
		
		ArrayList<String> dati2 = new ArrayList<String>();
		dati2.add("corso4");
		dati2.add("docente");
		dati2.add("descrizione");
		dati2.add("dataInizio");
		dati2.add("dataFine");
		assertEquals("successo", test.creazioneCorso(dati2));
		
		assertEquals("successo", test.iscrizioneCorso(dati.get(0), dati2.get(0)));
	}
	
	
	// TEST SUI METODI ESAME
	
	@org.junit.jupiter.api.Test
	@DisplayName("Creazione Esame")
	public void testCreazioneEsame() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("esame");
		dati.add("docente");
		dati.add("data");
		dati.add("ora");
		dati.add("durata");
		dati.add("aula");
		assertEquals("successo", test.creazioneEsame(dati));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Aggiornamento Esame")
	public void testAggiornamentoEsame() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("esame2");
		dati.add("docente");
		dati.add("data");
		dati.add("ora");
		dati.add("durata");
		dati.add("aula");
		assertEquals("successo", test.creazioneEsame(dati));
		
		dati.set(2, "nuovaData");
		dati.set(5, "nuovaAula");
		assertEquals("successo", test.aggiornaEsame(dati, dati.get(0)));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Eliminazione Esame")
	public void testEliminazioneEsame() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("esame3");
		dati.add("docente");
		dati.add("data");
		dati.add("ora");
		dati.add("durata");
		dati.add("aula");
		assertEquals("successo", test.creazioneEsame(dati));
		
		assertEquals("successo", test.eliminaEsame(dati.get(0)));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Iscrizione Esame")
	public void testIscrizioneEsame() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("email2");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		dati.add("matricola");
		assertEquals("successo", test.registrazioneStudente(dati));
		
		ArrayList<String> dati2 = new ArrayList<String>();
		dati2.add("esame4");
		dati2.add("docente");
		dati2.add("data");
		dati2.add("ora");
		dati2.add("durata");
		dati2.add("aula");
		assertEquals("successo", test.creazioneEsame(dati2));
		
		assertEquals("successo", test.iscrizioneEsame(dati.get(0), dati2.get(0)));
	}
	
	
	// TEST SUI METODI VOTI
	
	@org.junit.jupiter.api.Test
	@DisplayName("Aggiunta Voto")
	public void testAggiuntaVoto() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("email3");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		dati.add("matricola");
		assertEquals("successo", test.registrazioneStudente(dati));
		
		ArrayList<String> dati2 = new ArrayList<String>();
		dati2.add("esame5");
		dati2.add("docente");
		dati2.add("data");
		dati2.add("ora");
		dati2.add("durata");
		dati2.add("aula");
		assertEquals("successo", test.creazioneEsame(dati2));
		
		ArrayList<String> dati3 = new ArrayList<String>();
		dati3.add("");
		dati3.add("esame5");
		dati3.add("email3");
		dati3.add("voto");
		assertEquals("successo", test.aggiuntaVoto(dati3));
	}
	
	@org.junit.jupiter.api.Test
	@DisplayName("Pubblicazione Voto")
	public void testPubblicazioneVoto() {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("email4");
		dati.add("password");
		dati.add("nome");
		dati.add("cognome");
		dati.add("matricola");
		assertEquals("successo", test.registrazioneStudente(dati));
		
		ArrayList<String> dati2 = new ArrayList<String>();
		dati2.add("esame6");
		dati2.add("docente");
		dati2.add("data");
		dati2.add("ora");
		dati2.add("durata");
		dati2.add("aula");
		assertEquals("successo", test.creazioneEsame(dati2));
		
		ArrayList<String> dati3 = new ArrayList<String>();
		dati3.add("");
		dati3.add("esame6");
		dati3.add("email4");
		dati3.add("voto");
		assertEquals("successo", test.aggiuntaVoto(dati3));
		
		ArrayList<String> dati4 = new ArrayList<String>();
		dati4.add(dati3.get(2));
		dati4.add(dati3.get(3));
		assertEquals("successo", test.pubblicazioneVoti(dati4));
	}
	
	@AfterAll
	public static void clearDB() {
		test.clearCorsiDB();
		test.clearEsamiDB();
		test.clearIscrizioneCorsoDB();
		test.clearIscrizioneEsameDB(); 
		test.clearUtentiDB();
		test.clearVotiDB();
	}
}
