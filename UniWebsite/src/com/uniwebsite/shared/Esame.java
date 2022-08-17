package com.uniwebsite.shared;

import java.io.Serializable;
import java.util.ArrayList;

public class Esame implements Serializable {

	private static final long serialVersionUID = 1L;

	private  int idEsame;
	private  int idCorso; 
	private  String nomeEsame;
	private  String cfu;
	private  String emailDocente;
	private ArrayList<String> listaStudenti; 
	
	public Esame() {}

	public Esame(int idEsame, int idCorso, String nomeEsame, String cfu, String emailDocente) {
		this.idEsame = idEsame;
		this.idCorso = idCorso;
		this.nomeEsame = nomeEsame;
		this.cfu = cfu;
		this.emailDocente = emailDocente;
		listaStudenti = new ArrayList<>();
	}

	public int getIdEsame() {
		return idEsame;
	}

	public void setIdEsame(int idEsame) {
		this.idEsame = idEsame;
	}

	public int getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}

	public String getNomeEsame() {
		return nomeEsame;
	}

	public void setNomeEsame(String nomeEsame) {
		this.nomeEsame = nomeEsame;
	}

	public String getCfu() {
		return cfu;
	}

	public void setCfu(String cfu) {
		this.cfu = cfu;
	}

	public String getEmailDocente() {
		return emailDocente;
	}

	public void setEmailDocente(String emailDocente) {
		this.emailDocente = emailDocente;
	}

	public ArrayList<String> getListaStudenti() {
		return listaStudenti;
	}

	public void setListaStudenti(ArrayList<String> listaStudenti) {
		this.listaStudenti = listaStudenti;
	}
}
