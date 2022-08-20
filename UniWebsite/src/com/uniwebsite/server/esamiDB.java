package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.Corso;
import com.uniwebsite.shared.Esame;

public class esamiDB {

	/* creazione database esami */
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("esamiDB")).make();
		return db;
	}
	
	/* Metodo per ottenere tutti gli esami presenti nel database */
	public static ArrayList<Esame> getEsami() {
		DB db = getDB();
		BTreeMap<String, Esame> esami = db.getTreeMap("Esami");
		
		esami.put("analisi", new Esame("analisi", "docente", "12/05", "12:00", "1h", "A1"));
		esami.put("algebra", new Esame("algebra", "docente2", "29/12", "09:00", "2h", "A2"));
		db.commit();
		
		ArrayList<Esame> esamiAll = new ArrayList<Esame>();
		for(Entry<String, Esame> test : esami.entrySet()) {
			esamiAll.add(test.getValue());
		}
		return esamiAll;
	}

	/* Metodo per ottenere tutti gli esami di un certo docente */
	public static ArrayList<Esame> getEsamiDocente(String email) {
		DB db = getDB();
		BTreeMap<String, Esame> esami = db.getTreeMap("Esami");
		
		esami.put("analisi", new Esame("analisi", "docente", "12/05", "12:00", "1h", "A1"));
		esami.put("algebra", new Esame("algebra", "docente2", "29/12", "09:00", "2h", "A2"));
		db.commit();
		
		ArrayList<Esame> esamiOutput = new ArrayList<Esame>();
		for(Entry<String, Esame> test : esami.entrySet()) {
			if(email.equals(test.getValue().getEmailDocente())) {
				esamiOutput.add(test.getValue());
			}
		}
		return esamiOutput;
	}

}
