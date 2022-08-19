package com.uniwebsite.shared;

import java.io.Serializable;

public class IscrizioneCorso implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String corso;
	private String emailStudente;
	
	public IscrizioneCorso() {}

	public IscrizioneCorso(String corso, String emailStudente) {
		this.corso = corso;
		this.emailStudente = emailStudente;
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
