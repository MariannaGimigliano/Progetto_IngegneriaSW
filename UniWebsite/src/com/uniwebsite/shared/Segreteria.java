package com.uniwebsite.shared;

import java.io.Serializable;

public class Segreteria extends Utente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public Segreteria() {}
	
	public Segreteria(String email, String password, String nome, String cognome) {
		super(email, password, nome, cognome);
	}
}
