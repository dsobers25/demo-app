/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views;

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.BenefitsSideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="benefits", layout=MainLayout.class)
@PageTitle("Benefits")
class BenefitsView extends VerticalLayout {
    public BenefitsView() {
        // Remove padding and spacing
        setPadding(false);
        setSpacing(false);
        setSizeFull(); // Make the view take full height
        
        
        // Create a container for the entire view
        VerticalLayout mainContainer = new VerticalLayout();
        mainContainer.setPadding(false);
        mainContainer.setSpacing(false);
        mainContainer.setSizeFull();
        
        // Add the header
        DynamicHeader header = new DynamicHeader("You've got benefits", "Let's us explain them!");
        // DynamicHeader header = new DynamicHeader("Welcome John!", "What can we do for you today?");
        
        // Create content wrapper for the scrollable areas
        HorizontalLayout contentWrapper = new HorizontalLayout();
        contentWrapper.setHeightFull();
        contentWrapper.setWidthFull();
        contentWrapper.setSpacing(false);
        contentWrapper.setPadding(false);
        contentWrapper.getStyle()
            .set("flex", "1")
            .set("min-height", "0"); // Important for enabling scroll
        
        // Add left and right content with independent scrolling
        Component leftContent = createLeftContent();
        Component rightContent = createRightContent();
        
        contentWrapper.add(leftContent, rightContent);
        
        mainContainer.add(header, contentWrapper);
        add(mainContainer);
    }

    private Component createLeftContent() {
        Div leftWrapper = new Div();
        leftWrapper.addClassName("left-wrapper");
        leftWrapper.getStyle()
            // .set("width", "30%")
            .set("height", "100%")
            .set("overflow", "hidden") // Hide wrapper overflow
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("margin", "0")
            .set("padding-right", "16px"); // Add padding to the right side


        // Get the original left side content
        Component originalContent = BenefitsSideNav.leftSideContent();
        
        // Create a scrollable container for the navigation items
        Div scrollContainer = new Div();
        scrollContainer.getStyle()
            .set("overflow-y", "auto")
            .set("height", "100%")
            .set("flex", "1")
            .set("min-height", "0") // Important for enabling scroll
            .set("width", "100%")
            .set("display", "flex")
            .set("justify-content", "flex-end"); // Align content to the right
        
        
        scrollContainer.add(originalContent);
        leftWrapper.add(scrollContainer);
        
        return leftWrapper;
    }

    private Component createRightContent() {
        // Create a wrapper for the right content
        Div rightWrapper = new Div();
        rightWrapper.addClassName("right-wrapper");
        rightWrapper.getStyle()
            // .set("width", "70%")
            .set("height", "100%")
            .set("overflow", "hidden") // Hide wrapper overflow
            .set("display", "flex")
            .set("flex-direction", "column");

        // Create the scrollable container
        Div scrollContainer = new Div();
        scrollContainer.getStyle()
            .set("overflow-y", "auto")
            .set("height", "100%")
            .set("flex", "1")
            .set("min-height", "0") // Important for enabling scroll
            .set("background", "#FFFFFF")
            .set("padding", "var(--lumo-space-m)");

        // Add test content
        // for (int i = 0; i < 20; i++) {
        //     scrollContainer.add(new Div("Scroll content " + i));
        // }

        H3 topLine = new H3("Virtual Healthcare");
        topLine.getStyle().set("margin-bottom", "20px");
            // contactAndTime.add(number, timeAndDay);
    
        scrollContainer.add(topLine);


        // Main container
        Div benefitDiv = new Div();
        benefitDiv.addClassName("alert-center-dim");
        benefitDiv.getStyle()
            .set("display", "flex")
            
            .set("flex-direction", "column")
            .set("gap", "16px")
            .set("padding", "0px")
            .set("border-bottom", "2px solid #E6E4E4")
            .set("border-top", "2px solid #E6E4E4");

        // Top content container
        Div contentDiv = new Div();
        contentDiv.getStyle()
            .set("display", "flex")
            .set("justify-content", "space-between")
            .set("width", "100%");

        // Left side
        Div leftSide = new Div();
        leftSide.addClassName("remove-left-side");
        leftSide.getStyle()
            .set("align-items", "center");

        Paragraph leftline1 = new Paragraph("Benefit");
        leftSide.add(leftline1);

        // Right side
        Div rightSide = new Div();
        rightSide.addClassName("shift-text");
        rightSide.getStyle()
            .set("max-width", "60%"); // Adjust as needed for text wrapping

        // Paragraph rightline1 = new Paragraph("Urgent Care Telemedicine");
        // Paragraph rightline2 = new Paragraph("Primary Care Telemedicine");
        // Paragraph rightline3 = new Paragraph("$500 in-network diagnostics");
        // Paragraph rightline4 = new Paragraph("per year plus 50%");

        // Set margin for paragraphs
        // rightline1.getStyle().set("margin", "0");
        // rightline2.getStyle().set("margin", "0");
        // rightline3.getStyle().set("margin", "0");
        // rightline4.getStyle().set("margin", "0");

        // rightSide.add(rightline1, rightline2, rightline3, rightline4);

        Paragraph[] rightlines = {
            new Paragraph("Urgent Care Telemedicine"),
            new Paragraph("Primary Care Telemedicine"),
            new Paragraph("$500 in-network diagnostics"),
            new Paragraph("per year plus 50%")
        };

        for(Paragraph p : rightlines) {
            p.getStyle().set("margin", "0");
            rightSide.add(p);
        }

        // Add left and right to content container
        contentDiv.add(leftSide, rightSide);

        // Create bottom link section
        Div linkDiv = new Div();
        linkDiv.getStyle()
            .set("display", "flex")
            .set("justify-content", "flex-end")
            .set("align-items", "center")
            .set("gap", "8px")
            .set("cursor", "pointer")
            .set("border-top", "0.5px solid #E6E4E4");

        Span linkText = new Span("View Virtual Healthcare benefit details");
        Span arrow = new Span("→");
        arrow.getStyle()
            .set("font-size", "20px");

        linkDiv.add(linkText, arrow);

        // Add click listener to link div
        linkDiv.addClickListener(e -> {
            // Add your click handling here
        });

        // Style the link text
        linkText.getStyle()
            .set("color", "#1976d2");  // or your preferred link color

        // Add all components to main container
        benefitDiv.add(contentDiv, linkDiv);

        // Add to scroll container
        scrollContainer.add(benefitDiv);




        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }
}