package com.uniwebsite.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Studente extends Utente implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private String matricola;
	private ArrayList<String> listaCorsi; 
	private ArrayList<String> listaEsami; 
	
	public Studente() {}
	
	public Studente(String email, String password, String nome, String cognome, String matricola) {
		super(email, password, nome, cognome);
		this.matricola = matricola;
		listaCorsi = new ArrayList<>();
		listaEsami = new ArrayList<>();
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public ArrayList<String> getListaCorsi() {
		return listaCorsi;
	}

	public void setListaCorsi(ArrayList<String> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}

	public ArrayList<String> getListaEsami() {
		return listaEsami;
	}

	public void setListaEsami(ArrayList<String> listaEsami) {
		this.listaEsami = listaEsami;
	}
}
