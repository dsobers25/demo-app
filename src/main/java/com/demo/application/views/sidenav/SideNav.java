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

public class SideNav {
    private static Map<String, HorizontalLayout> menuItems = new HashMap<>();

    public SideNav() {

    }

    private static void pageMapper(HorizontalLayout homeSideItemLayout, HorizontalLayout virtualHealthcareSideItemLayout,
    HorizontalLayout behavioralSideItemLayout, HorizontalLayout labsSideItemLayout) {
            menuItems.put("", homeSideItemLayout); // homepage
            menuItems.put("virtual-healthcare", virtualHealthcareSideItemLayout);
            menuItems.put("behavioral-healthcare", behavioralSideItemLayout);
            menuItems.put("labs", labsSideItemLayout);
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
                .set("width", "30%")
                .set("height", "100%")
                .set("background", "#F7F8F9")
                .set("overflow-y", "auto") // Enable vertical scrolling
                .set("padding", "var(--lumo-space-m)")
                .set("display", "flex")         // Make it a flex container
                .set("flex-direction", "column") // Stack items vertically
                .set("align-items", "flex-end"); // Align items to the right
    
            // Add some test content to demonstrate scrolling
            // for (int i = 0; i < 20; i++) {
            //     leftContainer.add(new Div("Scroll content " + i));
            // }
    
            Div homeDiv = new Div();
            HorizontalLayout homeSideItemLayout = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer = new Div();

            textContainer.getStyle().set("padding-left", "8px")
                .set("width", "100%");  // Make text container take full width
    
            Paragraph homeMainText = new Paragraph("Home");
            Icon arrow = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph homeSubText = new Paragraph("Start here");
    
            // Style the arrow
            arrow.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            homeMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            homeSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer.add(homeMainText, homeSubText);
    
            // Configure the HorizontalLayout
            homeSideItemLayout.setWidthFull();
            homeSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            homeSideItemLayout.setAlignItems(Alignment.CENTER);
            homeSideItemLayout.add(textContainer, arrow);  // Add textContainer instead of homeParagraph
            homeDiv.add(homeSideItemLayout);
            
            // Single click listener for home section
            Component[] homeComponents = {homeDiv, homeSideItemLayout, textContainer, homeMainText, homeSubText, arrow};
            for (Component component : homeComponents) {
                component.getElement().addEventListener("click", e -> {
                    UI.getCurrent().navigate("");
                    updateActiveMenuItem("");
                }).addEventData("event.stopPropagation()");
            }

            // Update the click listeners for home
            textContainer.addClickListener(e -> {
                UI.getCurrent().navigate("");
                String location = UI.getCurrent().getInternals().getActiveViewLocation().getPathWithQueryParameters();
                updateActiveMenuItem(location);
            });          
    
            Div virtualHealthcareDiv = new Div();
            HorizontalLayout virtualHealthcareSideItemLayout = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer2 = new Div();
            textContainer2.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph virtualHealthcareMainText = new Paragraph("Virtual Healthcare");
            Icon arrow2 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph virtualHealthcareSubText = new Paragraph("Access doctors online");
    
            // Style the arrow
            arrow2.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            virtualHealthcareMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            virtualHealthcareSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer2.add(virtualHealthcareMainText, virtualHealthcareSubText);
            // Configure the HorizontalLayout
            virtualHealthcareSideItemLayout.setWidthFull();
            virtualHealthcareSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            virtualHealthcareSideItemLayout.setAlignItems(Alignment.CENTER);
            virtualHealthcareSideItemLayout.add(textContainer2, arrow2);  // Add textContainer instead of homeParagraph
            virtualHealthcareDiv.add(virtualHealthcareSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] virtualComponents = {virtualHealthcareDiv, virtualHealthcareSideItemLayout, textContainer2, 
            virtualHealthcareMainText, virtualHealthcareSubText, arrow2};

        for (Component component : virtualComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("virtual-healthcare");
            updateActiveMenuItem("virtual-healthcare");
        }).addEventData("event.stopPropagation()");
        }

        Div behavioralHealthcareDiv = new Div();

        HorizontalLayout behavioralSideItemLayout = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer3 = new Div();
            textContainer3.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph behaviroalMainText = new Paragraph("Behavioral Healthcare");
            Icon arrow3 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph behaviroalSubText = new Paragraph("Access counselors online");
    
            // Style the arrow
            arrow3.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            behaviroalMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            behaviroalSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer3.add(behaviroalMainText, behaviroalSubText);
            // Configure the HorizontalLayout
            behavioralSideItemLayout.setWidthFull();
            behavioralSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            behavioralSideItemLayout.setAlignItems(Alignment.CENTER);
            behavioralSideItemLayout.add(textContainer3, arrow3);  // Add textContainer instead of homeParagraph
            behavioralHealthcareDiv.add(behavioralSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] behavioralHealthcareComponents = {behavioralHealthcareDiv, behavioralSideItemLayout, textContainer3, 
            behaviroalMainText, behaviroalSubText, arrow3};

        for (Component component : behavioralHealthcareComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("behavioral-healthcare");
            updateActiveMenuItem("behavioral-healthcare");
        }).addEventData("event.stopPropagation()");
        }

        Div labsDiv = new Div();

        HorizontalLayout labsSideItemLayout = new HorizontalLayout();
            // Create a container div for the text content with orange left border
            Div textContainer4 = new Div();
            textContainer4.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph labsMainText = new Paragraph("Labs");
            Icon arrow4 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph labsSubText = new Paragraph("Understand your lab results");
    
            // Style the arrow
            arrow4.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            labsMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            labsSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer4.add(labsMainText, labsSubText);
            // Configure the HorizontalLayout
            labsSideItemLayout.setWidthFull();
            labsSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            labsSideItemLayout.setAlignItems(Alignment.CENTER);
            labsSideItemLayout.add(textContainer4, arrow4);  // Add textContainer instead of homeParagraph
            labsDiv.add(labsSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] labsComponents = {labsDiv, labsSideItemLayout, textContainer4, 
            labsMainText, labsSubText, arrow4};

        for (Component component : labsComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("labs");
            updateActiveMenuItem("labs");
        }).addEventData("event.stopPropagation()");
        }


        Div healthNavigatorDiv = new Div("Health Navigator");
        Div benefitsDiv = new Div("Benefits");
        Div cardsDiv = new Div("Cards");
        cardsDiv.getStyle().set("border-bottom","1px solid #333333");



        // Create virtual healthcare section
        // ... (rest of the virtual healthcare section creation remains the same)
        
        // Map the menu items BEFORE setting initial active state
        pageMapper(homeSideItemLayout, virtualHealthcareSideItemLayout, 
        behavioralSideItemLayout, labsSideItemLayout);

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
        divs.add(homeDiv);
        divs.add(virtualHealthcareDiv);
        divs.add(behavioralHealthcareDiv);
        divs.add(labsDiv);
        divs.add(healthNavigatorDiv);
        divs.add(benefitsDiv);
        divs.add(cardsDiv);

        for(Div div : divs) {
            div.addClassName("side-menu-items");
            div.getStyle().set("width", "255px") // Set width for the menu items
                        .set("margin", "0 0 0 32px")
                        .set("cursor", "pointer");
            leftContainer.add(div);
        }

        return leftContainer;
    }

}
