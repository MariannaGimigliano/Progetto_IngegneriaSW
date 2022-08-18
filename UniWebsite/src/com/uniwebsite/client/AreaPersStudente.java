package com.uniwebsite.client;

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
import com.uniwebsite.shared.Utente;


public class AreaPersStudente extends Composite {

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
	
	public AreaPersStudente() {
		initWidget(uiBinder.createAndBindUi(this));
		getUtente();
	}
	
	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeStudente());
	}

	@UiHandler("btnCorsi")
	void doClickCorsi(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new CorsiStudente());
	}
	
	@UiHandler("btnEsami")
	void doClickEs(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new EsamiStudente());
	}
	
	@UiHandler("btnVoti")
	void doClickVoti(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new VotiStudente());
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	/* Mostra i dati dell'utente */
	public void getUtente() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getUtente("ciao", new AsyncCallback<Utente>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(Utente user) {
					lblMatricola.setText(user.getNome());
					lblNome.setText(user.getNome());
					lblCognome.setText(user.getCognome());
					lblMail.setText(user.getEmail());
				}
			});
		} catch(Error e){};
	}
}
