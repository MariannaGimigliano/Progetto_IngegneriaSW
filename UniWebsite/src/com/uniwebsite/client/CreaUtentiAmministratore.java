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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class CreaUtentiAmministratore extends Composite {

	private static CreaUtentiAmministratoreUiBinder uiBinder = GWT.create(CreaUtentiAmministratoreUiBinder.class);

	@UiTemplate("CreaUtentiAmministratore.ui.xml")
	interface CreaUtentiAmministratoreUiBinder extends UiBinder<Widget, CreaUtentiAmministratore> {}
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnCreaAccount;

	@UiField
	Button btnGestisci;
	
	@UiField
	Button btnLogout;
	
	@UiField
	TextBox txtMatrStud;
	
	@UiField
	TextBox txtEmailStud;
	
	@UiField
	TextBox txtPsswStud;
	
	@UiField
	TextBox txtNomeStud;
	
	@UiField
	TextBox txtCognomeStud;
	
	@UiField
	Button btnCreaStud;
	
	@UiField
	TextBox txtEmailDoc;
	
	@UiField
	TextBox txtPsswDoc;
	
	@UiField
	TextBox txtNomeDoc;
	
	@UiField
	TextBox txtCognomeDoc;
	
	@UiField
	Button btnCreaDoc;
	
	@UiField
	TextBox txtEmailSeg;
	
	@UiField
	TextBox txtPsswSeg;
	
	@UiField
	TextBox txtNomeSeg;
	
	@UiField
	TextBox txtCognomeSeg;
	
	@UiField
	Button btnCreaSeg;

	public CreaUtentiAmministratore() {
		initWidget(uiBinder.createAndBindUi(this));
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
	
	/* Crea un nuovo utente Studente */
	@UiHandler("btnCreaStud")
	void doClickStud(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add(txtEmailStud.getText());
		dati.add(txtPsswStud.getText());
		dati.add(txtNomeStud.getText());
		dati.add(txtCognomeStud.getText());
		dati.add(txtMatrStud.getText());

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.registrazioneStudente(dati, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				RootPanel.get().clear();
				if(result.equals("successo")) {
					Alert alert = new Alert("Registrazione avvenuta con successo!");
					System.out.println(alert);
					RootPanel.get().add(new CreaUtentiAmministratore());
				} else if(result.equals("errore")){
					Alert alert = new Alert("Errore. Esiste già un utente con questa email o mancano dei dati.");
					System.out.println(alert);
					RootPanel.get().add(new CreaUtentiAmministratore());
				} 	

			}
		});
	}
	
	/* Crea un nuovo utente Docente */
	@UiHandler("btnCreaDoc")
	void doClickDoc(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add(txtEmailDoc.getText());
		dati.add(txtPsswDoc.getText());
		dati.add(txtNomeDoc.getText());
		dati.add(txtCognomeDoc.getText());

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.registrazioneDocente(dati, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				RootPanel.get().clear();
				if(result.equals("successo")) {
					Alert alert = new Alert("Registrazione avvenuta con successo!");
					System.out.println(alert);
					RootPanel.get().add(new CreaUtentiAmministratore());
				} else if(result.equals("errore")){
					Alert alert = new Alert("Errore. Esiste già un utente con questa email o mancano dei dati.");
					System.out.println(alert);
					RootPanel.get().add(new CreaUtentiAmministratore());
				} 	

			}
		});
	}
	
	/* Crea un nuovo utente Segreteria */
	@UiHandler("btnCreaSeg")
	void doClickSeg(ClickEvent event) {
		ArrayList<String> dati = new ArrayList<String>();
		dati.add(txtEmailSeg.getText());
		dati.add(txtPsswSeg.getText());
		dati.add(txtNomeSeg.getText());
		dati.add(txtCognomeSeg.getText());

		final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.registrazioneSegreteria(dati, new AsyncCallback<String>() {
			public void onFailure(Throwable c) {}
			@Override
			public void onSuccess(String result) {
				RootPanel.get().clear();
				if(result.equals("successo")) {
					Alert alert = new Alert("Registrazione avvenuta con successo!");
					System.out.println(alert);
					RootPanel.get().add(new CreaUtentiAmministratore());
				} else if(result.equals("errore")){
					Alert alert = new Alert("Errore. Esiste già un utente con questa email o mancano dei dati.");
					System.out.println(alert);
					RootPanel.get().add(new CreaUtentiAmministratore());
				} 		
			}
		});
	}
}
