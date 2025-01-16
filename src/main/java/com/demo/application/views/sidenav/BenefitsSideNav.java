package com.demo.application.views.sidenav;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.FlexComponent.JustifyContentMode;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public class BenefitsSideNav {
    private static Map<String, HorizontalLayout> menuItems = new HashMap<>();

    public BenefitsSideNav() {

    }

    private static void pageMapper(HorizontalLayout benefitsVHealthcareSideItemLayout,
    HorizontalLayout healthNavigatorSideItemLayout, HorizontalLayout benefitsHealthInsuranceSideItemLayout,
    HorizontalLayout benefitsDentalSideItemLayout, HorizontalLayout benefitsVisionSideItemLayout
    ) {
            menuItems.put("benefits/virtual-healthcare", benefitsVHealthcareSideItemLayout); // homepage
            menuItems.put("health-navigator", healthNavigatorSideItemLayout);
            menuItems.put("benefits/health-insurance", benefitsHealthInsuranceSideItemLayout);
            menuItems.put("benefits/dental", benefitsDentalSideItemLayout);
            menuItems.put("benefits/vision", benefitsVisionSideItemLayout);
            //
        }

        

        private static void updateActiveMenuItem(String location) {
            menuItems.values().forEach(item -> {
                item.removeClassName("active-side-menu-item");
                item.getStyle().remove("border-left");
            });
                    
            if (menuItems.containsKey(location)) {
                HorizontalLayout activeItem = menuItems.get(location);
                activeItem.addClassName("active-side-menu-item");
                activeItem.getStyle().set("border-left", "9px solid orange");
            }
        }
    
        public static Component leftSideContent() {
            var leftContainer = new Div();
            leftContainer.addClassName("left-container");
            leftContainer.getStyle()
                .set("width", "100%")
                .set("height", "100%")
                .set("background", "#F7F8F9")
                .set("display", "flex")
                .set("flex-direction", "column")
                .set("padding", "var(--lumo-space-m)")
                .set("padding-left", "0") // Remove left padding
                .set("padding-right", "10%") // Remove right padding
                .set("box-sizing", "border-box")
                .set("overflow-y", "auto") // Change to auto instead of always showing
                .set("align-items", "flex-end"); // Align items to the right side

    
            // Add some test content to demonstrate scrolling
            // for (int i = 0; i < 20; i++) {
            //     leftContainer.add(new Div("Scroll content " + i));
            // }
    
            Div benefitsVirtualHealthcareDiv = new Div();
            HorizontalLayout benefitsVirtualHealthcareSideItemLayout = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer = new Div();

            textContainer.getStyle().set("padding-left", "8px")
                .set("width", "100%");  // Make text container take full width
    
            Paragraph benefitsVirtualHealthcareMainText = new Paragraph("Virtual Healthcare");
            Icon arrow = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph benefitsVirtualHealthcareSubText = new Paragraph("By Recuro");
    
            // Style the arrow
            arrow.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            benefitsVirtualHealthcareMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            benefitsVirtualHealthcareSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer.add(benefitsVirtualHealthcareMainText, benefitsVirtualHealthcareSubText);
    
            // Configure the HorizontalLayout
            benefitsVirtualHealthcareSideItemLayout.setWidthFull();
            benefitsVirtualHealthcareSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            benefitsVirtualHealthcareSideItemLayout.setAlignItems(Alignment.CENTER);
            benefitsVirtualHealthcareSideItemLayout.add(textContainer, arrow);  // Add textContainer instead of homeParagraph
            benefitsVirtualHealthcareDiv.add(benefitsVirtualHealthcareSideItemLayout);
            
            // Single click listener for home section
            Component[] benefitsVirtualHealthcareComponents = {benefitsVirtualHealthcareDiv, benefitsVirtualHealthcareSideItemLayout,
                 textContainer, benefitsVirtualHealthcareMainText, benefitsVirtualHealthcareSubText, arrow};
            for (Component component : benefitsVirtualHealthcareComponents) {
                component.getElement().addEventListener("click", e -> {
                    UI.getCurrent().navigate("benefits/virtual-healthcare");
                    updateActiveMenuItem("benefits/virtual-healthcare");
                }).addEventData("event.stopPropagation()");
            }

            // Update the click listeners for home
            // textContainer.addClickListener(e -> {
            //     UI.getCurrent().navigate("");
            //     String location = UI.getCurrent().getInternals().getActiveViewLocation().getPathWithQueryParameters();
            //     updateActiveMenuItem(location);
            // });
            
            
            Div healthNavigatorDiv = new Div();

            HorizontalLayout healthNavigatorSideItemLayout = new HorizontalLayout();
                // Create a container div for the text content with orange left border
                Div textContainer5 = new Div();
                textContainer5.getStyle()
                    // .set("border-left", "9px solid orange")
                    .set("padding-left", "8px");  // Add some spacing between border and text
        
                Paragraph healthNavigatorMainText = new Paragraph("Health Navigator");
                Icon arrow5 = new Icon(VaadinIcon.ARROW_RIGHT);
                Paragraph healthNavigatorSubText = new Paragraph("Support when navigating healthcare");
        
                // Style the arrow
                arrow5.getStyle()
                    .set("font-size", "10px")
                    .set("margin-top", "10px");
        
                // Style the paragraph
                healthNavigatorMainText.getStyle()
                    .set("font-size", "16px")
                    .set("margin-bottom", "0px");
        
                healthNavigatorSubText.getStyle()
                    .set("font-size", "12px")
                    .set("margin-top", "0px");
        
                // Add both paragraphs to the text container
                textContainer5.add(healthNavigatorMainText, healthNavigatorSubText);
                // Configure the HorizontalLayout
                healthNavigatorSideItemLayout.setWidthFull();
                healthNavigatorSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
                healthNavigatorSideItemLayout.setAlignItems(Alignment.CENTER);
                healthNavigatorSideItemLayout.add(textContainer5, arrow5);  // Add textContainer instead of homeParagraph
                healthNavigatorDiv.add(healthNavigatorSideItemLayout);

            // Single click listener for virtual healthcare section
            Component[] healthNavigatorComponents = {healthNavigatorDiv, healthNavigatorSideItemLayout, textContainer5, 
                healthNavigatorMainText, healthNavigatorSubText, arrow5};

            for (Component component : healthNavigatorComponents) {
                component.getElement().addEventListener("click", e -> {
                UI.getCurrent().navigate("health-navigator");
                updateActiveMenuItem("health-navigator");
            }).addEventData("event.stopPropagation()");
        }
    
            Div benefitsHealthInsuranceDiv = new Div();
            HorizontalLayout benefitsHealthInsuranceSideItemLayout = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer2 = new Div();
            textContainer2.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph benefitsHealthInsuranceMainText = new Paragraph("Health Insurance");
            Icon arrow2 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph benefitsHealthInsuranceSubText = new Paragraph("by Aetna");
    
            // Style the arrow
            arrow2.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            benefitsHealthInsuranceMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
                benefitsHealthInsuranceSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer2.add(benefitsHealthInsuranceMainText, benefitsHealthInsuranceSubText);
            // Configure the HorizontalLayout
            benefitsHealthInsuranceSideItemLayout.setWidthFull();
            benefitsHealthInsuranceSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            benefitsHealthInsuranceSideItemLayout.setAlignItems(Alignment.CENTER);
            benefitsHealthInsuranceSideItemLayout.add(textContainer2, arrow2);  // Add textContainer instead of homeParagraph
            benefitsHealthInsuranceDiv.add(benefitsHealthInsuranceSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] benefitsHealthInsuranceComponents = {benefitsHealthInsuranceDiv, benefitsHealthInsuranceSideItemLayout, textContainer2, 
            benefitsHealthInsuranceMainText, benefitsHealthInsuranceSubText, arrow2};

        for (Component component : benefitsHealthInsuranceComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("benefits/health-insurance");
            updateActiveMenuItem("benefits/health-insurance");
        }).addEventData("event.stopPropagation()");
        }

        Div benefitsDentalDiv = new Div();

        HorizontalLayout benefitsDentalSideItemLayout = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer3 = new Div();
            textContainer3.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph benefitsDentalMainText = new Paragraph("Dental");
            Icon arrow3 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph benefitsDentalSubText = new Paragraph("by SunLife");
    
            // Style the arrow
            arrow3.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            benefitsDentalMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            benefitsDentalSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer3.add(benefitsDentalMainText, benefitsDentalSubText);
            // Configure the HorizontalLayout
            benefitsDentalSideItemLayout.setWidthFull();
            benefitsDentalSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            benefitsDentalSideItemLayout.setAlignItems(Alignment.CENTER);
            benefitsDentalSideItemLayout.add(textContainer3, arrow3);  // Add textContainer instead of homeParagraph
            benefitsDentalDiv.add(benefitsDentalSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] benefitsDentalComponents = {benefitsDentalDiv, benefitsDentalSideItemLayout, textContainer3, 
            benefitsDentalMainText, benefitsDentalSubText, arrow3};

        for (Component component : benefitsDentalComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("benefits/dental");
            updateActiveMenuItem("benefits/dental");
        }).addEventData("event.stopPropagation()");
        }
        
              
        Div benefitsVisionDiv = new Div();

        HorizontalLayout benefitsVisionSideItemLayout = new HorizontalLayout();
            // Create a container div for the text content with orange left border
            Div textContainer4 = new Div();
            textContainer4.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph benefitsVisionMainText = new Paragraph("Vision");
            Icon arrow4 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph benefitsVisionSubText = new Paragraph("by VSP Vision Care");
    
            // Style the arrow
            arrow4.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            benefitsVisionMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            benefitsVisionSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer4.add(benefitsVisionMainText, benefitsVisionSubText);
            // Configure the HorizontalLayout
            benefitsVisionSideItemLayout.setWidthFull();
            benefitsVisionSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            benefitsVisionSideItemLayout.setAlignItems(Alignment.CENTER);
            benefitsVisionSideItemLayout.add(textContainer4, arrow4);  // Add textContainer instead of homeParagraph
            benefitsVisionDiv.add(benefitsVisionSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] benefitsVisionComponents = {benefitsVisionDiv, benefitsVisionSideItemLayout, textContainer4, 
            benefitsVisionMainText, benefitsVisionSubText, arrow4};

        for (Component component : benefitsVisionComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("benefits/vision");
            updateActiveMenuItem("benefits/vision");
        }).addEventData("event.stopPropagation()");
        }



        
        pageMapper(benefitsVirtualHealthcareSideItemLayout, healthNavigatorSideItemLayout, benefitsHealthInsuranceSideItemLayout,
        benefitsDentalSideItemLayout, benefitsVisionSideItemLayout);

        // Set initial active state for home and add navigation listener
        UI.getCurrent().access(() -> {
            // Get current location
            String currentLocation = UI.getCurrent().getInternals().getActiveViewLocation().getPathWithQueryParameters();
            // If we're at the root path (empty string), activate home
            updateActiveMenuItem(currentLocation.isEmpty() ? "" : currentLocation);
        });

        // Add listener for subsequent navigation
        UI.getCurrent().addBeforeEnterListener(event -> {
            String location = event.getLocation().getPath();
            updateActiveMenuItem(location);
        });

        List<Div> divs = new ArrayList<>();
        divs.add(benefitsVirtualHealthcareDiv);
        divs.add(healthNavigatorDiv);
        divs.add(benefitsHealthInsuranceDiv);
        divs.add(benefitsDentalDiv);
        divs.add(benefitsVisionDiv);

        // Update the div styling in the loop
        for(Div div : divs) {
            div.addClassName("side-menu-items");
            div.getStyle()
                .set("width", "255px") // Fixed width instead of percentage
                .set("margin-bottom", "16px")
                .set("margin-right", "0") // Align to the right
                .set("cursor", "pointer");
            leftContainer.add(div);
        }

        return leftContainer;
    }

}