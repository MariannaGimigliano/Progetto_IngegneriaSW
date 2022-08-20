package com.uniwebsite.shared;

import java.io.Serializable;

public class IscrizioneEsame implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String esame;
	private String emailStudente;
	
	public IscrizioneEsame() {}

	public IscrizioneEsame(String esame, String emailStudente) {
		super();
		this.esame = esame;
		this.emailStudente = emailStudente;
	}

	public String getEsame() {
		return esame;
	}

	public void setEsame(String esame) {
		this.esame = esame;
	}

	public String getEmailStudente() {
		return emailStudente;
	}

	public void setEmailStudente(String emailStudente) {
		this.emailStudente = emailStudente;
	}
}
