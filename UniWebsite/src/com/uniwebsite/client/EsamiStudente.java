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
	
	String logged = "";
	private static EsamiStudenteUiBinder uiBinder = GWT.create(EsamiStudenteUiBinder.class);
	private static ArrayList<Esame> esamiStudente = new ArrayList<Esame>();
	private static ArrayList<Esame> esami = new ArrayList<Esame>();
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
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		String nomeEsame = listaEsami.getSelectedValue();
		
		greetingService.iscrizioneEsame(logged, nomeEsame, new AsyncCallback<String>() {
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
		RootPanel.get().add(new EsamiStudente(logged));
	}
	
	/* Ritorna tutti i corsi a cui lo studente è iscritto */
	public void getCorsiStudente() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsiStudente(logged, new AsyncCallback<ArrayList<String>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<String> corsi) {
					corsiStudente.clear();
					for(int i=0;i<corsi.size();i++) {
						corsiStudente.add(corsi.get(i));
					}
				}
			});
		}catch(Error e){};
	}
	
	/* Metodo che ritorna tutti gli esami nel db */
	public void getEsami() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getEsami(new AsyncCallback<ArrayList<Esame>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Esame> allEsami) {
					esami.clear();
					for(int i=0;i<allEsami.size();i++) {
						esami.add(allEsami.get(i));
					}
				}
			});
		}catch(Error e){};
	}
	
	/* Ritorna tutti gli esami disponibili per lo studente e riempie la tabella */
	public void getEsamiStudente() {
		esamiStudente.clear();
		getCorsiStudente();
		getEsami();
		for(int i=0;i<corsiStudente.size();i++) { 
			for(int j=0;j<esami.size();j++) { 
				if(corsiStudente.get(i).equals(esami.get(j).getEsame())) {
					listaEsami.addItem(esami.get(j).getEsame());
					esamiStudente.add(esami.get(j));
				}
			}
		}
					
		TextColumn<Esame> colEsame = new TextColumn<Esame>() {
			@Override
			public String getValue(Esame obj) {
				return obj.getEsame();
			}
		}; cellTable.addColumn(colEsame, "Esame");
		
		TextColumn<Esame> colDocente = new TextColumn<Esame>() {
			@Override
			public String getValue(Esame obj) {
				return obj.getEmailDocente();
			}
		}; cellTable.addColumn(colDocente, "Docente");
		
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
