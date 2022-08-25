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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.uniwebsite.shared.Corso;
import com.uniwebsite.shared.Esame;

public class InfoCorsiEsamiDocente extends Composite {

	String logged = "";
	private static InfoCorsiEsamiDocenteUiBinder uiBinder = GWT.create(InfoCorsiEsamiDocenteUiBinder.class);
	private static  ArrayList<Corso> corsi = new ArrayList<Corso>();
	private static  ArrayList<Esame> esami = new ArrayList<Esame>();

	@UiTemplate("InfoCorsiEsamiDocente.ui.xml")
	interface InfoCorsiEsamiDocenteUiBinder extends UiBinder<Widget, InfoCorsiEsamiDocente> {}

	@UiField
	Button btnHome;
	
	@UiField
	Button btnVisualizza;
	
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
	CellTable<Corso> cellTableCorsi;
	
	@UiField
	CellTable<Esame> cellTableEsami;
	
	public InfoCorsiEsamiDocente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
		getCorsi();
		getEsami();
	}

	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeDocente(logged));
	}
	
	@UiHandler("btnCorsi")
	void doClickCorsi(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new CorsiDocente(logged));
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
	
	/* Ritorna tutti i corsi del docente e riempie la tabella */
	public void getCorsi() {
		corsi.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsiDocente(logged, new AsyncCallback<ArrayList<Corso>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Corso> allCorsi) {
					for(int i=0;i<allCorsi.size();i++) {
						corsi.add(allCorsi.get(i));
					}
					
					TextColumn<Corso> colCorso = new TextColumn<Corso>() {
						@Override
						public String getValue(Corso obj) {
							return obj.getNomeCorso();
						}
					}; cellTableCorsi.addColumn(colCorso, "Corso");

					TextColumn<Corso> colDescrizione = new TextColumn<Corso>() {
						public String getValue(Corso obj) {
							return obj.getDescrizione();
						}
					}; cellTableCorsi.addColumn(colDescrizione, "Descrizione");

					TextColumn<Corso> colInizio = new TextColumn<Corso>() {
						@Override
						public String getValue(Corso obj) {
							return obj.getDataInizio();
						}
					}; cellTableCorsi.addColumn(colInizio, "Data Inizio");

					TextColumn<Corso> colFine = new TextColumn<Corso>() {
						@Override
						public String getValue(Corso obj) {
							return obj.getDataFine();
						}
					}; cellTableCorsi.addColumn(colFine, "Data Fine");

					cellTableCorsi.setRowCount(corsi.size(), true);
					cellTableCorsi.setRowData(0, corsi);
				}
			});
		} catch(Error e){};
	}
	
	/* Ritorna tutti gli esami del docente e riempie la tabella */
	public void getEsami() {
		esami.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getEsamiDocente(logged, new AsyncCallback<ArrayList<Esame>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Esame> allEsamii) {
					for(int i=0;i<allEsamii.size();i++) {
						esami.add(allEsamii.get(i));
					}
					
					TextColumn<Esame> colEsame = new TextColumn<Esame>() {
						@Override
						public String getValue(Esame obj) {
							return obj.getEsame();
						}
					}; cellTableEsami.addColumn(colEsame, "Esame");
					
					TextColumn<Esame> colData = new TextColumn<Esame>() {
						@Override
						public String getValue(Esame obj) {
							return obj.getData();
						}
					}; cellTableEsami.addColumn(colData, "Data");
			
					TextColumn<Esame> colOra = new TextColumn<Esame>() {
						public String getValue(Esame obj) {
							return obj.getOra();
						}
					}; cellTableEsami.addColumn(colOra, "Ora");
			
					TextColumn<Esame> colDurata = new TextColumn<Esame>() {
						@Override
						public String getValue(Esame obj) {
							return obj.getDurata();
						}
					}; cellTableEsami.addColumn(colDurata, "Durata");
			
					TextColumn<Esame> colAula = new TextColumn<Esame>() {
						@Override
						public String getValue(Esame obj) {
							return obj.getAula();
						}
					}; cellTableEsami.addColumn(colAula, "Aula");
			
					cellTableEsami.setRowCount(esami.size(), true);
					cellTableEsami.setRowData(0, esami);
				}
			});
		} catch(Error e){};
	}
}
