package com.demo.application.views;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="", layout=MainLayout.class)
@PageTitle("Home")
public class HomeView extends VerticalLayout {
    public HomeView() {

        setPadding(false);
        setSpacing(false);
        getStyle().set("padding", "0");

        Div headerr = new Div();
        headerr.getStyle().set("padding", "0px");
            headerr.getStyle().set("width", "100vw");
            headerr.getStyle().set("height", "30vh");
            headerr.getStyle().set("background-color", "#e7f5e9");
        
        H1 pageGreeting = new H1("Welcome John!");
        pageGreeting.getStyle().set("text-align", "center")
        .set("margin-top", "70px");
        Paragraph subText = new Paragraph("What can we do for you today?");
        subText.getStyle().set("text-align", "center");
        headerr.add(pageGreeting, subText);
        add(headerr);

        H1 words = new H1("hello");
        add(words);
        
    }
}
