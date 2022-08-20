package com.uniwebsite.client;

import java.util.ArrayList;

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
import com.uniwebsite.shared.*;

public class AreaPersDocente extends Composite {

	String logged = "";
	private static AreaPersDocenteUiBinder uiBinder = GWT.create(AreaPersDocenteUiBinder.class);

	@UiTemplate("AreaPersDocente.ui.xml")
	interface AreaPersDocenteUiBinder extends UiBinder<Widget, AreaPersDocente> {}

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
	Label lblNome;

	@UiField
	Label lblCognome;

	@UiField
	Label lblMail;

	@UiField
	Label lblCorsi;
	
	@UiField
	Label lblEsami;
	
	public AreaPersDocente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
		getDocente();
		getCorsi();
		getEsami();
	}
	
	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeDocente(logged));
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
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	/* Mostra i dati del docente */
	public void getDocente() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getUtente(logged, new AsyncCallback<Utente>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(Utente user) {
					lblNome.setText(user.getNome());
					lblCognome.setText(user.getCognome());
					lblMail.setText(user.getEmail());
				}
			});
		} catch(Error e){};
	}
	
	/* Mostra i corsi del docente */
	public void getCorsi() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getCorsiDocente(logged, new AsyncCallback<ArrayList<Corso>>() {
				public void onFailure(Throwable caught) {
					lblCorsi.setText(caught.getMessage());
				}
				@Override
				public void onSuccess(ArrayList<Corso> corsi) {
					String test = "";
					for(int i=0;i<corsi.size();i++) {
						test += corsi.get(i).getNomeCorso() + ", ";
					}
					lblCorsi.setText(test);
				}
			});
		}catch(Error e){};
	}
	
	/* Mostra gli esami del docente */
	public void getEsami() {
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getEsamiDocente(logged, new AsyncCallback<ArrayList<Esame>>() {
				public void onFailure(Throwable caught) {
					lblEsami.setText(caught.getMessage());
				}
				@Override
				public void onSuccess(ArrayList<Esame> esami) {
					String test = "";
					for(int i=0;i<esami.size();i++) {
						test += esami.get(i).getEsame() + ", ";
					}
					lblEsami.setText(test);
				}
			});
		}catch(Error e){};
	}
}
