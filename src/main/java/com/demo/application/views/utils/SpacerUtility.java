package com.demo.application.views.utils;

import com.vaadin.flow.component.html.Div;

public class SpacerUtility {

    public static Div createSpacer() {
        Div spacer = new Div();
        spacer.getStyle()
            .set("height", "40px")
            .set("width", "100%");
        return spacer;
    }

}
