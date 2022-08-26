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
import com.uniwebsite.shared.*;

public class VotiDocente extends Composite {

	String logged = "";
	private static VotiDocenteUiBinder uiBinder = GWT.create(VotiDocenteUiBinder.class);

	@UiTemplate("VotiDocente.ui.xml")
	interface VotiDocenteUiBinder extends UiBinder<Widget, VotiDocente> {}

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
	ListBox listaEsami;
	
	@UiField
	ListBox listaEmail;
	
	@UiField
	TextBox txtVoto;
	
	@UiField
	Button btnAgg;
	
	public VotiDocente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
		listBoxEsami();
		listBoxStudenti();
	}
	
	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeDocente(logged));
	}
	
	@UiHandler("btnVisualizza")
	void doClickVis(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new InfoCorsiEsamiDocente(logged));
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
	
	/* Riempie le listbox con gli esami del docente */
	public void listBoxEsami() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getEsamiDocente(logged, new AsyncCallback<ArrayList<Esame>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Esame> esamiDocente) {
					for(int i=0;i<esamiDocente.size();i++){
						listaEsami.addItem(esamiDocente.get(i).getEsame());
					}
				}
			});
		}catch(Error e){};
	}
	
	/* Riempie le listbox con gli studenti */
	public void listBoxStudenti() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getStudenti(new AsyncCallback<ArrayList<Studente>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Studente> studenti) {
					for(int i=0;i<studenti.size();i++){
						listaEmail.addItem(studenti.get(i).getEmail());
					}
				}
			});
		}catch(Error e){};
	}
	
	/* Invia il voto di un'esame alla segreteria */
	@UiHandler("btnAgg")
	void doClickAgg(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add("");
		dati.add(listaEsami.getSelectedValue());
		dati.add(listaEmail.getSelectedValue());
		dati.add(txtVoto.getText());
		
		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.aggiuntaVoto(dati, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {
				RootPanel.get().clear();
				RootPanel.get().add(new HomeDocente(logged));
			}
			@Override
			public void onSuccess(String result) {
				RootPanel.get().clear();
				if(result.equals("successo")) {
					Alert alert = new Alert("Voto inviato con successo!");
					System.out.println(alert);
					RootPanel.get().add(new VotiDocente(logged));
				} else if(result.equals("errore")) {
					Alert alert = new Alert("Errore. Il voto è già stato inviato o mancano dei dati.");
					System.out.println(alert);
					RootPanel.get().add(new VotiDocente(logged));
				} 	
			}
		});
	}
}
