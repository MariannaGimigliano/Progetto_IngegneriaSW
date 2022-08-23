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

public class VotiSegreteria extends Composite {

	private static VotiSegreteriaUiBinder uiBinder = GWT.create(VotiSegreteriaUiBinder.class);

	@UiTemplate("VotiSegreteria.ui.xml")
	interface VotiSegreteriaUiBinder extends UiBinder<Widget, VotiSegreteria> {}

	@UiField
	Button btnHome;
	
	@UiField
	Button btnStudenti;
	
	@UiField
	Button btnVoti;
	
	@UiField
	Button btnLogout;
	
	public VotiSegreteria() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeSegreteria());
	}
	
	@UiHandler("btnStudenti")
	void doClickStud(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new InfoUtentiSegreteria());
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}

}
