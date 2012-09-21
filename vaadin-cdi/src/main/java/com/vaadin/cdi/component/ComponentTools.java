package com.vaadin.cdi.component;

import javax.enterprise.inject.Produces;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Component;
import com.vaadin.util.CurrentInstance;

public class ComponentTools {

    public void setEnabledForRoles(Component component, String... roles) {
        component.setEnabled(isUserInSomeGivenRole(roles));
    }

    public void setVisibleForRoles(Component component, String... roles) {
        component.setVisible(isUserInSomeGivenRole(roles));
    }

    private boolean isUserInSomeGivenRole(String... roles) {
        HttpServletRequest request = getCurrentRequest();

        for (String role : roles) {
            if (request.isUserInRole(role)) {
                return true;
            }
        }

        return false;
    }

    @Produces
    protected HttpServletRequest getCurrentRequest() {
        return (HttpServletRequest) CurrentInstance
                .get(ServletRequest.class);
    }
}
