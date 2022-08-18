package com.uniwebsite.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Corso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nomeCorso;
	private String descrizione;
	private String dataInizio;
	private String dataFine;
	private ArrayList<String> listaStudenti; 
	
	public Corso() {}

	public Corso(String nomeCorso, String descrizione, String dataInizio, String dataFine) {
		this.nomeCorso = nomeCorso;
		this.descrizione = descrizione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		listaStudenti = new ArrayList<>();
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(String dataInizio) {
		this.dataInizio = dataInizio;
	}

	public String getDataFine() {
		return dataFine;
	}

	public void setDataFine(String dataFine) {
		this.dataFine = dataFine;
	}

	public ArrayList<String> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(ArrayList<String> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}
}
