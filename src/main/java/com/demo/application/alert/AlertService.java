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
import java.util.Arrays;
import java.util.List;

public class AlertService {
    public static List<AlertData> getAlerts() {
        return Arrays.asList(
            new AlertData("ALT (SGPT)", "HIGH", "alt-details"),
            new AlertData("AST (SGOT)", "HIGH", "ast-details"),
            new AlertData("BUN", "HIGH", "bun-details"),
            new AlertData("Glucose", "HIGH", "glucose-details"),
            new AlertData("Hemoglobin A1c", "HIGH", "hemoglobin-details"),
            new AlertData("Protein, Total", "LOW", "protein-details"),
            new AlertData("Sodium", "HIGH", "sodium-details")
        );
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

        // Add SVG icon
        Div alertIcon = new Div();
        String iconColor = alert.getStatus().equals("LOW") ? "rgb(37, 99, 235)" : "rgb(220, 38, 38)";
        alertIcon.getElement().setProperty("innerHTML",
            "<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' width='20' height='20'>" +
            "<circle cx='12' cy='12' r='10' fill='" + iconColor + "'/>" +
            "<path d='M12 8v5' stroke='white' stroke-width='2' stroke-linecap='round'/>" +
            "<circle cx='12' cy='16' r='1' fill='white'/>" +
            "</svg>"
        );

        Paragraph text1 = new Paragraph(alert.getLabel());
        text1.getStyle().set("margin", "0");

        leftSide.add(alertIcon, text1);

        // Create right side container
        HorizontalLayout rightSide = new HorizontalLayout();
        rightSide.setAlignItems(Alignment.CENTER);
        rightSide.setSpacing(true);

        Paragraph text2 = new Paragraph(alert.getStatus());
        text2.getStyle()
            .set("margin", "0")
            .set("margin-right", "8px");

        Icon arrowIcon = new Icon(VaadinIcon.ARROW_RIGHT);
        arrowIcon.getStyle()
            .set("width", "20px")
            .set("height", "20px");

        rightSide.add(text2, arrowIcon);
        alertCenterDiv.add(leftSide, rightSide);
        
        alertCenterDiv.addClickListener(e -> UI.getCurrent().navigate(alert.getRoute()));

        return alertCenterDiv;
    }
}