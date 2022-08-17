package com.uniwebsite.server;

import com.uniwebsite.client.GreetingService;
import com.uniwebsite.shared.Corso;
import com.uniwebsite.shared.Docente;
import com.uniwebsite.shared.Esame;
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
	public String registrazioneAmministratore(ArrayList<String> dati) throws IllegalArgumentException {
		return utentiDB.registrazioneAmministratore(dati);
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
	public String getInfoUtente(String email) throws IllegalArgumentException {
		return utentiDB.getInfoUtente(email);
	}

	@Override
	public Utente getUtente(String email) throws IllegalArgumentException {
		return utentiDB.getUtente(email);
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
	public ArrayList<Utente> getUtenti() throws IllegalArgumentException {
		return utentiDB.getUtenti();
	}

	@Override
	public String eliminaUtente(String email) throws IllegalArgumentException {
		return utentiDB.eliminaUtente(email);
	}

	@Override
	public String aggiornaUtente(ArrayList<String> utenteUpdate, String email) throws IllegalArgumentException {
		return utentiDB.aggiornaUtente(utenteUpdate, email);
	}


	// METODI PER GESTIRE I CORSI
	@Override
	public String creazioneCorso(ArrayList<String> dati) throws IllegalArgumentException {
		return corsiDB.creazioneCorso(dati);
	}

	@Override
	public String aggiornaCorso(ArrayList<String> corsoUpdate, String nomeCorso) throws IllegalArgumentException {
		return corsiDB.aggiornaCorso(dati);
	}

	@Override
	public String iscrizioneCorso(String email, int idCorso) throws IllegalArgumentException {
		return corsiDB.iscrizioneCorso(corsoUpdate, idCorso);
	}

	@Override
	public ArrayList<Integer> getCorsiStudente(String email) throws IllegalArgumentException {
		return corsiDB.getCorsiStudente(email);
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
	public String creazioneEsame(ArrayList<String> dati, int idCorso) throws IllegalArgumentException {
		return esamiDB.creazioneEsame(dati, idCorso);
	}

	@Override
	public String aggiornaEsame(ArrayList<String> esameUpdate, int idCorso) throws IllegalArgumentException {
		return esamiDB.aggiornaEsame(esameUpdate, idCorso);
	}

	@Override
	public String iscrizioneEsame(String email, int idCorso) throws IllegalArgumentException {
		return esamiDB.iscrizioneEsame(email, idCorso);
	}

	@Override
	public ArrayList<Esame> getEsamiDocente(String email) throws IllegalArgumentException {
		return esamiDB.getEsamiDocente(email);
	}

	@Override
	public ArrayList<Esame> getEsami() throws IllegalArgumentException {
		return esamiDB.getEsami();
	}

	@Override
	public ArrayList<Integer> getEsamiStudente(String email) throws IllegalArgumentException {
		return esamiDB.getEsamiStudente(email);
	}

	@Override
	public String eliminaEsame(int idCorso) throws IllegalArgumentException {
		return esamiDB.eliminaEsame(idCorso);
	}

	@Override
	public ArrayList<String> getIscrittiEsame(Integer idEsame) throws IllegalArgumentException {
		return esamiDB.getIscrittiEsame(idEsame);
	}

	
	// METODI PER GESTIRE I VOTI
	@Override
	public String aggiuntaVoto(ArrayList<String> dati) throws IllegalArgumentException {
		return votiDB.aggiuntaVoto(dati);
	}

	@Override
	public ArrayList<Voto> getVotiStudente(String matricola) throws IllegalArgumentException {
		return votiDB.getVotiStudente(matricola);
	}

	@Override
	public ArrayList<Voto> getVoti() throws IllegalArgumentException {
		return votiDB.getVoti();
	}

	@Override
	public String pubblicazioneVoti(ArrayList<String> dati) throws IllegalArgumentException {
		return votiDB.pubblicazioneVoti(dati);
	}
	
	@Override
	public String eliminaVoto(Voto voto)  throws IllegalArgumentException {
		return votiDB.eliminaVoto(voto);
	}
}
