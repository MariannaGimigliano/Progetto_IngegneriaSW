package com.uniwebsite.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Esame implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String esame;
	private String corso; 
	private String data; 
	private String ora; 
	private String durata;
	private String aula;
	private ArrayList<String> listaStudenti; 
	
	public Esame() {}

	public Esame(String esame, String corso, String data, String ora, String durata, String aula) {
		this.esame = esame;
		this.corso = corso;
		this.data = data;
		this.ora = ora;
		this.durata = durata;
		this.aula = aula;
		listaStudenti = new ArrayList<>();
	}

	public String getEsame() {
		return esame;
	}

	public void setEsame(String esame) {
		this.esame = esame;
	}

	public String getCorso() {
		return corso;
	}

	public void setCorso(String corso) {
		this.corso = corso;
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

	public ArrayList<String> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(ArrayList<String> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}
}
