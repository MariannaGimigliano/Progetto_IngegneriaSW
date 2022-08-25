package com.uniwebsite.shared;

import java.io.Serializable;

public class IscrizioneEsame implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int idIscrizione;
	private String esame;
	private String emailStudente;
	
	public IscrizioneEsame() {}

	public IscrizioneEsame(int idIscrizione, String esame, String emailStudente) {
		this.idIscrizione = idIscrizione;
		this.esame = esame;
		this.emailStudente = emailStudente;
	}

	public int getIdIscrizione() {
		return idIscrizione;
	}

	public void setIdIscrizione(int idIscrizione) {
		this.idIscrizione = idIscrizione;
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
