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
		BTreeMap<String,Utente> utenti = db.getTreeMap("UtentiMap");
		
		for(Entry<String,Utente> utente : utenti.entrySet()) {
			if(utente.getValue().getEmail().equals(email)) {
				trovato = true;
			}
		} return trovato;
	}
	public static Utente login(String email, String password) throws IllegalArgumentException{
		DB db = getDB();
		BTreeMap<String,Utente> utenti = db.getTreeMap("UtentiMap");
		
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
		// TODO Auto-generated method stub
		return null;
	}

	public static String eliminaUtente(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public static String aggiornaUtente(ArrayList<String> utenteUpdate, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Utente getUtente(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<Studente> getStudenti() {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<Docente> getDocenti() {
		// TODO Auto-generated method stub
		return null;
	}

	public static ArrayList<Utente> getUtenti() {
		// TODO Auto-generated method stub
		return null;
	}
}
