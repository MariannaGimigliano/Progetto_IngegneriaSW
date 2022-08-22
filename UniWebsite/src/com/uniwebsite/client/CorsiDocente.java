package com.uniwebsite.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.uniwebsite.shared.Corso;

public class CorsiDocente extends Composite {

	String logged = "";
	private Corso corso;
	private static CorsiDocenteUiBinder uiBinder = GWT.create(CorsiDocenteUiBinder.class);
	private static ArrayList<Corso> corsi = new ArrayList<Corso>();

	@UiTemplate("CorsiDocente.ui.xml")
	interface CorsiDocenteUiBinder extends UiBinder<Widget, CorsiDocente> {}

	@UiField
	Button btnHome;
	
	@UiField
	Button btnCorsi;

	@UiField
	Button btnEsami;
	
	@UiField
	Button btnVoti;
	
	@UiField
	Button btnPers;
	
	@UiField
	Button btnLogout;
	
	@UiField
	TextBox txtCorso;
	
	@UiField
	TextBox txtDescr;
	
	@UiField
	TextBox txtInizio;
	
	@UiField
	TextBox txtFine;
	
	@UiField
	Button btnCrea;
	
	@UiField
	ListBox listaCorsi;
	
	@UiField
	TextBox txtModDescr;
	
	@UiField
	TextBox txtModInizio;
	
	@UiField
	TextBox txtModFine;
	
	@UiField
	Button btnModifica;
	
	@UiField
	ListBox listaCorsiElimina;
	
	@UiField
	Button btnElimina;
	
	public CorsiDocente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
		listBox();
	}

	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeDocente(logged));
	}
	
	@UiHandler("btnEsami")
	void doClickEsami(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new EsamiDocente(logged));
	}
	
	@UiHandler("btnVoti")
	void doClickVoti(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new VotiDocente(logged));
	}
	
	@UiHandler("btnPers")
	void doClickPers(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new AreaPersDocente(logged));
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	/* Riempie le listbox con i corsi del docente */
	public void listBox() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsiDocente(logged, new AsyncCallback<ArrayList<Corso>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Corso> corsiDocente) {
					for(int i=0;i<corsiDocente.size();i++){
						listaCorsi.addItem(corsiDocente.get(i).getNomeCorso());
						listaCorsiElimina.addItem(corsiDocente.get(i).getNomeCorso());
						corsi.add(corsiDocente.get(i));
					}
				}
			});
		}catch(Error e){};
	}
	
	/* Crea un nuovo corso associato al docente */
	@UiHandler("btnCrea")
	void doClickCrea(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add(0, txtCorso.getText());
		dati.add(1, logged);
		dati.add(2, txtDescr.getText());
		dati.add(3, txtInizio.getText());
		dati.add(4, txtFine.getText());

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.creazioneCorso(dati, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				if(result.equals("Successo")) {
					RootPanel.get().clear();
					RootPanel.get().add(new CorsiDocente(logged));
				}else {
					txtCorso.setText("esiste gia");
					//esame già esistente
				} 	

			}
		});

	}
	
	/* Modifica un corso associato al docente */
	@UiHandler("btnModifica")
	void doClickMod(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		String nomeCorso = listaCorsi.getSelectedValue();

		for(int i=0; i<corsi.size(); i++) {
			if(corsi.get(i).getNomeCorso().equals(nomeCorso)){
				corso = corsi.get(i);
			}
		}

		if(txtModDescr.getText() != "") {
			dati.add(0, txtModDescr.getText());
		} else {
			dati.add(0, corso.getDescrizione());
		}
		if(txtModInizio.getText()!="") {
			dati.add(1, txtModInizio.getText());
		}else {
			dati.add(1, corso.getDataInizio());
		}
		if(txtModFine.getText()!="") {
			dati.add(2, txtModFine.getText());
		}else {
			dati.add(2, corso.getDataFine());
		}

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

		greetingService.aggiornaCorso(dati, nomeCorso, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {
				
			}
			@Override
			public void onSuccess(String result) {
				if(result.equals("Successo")) {
					RootPanel.get().clear();
					RootPanel.get().add(new CorsiDocente(logged));
				}else {} 	

			}
		}); 
	}
	
	/* Elimina un corso associato al docente */
	@UiHandler("btnElimina")
	void doClickCanc(ClickEvent event) {
		String nomeCorso = listaCorsiElimina.getSelectedValue();

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.eliminaCorso(nomeCorso, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				if(result.equals("Successo")) {
					RootPanel.get().clear();
					RootPanel.get().add(new CorsiDocente(logged));
				}else {} 	
			}
		}); 
	}
}
