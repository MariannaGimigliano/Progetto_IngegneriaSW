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
import com.uniwebsite.shared.Studente;

public class InfoUtentiSegreteria extends Composite {

	private static InfoUtentiSegreteriaUiBinder uiBinder = GWT.create(InfoUtentiSegreteriaUiBinder.class);
	private static  ArrayList<Studente> studenti = new ArrayList<Studente>();

	@UiTemplate("InfoUtentiSegreteria.ui.xml")
	interface InfoUtentiSegreteriaUiBinder extends UiBinder<Widget, InfoUtentiSegreteria> {}

	@UiField
	Button btnHome;
	
	@UiField
	Button btnStudenti;
	
	@UiField
	Button btnVoti;
	
	@UiField
	Button btnLogout;
	
	@UiField
	CellTable<Studente> cellTable;
	
	public InfoUtentiSegreteria() {
		initWidget(uiBinder.createAndBindUi(this));
		getStudenti();
	}
	
	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeSegreteria());
	}
	
	@UiHandler("btnVoti")
	void doClickVoti(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new VotiSegreteria());
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
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
					}; cellTable.addColumn(colMatricola, "Matricola");

					TextColumn<Studente> colEmail = new TextColumn<Studente>() {
						@Override
						public String getValue(Studente obj) {
							return obj.getEmail();
						}
					}; cellTable.addColumn(colEmail, "Email");
					
					TextColumn<Studente> colNome = new TextColumn<Studente>() {
						@Override
						public String getValue(Studente obj) {
							return obj.getNome();
						}
					}; cellTable.addColumn(colNome, "Nome");
					
					TextColumn<Studente> colCognome = new TextColumn<Studente>() {
						@Override
						public String getValue(Studente obj) {
							return obj.getCognome();
						}
					}; cellTable.addColumn(colCognome, "Cognome");

					cellTable.setRowCount(studenti.size(), true);
					cellTable.setRowData(0, studenti);
				}		
			});
		}catch(Error e){};
	}

}
