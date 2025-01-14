package com.demo.application.views.header;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;

public class DynamicHeader extends Div {
    private final String pageGreeting;
    private final String subText;

    public DynamicHeader(String pageGreeting, String subText) {
        this.pageGreeting = pageGreeting;
        this.subText = subText;
        configureHeader();
    }

    private void configureHeader() {
        getStyle()
            .set("padding", "0px")
            .set("width", "100%")
            .set("height", "10%")
            .set("min-height", "200px")
            .set("background-color", "#e7f5e9")
            .set("position", "sticky")  // Make header sticky
            .set("top", "0")
            .set("z-index", "100");     // Ensure header stays on top

        H1 greeting = new H1(pageGreeting);
        greeting.getStyle()
            .set("text-align", "center")
            .set("margin-top", "70px")
            .set("margin-bottom", "0");

        Paragraph subTextParagraph = new Paragraph(subText);
        subTextParagraph.getStyle()
            .set("text-align", "center")
            .set("margin-top", "1rem");

        add(greeting, subTextParagraph);
    }
}