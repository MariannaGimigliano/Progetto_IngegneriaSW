package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map;
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
	
	/* metodo per login */
	public static Utente login(String email, String password) throws IllegalArgumentException{
		DB db = getDB();
		BTreeMap<String, Utente> utenti = db.getTreeMap("Utenti");
		
		utenti.put("marianna@unibo.it", new Studente("marianna@unibo.it", "mari", "Marianna", "Gimigliano", "0000915343"));
		utenti.put("martina@unibo.it", new Studente("martina@unibo.it", "marti", "Martina", "Daghia", "0000915287"));
		utenti.put("docente@unibo.it", new Docente("docente@unibo.it", "doc", "Martina", "Zauli"));
		utenti.put("docente2@unibo.it", new Docente("docente2@unibo.it", "doc2", "Francesco", "Bianchi"));
		utenti.put("segreteria@unibo.it", new Segreteria("segreteria@unibo.it", "seg", "Chiara", "Verdi"));
		utenti.put("amministratore@unibo.it", new Amministratore("amministratore@unibo.it", "amm", "Marco", "Rossi"));
		db.commit();
		
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

	/* metodo che crea un nuovo studente */
	public static String registrazioneStudente(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String, Studente> utenti = db.getTreeMap("Utenti");

		Studente utente = new Studente(
				dati.get(0), // email
				dati.get(1), // password
				dati.get(2), // nome
				dati.get(3), // cognome
				dati.get(4) // matricola
				);
		
		if(!trovaUtente(utente.getEmail()) && dati.get(0).length()>=1 && dati.get(1).length()>=1 && dati.get(2).length()>=1 
				&& dati.get(3).length()>=1 && dati.get(4).length()>=1) {		
			utenti.put(utente.getEmail(), utente);
			db.commit();
			db.close();
			return "successo";
		} else return "errore";
	}

	/* metodo che crea un nuovo utente segreteria */
	public static String registrazioneSegreteria(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String, Segreteria> utenti = db.getTreeMap("Utenti");

		Segreteria segreteria = new Segreteria(
				dati.get(0), // email
				dati.get(1), // password
				dati.get(2), // nome
				dati.get(3) // cognome
				);
		
		if(!trovaUtente(segreteria.getEmail()) && dati.get(0).length()>=1 && dati.get(1).length()>=1 && 
				dati.get(2).length()>=1 && dati.get(3).length()>=1) {
			utenti.put(segreteria.getEmail(), segreteria);
			db.commit();
			db.close();
			return "successo";
		} else return "errore";
	}

	/* metodo che crea un nuovo docente */
	public static String registrazioneDocente(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String, Docente> utenti = db.getTreeMap("Utenti");

		Docente docente = new Docente(
				dati.get(0), // email
				dati.get(1), // password
				dati.get(2), // nome
				dati.get(3) // cognome
				);
		
		if(!trovaUtente(docente.getEmail()) && dati.get(0).length()>=1 && dati.get(1).length()>=1 && 
				dati.get(2).length()>=1 && dati.get(3).length()>=1) {
			utenti.put(docente.getEmail(), docente);
			db.commit();
			db.close();
			return "successo";
		} else return "errore";
	}
	
	/* metodo che data l'email trova un utente specifico */
	public static Utente getUtente(String email) {
		DB db = getDB();
		BTreeMap<String, Utente> utenti = db.getTreeMap("Utenti");
		
		Utente user = utenti.get(email);
		return user;
	}

	/* metodo che data l'email trova uno studente specifico */
	public static Studente getStudente(String email) {
		DB db = getDB();
		BTreeMap<String, Studente> utenti = db.getTreeMap("Utenti");
		
		Studente user = utenti.get(email);
		return user;
	}

	/* metodo che ritorna la lista di tutti gli studenti */
	public static ArrayList<Studente> getStudenti() {
		DB db = getDB();
		Map<String, Utente> utenti = db.getTreeMap("Utenti");
		
		ArrayList<Studente> listaStudenti = new ArrayList<Studente>();
		for(Entry<String,Utente> test : utenti.entrySet()) {
			if(test.getValue() instanceof Studente) {
				listaStudenti.add((Studente) test.getValue());
			}
		}
		return listaStudenti;
	}

	/* metodo che ritorna la lista di tutti i docenti */
	public static ArrayList<Docente> getDocenti() {
		DB db = getDB();
		Map<String, Utente> utenti = db.getTreeMap("Utenti");
		
		ArrayList<Docente> listaDocenti = new ArrayList<Docente>();
		for(Entry<String,Utente> test : utenti.entrySet()) {
			if(test.getValue() instanceof Docente) {
				listaDocenti.add((Docente) test.getValue());
			}
		}
		return listaDocenti;
	}
	
	/* metodo che ritorna la lista di tutti gli utenti segreteria */
	public static ArrayList<Segreteria> getSegreteria() {
		DB db = getDB();
		Map<String, Utente> utenti = db.getTreeMap("Utenti");
		
		ArrayList<Segreteria> listaSegreteria = new ArrayList<Segreteria>();
		for(Entry<String,Utente> test : utenti.entrySet()) {
			if(test.getValue() instanceof Segreteria) {
				listaSegreteria.add((Segreteria) test.getValue());
			}
		}
		return listaSegreteria;
	}

	/* metodo che aggiorna i dati di uno studente data la sua email */
	public static String aggiornaStudente(ArrayList<String> dati, String email) {
		DB db = getDB();
		Map<String, Studente> utenti = db.getTreeMap("Utenti");
		
		Studente utente = utenti.get(email);
		utenti.remove(email);
		
		if(dati.get(0) != ""){
			utente.setPassword(dati.get(0));
		}
		if(dati.get(1) != ""){
			utente.setNome(dati.get(1));
		}
		if(dati.get(2) != ""){
			utente.setCognome(dati.get(2));
		}
		if(dati.get(3) != ""){
			utente.setMatricola(dati.get(3));
		}
		utenti.put(email, utente);
		db.commit();
		db.close();
		return "successo";
	}
	
	/* metodo che aggiorna i dati di un docente data la sua email */
	public static String aggiornaDocente(ArrayList<String> dati, String email) {
		DB db = getDB();
		Map<String, Docente> utenti = db.getTreeMap("Utenti");
		
		Docente utente = utenti.get(email);
		utenti.remove(email);
		
		if(dati.get(0) != ""){
			utente.setPassword(dati.get(0));
		}
		if(dati.get(1) != ""){
			utente.setNome(dati.get(1));
		}
		if(dati.get(2) != ""){
			utente.setCognome(dati.get(2));
		}
		utenti.put(email, utente);
		db.commit();
		db.close();
		return "successo";
	}
	
	/* metodo per eseguire un controllo: se l'utente esiste già nel sistema */
	private static boolean trovaUtente(String email) {
		boolean trovato = false;
		DB db = getDB();
		BTreeMap<String,Utente> utenti = db.getTreeMap("Utenti");
		
		for(Entry<String,Utente> utente : utenti.entrySet()) {
			if(utente.getValue().getEmail().equals(email)) {
				trovato = true;
			}
		} 
		return trovato;
	}
}
