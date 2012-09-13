package com.vaadin.hellocdi.presentation;

import com.vaadin.cdi.VaadinUI;
import com.vaadin.cdi.VaadinUIScoped;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.WrappedRequest;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * 
 * @author adam-bien.com
 */
@VaadinUI
public class ConventionalHello extends UI {
    @Override
    protected void init(WrappedRequest request) {
        setSizeFull();
        VerticalLayout layout = new VerticalLayout();
        layout.setSizeFull();
        layout.addComponent(new Label("UI with default mapping"));
        setContent(layout);
    }

}
