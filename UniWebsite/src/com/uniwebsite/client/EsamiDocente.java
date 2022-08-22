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
import com.uniwebsite.shared.Esame;

public class EsamiDocente extends Composite {

	String logged = "";
	private Esame esame;
	private static EsamiDocenteUiBinder uiBinder = GWT.create(EsamiDocenteUiBinder.class);
	private static ArrayList<Esame> esami = new ArrayList<Esame>();

	@UiTemplate("EsamiDocente.ui.xml")
	interface EsamiDocenteUiBinder extends UiBinder<Widget, EsamiDocente> {}

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
	ListBox txtEsame;
	
	@UiField
	TextBox txtData;
	
	@UiField
	TextBox txtOra;
	
	@UiField
	TextBox txtDurata;
	
	@UiField
	TextBox txtAula;
	
	@UiField
	Button btnCrea;
	
	@UiField
	ListBox listaEsami;
	
	@UiField
	TextBox txtModData;
	
	@UiField
	TextBox txtModOra;
	
	@UiField
	TextBox txtModDurata;
	
	@UiField
	TextBox txtModAula;
	
	@UiField
	Button btnModifica;
	
	@UiField
	ListBox listaEsamiElimina;
	
	@UiField
	Button btnElimina;
	
	public EsamiDocente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
		listBoxCorsi();
		listBoxEsami();
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
	
	/* Riempie la prima listbox con i corsi del docente */
	public void listBoxCorsi() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsiDocente(logged, new AsyncCallback<ArrayList<Corso>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Corso> corsiDocente) {
					for(int i=0;i<corsiDocente.size();i++){
						txtEsame.addItem(corsiDocente.get(i).getNomeCorso());
					}
				}
			});
		}catch(Error e){};
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
						listaEsamiElimina.addItem(esamiDocente.get(i).getEsame());
						esami.add(esamiDocente.get(i));
					}
				}
			});
		}catch(Error e){};
	}
	
	/* Crea un nuovo esame associato al docente */
	@UiHandler("btnCrea")
	void doClickCrea(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add(0, txtEsame.getSelectedValue());
		dati.add(1, logged);
		dati.add(2, txtData.getText());
		dati.add(3, txtOra.getText());
		dati.add(4, txtDurata.getText());
		dati.add(4, txtAula.getText());

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.creazioneEsame(dati, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				if(result.equals("Successo")) {
					RootPanel.get().clear();
					RootPanel.get().add(new EsamiDocente(logged));
				}else {
					//esame già esistente
				} 	

			}
		});

	}
	
	/* Modifica un'esame associato al docente */
	@UiHandler("btnModifica")
	void doClickMod(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		String nomeEsame = listaEsami.getSelectedValue();

		for(int i=0; i<esami.size(); i++) {
			if(esami.get(i).getEsame().equals(nomeEsame)){
				esame = esami.get(i);
			}
		}

		if(txtModData.getText() != "") {
			dati.add(0, txtModData.getText());
		} else {
			dati.add(0, esame.getData());
		}
		if(txtModOra.getText()!="") {
			dati.add(1, txtModOra.getText());
		}else {
			dati.add(1, esame.getOra());
		}
		if(txtModDurata.getText()!="") {
			dati.add(2, txtModDurata.getText());
		}else {
			dati.add(2, esame.getDurata());
		}
		if(txtModAula.getText()!="") {
			dati.add(2, txtModAula.getText());
		}else {
			dati.add(2, esame.getAula());
		}

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

		greetingService.aggiornaEsame(dati, nomeEsame, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				if(result.equals("Successo")) {
					RootPanel.get().clear();
					RootPanel.get().add(new EsamiDocente(logged));
				}else {} 	

			}
		}); 
	}
	
	/* Elimina un'esame associato al docente */
	@UiHandler("btnElimina")
	void doClickCanc(ClickEvent event) {
		String esame = listaEsamiElimina.getSelectedValue();

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.eliminaEsame(esame, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				if(result.equals("Successo")) {
					RootPanel.get().clear();
					RootPanel.get().add(new EsamiDocente(logged));
				}else {} 	
			}
		}); 
	}
}
