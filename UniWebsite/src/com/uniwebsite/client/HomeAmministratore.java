package com.uniwebsite.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class HomeAmministratore extends Composite {

	private static HomeAmministratoreUiBinder uiBinder = GWT.create(HomeAmministratoreUiBinder.class);

	@UiTemplate("HomeAmministratore.ui.xml")
	interface HomeAmministratoreUiBinder extends UiBinder<Widget, HomeAmministratore> {}

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
	
	public HomeAmministratore() {
		initWidget(uiBinder.createAndBindUi(this));
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
}
