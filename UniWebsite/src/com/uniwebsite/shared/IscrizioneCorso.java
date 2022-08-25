package com.uniwebsite.shared;

import java.io.Serializable;

public class IscrizioneCorso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int idIscrizione;
	private String corso;
	private String emailStudente;
	
	public IscrizioneCorso() {}

	public IscrizioneCorso(int idIscrizione, String corso, String emailStudente) {
		this.idIscrizione = idIscrizione;
		this.corso = corso;
		this.emailStudente = emailStudente;
	}

	public int getIdIscrizione() {
		return idIscrizione;
	}

	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
	}

	public String getEmailStudente() {
		return emailStudente;
	}

	public void setEmailStudente(String emailStudente) {
		this.emailStudente = emailStudente;
	}
}
