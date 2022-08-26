package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.Esame;

public class EsamiDB {

	/* creazione database esami */
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("esamiDB")).make();
		return db;
	}
	
	/* metodo che ritorna tutti gli esami presenti nel db */
	public static ArrayList<Esame> getEsami() {
		DB db = getDB();
		BTreeMap<String, Esame> esami = db.getTreeMap("Esami");

		esami.put("economia", new Esame("economia", "docente@unibo.it", "12/05", "12:00", "1h", "A1"));
		esami.put("web", new Esame("web", "docente@unibo.it", "15/05", "14:30", "1:30h", "B12"));
		esami.put("app", new Esame("app", "docente2@unibo.it", "29/12", "09:00", "2h", "A2"));
		esami.put("ingegneria", new Esame("ingegneria", "docente2@unibo.it", "03/12", "15:30", "3h", "C5"));
		db.commit();
		
		ArrayList<Esame> esamiAll = new ArrayList<Esame>();
		for(Entry<String, Esame> test : esami.entrySet()) {
			esamiAll.add(test.getValue());
		}
		return esamiAll;
	}

	/* metodo che ritorna tutti gli esami di un docente, data la sua email */
	public static ArrayList<Esame> getEsamiDocente(String email) {
		DB db = getDB();
		BTreeMap<String, Esame> esami = db.getTreeMap("Esami");

		db.commit();
		
		ArrayList<Esame> esamiOutput = new ArrayList<Esame>();
		for(Entry<String, Esame> test : esami.entrySet()) {
			if(email.equals(test.getValue().getEmailDocente())) {
				esamiOutput.add(test.getValue());
			}
		}
		return esamiOutput;
	}

	/* metodo che crea un nuovo esame, dato un array dei dati sull'esame */
	public static String creazioneEsame(ArrayList<String> dati) {
		DB db = getDB();
		BTreeMap<String, Esame> esami = db.getTreeMap("Esami");
		boolean trovato = false;
		
		Esame esame = new Esame(
				dati.get(0), // esame
				dati.get(1), // docente
				dati.get(2), // data 
				dati.get(3), // ora 
				dati.get(4), // durata  
				dati.get(5)  // aula  
				);
		
		for(Entry<String, Esame> test : esami.entrySet()) {
			if(test.getValue().getEsame().equals(esame.getEsame())) {
				trovato = true;
			}
		}
		
		if (!trovato && dati.get(0).length()>=1 && dati.get(1).length()>=1 && dati.get(2).length()>=1 
				&& dati.get(3).length()>=1 && dati.get(4).length()>=1 && dati.get(5).length()>=1) {
			esami.put(esame.getEsame(), esame);
			db.commit();
			db.close();
			return "successo";
		} else return "errore";
	}

	/* metodo che elimina un'esame, dato il suo nome */
	public static String eliminaEsame(String esame) {
		DB db = getDB();
		BTreeMap<String, Esame> esami = db.getTreeMap("Esami");

		for(Entry<String, Esame> test : esami.entrySet()) {
			if(esame.equals(test.getValue().getEsame())) {
				esami.remove(test.getKey());
			}
		}
		db.commit();
		db.close();
		return "successo";
	}

	/* metodo che aggiorna i dati di un'esame, dato il suo nome e un array dei dati sull'esame */
	public static String aggiornaEsame(ArrayList<String> dati, String nomeEsame) {
		DB db = getDB();
		BTreeMap<String, Esame> esami = db.getTreeMap("Esami");

		Esame esame = esami.get(nomeEsame);
		esami.remove(nomeEsame);
		
		if(dati.get(0) != "") {
			esame.setData(dati.get(0));
		}
		if(dati.get(1) != "") {
			esame.setOra(dati.get(1));
		}
		if(dati.get(2) != "") {
			esame.setDurata(dati.get(2));
		}
		if(dati.get(3) != "") {
			esame.setAula(dati.get(2));
		}
		esami.put(nomeEsame, esame);
		db.commit();
		db.close();
		return "successo";
	}
}
