package com.uniwebsite.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Corso implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idCorso; 
	private String emailDocente;
	private String nomeCorso;
	private String descrizione;
	private ArrayList<String> listaStudenti; 
	
	public Corso() {}

	public Corso(int idCorso, String emailDocente, String nomeCorso, String descrizione) {
		this.idCorso = idCorso;
		this.emailDocente = emailDocente;
		this.nomeCorso = nomeCorso;
		this.descrizione = descrizione;
		listaStudenti = new ArrayList<>();
	}

	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public String getEmailDocente() {
		return emailDocente;
	}

	public void setEmailDocente(String emailDocente) {
		this.emailDocente = emailDocente;
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

	public ArrayList<String> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(ArrayList<String> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}
}
