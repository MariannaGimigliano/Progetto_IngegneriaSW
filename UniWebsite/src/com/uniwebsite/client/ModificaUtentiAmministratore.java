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
import com.uniwebsite.shared.Docente;
import com.uniwebsite.shared.Studente;

public class ModificaUtentiAmministratore extends Composite {

	private Studente studente;
	private Docente docente;
	private static ModificaUtentiAmministratoreUiBinder uiBinder = GWT.create(ModificaUtentiAmministratoreUiBinder.class);
	private static ArrayList<Studente> studenti = new ArrayList<Studente>();
	private static ArrayList<Docente> docenti = new ArrayList<Docente>();

	@UiTemplate("ModificaUtentiAmministratore.ui.xml")
	interface ModificaUtentiAmministratoreUiBinder extends UiBinder<Widget, ModificaUtentiAmministratore> {}

	@UiField
	Button btnHome;
	
	@UiField
	Button btnVisualizza;
	
	@UiField
	Button btnCreaAccount;

	@UiField
	Button btnGestisci;
	
	@UiField
	Button btnLogout;
	
	@UiField
	ListBox txtEmailStud;
	
	@UiField
	TextBox txtPsswStud;
	
	@UiField
	TextBox txtNomeStud;
	
	@UiField
	TextBox txtCognomeStud;
	
	@UiField
	TextBox txtMatrStud;
	
	@UiField
	Button btnModStud;
	
	@UiField
	ListBox txtEmailDoc;
	
	@UiField
	TextBox txtPsswDoc;
	
	@UiField
	TextBox txtNomeDoc;
	
	@UiField
	TextBox txtCognomeDoc;
	
	@UiField
	Button btnModDoc;
	
	public ModificaUtentiAmministratore() {
		initWidget(uiBinder.createAndBindUi(this));
		listBoxStudenti();
		listBoxDocenti();
	}
	
	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeAmministratore());
	}

	@UiHandler("btnVisualizza")
	void doClickVis(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new InfoUtentiAmministratore());
	}
	
	@UiHandler("btnCreaAccount")
	void doClickCrea(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new CreaUtentiAmministratore());
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	/* Riempie la listbox con l'elenco degli studenti */
	public void listBoxStudenti() {
		studenti.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getStudenti(new AsyncCallback<ArrayList<Studente>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Studente> studentiOutput) {
					for(int i=0;i<studentiOutput.size();i++) {
						txtEmailStud.addItem(studentiOutput.get(i).getEmail());
						studenti.add(studentiOutput.get(i));
					}
				}		
			});
		}catch(Error e){};
	}
	
	/* Riempie la listbox con l'elenco dei docenti */
	public void listBoxDocenti() {
		docenti.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getDocenti(new AsyncCallback<ArrayList<Docente>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Docente> docentiOutput) {
					for(int i=0;i<docentiOutput.size();i++) {
						txtEmailDoc.addItem(docentiOutput.get(i).getEmail());
						docenti.add(docentiOutput.get(i));
					}
				}		
			});
		}catch(Error e){};
	}

	/* Modifica i dati di uno studente */
	@UiHandler("btnModStud")
	void doClickStud(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		String email = txtEmailStud.getSelectedValue();
		
		for(int i=0; i<studenti.size(); i++) {
			if(studenti.get(i).getEmail().equals(email)){
				studente = studenti.get(i);
			}
		}

		if(txtPsswStud.getText() != "") {
			dati.add(0, txtPsswStud.getText());
		}else {
			dati.add(0, studente.getPassword());
		}
		if(txtNomeStud.getText() != "") {
			dati.add(1, txtNomeStud.getText());
		}else {
			dati.add(1, studente.getNome());
		}
		if(txtCognomeStud.getText() != "") {
			dati.add(2, txtCognomeStud.getText());
		}else {
			dati.add(2, studente.getCognome());
		}
		if(txtMatrStud.getText() != "") {
			dati.add(3, txtMatrStud.getText());
		}else {
			dati.add(3, studente.getMatricola());
		}

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.aggiornaStudente(dati, email, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				RootPanel.get().clear();
				if(result.equals("successo")) {
					Alert alert = new Alert("Utente modificato con successo!");
					System.out.println(alert);
					RootPanel.get().add(new ModificaUtentiAmministratore());
				}
			}
		}); 
	}
	
	/* Modifica i dati di un docente */
	@UiHandler("btnModDoc")
	void doClickDoc(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		String email = txtEmailDoc.getSelectedValue();
		
		for(int i=0; i<docenti.size(); i++) {
			if(docenti.get(i).getEmail().equals(email)){
				docente = docenti.get(i);
			}
		}

		if(txtPsswDoc.getText() != "") {
			dati.add(0, txtPsswDoc.getText());
		}else {
			dati.add(0, docente.getPassword());
		}
		if(txtNomeDoc.getText() != "") {
			dati.add(1, txtNomeDoc.getText());
		}else {
			dati.add(1, docente.getNome());
		}
		if(txtCognomeDoc.getText() != "") {
			dati.add(2, txtCognomeDoc.getText());
		}else {
			dati.add(2, docente.getCognome());
		}

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.aggiornaDocente(dati, email, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				RootPanel.get().clear();
				if(result.equals("successo")) {
					Alert alert = new Alert("Utente modificato con successo!");
					System.out.println(alert);
					RootPanel.get().add(new ModificaUtentiAmministratore());
				}
			}
		}); 
	}
}
