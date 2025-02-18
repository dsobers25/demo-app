package com.demo.application.alert;

// AlertService.java

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlertService {
    public static List<AlertData> getAlerts(String[][] alertsData) {
        List<AlertData> alerts = new ArrayList<>();
        
        for (String[] row : alertsData) {
            if (row.length >= 3) {  // Ensure row has required elements
                alerts.add(new AlertData(row[0], row[1], row[2]));
            }
        }
        
        return alerts;
    }

    public static Component createAlertDiv(AlertData alert) {
        // Create the main Div
        Div alertCenterDiv = new Div();
        alertCenterDiv.addClassName("alert-center-dim");
        alertCenterDiv.getStyle()
            .set("display", "flex")
            .set("justify-content", "space-between")
            .set("align-items", "center")
            .set("padding", "16px")
            .set("border-top", "1px solid #e5e7eb")
            .set("border-bottom", "1px solid #e5e7eb")
            .set("cursor", "pointer");
    
        // Create left side container
        HorizontalLayout leftSide = new HorizontalLayout();
        leftSide.setAlignItems(Alignment.CENTER);
        leftSide.setSpacing(true);
    
        // Create alert icon
        Div alertIcon = new Div();
        String iconColor = "";
        String iconSvg = "";
    
        // Set icon color and SVG based on status
        if (alert.getStatus().isEmpty()) {
            iconSvg = "<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>" +
                      "<path d='M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12Zm13.36-1.814a.75.75 0 1 0-1.22-.872l-3.236 4.53L9.53 12.22a.75.75 0 0 0-1.06 1.06l2.25 2.25a.75.75 0 0 0 1.14-.094l3.75-5.25Z' fill='#16a34a'/>" + // Green with hex color
                      "</svg>";
         } else {
            iconSvg = "<svg xmlns='http://www.w3.org/2000/svg' width='24' height='24' viewBox='0 0 24 24'>" +
                      "<circle cx='12' cy='12' r='10' fill='#DC2626'/>" + // Red with hex color
                      "<path d='M12 8v5' stroke='#FFFFFF' stroke-width='2' stroke-linecap='round'/>" +
                      "<circle cx='12' cy='16' r='1' fill='#FFFFFF'/>" +
                      "</svg>";
         }
    
        // Set up the alert icon container
        alertIcon.getElement().setProperty("innerHTML", iconSvg);
        alertIcon.getStyle()
            .set("display", "flex")
            .set("align-items", "center")
            .set("width", "24px")
            .set("height", "24px")
            // .set("color", iconColor)
            .set("line-height", "0")
            .set("flex-shrink", "0");
    
        // Create and style the label text
        Paragraph text1 = new Paragraph(alert.getLabel());
        text1.getStyle().set("margin", "0");
    
        leftSide.add(alertIcon, text1);
    
        // Create right side container
        HorizontalLayout rightSide = new HorizontalLayout();
        rightSide.setAlignItems(Alignment.CENTER);
        rightSide.setSpacing(true);
    
        // Create and style the status text
        Paragraph text2 = new Paragraph(alert.getStatus());
        text2.getStyle()
            .set("margin", "0")
            .set("margin-right", "8px")
            .set("color", "rgb(220, 38, 38)")
            .set("font-weight", "500");
    
        // Create and style the arrow icon
        Icon arrowIcon = new Icon(VaadinIcon.ARROW_RIGHT);
        arrowIcon.getStyle()
            .set("width", "20px")
            .set("height", "20px");
    
        rightSide.add(text2, arrowIcon);
        alertCenterDiv.add(leftSide, rightSide);
        
        // Add click navigation
        alertCenterDiv.addClickListener(e -> UI.getCurrent().navigate(alert.getRoute()));
    
        return alertCenterDiv;
    }
}