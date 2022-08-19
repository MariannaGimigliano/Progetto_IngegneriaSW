package com.uniwebsite.shared;

import java.io.Serializable;

public class Studente extends Utente implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	private String matricola;
	
	public Studente() {}
	
	public Studente(String email, String password, String nome, String cognome, String matricola) {
		super(email, password, nome, cognome);
		this.matricola = matricola;
	}
	
	public String getMatricola() {
		return matricola;
	}
	
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
}
