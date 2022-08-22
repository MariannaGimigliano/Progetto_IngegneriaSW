package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.IscrizioneCorso;

public class iscrizioneCorsoDB {
	
	/* creazione database iscrizione ai corsi */
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("iscrizioneCorsoDB")).make();
		return db;
	}

	/* Metodo per ottenere tutti i corsi a cui uno studente è iscritto 
	 * (ritona un arraylist di nomi di corsi)
	 */
	public static ArrayList<String> getCorsiStudente(String email){       	//NON FUNZIONA !!!??????
		DB db = getDB();
		BTreeMap<String, IscrizioneCorso> iscrizioni = db.getTreeMap("IscrizioniCorso");
		
		iscrizioni.put("algebra", new IscrizioneCorso("algebra", "mari"));
		db.commit();
		
		ArrayList<String> corsiOutput = new ArrayList<String>();
		for(Entry<String, IscrizioneCorso> test : iscrizioni.entrySet()) {
			if(email.equals(test.getValue().getEmailStudente())) {
				corsiOutput.add(test.getValue().getCorso());
			}
		}
		return corsiOutput;
	}
	
	/* Metodo che permette ad uno studente di iscriversi ad un corso */
	public static String iscrizioneCorso(String email, String corso) { 
		DB db = getDB();
		BTreeMap<String, IscrizioneCorso> iscrizioni = db.getTreeMap("IscrizioniCorso");

		IscrizioneCorso iscrizione = new IscrizioneCorso(corso, email);
		boolean trovato = false;
		for(Entry<String, IscrizioneCorso> test : iscrizioni.entrySet()) {
			if(corso == test.getValue().getCorso() && email.equals(test.getValue().getEmailStudente())) {
				trovato = true;
			}
		}
		if(!trovato) {
			iscrizioni.put(iscrizione.getCorso(), iscrizione);
			db.commit();
			db.close();
			return "iscritto";
		} else {
			db.commit();
			db.close();		
			return "già presente";
		}
	}
}