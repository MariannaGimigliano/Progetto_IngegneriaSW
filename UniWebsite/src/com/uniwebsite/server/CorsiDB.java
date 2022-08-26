package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.Corso;

public class CorsiDB {

	/* creazione database corsi */
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("corsiDB")).make();
		return db;
	}

	/* metodo che ritorna tutti i corsi presenti nel db */
	public static ArrayList<Corso> getCorsi() {
		DB db = getDB();
		BTreeMap<String, Corso> corsi = db.getTreeMap("Corsi");
		
		corsi.put("economia", new Corso("economia", "docente@unibo.it", "corso di economia aziendale", "12/03", "13/05"));
		corsi.put("web", new Corso("web", "docente@unibo.it", "corso di tecnologie web", "15/09", "23/12"));
		corsi.put("app", new Corso("app", "docente2@unibo.it", "corso di applicazioni mobili", "20/09", "18/12"));
		corsi.put("ingegneria", new Corso("ingegneria", "docente2@unibo.it", "corso di ingegneria del software", "20/09", "18/12"));
		db.commit();
		
		ArrayList<Corso> corsiOutput = new ArrayList<Corso>();
		for(Entry<String, Corso> test : corsi.entrySet()) {
			corsiOutput.add(test.getValue());
		}
		return corsiOutput;
	}

	/* metodo che ritorna tutti i corsi di un docente, data la sua email */
	public static ArrayList<Corso> getCorsiDocente(String email) {
		DB db = getDB();
		BTreeMap<String, Corso> corsi = db.getTreeMap("Corsi");
		
		ArrayList<Corso> corsiOutput = new ArrayList<Corso>();
		for(Entry<String, Corso> test : corsi.entrySet()) {
			if(email.equals(test.getValue().getEmailDocente())) {
				corsiOutput.add(test.getValue());
			}
		}
		return corsiOutput;
	}

	/* metodo che crea un nuovo corso, dato un array dei dati sul corso */
	public static String creazioneCorso(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String, Corso> corsi = db.getTreeMap("Corsi");
		boolean trovato = false;
		
		Corso corso = new Corso(
				dati.get(0), // corso
				dati.get(1), // docente
				dati.get(2), // descrizione 
				dati.get(3), // data inizio 
				dati.get(4)  // data fine  
				);
		
		for(Entry<String, Corso> test : corsi.entrySet()) {
			if(test.getValue().getNomeCorso().equals(corso.getNomeCorso())) {
				trovato = true;
			}
		}
		
		if (!trovato && dati.get(0).length()>=1 && dati.get(1).length()>=1 && dati.get(2).length()>=1 
				&& dati.get(3).length()>=1 && dati.get(4).length()>=1) {
			corsi.put(corso.getNomeCorso(), corso);
			db.commit();
			db.close();
			return "successo";
		} else return "errore";
	}

	/* metodo che elimina un corso, dato il suo nome */
	public static String eliminaCorso(String nomeCorso) {
		DB db = getDB();
		BTreeMap<String, Corso> corsi = db.getTreeMap("Corsi");

		for(Entry<String, Corso> test : corsi.entrySet()) {
			if(nomeCorso.equals(test.getValue().getNomeCorso())) {
				corsi.remove(test.getKey());
			}
		}
		db.commit();
		db.close();
		return "successo";
	}

	/* metodo che aggiorna i dati di un corso, dato il suo nome e un array dei dati sul corso */
	public static String aggiornaCorso(ArrayList<String> dati, String nomeCorso) {
		DB db = getDB();
		BTreeMap<String, Corso> corsi = db.getTreeMap("Corsi");

		Corso corso = corsi.get(nomeCorso);
		corsi.remove(nomeCorso);
		
		if(dati.get(0) != "") {
			corso.setDescrizione(dati.get(0));
		}
		if(dati.get(1) != "") {
			corso.setDataInizio(dati.get(1));
		}
		if(dati.get(2) != "") {
			corso.setDataFine(dati.get(2));
		}
		corsi.put(nomeCorso, corso);
		db.commit();
		db.close();
		return "successo";
	}
}
