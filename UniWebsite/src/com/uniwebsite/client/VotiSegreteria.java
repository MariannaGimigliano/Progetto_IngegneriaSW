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
import com.google.gwt.user.client.ui.Widget;
import com.uniwebsite.shared.*;

public class VotiSegreteria extends Composite {

	private static VotiSegreteriaUiBinder uiBinder = GWT.create(VotiSegreteriaUiBinder.class);

	@UiTemplate("VotiSegreteria.ui.xml")
	interface VotiSegreteriaUiBinder extends UiBinder<Widget, VotiSegreteria> {}

	@UiField
	Button btnHome;
	
	@UiField
	Button btnStudenti;
	
	@UiField
	Button btnVoti;
	
	@UiField
	Button btnLogout;
	
	@UiField
	ListBox listaStudenti;
	
	@UiField
	Button btnCerca;
	
	@UiField
	ListBox listaVoti;
	
	@UiField
	Button btnPubb;
	
	public VotiSegreteria() {
		initWidget(uiBinder.createAndBindUi(this));
		listBoxStudenti();
	}

	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeSegreteria());
	}
	
	@UiHandler("btnStudenti")
	void doClickStud(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new InfoUtentiSegreteria());
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	/* Riempie la listbox con l'elenco degli studenti */
	public void listBoxStudenti() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getStudenti(new AsyncCallback<ArrayList<Studente>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Studente> studentiOutput) {
					for(int i=0;i<studentiOutput.size();i++) {
						listaStudenti.addItem(studentiOutput.get(i).getEmail());
					}
				}		
			});
		}catch(Error e){};
	}
	
	/* Chiama il metodo di ricerca dei voti non pubblicati dopo aver selezionato uno studente */
	@UiHandler("btnCerca")
	void doClickCerca(ClickEvent event) {
		listBoxVoti();
	}
	
	/* Riempie la listbox con l'elenco dei voti non pubblicati dello studente selezionato */
	public void listBoxVoti() {
		listaVoti.clear();
		String studente = listaStudenti.getSelectedValue();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getVotiNonPubblicati(studente, new AsyncCallback<ArrayList<Voto>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Voto> votiOutput) {
					for(int i=0;i<votiOutput.size();i++) {
						listaVoti.addItem(votiOutput.get(i).getVoto());
					}
				}		
			});
		}catch(Error e){};
	}
	
	/* Pubblica un voto per lo studente */
	@UiHandler("btnPubb")
	void doClickPubb(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add(0, listaStudenti.getSelectedValue());
		dati.add(1, listaVoti.getSelectedValue());
		
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.pubblicazioneVoti(dati, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {
				listaVoti.setItemText(0, c.getMessage());
			}
			@Override
			public void onSuccess(String result) {
				RootPanel.get().clear();
				if(result.equals("successo")) {
					Alert alert = new Alert("Voto pubblicato con successo!");
					System.out.println(alert);
					RootPanel.get().add(new VotiSegreteria());
				}
			}
		});
	}

}
