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
import com.uniwebsite.shared.Docente;
import com.uniwebsite.shared.Segreteria;
import com.uniwebsite.shared.Studente;

public class InfoUtentiAmministratore extends Composite {

	private static InfoUtentiAmministratoreUiBinder uiBinder = GWT.create(InfoUtentiAmministratoreUiBinder.class);
	private static  ArrayList<Studente> studenti = new ArrayList<Studente>();
	private static  ArrayList<Docente> docenti = new ArrayList<Docente>();
	private static  ArrayList<Segreteria> segreteria = new ArrayList<Segreteria>();

	@UiTemplate("InfoUtentiAmministratore.ui.xml")
	interface InfoUtentiAmministratoreUiBinder extends UiBinder<Widget, InfoUtentiAmministratore> {}

	@UiField
	Button btnHome;
	
	@UiField
	Button btnCreaAccount;

	@UiField
	Button btnGestisci;
	
	@UiField
	Button btnLogout;
	
	@UiField
	CellTable<Studente> cellTableStud;
	
	@UiField
	CellTable<Docente> cellTableDoc;
	
	@UiField
	CellTable<Segreteria> cellTableSeg;
	
	public InfoUtentiAmministratore() {
		initWidget(uiBinder.createAndBindUi(this));
		getStudenti();
		getDocenti();
		getSegreteria();
	}

	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeAmministratore());
	}
	
	@UiHandler("btnCreaAccount")
	void doClickCrea(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new CreaUtentiAmministratore());
	}
	
	@UiHandler("btnGestisci")
	void doClickGest(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new ModificaUtentiAmministratore());
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	/* Ritorna tutti gli utenti di tipo Studente e riempie la tabella */
	public void getStudenti() {
		studenti.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getStudenti(new AsyncCallback<ArrayList<Studente>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Studente> studentiOutput) {
					for(int i=0;i<studentiOutput.size();i++) {
						studenti.add(studentiOutput.get(i));
					}
					
					TextColumn<Studente> colMatricola = new TextColumn<Studente>() {
						@Override
						public String getValue(Studente obj) {
							return obj.getMatricola();
						}
					}; cellTableStud.addColumn(colMatricola, "Matricola");

					TextColumn<Studente> colEmail = new TextColumn<Studente>() {
						@Override
						public String getValue(Studente obj) {
							return obj.getEmail();
						}
					}; cellTableStud.addColumn(colEmail, "Email");
					
					TextColumn<Studente> colPassword = new TextColumn<Studente>() {
						@Override
						public String getValue(Studente obj) {
							return obj.getPassword();
						}
					}; cellTableStud.addColumn(colPassword, "Password");
					
					TextColumn<Studente> colNome = new TextColumn<Studente>() {
						@Override
						public String getValue(Studente obj) {
							return obj.getNome();
						}
					}; cellTableStud.addColumn(colNome, "Nome");
					
					TextColumn<Studente> colCognome = new TextColumn<Studente>() {
						@Override
						public String getValue(Studente obj) {
							return obj.getCognome();
						}
					}; cellTableStud.addColumn(colCognome, "Cognome");

					cellTableStud.setRowCount(studenti.size(), true);
					cellTableStud.setRowData(0, studenti);
				}		
			});
		}catch(Error e){};
	}
	
	/* Ritorna tutti gli utenti di tipo Docente e riempie la tabella */
	public void getDocenti() {
		docenti.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getDocenti(new AsyncCallback<ArrayList<Docente>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Docente> docentiOutput) {
					for(int i=0;i<docentiOutput.size();i++) {
						docenti.add(docentiOutput.get(i));
					}

					TextColumn<Docente> colEmail = new TextColumn<Docente>() {
						@Override
						public String getValue(Docente obj) {
							return obj.getEmail();
						}
					}; cellTableDoc.addColumn(colEmail, "Email");
					
					TextColumn<Docente> colPassword = new TextColumn<Docente>() {
						@Override
						public String getValue(Docente obj) {
							return obj.getPassword();
						}
					}; cellTableDoc.addColumn(colPassword, "Password");
					
					TextColumn<Docente> colNome = new TextColumn<Docente>() {
						@Override
						public String getValue(Docente obj) {
							return obj.getNome();
						}
					}; cellTableDoc.addColumn(colNome, "Nome");
					
					TextColumn<Docente> colCognome = new TextColumn<Docente>() {
						@Override
						public String getValue(Docente obj) {
							return obj.getCognome();
						}
					}; cellTableDoc.addColumn(colCognome, "Cognome");

					cellTableDoc.setRowCount(docenti.size(), true);
					cellTableDoc.setRowData(0, docenti);
				}		
			});
		}catch(Error e){};
	}
	
	/* Ritorna tutti gli utenti di tipo Segreteria e riempie la tabella */
	public void getSegreteria() {
		segreteria.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getSegreteria(new AsyncCallback<ArrayList<Segreteria>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Segreteria> segreteriaOutput) {
					for(int i=0;i<segreteriaOutput.size();i++) {
						segreteria.add(segreteriaOutput.get(i));
					}

					TextColumn<Segreteria> colEmail = new TextColumn<Segreteria>() {
						@Override
						public String getValue(Segreteria obj) {
							return obj.getEmail();
						}
					}; cellTableSeg.addColumn(colEmail, "Email");
					
					TextColumn<Segreteria> colPassword = new TextColumn<Segreteria>() {
						@Override
						public String getValue(Segreteria obj) {
							return obj.getPassword();
						}
					}; cellTableSeg.addColumn(colPassword, "Password");
					
					TextColumn<Segreteria> colNome = new TextColumn<Segreteria>() {
						@Override
						public String getValue(Segreteria obj) {
							return obj.getNome();
						}
					}; cellTableSeg.addColumn(colNome, "Nome");
					
					TextColumn<Segreteria> colCognome = new TextColumn<Segreteria>() {
						@Override
						public String getValue(Segreteria obj) {
							return obj.getCognome();
						}
					}; cellTableSeg.addColumn(colCognome, "Cognome");

					cellTableSeg.setRowCount(segreteria.size(), true);
					cellTableSeg.setRowData(0, segreteria);
				}		
			});
		}catch(Error e){};
	}
}
