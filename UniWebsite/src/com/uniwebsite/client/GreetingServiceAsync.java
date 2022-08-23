package com.uniwebsite.client;

import java.util.ArrayList;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.uniwebsite.shared.Corso;
import com.uniwebsite.shared.Docente;
import com.uniwebsite.shared.Esame;
import com.uniwebsite.shared.Segreteria;
import com.uniwebsite.shared.Studente;
import com.uniwebsite.shared.Utente;
import com.uniwebsite.shared.Voto;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	
	void getDatabase(AsyncCallback<String> callback) throws IllegalArgumentException;
	
	// METODI PER GESTIRE TUTTE LE TIPOLOGIE DI UTENTE
	void registrazioneStudente(ArrayList<String> dati, AsyncCallback<String> callback) throws IllegalArgumentException; 
	
	void registrazioneSegreteria(ArrayList<String> dati, AsyncCallback<String> callback) throws IllegalArgumentException; 
		
	void registrazioneDocente(ArrayList<String> dati, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void login(String username, String password, AsyncCallback<Utente> callback) throws IllegalArgumentException;
		
	void getUtente(String email, AsyncCallback<Utente> callback) throws IllegalArgumentException; 
	
	void getStudente(String email, AsyncCallback<Studente> callback) throws IllegalArgumentException;
	
	void getStudenti(AsyncCallback<ArrayList<Studente>> callback) throws IllegalArgumentException; 
	
	void getDocenti(AsyncCallback<ArrayList<Docente>> callback) throws IllegalArgumentException; 
	
	void getSegreteria(AsyncCallback<ArrayList<Segreteria>> callback) throws IllegalArgumentException;
			
	void aggiornaStudente(ArrayList<String> utenteUpdate, String email, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void aggiornaDocente(ArrayList<String> utenteUpdate, String email, AsyncCallback<String> callback) throws IllegalArgumentException; 
	
	
	// METODI PER GESTIRE I CORSI
	void creazioneCorso(ArrayList<String> dati, AsyncCallback<String> callback) throws IllegalArgumentException; 
	
	void aggiornaCorso(ArrayList<String> corsoUpdate, String nomeCorso, AsyncCallback<String> callback) throws IllegalArgumentException; 
	
	void iscrizioneCorso(String email, String corso, AsyncCallback<String> callback) throws IllegalArgumentException; 
	
	void getCorsiDocente(String email, AsyncCallback<ArrayList<Corso>> callback) throws IllegalArgumentException;

	void getCorsiStudente(String email, AsyncCallback<ArrayList<String>> callback) throws IllegalArgumentException;
	
	void eliminaCorso(String nomeCorso, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void getCorsi(AsyncCallback<ArrayList<Corso>> callback) throws IllegalArgumentException; 
	
	
	// METODI PER GESIRE GLI ESAMI
	void creazioneEsame(ArrayList<String> dati, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void aggiornaEsame(ArrayList<String> esameUpdate, String nomeEsame, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void iscrizioneEsame(String email, String esame, AsyncCallback<String> callback) throws IllegalArgumentException; 
	
	void getEsamiDocente(String email, AsyncCallback<ArrayList<Esame>> callback) throws IllegalArgumentException; 
	
	void getEsamiStudente(String email, AsyncCallback<ArrayList<String>> callback) throws IllegalArgumentException;
	
	void eliminaEsame(String esame, AsyncCallback<String> callback) throws IllegalArgumentException;
	
	void getEsami(AsyncCallback<ArrayList<Esame>> callback) throws IllegalArgumentException;
		
	
	// METODI PER GESTIRE I VOTI
	void aggiuntaVoto(ArrayList<String> dati, AsyncCallback<String> callback) throws IllegalArgumentException; //
	
	void getVotiStudente(String email, AsyncCallback<ArrayList<Voto>> callback) throws IllegalArgumentException; //
		
	void pubblicazioneVoti(ArrayList<String> dati, AsyncCallback<String> callback) throws IllegalArgumentException;
}
