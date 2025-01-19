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
        .set("padding", "24px")  // Add vertical padding
        .set("width", "100%")
        .set("min-height", "128px")
        .set("box-sizing", "border-box")
        .set("background-color", "#e7f5e9")
        .set("position", "sticky")
        .set("top", "0")
        .set("z-index", "100")
        .set("display", "flex")  // Add flex display
        .set("flex-direction", "column")  // Stack children vertically
        .set("justify-content", "center");  // Center content vertically

        addClassName("header-height");

        H1 greeting = new H1(pageGreeting);
            greeting.getStyle()
                .set("text-align", "center")
                .set("margin", "0")  // Remove default margins
                .set("padding", "8px 0");  // Add some vertical padding

        Paragraph subTextParagraph = new Paragraph(subText);
            subTextParagraph.getStyle()
                .set("text-align", "center")
                .set("white-space"," nowrap")
                .set("margin", "0")  // Remove default margins
                .set("padding", "8px 0");  // Add some vertical padding

        greeting.addClassName("pageGreeting");


        subTextParagraph.addClassName("subText");

        add(greeting, subTextParagraph);
    }
}