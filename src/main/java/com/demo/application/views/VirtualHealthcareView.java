/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views;

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="virtual-healthcare", layout=MainLayout.class)
@PageTitle("Virtual Healthcare")
class VirtualHealthcareView extends VerticalLayout {

    VirtualHealthcareView() {
        
        // Remove padding and spacing
        setPadding(false);
        setSpacing(false);
        setSizeFull(); // Make the view take full height
        
        DynamicHeader header = new DynamicHeader("Need a doctor?", "Talk to one online!");
        
        // Create content wrapper for scrollable content
        HorizontalLayout contentWrapper = new HorizontalLayout();
        contentWrapper.setSizeFull();
        contentWrapper.setSpacing(false);
        contentWrapper.setPadding(false);

        
        // Add left and right content
        contentWrapper.add(SideNav.leftSideContent());
        contentWrapper.add(rightSideContent());
        
        add(header, contentWrapper);
        // H1 testText = new H1("Virtual Healthcare");
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
        // for (int i = 0; i < 20; i++) {
            rightContainer.add(new Div("this is Virtual Healthcare tab"));
        // }

        return rightContainer;
    }

}
