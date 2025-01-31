/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views.labs;

import com.demo.application.alert.AlertService;
import com.demo.application.history.TestHistoryService;
import com.demo.application.views.MainLayout;
import com.demo.application.views.charts.DummyChart;
import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="labs/bioMarker/001545", layout=MainLayout.class)
@PageTitle("Labs")
class LabsBioMarker01View extends VerticalLayout {
    public LabsBioMarker01View() {
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
        DynamicHeader header = new DynamicHeader("Need a lab?", "See your results online!");
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
        Component originalContent = SideNav.leftSideContent();
        
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


        /*
         * 
         * I gave the below statement to AI
         * 
         * 1/31/2025
         * 
         * I want to have a horizontallayout with 2 divs one to the far left and one to the far right.

        the left div has leftText H1 added to it and the right has H1 rightNum added to it.
        for numUnit annd numLevel I need them to be on the side of the rightNum verticle of each other with numUnit on top and numLevel on the bottom and High should be red 

        this is what I have. work from here to achieve my solution

        HorizontalLayout biomarkerRow = new HorizontalLayout();
        Div bioMarkerLeft = new Div();
        Div bioMarkerRight = new Div();
        H1 leftText = new H1("ALT (SGPT)");
        H1 rightNum = new H1("50");
        Paragraph numUnit = new Paragraph("IU/L");
        Paragraph numLevel = new Paragraph("HIGH");

         * 
         * 
         */
        // HorizontalLayout biomarkerRow = new HorizontalLayout();
        // Div bioMarkerLeft = new Div();
        // Div bioMarkerRight = new Div();
        // H1 leftText = new H1("ALT (SGPT)");
        // H1 rightNum = new H1("50");
        // Paragraph numUnit = new Paragraph("IU/L");
        // Paragraph numLevel = new Paragraph("HIGH");
        

        HorizontalLayout biomarkerRow = new HorizontalLayout();
        biomarkerRow.addClassName("license-counselor");
        biomarkerRow.setWidthFull();
        biomarkerRow.setJustifyContentMode(JustifyContentMode.BETWEEN); // Pushes items to edges
        biomarkerRow.setAlignItems(Alignment.CENTER);

        // Left side
        Div bioMarkerLeft = new Div();
        H1 leftText = new H1("ALT (SGPT)");
        leftText.getStyle()
            .set("margin", "0");
        bioMarkerLeft.add(leftText);

        // Right side
        Div bioMarkerRight = new Div();
        bioMarkerRight.getStyle()
            .set("display", "flex")
            .set("align-items", "center")
            .set("gap", "16px"); // Space between number and unit/level

        // Number
        H1 rightNum = new H1("50");
        rightNum.getStyle()
            .set("margin", "0");

        // Unit and Level container
        Div levelContainer = new Div();
        levelContainer.getStyle()
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("align-items", "flex-start");

        Paragraph numUnit = new Paragraph("IU/L");
        numUnit.getStyle()
            .set("margin", "0")
            .set("font-size", "14px")
            .set("color", "var(--lumo-secondary-text-color)");

        Paragraph numLevel = new Paragraph("HIGH");
        numLevel.getStyle()
            .set("margin", "0")
            .set("font-size", "14px")
            .set("color", "rgb(220, 38, 38)"); // Red color for HIGH

        levelContainer.add(numUnit, numLevel);
        bioMarkerRight.add(rightNum, levelContainer);

        biomarkerRow.add(bioMarkerLeft, bioMarkerRight);

        scrollContainer.add(biomarkerRow);


        
        H4 testOrderMainText = new H4("Clinical Reference");
        Paragraph testOrderSubText = new Paragraph("Target is between 0 and 44.");

        // Add all components to the div
        scrollContainer.add(testOrderMainText, testOrderSubText);

        Div alertCenterDiv = new Div();
            alertCenterDiv.getStyle()
            .set("margin-bottom", "10px");
            H4 text = new H4("Description");
            alertCenterDiv.addClassName("alert-center-dim");
            // alertCenterDiv.getStyle().set("border", "2px 0px solid black");
            Paragraph descriptionParagraph = new Paragraph("ALT, or alanine aminotransferase, is an enzyme that is found primarily in the liver. It is released into the blood when the liver is damaged.");
            alertCenterDiv.add(text, descriptionParagraph);
            
        scrollContainer.add(alertCenterDiv);



        // AlertService.getAlerts().forEach(alert -> 
        // scrollContainer.add(AlertService.createAlertDiv(alert))
        // );


        Div discussLabSectionDiv = new Div();
        discussLabSectionDiv.addClassName("license-counselor");
            discussLabSectionDiv.getStyle()
                            // .set("max-width", "60%")
                            .set("background-color", "#e7f5e9")
                            .set("max-height", "25%")
                            .set("margin-bottom", "12px")
                            .set("margin-top", "30px")
                            .set("padding", "16px")
                            .set("background-color", "#e7f5e9")
                            .set("border-radius", "16px 16px 16px 16px")
                            .set("border", "1px solid #E6E5E5");

        H4 discussLabMainText = new H4("Discuss your lab results with a doctor:");
        Paragraph discussLabSubText = new Paragraph("Schedule an appointment with a primary care doctor to discuss your lab results.");
        
        // Create the "learn more" link
        Anchor goToVirtualAnchor = new Anchor("virtual-healthcare", "Go to Virtual Healthcare");
        goToVirtualAnchor.getStyle()
            .set("display", "block")
            .set("text-align", "right")
            .set("margin-top", "16px")
            .set("text-decoration", "none")
            .set("color", "#1976d2")  // Use your preferred color
            .set("cursor", "pointer");

        // Add all components to the div
        discussLabSectionDiv.add(discussLabMainText, discussLabSubText, goToVirtualAnchor);
        scrollContainer.add(discussLabSectionDiv);

        Div testHistDiv = new Div();
        testHistDiv.getStyle()
        .set("margin-bottom", "10px");
        H4 text2 = new H4("History");
        testHistDiv.add(text2);
        testHistDiv.addClassName("alert-center-dim");
        // alertCenterDiv.getStyle().set("border", "2px 0px solid black");

        scrollContainer.add(testHistDiv);

        // TestHistoryService.getAlerts().forEach(test -> 
        // scrollContainer.add(TestHistoryService.createTestHistoryDiv(test))
        // );

        String[][] data = {
            {"Jan 31st 2025", "HIGH", "50"},
            {"Jan 31st 2025", "HIGH", "52"},
            {"Jan 31st 2025", "HIGH", "67"}
        };

        TestHistoryService.getAlerts(data).forEach(test -> 
        scrollContainer.add(TestHistoryService.createHistoryDiv(test))
        );

    // Create a div to hold the chart
        Div chartContainer = new Div();
        chartContainer.getStyle().set("margin-top","20px");
        chartContainer.setId("chartContainer");
        chartContainer.setWidth("661px");
        chartContainer.setHeight("397px");

        // Create the JavaScript for the chart
        String jsCode = DummyChart.jsCode;

        // Add Chart.js library
        UI.getCurrent().getPage().addJavaScript("https://cdn.jsdelivr.net/npm/chart.js");

        // Execute the chart creation after the library is loaded
        UI.getCurrent().getPage().executeJs(jsCode);

        // Add the chart container to your layout
        scrollContainer.add(chartContainer);
        
        // Add test content
        // for (int i = 0; i < 20; i++) {
        //     scrollContainer.add(new Div("Scroll content " + i));
        // }

        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }
}