package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.IscrizioneEsame;

public class iscrizioneEsameDB {

	/* creazione database iscrizione agli esami */
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("iscrizioneEsameDB")).make();
		return db;
	}
	
	/* Metodo per ottenere tutti gli esami a cui uno studente è iscritto 
	 * (ritona un arraylist di nomi di esami)
	 */
	public static ArrayList<String> getEsamiStudente(String email){
		DB db = getDB();
		BTreeMap<String, IscrizioneEsame> iscrizioni = db.getTreeMap("IscrizioniEsame");
		
		iscrizioni.put("web", new IscrizioneEsame("web", "marianna@unibo.it"));
		db.commit();
		
		ArrayList<String> esamiOutput = new ArrayList<String>();
		for(Entry<String, IscrizioneEsame> test : iscrizioni.entrySet()) {
			if(email.equals(test.getValue().getEmailStudente())) {
				esamiOutput.add(test.getValue().getEsame());
			}
		}
		return esamiOutput;
	}
	
	/* Metodo che permette ad uno studente di iscriversi ad un esame */
	public static String iscrizioneEsame(String email, String esame) { 
		DB db = getDB();
		BTreeMap<String, IscrizioneEsame> iscrizioni = db.getTreeMap("IscrizioniEsame");

		IscrizioneEsame iscrizione = new IscrizioneEsame(esame, email);
		boolean trovato = false;
		for(Entry<String, IscrizioneEsame> test : iscrizioni.entrySet()) {
			if(esame == test.getValue().getEsame() && email.equals(test.getValue().getEmailStudente())) {
				trovato = true;
			}
		}
		if(!trovato) {
			iscrizioni.put(iscrizione.getEsame(), iscrizione); 
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
