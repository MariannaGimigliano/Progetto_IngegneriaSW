package com.uniwebsite.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class Login extends Composite {

	private static LoginUiBinder uiBinder = GWT.create(LoginUiBinder.class);

	@UiTemplate("Login.ui.xml")
	interface LoginUiBinder extends UiBinder<Widget, Login> {}
	
	@UiField
	Button btnHome;
	
	@UiField
	Button btnDipartimenti;

	@UiField
	Button btnContatti;
	
	@UiField
	Button btnLogin;
	
	public Login() {
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
	
	@UiHandler("btnContatti")
	void doClickCont(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Contatti());
	}
}
