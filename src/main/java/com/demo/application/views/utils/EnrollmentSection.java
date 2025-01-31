package com.demo.application.views.utils;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class EnrollmentSection extends Div {
    public static class EnrollmentData {
        private final String title;
        private final String description;
        private final String price;  // Optional, can be null
        private final boolean showCheckmark; // New boolean for checkmark
 
        public EnrollmentData(String title, String description, String price, boolean showCheckmark) {
            this.title = title;
            this.description = description;
            this.price = price;
            this.showCheckmark = showCheckmark;
        }
 
        public EnrollmentData(String title, String description) {
            this(title, description, null, false);
        }
    }
 
    public EnrollmentSection(EnrollmentData... sections) {
        addClassName("license-counselor-x");
        getStyle()
            .set("padding", "24px")
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("gap", "24px")
            .set("border", "1px solid #E6E5E5")
            .set("border-radius", "8px");
 
        for (int i = 0; i < sections.length; i++) {
            EnrollmentData section = sections[i];
            
            // For sections with price, use HorizontalLayout
            if (section.price != null) {
                HorizontalLayout row = new HorizontalLayout();
                row.setWidthFull();
                row.setJustifyContentMode(JustifyContentMode.BETWEEN);
                row.setSpacing(false);
                row.setPadding(false);
 
                // Left side content
                Div leftContent = new Div();
                leftContent.getStyle()
                    .set("display", "flex")
                    .set("flex-direction", "column")
                    .set("gap", "8px");
 
                H4 title = new H4(section.title);
                title.getStyle().set("margin", "0");
 
                Paragraph description = new Paragraph(section.description);
                description.getStyle().set("margin", "0");
 
                leftContent.add(title, description);
 
                // Right side content
                HorizontalLayout rightContent = new HorizontalLayout();
                rightContent.setSpacing(true);
                rightContent.setAlignItems(Alignment.CENTER);
 
                // Price
                H4 price = new H4(section.price);
                price.getStyle()
                    .set("margin", "0")
                    .set("color", "var(--lumo-primary-text-color)");
 
                rightContent.add(price);
 
                // Add checkmark if needed
                if (section.showCheckmark) {
                    Div checkIcon = new Div();
                    checkIcon.getElement().setProperty("innerHTML", 
                        "<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='currentColor' style='width: 20px; height: 20px;'>" +
                        "<path fill-rule='evenodd' d='M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12Zm13.36-1.814a.75.75 0 1 0-1.22-.872l-3.236 4.53L9.53 12.22a.75.75 0 0 0-1.06 1.06l2.25 2.25a.75.75 0 0 0 1.14-.094l3.75-5.25Z' clip-rule='evenodd'></path>" +
                        "</svg>");
                    checkIcon.getStyle()
                        .set("color", "var(--alertPrimary)")
                        .set("display", "flex")
                        .set("align-items", "center")
                        .set("margin-left", "8px");
                    rightContent.add(checkIcon);
                }
 
                row.add(leftContent, rightContent);
 
                // Add border if not last section
                if (i < sections.length - 1) {
                    row.getStyle()
                        .set("padding-bottom", "16px")
                        .set("border-bottom", "1px solid #E6E5E5");
                }
 
                add(row);
            } 
            // For sections without price, use Div
            else {
                Div row = new Div();
                row.getStyle()
                    .set("display", "flex")
                    .set("flex-direction", "column");
 
                H4 title = new H4(section.title);
                title.getStyle().set("margin", "0");
 
                Paragraph description = new Paragraph(section.description);
                description.getStyle().set("margin", "8px 0 0 0");
 
                row.add(title, description);
 
                // Add border if not last section
                if (i < sections.length - 1) {
                    row.getStyle()
                        .set("padding-bottom", "16px")
                        .set("border-bottom", "1px solid #E6E5E5");
                }
 
                add(row);
            }
        }
 
        // Add footer note with info icon
        HorizontalLayout footerLayout = new HorizontalLayout();
        footerLayout.setSpacing(false);
        footerLayout.setAlignItems(Alignment.CENTER);
        footerLayout.getStyle()
            .set("gap", "8px")
            .set("margin-top", "16px")
            .set("border-top", "1px solid #E6E5E5")
            .set("padding-top", "10px");
 
        // Info icon
        Div infoIcon = new Div();
        infoIcon.getElement().setProperty("innerHTML", 
            "<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='currentColor' style='width: 24px; height: 24px;'>" +
            "<path fill-rule='evenodd' d='M2.25 12c0-5.385 4.365-9.75 9.75-9.75s9.75 4.365 9.75 9.75-4.365 9.75-9.75 9.75S2.25 17.385 2.25 12Zm8.706-1.442c1.146-.573 2.437.463 2.126 1.706l-.709 2.836.042-.02a.75.75 0 0 1 .67 1.34l-.04.022c-1.147.573-2.438-.463-2.127-1.706l.71-2.836-.042.02a.75.75 0 1 1-.671-1.34l.041-.022ZM12 9a.75.75 0 1 0 0-1.5.75.75 0 0 0 0 1.5Z' clip-rule='evenodd'></path>" +
            "</svg>");
        infoIcon.getStyle()
            .set("color", "var(--alertPrimary)")
            .set("display", "flex")
            .set("align-items", "center");
 
        // Footer text
        Paragraph footerNote = new Paragraph("This benefit is eligible for reimbursement under your 105b Healthcare Reimbursement Arrangement.");
        footerNote.getStyle()
            .set("margin", "0")
            .set("font-weight", "bold");
 
        footerLayout.add(infoIcon, footerNote);
        add(footerLayout);
    }
 }