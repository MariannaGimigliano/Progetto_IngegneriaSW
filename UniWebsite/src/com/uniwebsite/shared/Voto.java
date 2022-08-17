package com.uniwebsite.shared;

import java.io.Serializable;

public class Voto implements Serializable {

private static final long serialVersionUID = 1L;

	private Integer idVoto;
	private String esame;
	private String matricola;
	private String voto;
		
	public Voto() {}

	public Voto(Integer idVoto, String esame, String matricola, String voto) {
		this.idVoto = idVoto;
		this.esame = esame;
		this.matricola = matricola;
		this.voto = voto;
	}

	public Integer getIdVoto() {
		return idVoto;
	}

	public void setIdVoto(Integer idVoto) {
		this.idVoto = idVoto;
	}

	public String getEsame() {
		return esame;
	}

	public void setEsame(String esame) {
		this.esame = esame;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}
}
