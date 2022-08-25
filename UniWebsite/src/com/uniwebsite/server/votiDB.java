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
		boolean trovato = false;
		
		Voto voto = new Voto(
				voti.size() + 1, // id voto
				dati.get(1), // esame
				dati.get(2), // email studente
				dati.get(3), // voto
				false);      // pubblicato
			
		for(Entry<Integer, Voto> test : voti.entrySet()) {
			if(test.getValue().getEmail().equals(voto.getEmail()) && test.getValue().getEsame().equals(voto.getEsame())) {
				trovato = true; 
			}
		}
		
		if (!trovato && dati.get(1).length()>=1 && dati.get(2).length()>=1 && dati.get(3).length()>=1) {
			voti.put(voto.getIdVoto(), voto);
			db.commit();
			db.close();
			return "successo";
		} else return "errore";
	}
	
	/* metodo per ottenere tutti i voti (già pubblicati) di uno studente data la sua email */
	public static ArrayList<Voto> getVotiStudente(String email){
		DB db = getDB();
		BTreeMap<Integer, Voto> voti = db.getTreeMap("Voti");
		
		voti.put(1, new Voto(1, "economia", "marianna@unibo.it", "28", true));
		voti.put(2, new Voto(2, "basi di dati", "marianna@unibo.it", "20", true));
		voti.put(3, new Voto(3, "teoria dell'impresa", "marianna@unibo.it", "25", true));
		voti.put(4, new Voto(4, "web", "martina@unibo.it", "24", true));
		voti.put(5, new Voto(5, "basi di dati", "martina@unibo.it", "30", true));
		db.commit();
		
		ArrayList<Voto> votiOutput = new ArrayList<Voto>();
		for(Entry<Integer, Voto> test : voti.entrySet()) {
			if(email.equals(test.getValue().getEmail())) {
				if(test.getValue().isPubblicato()) {
					votiOutput.add(test.getValue());
				}	
			}
		}
		return votiOutput;
	}
	
	/* metodo per ottenere l'elenco dei voti non pubblicati di uno studente data la sua email */
	public static ArrayList<Voto> getVotiNonPubblicati(String email){
		DB db = getDB();
		BTreeMap<Integer, Voto> voti = db.getTreeMap("Voti");
				
		ArrayList<Voto> votiOutput = new ArrayList<Voto>();
		for(Entry<Integer, Voto> test : voti.entrySet()) {
			if(email.equals(test.getValue().getEmail())) {
				if(!test.getValue().isPubblicato()) {
					votiOutput.add(test.getValue());
				}	
			}
		}
		return votiOutput;
	}

	/* aggiunta voto (segreteria pubblica voto per lo studente) */
	public static String pubblicazioneVoti(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<Integer, Voto> voti = db.getTreeMap("Voti");
		
		Voto voto = new Voto();
		for(Entry<Integer,Voto> test : voti.entrySet()) {
			if(dati.get(0).equals(test.getValue().getEmail()) && dati.get(1).equals(test.getValue().getVoto())) {
				voto = test.getValue();				
			}
		}
		voti.remove(voto.getIdVoto());
		
		voto.setPubblicato(true);
		voti.put(voto.getIdVoto(), voto);
		db.commit();
		db.close();
		return "successo";
	}

}
