package com.uniwebsite.server;

import java.io.File;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;
import com.uniwebsite.shared.*;

public class utentiDB {
	
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

}
