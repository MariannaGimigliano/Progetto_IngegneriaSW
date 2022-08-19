package com.uniwebsite.client;

import java.util.ArrayList;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.uniwebsite.shared.*;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	
	String getDatabase() throws IllegalArgumentException;
	
	// METODI PER GESTIRE TUTTE LE TIPOLOGIE DI UTENTE
	String registrazioneStudente(ArrayList<String> dati) throws IllegalArgumentException;

	String registrazioneSegreteria(ArrayList<String> dati) throws IllegalArgumentException;

	String registrazioneAmministratore(ArrayList<String> dati) throws IllegalArgumentException;

	String registrazioneDocente(ArrayList<String> dati) throws IllegalArgumentException;

	Utente login(String username, String password) throws IllegalArgumentException;

	String getInfoUtente(String email) throws IllegalArgumentException;

	Studente getStudente(String email) throws IllegalArgumentException; //

	ArrayList<Studente> getStudenti() throws IllegalArgumentException;

	ArrayList<Docente> getDocenti() throws IllegalArgumentException;

	ArrayList<Utente> getUtenti() throws IllegalArgumentException;

	String eliminaUtente(String email) throws IllegalArgumentException;

	String aggiornaUtente(ArrayList<String> utenteUpdate, String email) throws IllegalArgumentException;


	// METODI PER GESTIRE I CORSI
	String creazioneCorso(ArrayList<String> dati) throws IllegalArgumentException;

	String aggiornaCorso(ArrayList<String> corsoUpdate, String nomeCorso) throws IllegalArgumentException;

	String iscrizioneCorso(String email, int idCorso) throws IllegalArgumentException;

	ArrayList<Corso> getCorsiStudente(String email) throws IllegalArgumentException; 
	
	String eliminaCorso(String nomeCorso) throws IllegalArgumentException;

	ArrayList<Corso> getCorsi() throws IllegalArgumentException; //


	// METODI PER GESIRE GLI ESAMI
	String creazioneEsame(ArrayList<String> dati, int idCorso) throws IllegalArgumentException;

	String aggiornaEsame(ArrayList<String> esameUpdate, int idCorso) throws IllegalArgumentException;

	String iscrizioneEsame(String email, int idCorso) throws IllegalArgumentException;

	ArrayList<Esame> getEsamiDocente(String email) throws IllegalArgumentException;

	ArrayList<Esame> getEsami() throws IllegalArgumentException;

	ArrayList<Integer> getEsamiStudente(String email) throws IllegalArgumentException;

	String eliminaEsame(int idCorso) throws IllegalArgumentException;

	ArrayList<String> getIscrittiEsame(Integer idEsame) throws IllegalArgumentException;

	
	// METODI PER GESTIRE I VOTI
	String aggiuntaVoto(ArrayList<String> dati) throws IllegalArgumentException;

	ArrayList<Voto> getVotiStudente(String matricola) throws IllegalArgumentException;

	ArrayList<Voto> getVoti() throws IllegalArgumentException;

	String pubblicazioneVoti(ArrayList<String> dati) throws IllegalArgumentException;

	String eliminaVoto(Voto voto)  throws IllegalArgumentException;
}
