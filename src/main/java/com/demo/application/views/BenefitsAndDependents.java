package com.demo.application.views;



/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.demo.application.views.utils.EnrollmentSection;
import com.demo.application.views.utils.SpacerUtility;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="enrollment", layout=MainLayout.class)
@PageTitle("Enrollment")
public class BenefitsAndDependents extends VerticalLayout {
     public BenefitsAndDependents() {
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
        //  DynamicHeader header = new DynamicHeader("Updating your benefits?", "You can change your benefit enrollment here!");
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
            //  .set("padding-right", "16px"); // Add padding to the right side
 
 
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
 
         // Add test content
        //  for (int i = 0; i < 20; i++) {
        //      scrollContainer.add(new Div("Scroll content " + i));
        //  }

        Div benefitsDiv = new Div();
        benefitsDiv.addClassName("license-counselor-x");
        benefitsDiv.getStyle()
           .set("display", "flex")
           .set("flex-direction", "column")
           .set("gap", "12px");  // Reduced gap between elements
        
        // Benefits Summary Section
        H4 summaryTitle = new H4("Your benefits summary");
        summaryTitle.getStyle().set("margin", "10px 0 8px 0");  // Added bottom margin to title
        
        // Virtual Healthcare Row
        HorizontalLayout virtualRow = new HorizontalLayout();  // Changed to HorizontalLayout
        virtualRow.setWidthFull();
        virtualRow.setJustifyContentMode(JustifyContentMode.BETWEEN);  // Space between label and amount
        virtualRow.setSpacing(false);
        virtualRow.setPadding(false);
        
        Paragraph virtualLabel = new Paragraph("Virtual Healthcare");
        virtualLabel.getStyle().set("margin", "0");
        Paragraph virtualAmount = new Paragraph("$12.50");
        virtualAmount.getStyle().set("margin", "0");
        virtualRow.add(virtualLabel, virtualAmount);
        
        // Behavioral Healthcare Row
        HorizontalLayout behavioralRow = new HorizontalLayout();  // Changed to HorizontalLayout
        behavioralRow.setWidthFull();
        behavioralRow.setJustifyContentMode(JustifyContentMode.BETWEEN);
        behavioralRow.setSpacing(false);
        behavioralRow.setPadding(false);
        
        Paragraph behavioralLabel = new Paragraph("Behavioral Healthcare");
        behavioralLabel.getStyle().set("margin", "0");
        Paragraph behavioralAmount = new Paragraph("$40.00");
        behavioralAmount.getStyle().set("margin", "0");
        behavioralRow.add(behavioralLabel, behavioralAmount);
        
        // Lab Testing Row
        HorizontalLayout labRow = new HorizontalLayout();  // Changed to HorizontalLayout
        labRow.setWidthFull();
        labRow.setJustifyContentMode(JustifyContentMode.BETWEEN);
        labRow.setSpacing(false);
        labRow.setPadding(false);
        labRow.getStyle()
           .set("padding-bottom", "8px")  // Reduced padding
           .set("border-bottom", "1px solid #E6E5E5");
        
        Paragraph labLabel = new Paragraph("Lab Testing");
        labLabel.getStyle().set("margin", "0");
        Paragraph labAmount = new Paragraph("$125.00");
        labAmount.getStyle().set("margin", "0");
        labRow.add(labLabel, labAmount);
        
        // Total Cost Row
        HorizontalLayout totalRow = new HorizontalLayout();
        totalRow.setWidthFull();
        totalRow.setJustifyContentMode(JustifyContentMode.BETWEEN);
        totalRow.setSpacing(false);
        totalRow.setPadding(false);
        
        Paragraph totalLabel = new Paragraph("Total cost of benefits");
        totalLabel.getStyle()
           .set("margin", "0")
           .set("font-weight", "bold");
        Paragraph totalAmount = new Paragraph("$177.50");
        totalAmount.getStyle()
           .set("margin", "0")
           .set("font-weight", "bold");
        totalRow.add(totalLabel, totalAmount);
        
        // HRA Row
        HorizontalLayout hraRow = new HorizontalLayout();
        hraRow.setWidthFull();
        hraRow.setJustifyContentMode(JustifyContentMode.BETWEEN);
        hraRow.setSpacing(false);
        hraRow.setPadding(false);
        hraRow.getStyle()
           .set("padding-bottom", "8px")  // Reduced padding
           .set("border-bottom", "1px solid #E6E5E5");
        
        Paragraph hraLabel = new Paragraph("HRA reimbursement");
        hraLabel.getStyle().set("margin", "0");
        Paragraph hraAmount = new Paragraph("$125.00");
        hraAmount.getStyle().set("margin", "0");
        hraRow.add(hraLabel, hraAmount);
        
        // Net Deduction Row
        HorizontalLayout netRow = new HorizontalLayout();
        netRow.setWidthFull();
        netRow.setJustifyContentMode(JustifyContentMode.BETWEEN);
        netRow.setSpacing(false);
        netRow.setPadding(false);
        
        Paragraph netLabel = new Paragraph("Net deduction from your monthly payroll");
        netLabel.getStyle()
           .set("margin", "0")
           .set("font-weight", "bold");
        Paragraph netAmount = new Paragraph("$52.50");
        netAmount.getStyle()
           .set("margin", "0")
           .set("font-weight", "bold");
        netRow.add(netLabel, netAmount);
        
        // Save Button Container
        Div buttonContainer = new Div();
        buttonContainer.getStyle()
           .set("display", "flex")
           .set("justify-content", "flex-end");
        //    .set("margin-top", "16px");  // Reduced margin
        
        Button saveButton = new Button("Save Changes");
        saveButton.getStyle()
           .set("background-color", "black")
           .set("color", "white")
           .set("padding", "8px 16px")
           .set("border-radius", "4px")
           .set("cursor", "pointer");
        
        buttonContainer.add(saveButton);
        
        // Add all components to main container
        benefitsDiv.add(
           summaryTitle,
           virtualRow,
           behavioralRow,
           labRow,
           totalRow,
           hraRow,
           netRow,
           buttonContainer
        );

        scrollContainer.add(benefitsDiv);

        H4 yourAvailableBen = new H4("Your available Benefits");
        yourAvailableBen.getStyle().set("margin", "10px 0 15px 0");

        scrollContainer.add(yourAvailableBen);

        // Create enrollment sections data
        EnrollmentSection.EnrollmentData[] sections = {
            new EnrollmentSection.EnrollmentData(
                "Virtual Healthcare",
                "This benefit provides access to physicians via live video, phone, and instant messaging."
            ),
            new EnrollmentSection.EnrollmentData(
                "Urgent Care Only",
                "This option provides 24/7 access to doctors for common medical concerns, for the primary members & dependants.",
                "$12.50",
                true  // Show checkmark
            ),
            new EnrollmentSection.EnrollmentData(
                "Primary Care Only",
                "This option provides access to a dedicated primary care physician, for the primary members & dependants.",
                "$15.00",
                false  // Don't show checkmark
            )
        };
        
        // EnrollmentSection enrollmentSection = new EnrollmentSection(sections);

        // Create and add the enrollment section
        EnrollmentSection enrollmentSection = new EnrollmentSection(sections);
        scrollContainer.add(enrollmentSection);  // Add to your layout
        scrollContainer.add(SpacerUtility.createSpacer());


        // Create second enrollment sections data
        EnrollmentSection.EnrollmentData[] sections2 = {
            new EnrollmentSection.EnrollmentData(
                "Behavioral Healthcare",
                "This benefit provides access to comprehensive mental healthcare solutions for everything from workplace issues to grief counseling."
            ),
            new EnrollmentSection.EnrollmentData(
                "Primary Member Only",
                "Provides comprehensive mental healthcare and 24/7 crisis support to the primary member only.",
                "$15.00",
                true  // Don't show checkmark
            ),
            new EnrollmentSection.EnrollmentData(
                "Primary Member & Dependants",
                "Provides comprehensive mental healthcare and 24/7 crisis support to the primary member & family.",
                "$40.00",
                false  // Don't show checkmark
            )
        };
        
        // Create and add the enrollment section
        EnrollmentSection enrollmentSection2 = new EnrollmentSection(sections2);
        scrollContainer.add(enrollmentSection2);  // Add to your layout
        scrollContainer.add(SpacerUtility.createSpacer());


        // Create lab testing enrollment sections data
        EnrollmentSection.EnrollmentData[] sections3 = {
            new EnrollmentSection.EnrollmentData(
                "Lab Testing",
                "This benefit provides access to lab testing on a regular basis."
            ),
            new EnrollmentSection.EnrollmentData(
                "Annual Testing for Primary Member Only",
                "This option provides a general wellness lab test once a year for the primary member only.",
                "$12.50",
                false  // Don't show checkmark
            ),
            new EnrollmentSection.EnrollmentData(
                "Annual Testing for Primary Member & Dependants",
                "This option provides a general wellness lab test once a year for the primary member & for each dependant.",
                "$62.50",
                false  // Don't show checkmark
            ),
            new EnrollmentSection.EnrollmentData(
                "Bi-annual Testing for Primary Member Only",
                "This option provides a general wellness lab test twice a year for the primary member only.",
                "$25.00",
                false  // Don't show checkmark
            ),
            new EnrollmentSection.EnrollmentData(
                "Bi-annual Testing for Primary Member & Dependants",
                "This option provides a general wellness lab test twice a year for the primary member & for each dependant",
                "$125.00",
                true  // Don't show checkmark
            )
        };
        
        // Create and add the enrollment section
        EnrollmentSection enrollmentSection3 = new EnrollmentSection(sections3);
        scrollContainer.add(enrollmentSection3);  // Add to your layout

        scrollContainer.add(SpacerUtility.createSpacer());
        scrollContainer.add(SpacerUtility.createSpacer());

 
         rightWrapper.add(scrollContainer);
         return rightWrapper;
     }
 }