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

	/* aggiunta voto (segreteria) */
	public static void aggiuntaVoto(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<Integer, Voto> voti = db.getTreeMap("Voti");

		voti.put(1, new Voto(1, "ciao", "ciao", "22"));
		db.commit();
		db.close();
		
		/*boolean trovato = false;
		
		Voto voto = new Voto(
				voti.size(), //id voto
				dati.get(1), //esame
				dati.get(2), //email studente
				dati.get(3)); //voto
				
		for(Entry<Integer, Voto> test : voti.entrySet()) {
			if(test.getValue().getEmail().equals(voto.getEmail()) && test.getValue().getEsame().equals(voto.getEsame())) {
				trovato = true; //il voto era già presente nel db
			}
		}
		//aggiunta effettiva del voto nel db
		if(dati.get(1).length()>=1 && dati.get(2).length()>=1 && dati.get(3).length()>=1 && !trovato) {
			voti.put(voto.getIdVoto(), voto);
			db.commit();
			db.close();
		}*/
	}
	
	/* Metodo per ottenere tutti i voti assegnati ad uno studente, prendendo in input la sua email */
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

}
