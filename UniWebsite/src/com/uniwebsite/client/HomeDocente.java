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

public class HomeDocente extends Composite {

	String logged = "";
	private static HomeDocenteUiBinder uiBinder = GWT.create(HomeDocenteUiBinder.class);
	
	@UiTemplate("HomeDocente.ui.xml")
	interface HomeDocenteUiBinder extends UiBinder<Widget, HomeDocente> {}

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
	
	public HomeDocente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
	}
	
	@UiHandler("btnCorsi")
	void doClickCorsi(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new CorsiDocente(logged));
	}
	
	@UiHandler("btnEsami")
	void doClickEsami(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new EsamiDocente(logged));
	}
	
	@UiHandler("btnVoti")
	void doClickVoti(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new VotiDocente(logged));
	}
	
	@UiHandler("btnPers")
	void doClickPers(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new AreaPersDocente(logged));
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
}
