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

public class Home extends Composite {

	private static HomeUiBinder uiBinder = GWT.create(HomeUiBinder.class);

	@UiTemplate("Home.ui.xml")
	interface HomeUiBinder extends UiBinder<Widget, Home> {}
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnDipartimenti;

	@UiField
	Button btnContatti;
	
	@UiField
	Button btnLogin;

	public Home() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("btnDipartimenti")
	void doClickDip(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Dipartimenti());
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
