package com.uniwebsite.shared;

import java.io.Serializable;

public class Voto implements Serializable {

private static final long serialVersionUID = 1L;

	private Integer idVoto;
	private String esame;
	private String email;
	private String voto;
		
	public Voto() {}

	public Voto(Integer idVoto, String esame, String email, String voto) {
		this.idVoto = idVoto;
		this.esame = esame;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getVoto() {
		return voto;
	}

	public void setVoto(String voto) {
		this.voto = voto;
	}
}
