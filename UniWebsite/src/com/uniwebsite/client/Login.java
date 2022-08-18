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
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.uniwebsite.shared.*;

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
	
	@UiField
	Button btnLog;
	
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
	
	@UiHandler("btnLog")
	void doClickLog(ClickEvent event) {
		/*final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);
		greetingService.login(txtMail.getText(), txtPassword.getText(), new AsyncCallback<Utente>() {

			public void onFailure(Throwable c) {
				RootPanel.get().clear();
				RootPanel.get().add(new Login());
			}

			@Override
			public void onSuccess(Utente user) {
				Account.email = txtMail.getText();

				RootPanel.get("container").clear();
				if(user instanceof Studente) {
					Account.matricola=((Studente) user).getMatricola();
					RootPanel.get("container").add(new HomePageUtente());

				}else if(user instanceof Docente) {
					RootPanel.get("container").add(new HomePageDocente());
				}else if(user instanceof Amministratore) {
					RootPanel.get("container").add(new HomePageAdmin());
				}else if(user instanceof Segreteria) {
					RootPanel.get("container").add(new HomePageSegreteria(listaStudenti));
				}

				else {
					RootPanel.get("container").add(new HomePage());
				}


			}
		});*/
		RootPanel.get().clear();
		RootPanel.get().add(new HomeStudente());
	}
}
