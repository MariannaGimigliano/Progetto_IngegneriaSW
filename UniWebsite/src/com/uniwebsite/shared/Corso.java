package com.uniwebsite.shared;

import java.io.Serializable;

public class Corso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nomeCorso;
	private String emailDocente;
	private String descrizione;
	private String dataInizio;
	private String dataFine;
	
	public Corso() {}

	public Corso(String nomeCorso, String emailDocente, String descrizione, String dataInizio, String dataFine) {
		this.nomeCorso = nomeCorso;
		this.emailDocente = emailDocente;
		this.descrizione = descrizione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public void setNomeCorso(String nomeCorso) {
		this.nomeCorso = nomeCorso;
	}

	public String getEmailDocente() {
		return emailDocente;
	}

	public void setEmailDocente(String emailDocente) {
		this.emailDocente = emailDocente;
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
}
