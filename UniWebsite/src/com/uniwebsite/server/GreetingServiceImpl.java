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

	@Override
	public String getDatabase() throws IllegalArgumentException {
		return utentiDB.getDatabase();
	}
	
	// METODI PER GESTIRE TUTTE LE TIPOLOGIE DI UTENTE
	@Override
	public String registrazioneStudente(ArrayList<String> dati) throws IllegalArgumentException { 
		return utentiDB.registrazioneStudente(dati);
	}

	@Override
	public String registrazioneSegreteria(ArrayList<String> dati) throws IllegalArgumentException { 
		return utentiDB.registrazioneSegreteria(dati);
	}

	@Override
	public String registrazioneDocente(ArrayList<String> dati) throws IllegalArgumentException {
		return utentiDB.registrazioneDocente(dati);
	}

	@Override
	public Utente login(String username, String password) throws IllegalArgumentException {
		return utentiDB.login(username, password);
	}

	@Override
	public Utente getUtente(String email) throws IllegalArgumentException { 
		return utentiDB.getUtente(email);
	}

	@Override
	public Studente getStudente(String email) throws IllegalArgumentException { 
		return utentiDB.getStudente(email);
	}

	@Override
	public ArrayList<Studente> getStudenti() throws IllegalArgumentException { 
		return utentiDB.getStudenti();
	}

	@Override
	public ArrayList<Docente> getDocenti() throws IllegalArgumentException { 
		return utentiDB.getDocenti();
	}
	
	@Override
	public ArrayList<Segreteria> getSegreteria() throws IllegalArgumentException {
		return utentiDB.getSegreteria();
	}

	@Override
	public String aggiornaStudente(ArrayList<String> utenteUpdate, String email) throws IllegalArgumentException {
		return utentiDB.aggiornaStudente(utenteUpdate, email);
	}
	
	@Override
	public String aggiornaDocente(ArrayList<String> utenteUpdate, String email) throws IllegalArgumentException { 
		return utentiDB.aggiornaDocente(utenteUpdate, email);
	}


	// METODI PER GESTIRE I CORSI
	@Override
	public String creazioneCorso(ArrayList<String> dati) throws IllegalArgumentException { 
		return corsiDB.creazioneCorso(dati);
	}

	@Override
	public String aggiornaCorso(ArrayList<String> corsoUpdate, String nomeCorso) throws IllegalArgumentException { 
		return corsiDB.aggiornaCorso(corsoUpdate, nomeCorso);
	}

	@Override
	public String iscrizioneCorso(String email, String corso) throws IllegalArgumentException { 
		return iscrizioneCorsoDB.iscrizioneCorso(email, corso);
	}
	
	@Override
	public ArrayList<Corso> getCorsiDocente(String email) throws IllegalArgumentException { 
		return corsiDB.getCorsiDocente(email);
	}

	@Override
	public ArrayList<String> getCorsiStudente(String email) throws IllegalArgumentException { 
		return iscrizioneCorsoDB.getCorsiStudente(email);
	}	
	
	@Override
	public String eliminaCorso(String nomeCorso) throws IllegalArgumentException { 
		return corsiDB.eliminaCorso(nomeCorso);
	}

	@Override
	public ArrayList<Corso> getCorsi() throws IllegalArgumentException {
		return corsiDB.getCorsi();
	}


	// METODI PER GESIRE GLI ESAMI
	@Override
	public String creazioneEsame(ArrayList<String> dati) throws IllegalArgumentException { 
		return esamiDB.creazioneEsame(dati);
	}

	@Override
	public String aggiornaEsame(ArrayList<String> esameUpdate, String nomeEsame) throws IllegalArgumentException { 
		return esamiDB.aggiornaEsame(esameUpdate, nomeEsame);
	}

	@Override
	public String iscrizioneEsame(String email, String esame) throws IllegalArgumentException { 
		return iscrizioneEsameDB.iscrizioneEsame(email, esame);
	}

	@Override
	public ArrayList<Esame> getEsamiDocente(String email) throws IllegalArgumentException {
		return esamiDB.getEsamiDocente(email);
	}

	@Override
	public ArrayList<String> getEsamiStudente(String email) throws IllegalArgumentException { 
		return iscrizioneEsameDB.getEsamiStudente(email);
	}

	@Override
	public String eliminaEsame(String esame) throws IllegalArgumentException { 
		return esamiDB.eliminaEsame(esame);
	}
	
	@Override
	public ArrayList<Esame> getEsami() throws IllegalArgumentException { 
		return esamiDB.getEsami();
	}

	
	// METODI PER GESTIRE I VOTI
	@Override
	public String aggiuntaVoto(ArrayList<String> dati) throws IllegalArgumentException { //
		return votiDB.aggiuntaVoto(dati);
	}

	@Override
	public ArrayList<Voto> getVotiStudente(String email) throws IllegalArgumentException { //
		return votiDB.getVotiStudente(email);
	}

	@Override
	public String pubblicazioneVoti(ArrayList<String> dati) throws IllegalArgumentException {
		return votiDB.pubblicazioneVoti(dati);
	}
}
