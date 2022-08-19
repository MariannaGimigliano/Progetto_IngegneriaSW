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
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.uniwebsite.shared.Studente;

public class AreaPersStudente extends Composite {

	String logged = "";
	private static AreaPersStudenteUiBinder uiBinder = GWT.create(AreaPersStudenteUiBinder.class);

	@UiTemplate("AreaPersStudente.ui.xml")
	interface AreaPersStudenteUiBinder extends UiBinder<Widget, AreaPersStudente> {}

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
	Label lblMatricola;
	
	@UiField
	Label lblNome;

	@UiField
	Label lblCognome;

	@UiField
	Label lblMail;

	@UiField
	Label lblCorsi;

	@UiField
	Label lblEsami;
	
	public AreaPersStudente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
		getStudente();
		getCorsoStudente();
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
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	/* Mostra i dati dello studente */
	public void getStudente() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getStudente(logged, new AsyncCallback<Studente>() {
				public void onFailure(Throwable caught) {
					lblMatricola.setText(caught.getMessage());
				}
				@Override
				public void onSuccess(Studente user) {
					lblMatricola.setText(user.getMatricola());
					lblNome.setText(user.getNome());
					lblCognome.setText(user.getCognome());
					lblMail.setText(user.getEmail());
				}
			});
		} catch(Error e){};
	}
	
	/* Mostra i corsi a cui lo studente è iscritto */
	public void getCorsoStudente() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsiStudente(logged, new AsyncCallback<ArrayList<String>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<String> corsi) {
					String test = "";
					for(int i=0;i<corsi.size();i++) {
						test += corsi.get(i) + ", ";
					}
					lblCorsi.setText(test);
				}
			});
		}catch(Error e){};
	}
}
