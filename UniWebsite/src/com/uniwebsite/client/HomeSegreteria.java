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
import com.google.gwt.user.client.ui.Widget;

public class HomeSegreteria extends Composite {

	String logged = "";
	private static HomeSegreteriaUiBinder uiBinder = GWT.create(HomeSegreteriaUiBinder.class);

	@UiTemplate("HomeSegreteria.ui.xml")
	interface HomeSegreteriaUiBinder extends UiBinder<Widget, HomeSegreteria> {}

	public HomeSegreteria(String email) {
		initWidget(uiBinder.createAndBindUi(this));
		logged = email;
	}

}
