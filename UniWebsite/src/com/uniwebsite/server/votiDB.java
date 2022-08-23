package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.Voto;

public class votiDB {
	
	/* creazione database voti */
	public static DB getDB() {
		DB db = DBMaker.newFileDB(new File("votiDB")).make();
		return db;
	}

	/* aggiunta voto (docente invia voto a segreteria) */
	public static String aggiuntaVoto(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<Integer, Voto> voti = db.getTreeMap("Voti");
				
		Voto voto = new Voto(
				voti.size(), // id voto
				dati.get(1), // esame
				dati.get(2), // email studente
				dati.get(3)  // voto
				); 
				
		voti.put(voto.getIdVoto(), voto);
		db.commit();
		db.close();
		return "Successo";	

	}
	
	/* metodo per ottenere tutti i voti di uno studente data la sua email */
	public static ArrayList<Voto> getVotiStudente(String email){
		DB db = getDB();
		BTreeMap<Integer, Voto> voti = db.getTreeMap("Voti");
		
		voti.put(1, new Voto(1, "analisi", "mari", "30"));
		db.commit();
		
		ArrayList<Voto> votiOutput = new ArrayList<Voto>();
		for(Entry<Integer, Voto> test : voti.entrySet()) {
			if(email.equals(test.getValue().getEmail())) {
				//if(test.getValue().getPubblicato()) {
					votiOutput.add(test.getValue());
				//}	
			}
		}
		return votiOutput;
	}

	/* aggiunta voto (segreteria pubblica voto per lo studente) */
	public static String pubblicazioneVoti(ArrayList<String> dati) {
		// TODO Auto-generated method stub
		return null;
	}

}
