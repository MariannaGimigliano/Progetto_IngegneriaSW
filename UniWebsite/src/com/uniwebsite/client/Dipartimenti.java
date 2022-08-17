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

public class Dipartimenti extends Composite {

	private static DipartimentiUiBinder uiBinder = GWT.create(DipartimentiUiBinder.class);

	@UiTemplate("Dipartimenti.ui.xml")
	interface DipartimentiUiBinder extends UiBinder<Widget, Dipartimenti> {}
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnDipartimenti;

	@UiField
	Button btnContatti;
	
	@UiField
	Button btnLogin;

	public Dipartimenti() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	@UiHandler("btnContatti")
	void doClickCont(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Contatti());
	}
	
	@UiHandler("btnLogin")
	void doClickLog(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Login());
	}
}
