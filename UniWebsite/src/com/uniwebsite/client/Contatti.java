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

public class Contatti extends Composite {

	private static ContattiUiBinder uiBinder = GWT.create(ContattiUiBinder.class);

	@UiTemplate("Contatti.ui.xml")
	interface ContattiUiBinder extends UiBinder<Widget, Contatti> {}
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnDipartimenti;

	@UiField
	Button btnContatti;
	
	@UiField
	Button btnLogin;

	public Contatti() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}

	@UiHandler("btnDipartimenti")
	void doClickDip(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Dipartimenti());
	}
	
	@UiHandler("btnLogin")
	void doClickLog(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Login());
	}
}
