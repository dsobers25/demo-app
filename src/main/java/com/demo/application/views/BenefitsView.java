/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views;

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.BenefitsSideNav;
import com.demo.application.views.utils.SpacerUtility;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
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
        
        mainContainer.add(contentWrapper);
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
            .set("margin", "0");
            // .set("padding-right", "16px"); // Add padding to the right side


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

        Paragraph[] rightlinesOne = {
            new Paragraph("Urgent Care Telemedicine"),
            new Paragraph("Primary Care Telemedicine"),
            new Paragraph("$500 in-network diagnostics"),
            new Paragraph("per year plus 50%")
        };


        benefitsSections("Virtual Healthcare", "Benefit", rightlinesOne,
        "View Virtual Healthcare benefit details", scrollContainer, "", false);


        Paragraph[] rightlinesTwo = {
            new Paragraph("Health advocacy & care navigation services"),
            new Paragraph("that provide personal support for any"),
            new Paragraph("healthcare challenge.")
        };

        benefitsSections("Health Navigator", "Benefit", rightlinesTwo,
        "View Health Navigator benefit details", scrollContainer, "health-navigator", true);


        Paragraph[] rightlinesThree = {
            new Paragraph("100% in-network preventative care"),
            new Paragraph("80% outpatient services"),
            new Paragraph("80% inpatient hospital")
        };

        benefitsSections("Health Insurance", "Benefit", rightlinesThree,
        "View Health Insurance benefit details", scrollContainer, "benefits/health-insurance", true);


        Paragraph[] rightlinesFour = {
            new Paragraph("24/7 toll-free counselling"),
            new Paragraph("Crisis consultation")
        };

        benefitsSections("Mental Healthcare", "Benefit", rightlinesFour,
        "", scrollContainer, "", true);


        Paragraph[] rightlinesFive = {
            new Paragraph("100% of Covered Services"),
            new Paragraph("1 Routine Exam every 6 months"),
            new Paragraph("1 Bitewing X-Ray every 12 months"),
            new Paragraph("2 Cleanings every 12 months")
        };

        benefitsSections("Dental", "Benefit", rightlinesFive,
        "View Dental benefit details", scrollContainer, "benefits/dental", true);


        Paragraph[] rightlinesSix = {
            new Paragraph("100% of Covered Services"),
            new Paragraph("1 Routine Exam every 6 months"),
            new Paragraph("1 Bitewing X-Ray every 12 months"),
            new Paragraph("2 Cleanings every 12 months")
        };

        benefitsSections("Vision", "Benefit", rightlinesSix,
        "View Dental benefit details", scrollContainer, "benefits/vision", true);


        Paragraph[] rightlinesSeven = {
            new Paragraph("60% of weekly salary to a maximum of "),
            new Paragraph("$2,500 per week"),
            new Paragraph("Elimination period: 0 days for accident and 7 "),
            new Paragraph("days for Illness"),
            new Paragraph("Benefit duration: 26 weeks")
        };

        benefitsSections("Long-term disability benefit", "Benefit", rightlinesSeven,
        "", scrollContainer, "", true);


        Paragraph[] rightlinesEight = {
            new Paragraph("60% of weekly salary to a maximum of "),
            new Paragraph("$15,000 per week"),
            new Paragraph("Elimination period: 180 days"),
            new Paragraph("Benefit duration: Up to age 65 or SSNRA,"),
            new Paragraph("whichever is longest")
        };

        benefitsSections("Short-term disability benefit", "Benefit", rightlinesEight,
        "", scrollContainer, "", true);


        Paragraph[] rightlinesNine = {
            new Paragraph("Employee Benefit for covered illness:"),
            new Paragraph("$30,000"),
            new Paragraph("Spouse Benefit for covered illness: $15,000"),
            new Paragraph("Recurrence benefit included")
        };

        benefitsSections("Critical Illness Insurance Benefit", "Benefit", rightlinesNine,
        "", scrollContainer, "", true);


        Paragraph[] rightlinesTen = {
            new Paragraph("High plan election"),
            new Paragraph("Follow schedule of benefits for payable"),
            new Paragraph("amount"),
            new Paragraph("Guaranteed Issue and portability included")
        };

        benefitsSections("Accident Insurance Benefit", "Benefit", rightlinesTen,
        "", scrollContainer, "", true);

        Div spacer = new Div();
        spacer.addClassName("alert-center-dim");
        spacer.getStyle().set("height", "40px");

        scrollContainer.add(spacer);

        scrollContainer.add(SpacerUtility.createSpacer());
        scrollContainer.add(SpacerUtility.createSpacer());
        scrollContainer.add(SpacerUtility.createSpacer());


        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }

    public void benefitsSections(String sectionTitle, String left, Paragraph[] rightLines,
    String textForLink, Div scrollContainer, String route, boolean topMargin) {
        // H3 topLine = new H3("Virtual Healthcare");
        H3 topLine = new H3(sectionTitle);
        if(topMargin) {
            topLine.getStyle().set("margin-top", "56px");
        }
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

        // Paragraph leftline1 = new Paragraph("Benefit");
        Paragraph leftline1 = new Paragraph(left);
        leftSide.add(leftline1);

        // Right side
        Div rightSide = new Div();
        rightSide.addClassName("shift-text");
        rightSide.getStyle()
            .set("max-width", "60%") // Adjust as needed for text wrapping
            .set("text-align", "right") // Add this to align all content right
            .set("margin-left", "auto"); // This will push the div to the right


        for(Paragraph p : rightLines) {
            p.getStyle().set("margin", "0");
            rightSide.add(p);
        }

        // Add left and right to content container
        contentDiv.add(leftSide, rightSide);

        // Add all components to main container
        benefitDiv.add(contentDiv);


        // Create bottom link section
        Div linkDiv = new Div();
        linkDiv.getStyle()
            .set("display", "flex")
            .set("justify-content", "flex-end")
            .set("align-items", "center")
            .set("gap", "8px")
            .set("cursor", "pointer")
            .set("border-top", "0.5px solid #E6E4E4");

        //if route and textForLink are not null add clickable link section
        if(route != "" && textForLink != "") {

        // Span linkText = new Span("View Virtual Healthcare benefit details");
        Span linkText = new Span(textForLink);
        Span arrow = new Span("→");
        arrow.getStyle()
            .set("font-size", "20px");

        linkDiv.add(linkText, arrow);

        // Add click listener to link div
        linkDiv.addClickListener(e -> {
            // Add your click handling here
            UI.getCurrent().navigate(route);
        });

        // Style the link text
        linkText.getStyle()
            .set("color", "#1976d2");  // or your preferred link color

        // Add all components to main container
        benefitDiv.add(linkDiv);
        
    }

        // Add to scroll container
        scrollContainer.add(benefitDiv);
    }
}