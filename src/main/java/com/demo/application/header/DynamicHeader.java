package com.demo.application.header;

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
        // Configure the header div (this)
        getStyle()
            .set("padding", "0px")
            .set("width", "100vw")
            .set("height", "30vh")
            .set("background-color", "#e7f5e9");

        // Create and configure greeting
        H1 greeting = new H1(pageGreeting);
        greeting.getStyle()
            .set("text-align", "center")
            .set("margin-top", "70px");

        // Create and configure subtext
        Paragraph subTextParagraph = new Paragraph(subText);
        subTextParagraph.getStyle()
            .set("text-align", "center");

        // Add components to this div
        add(greeting, subTextParagraph);
    }
}