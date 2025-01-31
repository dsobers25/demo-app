/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views;

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.details.Details;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

// need to make dropdowns close when another drop down is opened

@Route(value="virtual-healthcare", layout=MainLayout.class)
@PageTitle("Virtual Healthcare")
class VirtualHealthcareView extends VerticalLayout {
    public VirtualHealthcareView() {
        
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
        DynamicHeader header = new DynamicHeader("Need a doctor?", "Talk to one online!");
        
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

    private Component createDropdown(String title, String content) {
        // Create custom dropdown with arrow at the end
        HorizontalLayout dropdownHeader = new HorizontalLayout();
        dropdownHeader.setWidthFull();
        dropdownHeader.setJustifyContentMode(JustifyContentMode.BETWEEN);
        dropdownHeader.setAlignItems(Alignment.CENTER);
        dropdownHeader.getStyle()
            .set("cursor", "pointer")
            .set("padding", "16px");
    
        // Add the text
        Span text = new Span(title);
        text.getStyle()
            .set("font-size", "16px")
            .set("font-weight", "500")
            .set("color", "#333333");
    
        // Add the arrow icon
        Icon arrow = new Icon(VaadinIcon.ANGLE_DOWN);
        arrow.getStyle()
            .set("margin-left", "auto")
            .set("transition", "transform 0.3s");
    
        dropdownHeader.add(text, arrow);
    
        // Create the content div
        Div contentDiv = new Div();
        contentDiv.setText(content);
        contentDiv.getStyle()
            .set("padding", "16px")
            .set("color", "#666666")
            .set("display", "none");
    
        // Create container for both header and content
        Div dropdownContainer = new Div();
        dropdownContainer.getStyle()
            .set("border-bottom", "1px solid #e5e7eb");
            // .set("width", "100%");
    
        // Add media query for max-width
        // Add media query for responsive width
        // UI.getCurrent().getPage().executeJs(
        //     "const style = document.createElement('style');" +
        //     "style.textContent = `" +
        //     // "  .dropdown-container {" +
        //     // "    width: 100% !important;" +  // Default width for small screens
        //     // "  }" +
        //     "  @media (min-width: 1024px) {" +
        //     "    .dropdown-container {" +
        //     "      max-width: 595.86px !important;" +
        //     "    }" +
        //     "  }`;" +
        //     "document.head.appendChild(style);"
        // );

        dropdownContainer.addClassName("dropdown-container");
    
        dropdownContainer.add(dropdownHeader, contentDiv);

        
    
        // Add click listener to toggle content
        dropdownHeader.addClickListener(e -> {
            String currentDisplay = contentDiv.getStyle().get("display");
            if ("none".equals(currentDisplay)) {
                contentDiv.getStyle().set("display", "block");
                arrow.getStyle().set("transform", "rotate(180deg)");
            } else {
                contentDiv.getStyle().set("display", "none");
                arrow.getStyle().set("transform", "rotate(0deg)");
            }
        });
    
        return dropdownContainer;
    }
    
    private Component createRightContent() {
        Div rightWrapper = new Div();
        rightWrapper.addClassName("right-wrapper");
        rightWrapper.getStyle()
            // .set("width", "70%")
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
        
        H4 mainText = new H4("Virtual Primary Care & Virtual Urgent Care");
        Paragraph subText = new Paragraph("powered by Recuro Health");
        scrollContainer.add(mainText, subText);
    
        // Add all dropdowns
        scrollContainer.add(
            createDropdown(
                "Dedicated, board-certified primary care physician",
                "Select a board-certified physician to create a personalized care plan and receive ongoing medical support."
            ),
            createDropdown(
                "Virtual urgent care visits",
                "Connect with a doctor 24/7 for non-emergency medical concerns."
            ),
            createDropdown(
                "Preventive care and wellness",
                "Get regular check-ups and screenings to maintain your health."
            ),
            createDropdown(
                "Chronic condition management",
                "Receive ongoing care and support for managing chronic conditions."
            ),
            createDropdown(
                "Prescription management",
                "Get prescriptions and refills managed by your healthcare team."
            ),
            createDropdown(
                "Lab work and testing",
                "Order and review lab tests with your doctor virtually."
            ),
            createDropdown(
                "Specialist referrals",
                "Get referrals to specialists when needed for your care."
            )
        );
        
        Div openRecuroHealthButton = new Div("Open Recuro Health");
            openRecuroHealthButton.getStyle()
                .set("max-width", "595.86px")
                .set("height", "40px")
                .set("background-color", "green")
                .set("color", "#FFFFFF")
                .set("padding", "3px")
                .set("box-sizing", "border-box")
                
                .set("border-radius", "5px")
                .set("display", "flex")  // Add this
                .set("justify-content", "center")
                .set("align-items", "center")  // Fix typo
                .set("margin-bottom", "33px")     // Add some space above button
                .set("cursor", "pointer");      // Add pointer cursor

                openRecuroHealthButton.addClickListener(e -> UI.getCurrent().navigate("/recuro-health"));

        
        rightWrapper.add(scrollContainer);
        rightWrapper.add(openRecuroHealthButton);
        return rightWrapper;
    }
}
