package com.demo.application.views.sidenav;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;

public class SideNav {

    public SideNav() {

    }

    public static Component leftSideContent() {
        var leftContainer = new Div("something on the left");
        leftContainer.addClassName("left-container");
        leftContainer.getStyle()
            .set("width", "30%")
            .set("height", "100%")
            .set("background", "#F7F8F9")
            .set("overflow-y", "auto") // Enable vertical scrolling
            .set("padding", "var(--lumo-space-m)");

        // Add some test content to demonstrate scrolling
        for (int i = 0; i < 20; i++) {
            leftContainer.add(new Div("Scroll content " + i));
        }

        return leftContainer;
    }

}
