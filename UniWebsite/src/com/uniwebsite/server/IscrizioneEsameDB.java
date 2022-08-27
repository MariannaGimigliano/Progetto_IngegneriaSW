package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.IscrizioneEsame;

public class IscrizioneEsameDB {

	/* creazione database iscrizione agli esami */
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("iscrizioneEsameDB")).make();
		return db;
	}
	
	/* metodo che ritorna tutti gli esami a cui uno studente è iscritto 
	 * (ritona un arraylist di nomi di esami)
	 */
	public static ArrayList<String> getEsamiStudente(String email){
		DB db = getDB();
		BTreeMap<Integer, IscrizioneEsame> iscrizioni = db.getTreeMap("IscrizioniEsame");
		
		iscrizioni.put(1, new IscrizioneEsame(1, "web", "marianna@unibo.it"));
		iscrizioni.put(2, new IscrizioneEsame(2, "web", "martina@unibo.it"));
		db.commit();
		
		ArrayList<String> esamiOutput = new ArrayList<String>();
		for(Entry<Integer, IscrizioneEsame> test : iscrizioni.entrySet()) {
			if(email.equals(test.getValue().getEmailStudente())) {
				esamiOutput.add(test.getValue().getEsame());
			}
		}
		return esamiOutput;
	}
	
	/* metodo che permette ad uno studente di iscriversi ad un'esame, data l'email dello studente
	 * e il nome del'esame
	 */
	public static String iscrizioneEsame(String email, String esame) { 
		DB db = getDB();
		BTreeMap<Integer, IscrizioneEsame> iscrizioni = db.getTreeMap("IscrizioniEsame");

		IscrizioneEsame iscrizione = new IscrizioneEsame(iscrizioni.size() +1, esame, email);
		boolean trovato = false;
		for(Entry<Integer, IscrizioneEsame> test : iscrizioni.entrySet()) {
			if(esame.equals(test.getValue().getEsame()) && email.equals(test.getValue().getEmailStudente())) {
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
	public static void clearIscrizioneEsameDB() {
		DB db = getDB();
		BTreeMap<Integer, IscrizioneEsame> iscrizioni = db.getTreeMap("IscrizioniEsame");
		iscrizioni.clear();
		db.commit();
		db.close();
	}
}
