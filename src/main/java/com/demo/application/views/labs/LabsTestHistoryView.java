package com.demo.application.views.labs;

import com.demo.application.alert.AlertService;
import com.demo.application.history.TestHistoryService;
import com.demo.application.views.MainLayout;
import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="labs/abc123", layout=MainLayout.class)
@PageTitle("Labs")
class LabsTestHistoryView extends VerticalLayout {
    public LabsTestHistoryView() {
        setPadding(false);
        setSpacing(false);
        setSizeFull();
        
        VerticalLayout mainContainer = new VerticalLayout();
        mainContainer.setPadding(false);
        mainContainer.setSpacing(false);
        mainContainer.setSizeFull();
        
        
        HorizontalLayout contentWrapper = new HorizontalLayout();
        contentWrapper.setHeightFull();
        contentWrapper.setWidthFull();
        contentWrapper.setSpacing(false);
        contentWrapper.setPadding(false);
        contentWrapper.getStyle()
            .set("flex", "1")
            .set("min-height", "0");
        
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
            .set("height", "100%")
            .set("overflow", "hidden")
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("margin", "0")
            .set("padding-right", "16px");

        Component originalContent = SideNav.leftSideContent();
        
        Div scrollContainer = new Div();
        scrollContainer.getStyle()
            .set("overflow-y", "auto")
            .set("height", "100%")
            .set("flex", "1")
            .set("min-height", "0")
            .set("width", "100%")
            .set("display", "flex")
            .set("justify-content", "flex-end");
        
        scrollContainer.add(originalContent);
        leftWrapper.add(scrollContainer);
        
        return leftWrapper;
    }

