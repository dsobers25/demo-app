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

public class SideNav2 {
    private static Map<String, HorizontalLayout> menuItems = new HashMap<>();

    public SideNav2() {

    }

    private static void pageMapper(HorizontalLayout homeSideItemLayout, HorizontalLayout virtualHealthcareSideItemLayout,
    HorizontalLayout behavioralSideItemLayout, HorizontalLayout labsSideItemLayout,
    HorizontalLayout healthNavigatorSideItemLayout, HorizontalLayout benefitsSideItemLayout, HorizontalLayout cardsSideItemLayout) {
            menuItems.put("", homeSideItemLayout); // homepage
            menuItems.put("virtual-healthcare", virtualHealthcareSideItemLayout);
            menuItems.put("behavioral-healthcare", behavioralSideItemLayout);
            menuItems.put("labs", labsSideItemLayout);
            menuItems.put("health-navigator", healthNavigatorSideItemLayout);
            menuItems.put("benefits", benefitsSideItemLayout);
            menuItems.put("cards", cardsSideItemLayout);
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
            // leftContainer.addClassName("left-container"); //<-- BUG01: adding ths was making side menu disapear when screen with was less than 1024px
            leftContainer.getStyle()
                .set("width", "100%")
                .set("height", "100%")
                // .set("background", "#F7F8F9")
                .set("display", "flex")
                .set("flex-direction", "column")
                .set("padding", "var(--lumo-space-m)")
                // .set("padding-left", "0") // Remove left padding
                // .set("padding-right", "10%") // Remove right padding
                .set("box-sizing", "border-box")
                .set("overflow-y", "auto") // Change to auto instead of always showing
                .set("align-items", "flex-end"); // Align items to the right side

    
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
    
            Paragraph homeMainText = new Paragraph("Homie");
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

        // Update the click listeners for Virtual Healthcare
        textContainer2.addClickListener(e -> {
            UI.getCurrent().navigate("virtual-healthcare");
            String location = UI.getCurrent().getInternals().getActiveViewLocation().getPathWithQueryParameters();
            updateActiveMenuItem(location);
        });    

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

        Div benefitsDiv = new Div();

        HorizontalLayout benefitsSideItemLayout = new HorizontalLayout();
            // Create a container div for the text content with orange left border
            Div textContainer6 = new Div();
            textContainer6.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph benefitsMainText = new Paragraph("Benefits");
            Icon arrow6 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph benefitsSubText = new Paragraph("Understand your benefits");
    
            // Style the arrow
            arrow6.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            benefitsMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            benefitsSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer6.add(benefitsMainText, benefitsSubText);
            // Configure the HorizontalLayout
            benefitsSideItemLayout.setWidthFull();
            benefitsSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            benefitsSideItemLayout.setAlignItems(Alignment.CENTER);
            benefitsSideItemLayout.add(textContainer6, arrow6);  // Add textContainer instead of homeParagraph
            benefitsDiv.add(benefitsSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] benefitsNavigatorComponents = {benefitsDiv, benefitsSideItemLayout, textContainer5, 
            benefitsMainText, benefitsSubText, arrow6};

        for (Component component : benefitsNavigatorComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("benefits");
            updateActiveMenuItem("benefits");
        }).addEventData("event.stopPropagation()");
        }


        Div cardsDiv = new Div();
        cardsDiv.getStyle().set("border-bottom","1px solid #333333");

        HorizontalLayout cardsSideItemLayout = new HorizontalLayout();
            // Create a container div for the text content with orange left border
            Div textContainer7 = new Div();
            textContainer7.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph cardsMainText = new Paragraph("Cards");
            Icon arrow7 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph cardsSubText = new Paragraph("Understand your membership cards");
    
            // Style the arrow
            arrow7.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            cardsMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            cardsSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer7.add(cardsMainText, cardsSubText);
            // Configure the HorizontalLayout
            cardsSideItemLayout.setWidthFull();
            cardsSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            cardsSideItemLayout.setAlignItems(Alignment.CENTER);
            cardsSideItemLayout.add(textContainer7, arrow7);  // Add textContainer instead of homeParagraph
            cardsDiv.add(cardsSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] cardsNavComponents = {cardsDiv, cardsSideItemLayout, textContainer7, 
            cardsMainText, cardsSubText, arrow7};

        for (Component component : cardsNavComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("cards");
            updateActiveMenuItem("cards");
        }).addEventData("event.stopPropagation()");
    }

        // Create virtual healthcare section
        // ... (rest of the virtual healthcare section creation remains the same)
        
        // Map the menu items BEFORE setting initial active state
        pageMapper(homeSideItemLayout, virtualHealthcareSideItemLayout, 
        behavioralSideItemLayout, labsSideItemLayout, healthNavigatorSideItemLayout,
        benefitsSideItemLayout, cardsSideItemLayout);

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
            System.out.println("close the side menue for " + location);
        });

        

        List<Div> divs = new ArrayList<>();
        divs.add(homeDiv);
        divs.add(virtualHealthcareDiv);
        divs.add(behavioralHealthcareDiv);
        divs.add(labsDiv);
        divs.add(healthNavigatorDiv);
        divs.add(benefitsDiv);
        divs.add(cardsDiv);

        // Update the div styling in the loop
        for(Div div : divs) {
            div.addClassName("side-menu-items"); // when this what commented out the side menu wouldn't close
            div.getStyle()
                .set("width", "100%") // Fixed width instead of percentage
                .set("margin-bottom", "16px")
                .set("margin-right", "0") // Align to the right
                .set("cursor", "pointer");
            leftContainer.add(div);
        }

        return leftContainer;
    }

}