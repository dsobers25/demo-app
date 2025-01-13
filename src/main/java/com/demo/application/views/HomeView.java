package com.demo.application.views;

import com.demo.application.header.DynamicHeader;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="", layout=MainLayout.class)
@PageTitle("Home")
public class HomeView extends VerticalLayout {
    public HomeView() {

        setPadding(false);
        setSpacing(false);
        
        DynamicHeader header = new DynamicHeader("Welcome John!", "What can we do for you today?");
        add(header);

        // H1 words = new H1("hello 2025");
        HorizontalLayout horizontalLayout = new HorizontalLayout();

        horizontalLayout.add(leftSideContent());
        horizontalLayout.add(rightSideContent());

        add(horizontalLayout);


        
    }

    private Component leftSideContent() {
        var leftContainer = new Div("something on the left");
        leftContainer.addClassName("left-container");
        leftContainer.getStyle().set("width", "30vw")
                                .set("height", "100vw")
                                .set("background", "#F7F8F9");

        return leftContainer;
    }

    private Component rightSideContent() {
        var rightContainer = new Div("something on the right");
        rightContainer.addClassName("right-container");
        rightContainer.getStyle().set("width", "70vw")
                                .set("height", "100vw")
                                .set("background", "#FFFFFF");

        return rightContainer;
    }
}
