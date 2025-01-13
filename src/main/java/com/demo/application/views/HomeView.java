package com.demo.application.views;

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
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
        // Remove padding and spacing
        setPadding(false);
        setSpacing(false);
        setSizeFull(); // Make the view take full height
        
        DynamicHeader header = new DynamicHeader("Welcome John!", "What can we do for you today?");
        
        // Create content wrapper for scrollable content
        HorizontalLayout contentWrapper = new HorizontalLayout();
        contentWrapper.setSizeFull();
        contentWrapper.setSpacing(false);
        contentWrapper.setPadding(false);

        
        // Add left and right content
        contentWrapper.add(SideNav.leftSideContent());
        contentWrapper.add(rightSideContent());
        
        add(header, contentWrapper);
    }

    

    private Component rightSideContent() {
        var rightContainer = new Div("something on the right");
        rightContainer.addClassName("right-container");
        rightContainer.getStyle()
            .set("width", "70%")
            .set("height", "100%")
            .set("background", "#FFFFFF")
            .set("overflow-y", "auto") // Enable vertical scrolling
            .set("padding", "var(--lumo-space-m)");

        // Add some test content to demonstrate scrolling
        for (int i = 0; i < 20; i++) {
            rightContainer.add(new Div("Scroll content " + i));
        }

        return rightContainer;
    }
}
