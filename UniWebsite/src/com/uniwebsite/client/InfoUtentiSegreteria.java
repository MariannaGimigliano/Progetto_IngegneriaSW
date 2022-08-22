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

public class InfoUtentiSegreteria extends Composite {

	String logged = "";
	private static InfoUtentiSegreteriaUiBinder uiBinder = GWT.create(InfoUtentiSegreteriaUiBinder.class);

	@UiTemplate("InfoUtentiSegreteria.ui.xml")
	interface InfoUtentiSegreteriaUiBinder extends UiBinder<Widget, InfoUtentiSegreteria> {}

	@UiField
	Button btnHome;
	
	@UiField
	Button btnStudenti;
	
	@UiField
	Button btnVoti;
	
	public InfoUtentiSegreteria(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
	}
	
	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeSegreteria(logged));
	}
	
	@UiHandler("btnVoti")
	void doClickVoti(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new VotiSegreteria(logged));
	}

}
