package com.uniwebsite.shared;

import java.io.Serializable;

public class Esame implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String esame;
	private String emailDocente; 
	private String data; 
	private String ora; 
	private String durata;
	private String aula;
	
	public Esame() {}

	public Esame(String esame, String emailDocente, String data, String ora, String durata, String aula) {
		this.esame = esame;
		this.emailDocente = emailDocente;
		this.data = data;
		this.ora = ora;
		this.durata = durata;
		this.aula = aula;
	}

	public String getEsame() {
		return esame;
	}

	public void setEsame(String esame) {
		this.esame = esame;
	}

	public String getEmailDocente() {
		return emailDocente;
	}

	public void setEmailDocente(String emailDocente) {
		this.emailDocente = emailDocente;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	public String getDurata() {
		return durata;
	}

	public void setDurata(String durata) {
		this.durata = durata;
	}

	public String getAula() {
		return aula;
	}

	public void setAula(String aula) {
		this.aula = aula;
	}
}
