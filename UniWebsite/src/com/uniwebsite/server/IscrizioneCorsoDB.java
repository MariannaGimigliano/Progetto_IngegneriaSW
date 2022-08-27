package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.IscrizioneCorso;

public class IscrizioneCorsoDB {
	
	/* creazione database iscrizione ai corsi */
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("iscrizioneCorsoDB")).make();
		return db;
	}

	/* metodo che ritorna tutti i corsi a cui uno studente è iscritto 
	 * (ritona un arraylist di nomi di corsi)
	 */
	public static ArrayList<String> getCorsiStudente(String email){ 
		DB db = getDB();
		BTreeMap<Integer, IscrizioneCorso> iscrizioni = db.getTreeMap("IscrizioniCorso");
		
		iscrizioni.put(1, new IscrizioneCorso(1, "web", "marianna@unibo.it"));
		iscrizioni.put(2, new IscrizioneCorso(2, "ingegneria", "marianna@unibo.it"));
		iscrizioni.put(3, new IscrizioneCorso(3, "web", "martina@unibo.it"));
		db.commit();
		
		ArrayList<String> corsiOutput = new ArrayList<String>();
		for(Entry<Integer, IscrizioneCorso> test : iscrizioni.entrySet()) {
			if(email.equals(test.getValue().getEmailStudente())) {
				corsiOutput.add(test.getValue().getCorso());
			}
		}
		return corsiOutput;
	}
	
	/* metodo che permette ad uno studente di iscriversi ad un corso, data l'email dello studente
	 * e il nome del corso
	 */
	public static String iscrizioneCorso(String email, String corso) { 
		DB db = getDB();
		BTreeMap<Integer, IscrizioneCorso> iscrizioni = db.getTreeMap("IscrizioniCorso");

		IscrizioneCorso iscrizione = new IscrizioneCorso(iscrizioni.size() +1, corso, email);
		boolean trovato = false;
		for(Entry<Integer, IscrizioneCorso> test : iscrizioni.entrySet()) {
			if(corso.equals(test.getValue().getCorso()) && email.equals(test.getValue().getEmailStudente())) {
				trovato = true;
			}
		}
		if(!trovato) {
			iscrizioni.put(iscrizione.getIdIscrizione(), iscrizione);
			db.commit();
			db.close();
			return "successo";
		} else return "errore";
	}

	/* eliminazione dati db */
	public static void clearIscrizioneCorsoDB() {
		DB db = getDB();
		BTreeMap<Integer, IscrizioneCorso> iscrizioni = db.getTreeMap("IscrizioniCorso");
		iscrizioni.clear();
		db.commit();
		db.close();
	}
}