    private Component createRightContent() {
        Div rightWrapper = new Div();
        rightWrapper.addClassName("right-wrapper");
        rightWrapper.getStyle()
            .set("height", "100%")
            .set("overflow", "hidden")
            .set("display", "flex")
            .set("flex-direction", "column");

        Div scrollContainer = new Div();
        scrollContainer.getStyle()
            .set("overflow-y", "auto")
            .set("height", "100%")
            .set("flex", "1")
            .set("min-height", "0")
            .set("background", "#FFFFFF")
            .set("padding", "var(--lumo-space-m)");

        // Lab Test Info Section
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.addClassName("license-counselor");
        horizontalLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
        horizontalLayout.getStyle().set("margin-bottom", "40px");  // Add spacing after lab test info

        // Left side content
        Div leftDiv = new Div();
        leftDiv.getStyle().set("display", "flex").set("flex-direction", "column");

        H4 labTest = new H4("Lab Test");
        labTest.getStyle()
            .set("margin", "0 0 5px 0")
            .set("font-weight", "600");

        // Left side dates
        Paragraph orderedOnLabel = new Paragraph("Ordered on:");
        orderedOnLabel.getStyle()
            .set("margin", "0")
            .set("font-size", "14px")
            .set("color", "var(--lumo-secondary-text-color)");

        Paragraph orderedDate = new Paragraph("Jan 15th 2025");
        orderedDate.getStyle()
            .set("margin", "0 0 16px 0");

        Paragraph drawnOnLabel = new Paragraph("Drawn on:");
        drawnOnLabel.getStyle()
            .set("margin", "0")
            .set("font-size", "14px")
            .set("color", "var(--lumo-secondary-text-color)");

        Paragraph drawnDate = new Paragraph("Jan 22nd 2025");
        drawnDate.getStyle()
            .set("margin", "0 0 16px 0");

        Paragraph lastUpdatedLabel = new Paragraph("Last updated on:");
        lastUpdatedLabel.getStyle()
            .set("margin", "0")
            .set("font-size", "14px")
            .set("color", "var(--lumo-secondary-text-color)");

        Paragraph lastUpdatedDate = new Paragraph("Jan 19th 2025");
        lastUpdatedDate.getStyle().set("margin", "0");

        // Right side content
        Div rightDiv = new Div();
        rightDiv.getStyle().set("display", "flex").set("flex-direction", "column");

        Paragraph statusLabel = new Paragraph("Status:");
        statusLabel.getStyle()
            .set("margin", "0")
            .set("font-size", "14px")
            .set("color", "var(--lumo-secondary-text-color)");

        Paragraph statusValue = new Paragraph("Final");
        statusValue.getStyle()
            .set("margin", "0 0 16px 0");

        Paragraph panelsLabel = new Paragraph("Panels ordered:");
        panelsLabel.getStyle()
            .set("margin", "0")
            .set("font-size", "14px")
            .set("color", "var(--lumo-secondary-text-color)");

        UnorderedList panelsList = new UnorderedList();
        panelsList.getStyle()
            .set("margin", "0")
            .set("padding-left", "20px");

        String[] panels = {
            "Complete Blood Count with Differential",
            "Comprehensive Metabolic Panel",
            "Hemoglobin A1c with EAG",
            "Lipid Panel"
        };

        for (String panel : panels) {
            ListItem item = new ListItem(panel);
            item.getStyle().set("margin", "4px 0");
            panelsList.add(item);
        }

        leftDiv.add(labTest, orderedOnLabel, orderedDate, drawnOnLabel, drawnDate, lastUpdatedLabel, lastUpdatedDate);
        rightDiv.add(statusLabel, statusValue, panelsLabel, panelsList);
        horizontalLayout.add(leftDiv, rightDiv);
        scrollContainer.add(horizontalLayout);

        // Biomarkers Section
        Div alertCenterDiv = new Div();
        alertCenterDiv.getStyle().set("margin-bottom", "15px");
        H4 text = new H4("Biomarkers Out Of Range");
        alertCenterDiv.add(text);
        alertCenterDiv.addClassName("alert-center-dim");
        scrollContainer.add(alertCenterDiv);

        String[][] data = {
            {"ALT (SGPT)", "HIGH", "labs/bioMarker/001545"},
            {"AST (SGOT)", "HIGH", "labs/bioMarker/001545"},
            {"BUN", "HIGH", "labs/bioMarker/001545"},
            {"Glucose", "HIGH", "labs/bioMarker/001545"},
            {"Hemoglobin A1c", "HIGH", "labs/bioMarker/001545"},
            {"Protein, Total", "LOW", "labs/bioMarker/001545"},
            {"Sodium", "HIGH", "labs/bioMarker/001545"}
        };

        // Add alerts with spacing after the last one
        Component[] alerts = AlertService.getAlerts(data).stream()
            .map(AlertService::createAlertDiv)
            .toArray(Component[]::new);
        if (alerts.length > 0) {
            alerts[alerts.length - 1].getStyle().set("margin-bottom", "40px");
        }
        for (Component alert : alerts) {
            scrollContainer.add(alert);
        }

        // Discuss Lab Section
        Div discussLabSectionDiv = new Div();
        discussLabSectionDiv.addClassName("license-counselor");
        discussLabSectionDiv.getStyle()
            .set("background-color", "#e7f5e9")
            .set("margin-bottom", "40px")
            .set("padding", "16px")
            .set("border-radius", "16px")
            .set("border", "1px solid #E6E5E5");

        H4 discussLabMainText = new H4("Discuss your lab results with a doctor:");
        Paragraph discussLabSubText = new Paragraph("Schedule an appointment with a primary care doctor to discuss your lab results.");
        
        Anchor goToVirtualAnchor = new Anchor("virtual-healthcare", "Go to Virtual Healthcare");
        goToVirtualAnchor.getStyle()
            .set("display", "block")
            .set("text-align", "right")
            .set("margin-top", "16px")
            .set("text-decoration", "none")
            .set("color", "#1976d2")
            .set("cursor", "pointer");

        discussLabSectionDiv.add(discussLabMainText, discussLabSubText, goToVirtualAnchor);
        scrollContainer.add(discussLabSectionDiv);

        // Complete Blood Count Section
        Div sectionDiv = new Div();
        sectionDiv.getStyle().set("margin-bottom", "15px");
        H4 text2 = new H4("Complete Blood Count with Differential");
        sectionDiv.add(text2);
        sectionDiv.addClassName("alert-center-dim");
        scrollContainer.add(sectionDiv);

        String[][] data2 = {
            {"Baso (Absolute)", "", "labs/bioMarker/001545"},
            {"Baso (Absolute)", "", "labs/bioMarker/001545"},
            {"BUN", "HIGH", "labs/bioMarker/001545"},
            {"Esos (Absolute)", "", "labs/bioMarker/001545"},
            {"Esos (Absolute)", "", "labs/bioMarker/001545"},
            {"Glucose", "HIGH", "labs/bioMarker/001545"},
            {"Protein, Total", "LOW", "labs/bioMarker/001545"},
            {"Sodium", "HIGH", "labs/bioMarker/001545"}
        };

        // Add alerts with spacing after the last one
        Component[] alerts2 = AlertService.getAlerts(data2).stream()
            .map(AlertService::createAlertDiv)
            .toArray(Component[]::new);
        if (alerts2.length > 0) {
            alerts2[alerts2.length - 1].getStyle().set("margin-bottom", "40px");
        }
        for (Component alert : alerts2) {
            scrollContainer.add(alert);
        }

        // Comprehensive Metabolic Panel Section
        Div section2Div = new Div();
        section2Div.getStyle().set("margin-bottom", "15px");
        H4 text3 = new H4("Comprehensive Metabolic Panel");
        section2Div.add(text3);
        section2Div.addClassName("alert-center-dim");
        scrollContainer.add(section2Div);

        String[][] data3 = {
            {"A/G Ratio", "", "labs/bioMarker/001545"},
            {"Albumin", "", "labs/bioMarker/001545"},
            {"ALT (SGPT)", "HIGH", "labs/bioMarker/001545"},
            {"AST (SGOT)", "HIGH", "labs/bioMarker/001545"}
        };

        // Add final set of alerts
        AlertService.getAlerts(data3).forEach(alert -> 
            scrollContainer.add(AlertService.createAlertDiv(alert))
        );

        // Add alerts with spacing after the last one
        Component[] alerts3 = AlertService.getAlerts(data3).stream()
            .map(AlertService::createAlertDiv)
            .toArray(Component[]::new);
        if (alerts3.length > 0) {
            alerts3[alerts3.length - 1].getStyle().set("margin-bottom", "40px");
        }
        for (Component alert : alerts3) {
            scrollContainer.add(alert);
        }

        // Hemoglobin A1c Section
        Div section3Div = new Div();
        section3Div.getStyle().set("margin-bottom", "15px");
        H4 text4 = new H4("Hemoglobin A1c with EAG");
        section3Div.add(text4);
        section3Div.addClassName("alert-center-dim");
        scrollContainer.add(section3Div);

        String[][] data4 = {
        {"Estim. Avg Glu (eAG)", "", "labs/bioMarker/001545"},
        {"Hemoglobin A1c", "HIGH", "labs/bioMarker/001545"}
        };

        // Add alerts
        AlertService.getAlerts(data4).forEach(alert -> 
        scrollContainer.add(AlertService.createAlertDiv(alert))
        );

        // Add alerts with spacing after the last one
        Component[] alerts4 = AlertService.getAlerts(data4).stream()
            .map(AlertService::createAlertDiv)
            .toArray(Component[]::new);
        if (alerts4.length > 0) {
            alerts4[alerts4.length - 1].getStyle().set("margin-bottom", "40px");
        }
        for (Component alert : alerts4) {
            scrollContainer.add(alert);
        }

        // Lipid Panel Section
        Div section4Div = new Div();
        section4Div.getStyle().set("margin-bottom", "15px");
        H4 text5 = new H4("Lipid Panel");
        section4Div.add(text5);
        section4Div.addClassName("alert-center-dim");
        scrollContainer.add(section4Div);

        String[][] data5 = {
        {"Cholesterol, Total", "", "labs/bioMarker/001545"},
        {"HDL Cholesterol", "", "labs/bioMarker/001545"},
        {"LDL Chol Calc (NIH)", "", "labs/bioMarker/001545"},
        {"Triglycerides", "", "labs/bioMarker/001545"}
        };

        // Add alerts
        AlertService.getAlerts(data5).forEach(alert -> 
        scrollContainer.add(AlertService.createAlertDiv(alert))
        );

        // Add alerts with spacing after the last one
        Component[] alerts5 = AlertService.getAlerts(data4).stream()
            .map(AlertService::createAlertDiv)
            .toArray(Component[]::new);
        if (alerts5.length > 0) {
            alerts5[alerts5.length - 1].getStyle().set("margin-bottom", "40px");
        }
        for (Component alert : alerts5) {
            scrollContainer.add(alert);
        }

        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }
}