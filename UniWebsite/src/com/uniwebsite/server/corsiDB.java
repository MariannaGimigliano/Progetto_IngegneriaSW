package com.uniwebsite.server;

import java.io.File;
import java.util.ArrayList;
import java.util.Map.Entry;

import org.mapdb.BTreeMap;
import org.mapdb.DB;
import org.mapdb.DBMaker;

import com.uniwebsite.shared.Corso;

public class corsiDB {

	/* creazione database corsi */
	private static DB getDB() {
		DB db = DBMaker.newFileDB(new File("corsiDB")).make();
		return db;
	}

	/* metodo che ritorna tutti i corsi presenti nel db */
	public static ArrayList<Corso> getCorsi() {
		DB db = getDB();
		BTreeMap<String, Corso> corsi = db.getTreeMap("Corsi");
		
		corsi.put("analisi", new Corso("analisi", "ciao", "sss", "12/06", "13/07"));
		corsi.put("albebra", new Corso("algebra", "ciao", "sss", "12/06", "13/07"));
		db.commit();
		
		ArrayList<Corso> corsiOutput = new ArrayList<Corso>();
		for(Entry<String, Corso> test : corsi.entrySet()) {
			corsiOutput.add(test.getValue());
		}
		return corsiOutput;
	}

}
