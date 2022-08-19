package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

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
		
		ArrayList<Esame> esamiAll = new ArrayList<Esame>();
		for(Entry<String, Esame> test : esami.entrySet()) {
			esamiAll.add(test.getValue());
		}
		return esamiAll;
	}

}
