package com.uniwebsite.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Docente extends Utente implements Serializable {
	
	private static final long serialVersionUID = 1L; 
	
	private ArrayList<String> listaCorsi; 
	
	public Docente() {}
	
	public Docente(String email, String password, String nome, String cognome) {
		super(email, password, nome, cognome);
		listaCorsi = new ArrayList<>();
	}

	public ArrayList<String> getListaCorsi() {
		return listaCorsi;
	}

	public void setListaCorsi(ArrayList<String> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}
}
