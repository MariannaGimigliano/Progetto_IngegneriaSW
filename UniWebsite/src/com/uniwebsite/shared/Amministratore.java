package com.uniwebsite.shared;

import java.io.Serializable;

public class Amministratore extends Utente implements Serializable {

	private static final long serialVersionUID = 1L; 
	
	public Amministratore(){}

	public Amministratore(String email, String password, String nome, String cognome) {
		super(email, password,  nome, cognome);
	}
}
