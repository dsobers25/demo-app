/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views.benefits;

import com.demo.application.views.MainLayout;
import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.BenefitsSideNav;
import com.demo.application.views.sidenav.SideNav;
import com.demo.application.views.utils.SectionUtility;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="benefits/health-insurance", layout=MainLayout.class)
@PageTitle("Benefits Health Insurance")
class BenefitsHealthInsuranceView extends VerticalLayout {
    public BenefitsHealthInsuranceView() {
        
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
        // DynamicHeader header = new DynamicHeader("Welcome John!", "What can we do for you today?");
        DynamicHeader header = new DynamicHeader("You've got benefits!", "Let us explain them!");
        
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
        // }\

        // Benefits Section

        Paragraph[][] virtualHealthcareBenefitsLeftSection = new Paragraph[][] {
            new Paragraph[]{new Paragraph("Annual deductible")},
            new Paragraph[]{new Paragraph("HSA funding")},
            new Paragraph[]{new Paragraph("Preventive care")},
            new Paragraph[]{new Paragraph("Office visit, outpatient services"),
                            new Paragraph("(after deductible)")},
            new Paragraph[]{new Paragraph("Inpatient hospital"),
                            new Paragraph("(after deductible, with precertification)")},
            new Paragraph[]{new Paragraph("30-Day retail prescriptions"),
                            new Paragraph("(after deductible)")},
            new Paragraph[]{new Paragraph("Out-of-pocket maximum"),
                            new Paragraph("(includes deductible)")}
        };

        Paragraph[][] virtualHealthcareBenefitsRightSection = new Paragraph[][] {
            new Paragraph[]{new Paragraph("Self only: $1,800/$3,600"),
                            new Paragraph("Family: $3,600/$7,200")},
            new Paragraph[]{new Paragraph("You only")},
            new Paragraph[]{new Paragraph("Plan pays 100%"),
                            new Paragraph("Deductible waived if in-network")},
            new Paragraph[]{new Paragraph("Plan pays 80%/60%")},
            new Paragraph[]{new Paragraph("Plan pays 80%/60%")},
            new Paragraph[]{new Paragraph("$15 generic"),
                            new Paragraph("$45 brand-name drug on Aetna Performance"),
                            new Paragraph("Drug List"),
                            new Paragraph("$65 other brand-name drug")},
            new Paragraph[]{new Paragraph("Self only: $4,700/$8,650"),
                            new Paragraph("Family: $8,100/$16,300")}
        };
        

        SectionUtility section = new SectionUtility(virtualHealthcareBenefitsLeftSection, virtualHealthcareBenefitsRightSection);

        healthInsuranceSections(section, scrollContainer, true);

        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }

    public void healthInsuranceSections(SectionUtility section,
    Div scrollContainer, boolean topMargin) {
        // H3 topLine = new H3("Virtual Healthcare");
        // H3 topLine = new H3(sectionTitle);
        // if(!topMargin) {
        //     topLine.getStyle().set("margin-top", "56px");
        // }

        // topLine.getStyle().set("margin-bottom", "5px");
            // contactAndTime.add(number, timeAndDay);
    
        // scrollContainer.add(topLine);

        // Main container
        Div mainDiv = new Div();
        mainDiv.addClassName("alert-center-dim");
        mainDiv.getStyle()
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("gap", "16px")
            .set("padding", "0px")
            .set("border-bottom", "2px solid #E6E4E4")
            .set("border-top", "2px solid #E6E4E4");

        // contentDiv added for each row
        for(int i = 0; i < section.getRows(); i++) {

        // Top content container
        Div contentDiv = new Div();
        contentDiv.getStyle()
            .set("display", "flex")
            .set("justify-content", "space-between")
            .set("width", "100%");

        if(i != section.getRows() -1) {
            contentDiv.getStyle()
            .set("border-bottom", "2px solid #E6E4E4");
        }

        // Left side
        Div leftSide = new Div();
        // leftSide.addClassName("remove-left-side");
        leftSide.getStyle()
            .set("align-items", "center");

        // Paragraph leftline1 = new Paragraph("Benefit");
        // Paragraph leftline1 = new Paragraph(left);
        // leftSide.add(leftline1);


        // leftLines array needs to be added like rightLines
        for(Paragraph p : section.getLeftside()[i]) {
            p.getStyle().set("margin", "0")
            .set("font-size", "12px")
            .set("align-items", "center");
            leftSide.add(p);

            // System.out.println(p.getText());
        }

        // Right side
        Div rightSide = new Div();
        rightSide.addClassName("shift-text");
        rightSide.getStyle()
            .set("max-width", "60%") // Adjust as needed for text wrapping
            .set("text-align", "right") // Add this to align all content right
            .set("margin-left", "auto"); // This will push the div to the right


        for(Paragraph p : section.getRightside()[i]) {
            p.getStyle().set("margin", "0")
            .set("font-size", "16px")
            .set("font-weight", "500");
            rightSide.add(p);
        }

        // Add left and right to content container
        contentDiv.add(leftSide, rightSide);
        // contentDiv.add(leftSide);

        
        // Add all components to main container
        mainDiv.add(contentDiv);
    }
    scrollContainer.add(mainDiv);

    }
}