/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views.labs;

import com.demo.application.alert.AlertService;
import com.demo.application.history.TestHistoryService;
import com.demo.application.views.MainLayout;
import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
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

        // H3 topLine = new H3("Behavioral Healthcare");
        // Paragraph subLine = new Paragraph("powered by CCA");
            // contactAndTime.add(number, timeAndDay);
    
        // scrollContainer.add(topLine, subLine);

        Div testOrderTopSectionDiv = new Div();
        testOrderTopSectionDiv.addClassName("license-counselor");
            testOrderTopSectionDiv.getStyle()
                            // .set("max-width", "60%")
                            .set("background-color", "#e7f5e9")
                            .set("max-height", "25%")
                            .set("margin-bottom", "12px")
                            .set("padding", "16px")
                            .set("background-color", "#e7f5e9")
                            .set("border-radius", "16px 16px 16px 16px")
                            .set("border", "1px solid #E6E5E5");

        H4 testOrderMainText = new H4("You have a test order");
        Paragraph testOrderSubText = new Paragraph("A doctor has ordered lab tests for you.");
        
        // Create the "learn more" link
        Anchor learnMoreLink = new Anchor("your-target-page", "Click here to learn more →");
        learnMoreLink.getStyle()
            .set("display", "block")
            .set("text-align", "right")
            .set("margin-top", "16px")
            .set("text-decoration", "none")
            .set("color", "#1976d2")  // Use your preferred color
            .set("cursor", "pointer");

        // Add all components to the div
        testOrderTopSectionDiv.add(testOrderMainText, testOrderSubText, learnMoreLink);
        scrollContainer.add(testOrderTopSectionDiv);

        Div alertCenterDiv = new Div();
            alertCenterDiv.getStyle()
            .set("margin-bottom", "10px");
            H4 text = new H4("Alert Center");
            alertCenterDiv.add(text);
            alertCenterDiv.addClassName("alert-center-dim");
            // alertCenterDiv.getStyle().set("border", "2px 0px solid black");

        scrollContainer.add(alertCenterDiv);

        AlertService.getAlerts().forEach(alert -> 
        scrollContainer.add(AlertService.createAlertDiv(alert))
        );


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
        H4 text2 = new H4("Test History");
        testHistDiv.add(text2);
        testHistDiv.addClassName("alert-center-dim");
        // alertCenterDiv.getStyle().set("border", "2px 0px solid black");

        scrollContainer.add(testHistDiv);

        TestHistoryService.getAlerts().forEach(test -> 
        scrollContainer.add(TestHistoryService.createTestHistoryDiv(test))
        );

    // Create a div to hold the chart
        Div chartContainer = new Div();
        chartContainer.setId("chartContainer");
        chartContainer.setWidth("661px");
        chartContainer.setHeight("397px");

        // Create the JavaScript for the chart
        String jsCode = 
    "const ctx = document.createElement('canvas');" +
    "ctx.id = 'myChart';" +
    "ctx.style.width = '661px';" +
    "ctx.style.height = '397px';" +
    "document.getElementById('chartContainer').appendChild(ctx);" +
    
    "new Chart(ctx, {" +
    "   type: 'line'," +
    "   data: {" +
    "       labels: ['Jan 12 2023', 'Feb 12 2024', 'Jan 13 2025']," +
    "       datasets: [" +
    "           {" +  // Background green zone
    "               data: [25, 25, 25]," +  // Horizontal line at y=25
    "               fill: 'start'," +
    "               backgroundColor: 'rgba(0, 255, 0, 0.3)'," +
    "               borderWidth: 0," +
    "               pointRadius: 0," +
    "               order: 3" +  // Draw first (bottom layer)
    "           }," +
    "           {" +  // Background red zone
    "               data: [45, 45, 45]," +  // Top of graph
    "               fill: '-1'," +  // Fill to previous dataset
    "               backgroundColor: 'rgba(255, 0, 0, 0.3)'," +
    "               borderWidth: 0," +
    "               pointRadius: 0," +
    "               order: 2" +  // Draw second
    "           }," +
    "           {" +  // Actual data line
    "               data: [20, 30, 40]," +
    "               borderColor: 'white'," +
    "               borderWidth: 2," +
    "               pointRadius: 3," +
    "               fill: false," +
    "               order: 1" +  // Draw last (top layer)
    "           }" +
    "       ]" +
    "   }," +
    "   options: {" +
    "       responsive: true," +
    "       maintainAspectRatio: false," +
    "       scales: {" +
    "           y: {" +
    "               min: 15," +
    "               max: 45," +
    "               ticks: {" +
    "                   stepSize: 5" +
    "               }" +
    "           }" +
    "       }," +
    "       plugins: {" +
    "           legend: {" +
    "               display: false" +
    "           }" +
    "       }" +
    "   }" +
    "});";

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