package com.uniwebsite.server;

import com.uniwebsite.client.GreetingService;
import com.uniwebsite.shared.Corso;
import com.uniwebsite.shared.Docente;
import com.uniwebsite.shared.Esame;
import com.uniwebsite.shared.Segreteria;
import com.uniwebsite.shared.Studente;
import com.uniwebsite.shared.Utente;
import com.uniwebsite.shared.Voto;

import java.util.ArrayList;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
@SuppressWarnings("serial")
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {
	
	// METODI PER GESTIRE TUTTE LE TIPOLOGIE DI UTENTE
	@Override
	public String registrazioneStudente(ArrayList<String> dati) throws IllegalArgumentException { 
		return UtentiDB.registrazioneStudente(dati);
	}

	@Override
	public String registrazioneSegreteria(ArrayList<String> dati) throws IllegalArgumentException { 
		return UtentiDB.registrazioneSegreteria(dati);
	}

	@Override
	public String registrazioneDocente(ArrayList<String> dati) throws IllegalArgumentException {
		return UtentiDB.registrazioneDocente(dati);
	}

	@Override
	public Utente login(String username, String password) throws IllegalArgumentException {
		return UtentiDB.login(username, password);
	}

	@Override
	public Utente getUtente(String email) throws IllegalArgumentException { 
		return UtentiDB.getUtente(email);
	}

	@Override
	public Studente getStudente(String email) throws IllegalArgumentException { 
		return UtentiDB.getStudente(email);
	}

	@Override
	public ArrayList<Studente> getStudenti() throws IllegalArgumentException { 
		return UtentiDB.getStudenti();
	}

	@Override
	public ArrayList<Docente> getDocenti() throws IllegalArgumentException { 
		return UtentiDB.getDocenti();
	}
	
	@Override
	public ArrayList<Segreteria> getSegreteria() throws IllegalArgumentException {
		return UtentiDB.getSegreteria();
	}

	@Override
	public String aggiornaStudente(ArrayList<String> utenteUpdate, String email) throws IllegalArgumentException {
		return UtentiDB.aggiornaStudente(utenteUpdate, email);
	}
	
	@Override
	public String aggiornaDocente(ArrayList<String> utenteUpdate, String email) throws IllegalArgumentException { 
		return UtentiDB.aggiornaDocente(utenteUpdate, email);
	}


	// METODI PER GESTIRE I CORSI
	@Override
	public String creazioneCorso(ArrayList<String> dati) throws IllegalArgumentException { 
		return CorsiDB.creazioneCorso(dati);
	}

	@Override
	public String aggiornaCorso(ArrayList<String> corsoUpdate, String nomeCorso) throws IllegalArgumentException { 
		return CorsiDB.aggiornaCorso(corsoUpdate, nomeCorso);
	}

	@Override
	public String iscrizioneCorso(String email, String corso) throws IllegalArgumentException { 
		return IscrizioneCorsoDB.iscrizioneCorso(email, corso);
	}
	
	@Override
	public ArrayList<Corso> getCorsiDocente(String email) throws IllegalArgumentException { 
		return CorsiDB.getCorsiDocente(email);
	}

	@Override
	public ArrayList<String> getCorsiStudente(String email) throws IllegalArgumentException { 
		return IscrizioneCorsoDB.getCorsiStudente(email);
	}	
	
	@Override
	public String eliminaCorso(String nomeCorso) throws IllegalArgumentException { 
		return CorsiDB.eliminaCorso(nomeCorso);
	}

	@Override
	public ArrayList<Corso> getCorsi() throws IllegalArgumentException {
		return CorsiDB.getCorsi();
	}


	// METODI PER GESIRE GLI ESAMI
	@Override
	public String creazioneEsame(ArrayList<String> dati) throws IllegalArgumentException { 
		return EsamiDB.creazioneEsame(dati);
	}

	@Override
	public String aggiornaEsame(ArrayList<String> esameUpdate, String nomeEsame) throws IllegalArgumentException { 
		return EsamiDB.aggiornaEsame(esameUpdate, nomeEsame);
	}

	@Override
	public String iscrizioneEsame(String email, String esame) throws IllegalArgumentException { 
		return IscrizioneEsameDB.iscrizioneEsame(email, esame);
	}

	@Override
	public ArrayList<Esame> getEsamiDocente(String email) throws IllegalArgumentException {
		return EsamiDB.getEsamiDocente(email);
	}

	@Override
	public ArrayList<String> getEsamiStudente(String email) throws IllegalArgumentException { 
		return IscrizioneEsameDB.getEsamiStudente(email);
	}

	@Override
	public String eliminaEsame(String esame) throws IllegalArgumentException { 
		return EsamiDB.eliminaEsame(esame);
	}
	
	@Override
	public ArrayList<Esame> getEsami() throws IllegalArgumentException { 
		return EsamiDB.getEsami();
	}

	
	// METODI PER GESTIRE I VOTI
	@Override
	public String aggiuntaVoto(ArrayList<String> dati) throws IllegalArgumentException { 
		return VotiDB.aggiuntaVoto(dati);
	}

	@Override
	public ArrayList<Voto> getVotiStudente(String email) throws IllegalArgumentException { 
		return VotiDB.getVotiStudente(email);
	}
	
	@Override
	public ArrayList<Voto> getVotiNonPubblicati(String email) throws IllegalArgumentException { 
		return VotiDB.getVotiNonPubblicati(email);
	}

	@Override
	public String pubblicazioneVoti(ArrayList<String> dati) throws IllegalArgumentException {
		return VotiDB.pubblicazioneVoti(dati);
	}
	
	
	// JUNIT
	private GreetingService mock = null;

	public GreetingService getMock() {
		return mock;
	}

	public void setMock(GreetingService mock) {
		this.mock = mock;
	}
	
	public void clearCorsiDB() {
		CorsiDB.clearCorsiDB();
	}
	
	public void clearEsamiDB() {
		EsamiDB.clearEsamiDB();
	}
	
	public void clearIscrizioneCorsoDB() {
		IscrizioneCorsoDB.clearIscrizioneCorsoDB();
	}
	
	public void clearIscrizioneEsameDB() {
		IscrizioneEsameDB.clearIscrizioneEsameDB();
	}
	
	public void clearVotiDB() {
		VotiDB.clearVotiDB();
	}
	
	public void clearUtentiDB() {
		UtentiDB.clearUtentiDB();
	}
}
