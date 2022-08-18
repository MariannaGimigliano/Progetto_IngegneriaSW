package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.*;

public class utentiDB {
	
	public static String getDatabase() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* creazione database utenti */
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("utentiDB")).make();
		return db;
	}
	
	/* metodi per login */
	private static boolean trovaUtente(String email) {
		boolean trovato = false;
		DB db = getDB();
		BTreeMap<String,Utente> utenti = db.getTreeMap("Utenti");
		
		for(Entry<String,Utente> utente : utenti.entrySet()) {
			if(utente.getValue().getEmail().equals(email)) {
				trovato = true;
			}
		} return trovato;
	}
	
	public static Utente login(String email, String password) throws IllegalArgumentException{
		DB db = getDB();
		BTreeMap<String,Utente> utenti = db.getTreeMap("Utenti");
		
		if(trovaUtente(email)) {
			Utente utente = utenti.get(email);
			if(utente.getPassword().equals(password)) {
				return utente;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public static String registrazioneStudente(ArrayList<String> dati) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String registrazioneSegreteria(ArrayList<String> dati) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String registrazioneAmministratore(ArrayList<String> dati) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String registrazioneDocente(ArrayList<String> dati) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String getInfoUtente(String email) {
		DB db = getDB();
		BTreeMap<String, Utente> utenti = db.getTreeMap("Utenti");

		Studente user = (Studente) utenti.get(email);

		String info = "Email :" + user.getEmail() + "\nPassword : " + user.getPassword() + "\nMatricola : " + 
				user.getMatricola() + "\nNome : " + user.getNome() + "\nCognome : " + user.getCognome();
		return info;
	}

	public static String eliminaUtente(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String aggiornaUtente(ArrayList<String> utenteUpdate, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	/* metodo che data l'email trova un utente specifico */
	public static Utente getUtente(String email) {
		DB db = getDB();
		BTreeMap<String, Utente> utenti = db.getTreeMap("Utenti");

		Utente user = utenti.get(email);
		return user;
	}

	public static ArrayList<Studente> getStudenti() {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<Docente> getDocenti() {
		// TODO Auto-generated method stub
		return null;
	}

	/* metodo che ritorna la lista di tutti gli utenti nel sistema */
	public static ArrayList<Utente> getUtenti() {
		DB db = getDB();
		BTreeMap<String, Utente> utenti = db.getTreeMap("Utenti");
		
		ArrayList<Utente> listaUtenti = new ArrayList<Utente>();
		for(Entry<String,Utente> test : utenti.entrySet()) {
			listaUtenti.add(test.getValue());
		}
		return listaUtenti;
	}
}
