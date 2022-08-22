package com.uniwebsite.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.uniwebsite.shared.*;


public class CorsiStudente extends Composite {

	String logged = "";
	private static CorsiStudenteUiBinder uiBinder = GWT.create(CorsiStudenteUiBinder.class);
	private static ArrayList<Corso> corsi = new ArrayList<Corso>();
	
	@UiTemplate("CorsiStudente.ui.xml")
	interface CorsiStudenteUiBinder extends UiBinder<Widget, CorsiStudente> {}

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
	Button btnIscriviti;
	
	@UiField
	CellTable<Corso> cellTable;
	
	@UiField
	ListBox listaCorsi;

	public CorsiStudente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
		getCorsi();
	}

	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeStudente(logged));
	}
	
	@UiHandler("btnEsami")
	void doClickEs(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new EsamiStudente(logged));
	}
	
	@UiHandler("btnVoti")
	void doClickVoti(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new VotiStudente(logged));
	}
	
	@UiHandler("btnPers")
	void doClickPers(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new AreaPersStudente(logged));
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	@UiHandler("btnIscriviti")
	void doClickIscr(ClickEvent event) {
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		String nomeCorso = listaCorsi.getSelectedValue();
		
		greetingService.iscrizioneCorso(logged, nomeCorso, new AsyncCallback<String>() {
			public void onFailure(Throwable caught) {}
			@Override
			public void onSuccess(String result) {
				if(result=="iscritto") {
					//Alert nice = new Alert("Iscrizione al corso effettuata!");
				}else {
					//Alert e = new Alert("Sei gia iscritto a questo corso!");
				}
			}

		});
		RootPanel.get().clear();
		RootPanel.get().add(new CorsiStudente(logged));
	}

	/* Ritorna tutti i corsi disponibili per l'utente e riempie la tabella */
	public void getCorsi() {
		corsi.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsi(new AsyncCallback<ArrayList<Corso>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Corso> allCorsi) {
					for(int i=0;i<allCorsi.size();i++) {
						corsi.add(allCorsi.get(i));
						listaCorsi.addItem(corsi.get(i).getNomeCorso());
					}
					
					TextColumn<Corso> colCorso = new TextColumn<Corso>() {
						@Override
						public String getValue(Corso obj) {
							return obj.getNomeCorso();
						}
					}; cellTable.addColumn(colCorso, "Corso");
					
					TextColumn<Corso> colDocente = new TextColumn<Corso>() {
						@Override
						public String getValue(Corso obj) {
							return obj.getEmailDocente();
						}
					}; cellTable.addColumn(colDocente, "Docente");

					TextColumn<Corso> colDescrizione = new TextColumn<Corso>() {
						public String getValue(Corso obj) {
							return obj.getDescrizione();
						}
					}; cellTable.addColumn(colDescrizione, "Descrizione");

					TextColumn<Corso> colInizio = new TextColumn<Corso>() {
						@Override
						public String getValue(Corso obj) {
							return obj.getDataInizio();
						}
					}; cellTable.addColumn(colInizio, "Data Inizio");

					TextColumn<Corso> colFine = new TextColumn<Corso>() {
						@Override
						public String getValue(Corso obj) {
							return obj.getDataFine();
						}
					}; cellTable.addColumn(colFine, "Data Fine");

					cellTable.setRowCount(corsi.size(), true);
					cellTable.setRowData(0, corsi);
				}
			});
		} catch(Error e){};
	}
}
