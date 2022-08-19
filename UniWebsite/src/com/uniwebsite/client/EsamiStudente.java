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

public class EsamiStudente extends Composite {

	//NON FUNZIONA VISUALIZZAZIONE ESAMI
	
	String logged = "";
	private static EsamiStudenteUiBinder uiBinder = GWT.create(EsamiStudenteUiBinder.class);
	private static ArrayList<Esame> esamiStudente = new ArrayList<Esame>();
	private static ArrayList<String> corsiStudente = new ArrayList<String>();

	@UiTemplate("EsamiStudente.ui.xml")
	interface EsamiStudenteUiBinder extends UiBinder<Widget, EsamiStudente> {}

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
	CellTable<Esame> cellTable;
	
	@UiField
	ListBox listaEsami;
	
	public EsamiStudente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
		getCorsiStudente();
		getEsami();
		getEsamiStudente();
	}

	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeStudente(logged));
	}
	
	@UiHandler("btnCorsi")
	void doClickCorsi(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new CorsiStudente(logged));
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

	}
	
	/* Ritorna tutti i corsi a cui lo studente è iscritto */
	public void getCorsiStudente() {
		corsiStudente.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsiStudente(logged, new AsyncCallback<ArrayList<String>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<String> corsi) {
					for(int i=0;i<corsi.size();i++) {
						corsiStudente.add(corsi.get(i));
					}
				}
			});
		}catch(Error e){};
	}
	
	/* Metodo che ritorna tutti gli esami nel db */
	public void getEsami() {
		esamiStudente.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getEsami(new AsyncCallback<ArrayList<Esame>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Esame> esami) {
					for(int i=0;i<esami.size();i++) {
						esamiStudente.add(esami.get(i));
					}
				}
			});
		}catch(Error e){};
	}
	
	/* Ritorna tutti gli esami disponibili per lo studente e riempie la tabella */
	public void getEsamiStudente() {
		getCorsiStudente();
		getEsami();
		for(int i=0;i<corsiStudente.size();i++) { 
			for(int j=0;j<esamiStudente.size();j++) { 
				if(corsiStudente.get(i).equals(esamiStudente.get(j).getEsame())) {
					listaEsami.addItem(esamiStudente.get(j).getEsame());
				}
			}
		}
					
		TextColumn<Esame> colEsame = new TextColumn<Esame>() {
			@Override
			public String getValue(Esame obj) {
				return obj.getEsame();
			}
		}; cellTable.addColumn(colEsame, "Esame");
		
		TextColumn<Esame> colCorso = new TextColumn<Esame>() {
			@Override
			public String getValue(Esame obj) {
				return obj.getCorso();
			}
		}; cellTable.addColumn(colCorso, "Corso");
		
		TextColumn<Esame> colData = new TextColumn<Esame>() {
			@Override
			public String getValue(Esame obj) {
				return obj.getData();
			}
		}; cellTable.addColumn(colData, "Data");

		TextColumn<Esame> colOra = new TextColumn<Esame>() {
			public String getValue(Esame obj) {
				return obj.getOra();
			}
		}; cellTable.addColumn(colOra, "Ora");

		TextColumn<Esame> colDurata = new TextColumn<Esame>() {
			@Override
			public String getValue(Esame obj) {
				return obj.getDurata();
			}
		}; cellTable.addColumn(colDurata, "Durata");

		TextColumn<Esame> colAula = new TextColumn<Esame>() {
			@Override
			public String getValue(Esame obj) {
				return obj.getAula();
			}
		}; cellTable.addColumn(colAula, "Aula");

		cellTable.setRowCount(esamiStudente.size(), true);
		cellTable.setRowData(0, esamiStudente);
	}
}
