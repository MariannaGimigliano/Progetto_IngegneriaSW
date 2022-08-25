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

	String registrazioneDocente(ArrayList<String> dati) throws IllegalArgumentException; 

	Utente login(String username, String password) throws IllegalArgumentException; 
	
	Utente getUtente(String email) throws IllegalArgumentException; 

	Studente getStudente(String email) throws IllegalArgumentException; 
	
	ArrayList<Studente> getStudenti() throws IllegalArgumentException; 

	ArrayList<Docente> getDocenti() throws IllegalArgumentException; 
	
	ArrayList<Segreteria> getSegreteria() throws IllegalArgumentException; 

	String aggiornaStudente(ArrayList<String> utenteUpdate, String email) throws IllegalArgumentException; 
	
	String aggiornaDocente(ArrayList<String> utenteUpdate, String email) throws IllegalArgumentException; 


	// METODI PER GESTIRE I CORSI
	String creazioneCorso(ArrayList<String> dati) throws IllegalArgumentException; 

	String aggiornaCorso(ArrayList<String> corsoUpdate, String nomeCorso) throws IllegalArgumentException; 

	String iscrizioneCorso(String email, String corso) throws IllegalArgumentException; 

	ArrayList<Corso> getCorsiDocente(String email) throws IllegalArgumentException; 
	
	ArrayList<String> getCorsiStudente(String email) throws IllegalArgumentException; 
	
	String eliminaCorso(String nomeCorso) throws IllegalArgumentException; 

	ArrayList<Corso> getCorsi() throws IllegalArgumentException; 


	// METODI PER GESIRE GLI ESAMI
	String creazioneEsame(ArrayList<String> dati) throws IllegalArgumentException; 

	String aggiornaEsame(ArrayList<String> esameUpdate, String nomeEsame) throws IllegalArgumentException; 

	String iscrizioneEsame(String email, String esame) throws IllegalArgumentException; 

	ArrayList<Esame> getEsamiDocente(String email) throws IllegalArgumentException; 

	ArrayList<String> getEsamiStudente(String email) throws IllegalArgumentException; 

	String eliminaEsame(String esame) throws IllegalArgumentException; 
	
	ArrayList<Esame> getEsami() throws IllegalArgumentException; 

	
	// METODI PER GESTIRE I VOTI
	String aggiuntaVoto(ArrayList<String> dati) throws IllegalArgumentException; 

	ArrayList<Voto> getVotiStudente(String email) throws IllegalArgumentException; 
	
	ArrayList<Voto> getVotiNonPubblicati(String email) throws IllegalArgumentException; 

	String pubblicazioneVoti(ArrayList<String> dati) throws IllegalArgumentException;
}
