package com.uniwebsite.client;

import java.util.ArrayList;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.uniwebsite.shared.Voto;

public class VotiStudente extends Composite {

	String logged = "";
	private static VotiStudenteUiBinder uiBinder = GWT.create(VotiStudenteUiBinder.class);
	private static  ArrayList<Voto> voti = new ArrayList<Voto>();
	
	@UiTemplate("VotiStudente.ui.xml")
	interface VotiStudenteUiBinder extends UiBinder<Widget, VotiStudente> {}

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
	CellTable<Voto> cellTable;
	
	public VotiStudente(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
		getVoti();
	}

	@UiHandler("btnHome")
	void doClickHome(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new HomeStudente(logged));
	}
	
	@UiHandler("btnCorsi")
	void doClickCorsi(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new CorsiStudente(logged));
	}
	
	@UiHandler("btnEsami")
	void doClickEs(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new EsamiStudente(logged));
	}
	
	@UiHandler("btnPers")
	void doClickPers(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new AreaPersStudente(logged));
	}
	
	@UiHandler("btnLogout")
	void doClickOut(ClickEvent event) {
		RootPanel.get().clear();
		RootPanel.get().add(new Home());
	}
	
	public void getVoti() {
		voti.clear();
		try {
			final GreetingServiceAsync greetingService = GWT.create(GreetingService.class);

			greetingService.getVotiStudente(logged, new AsyncCallback<ArrayList<Voto>>() {
				public void onFailure(Throwable caught) {}
				@Override
				public void onSuccess(ArrayList<Voto> votiOutput) {
					for(int i=0;i<votiOutput.size();i++) {
						voti.add(votiOutput.get(i));
					}
					
					TextColumn<Voto> colEsame = new TextColumn<Voto>() {
						@Override
						public String getValue(Voto obj) {
							return obj.getEsame();
						}
					}; cellTable.addColumn(colEsame, "Esame");

					TextColumn<Voto> colVoto = new TextColumn<Voto>() {
						@Override
						public String getValue(Voto obj) {
							return obj.getVoto();
						}
					}; cellTable.addColumn(colVoto, "Voto");

					cellTable.setRowCount(voti.size(), true);
					cellTable.setRowData(0, voti);
				}		
			});
		}catch(Error e){};
	}
}
