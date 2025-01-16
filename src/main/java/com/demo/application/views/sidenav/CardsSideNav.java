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

public class CardsSideNav {
    private static Map<String, HorizontalLayout> menuItems = new HashMap<>();

    public CardsSideNav() {

    }

    private static void pageMapper(HorizontalLayout cardsHealthInsuranceSideItemLayout,
    HorizontalLayout cardsDentalSideItemLayout, HorizontalLayout cardsVisionSideItemLayout,
    HorizontalLayout cardsPrescriptionSideItemLayout, HorizontalLayout cardsHealthNavigatorSideItemLayout
    ) {
            menuItems.put("cards/health-insurance", cardsHealthInsuranceSideItemLayout); // homepage
            menuItems.put("cards/dental", cardsDentalSideItemLayout);
            menuItems.put("cards/vision", cardsVisionSideItemLayout);
            menuItems.put("cards/prescription-savings", cardsPrescriptionSideItemLayout);
            menuItems.put("cards/health-navigator", cardsHealthNavigatorSideItemLayout);
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
    
            Div cardsHealthInsuranceDiv = new Div();
            HorizontalLayout cardsHealthInsuranceSideItemLayout = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer = new Div();

            textContainer.getStyle().set("padding-left", "8px")
                .set("width", "100%");  // Make text container take full width
    
            Paragraph cardsHealthInsuranceMainText = new Paragraph("Health Insurance");
            Icon arrow = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph cardsHealthInsuranceSubText = new Paragraph("By Aetna");
    
            // Style the arrow
            arrow.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            cardsHealthInsuranceMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            cardsHealthInsuranceSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer.add(cardsHealthInsuranceMainText, cardsHealthInsuranceSubText);
    
            // Configure the HorizontalLayout
            cardsHealthInsuranceSideItemLayout.setWidthFull();
            cardsHealthInsuranceSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            cardsHealthInsuranceSideItemLayout.setAlignItems(Alignment.CENTER);
            cardsHealthInsuranceSideItemLayout.add(textContainer, arrow);  // Add textContainer instead of homeParagraph
            cardsHealthInsuranceDiv.add(cardsHealthInsuranceSideItemLayout);
            
            // Single click listener for home section
            Component[] cardsHealthInsuranceComponents = {cardsHealthInsuranceDiv, cardsHealthInsuranceSideItemLayout,
                 textContainer, cardsHealthInsuranceMainText, cardsHealthInsuranceSubText, arrow};
            for (Component component : cardsHealthInsuranceComponents) {
                component.getElement().addEventListener("click", e -> {
                    UI.getCurrent().navigate("cards/health-insurance");
                    updateActiveMenuItem("cards/health-insurance");
                }).addEventData("event.stopPropagation()");
            }

            // Update the click listeners for home
            // textContainer.addClickListener(e -> {
            //     UI.getCurrent().navigate("");
            //     String location = UI.getCurrent().getInternals().getActiveViewLocation().getPathWithQueryParameters();
            //     updateActiveMenuItem(location);
            // });
            
            
            Div cardsDentalDiv = new Div();

            HorizontalLayout cardsDentalSideItemLayout = new HorizontalLayout();
                // Create a container div for the text content with orange left border
                Div textContainer5 = new Div();
                textContainer5.getStyle()
                    // .set("border-left", "9px solid orange")
                    .set("padding-left", "8px");  // Add some spacing between border and text
        
                Paragraph cardsDentalMainText = new Paragraph("Dental");
                Icon arrow5 = new Icon(VaadinIcon.ARROW_RIGHT);
                Paragraph cardsDentalSubText = new Paragraph("by SunLife");
        
                // Style the arrow
                arrow5.getStyle()
                    .set("font-size", "10px")
                    .set("margin-top", "10px");
        
                // Style the paragraph
                cardsDentalMainText.getStyle()
                    .set("font-size", "16px")
                    .set("margin-bottom", "0px");
        
                cardsDentalSubText.getStyle()
                    .set("font-size", "12px")
                    .set("margin-top", "0px");
        
                // Add both paragraphs to the text container
                textContainer5.add(cardsDentalMainText, cardsDentalSubText);
                // Configure the HorizontalLayout
                cardsDentalSideItemLayout.setWidthFull();
                cardsDentalSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
                cardsDentalSideItemLayout.setAlignItems(Alignment.CENTER);
                cardsDentalSideItemLayout.add(textContainer5, arrow5);  // Add textContainer instead of homeParagraph
                cardsDentalDiv.add(cardsDentalSideItemLayout);

            // Single click listener for virtual healthcare section
            Component[] cardsDentalComponents = {cardsDentalDiv, cardsDentalSideItemLayout, textContainer5, 
                cardsDentalMainText, cardsDentalSubText, arrow5};

            for (Component component : cardsDentalComponents) {
                component.getElement().addEventListener("click", e -> {
                UI.getCurrent().navigate("cards/dental");
                updateActiveMenuItem("health-navigator");
            }).addEventData("event.stopPropagation()");
        }
    
            Div cardsVisionDiv = new Div();
            HorizontalLayout cardsVisionSideItemLayout = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer2 = new Div();
            textContainer2.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph cardsVisionMainText = new Paragraph("Vision");
            Icon arrow2 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph cardsVisionSubText = new Paragraph("by VSP");
    
            // Style the arrow
            arrow2.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            cardsVisionMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            cardsVisionSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer2.add(cardsVisionMainText, cardsVisionSubText);
            // Configure the HorizontalLayout
            cardsVisionSideItemLayout.setWidthFull();
            cardsVisionSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            cardsVisionSideItemLayout.setAlignItems(Alignment.CENTER);
            cardsVisionSideItemLayout.add(textContainer2, arrow2);  // Add textContainer instead of homeParagraph
            cardsVisionDiv.add(cardsVisionSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] cardsVisionComponents = {cardsVisionDiv, cardsVisionSideItemLayout, textContainer2, 
            cardsVisionMainText, cardsVisionSubText, arrow2};

        for (Component component : cardsVisionComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("cards/vision");
            updateActiveMenuItem("cards/vision");
        }).addEventData("event.stopPropagation()");
        }

        Div cardsPrescriptionDiv = new Div();

        HorizontalLayout cardsPrescriptionSideItemLayout = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer3 = new Div();
            textContainer3.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph cardsPrescriptionMainText = new Paragraph("Prescription Savings");
            Icon arrow3 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph cardsPrescriptionSubText = new Paragraph("RX Prescriptions");
    
            // Style the arrow
            arrow3.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            cardsPrescriptionMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            cardsPrescriptionSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer3.add(cardsPrescriptionMainText, cardsPrescriptionSubText);
            // Configure the HorizontalLayout
            cardsPrescriptionSideItemLayout.setWidthFull();
            cardsPrescriptionSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            cardsPrescriptionSideItemLayout.setAlignItems(Alignment.CENTER);
            cardsPrescriptionSideItemLayout.add(textContainer3, arrow3);  // Add textContainer instead of homeParagraph
            cardsPrescriptionDiv.add(cardsPrescriptionSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] cardsPrescriptionComponents = {cardsPrescriptionDiv, cardsPrescriptionSideItemLayout, textContainer3, 
            cardsPrescriptionMainText, cardsPrescriptionSubText, arrow3};

        for (Component component : cardsPrescriptionComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("cards/prescription-savings");
            updateActiveMenuItem("cards/prescription-savings");
        }).addEventData("event.stopPropagation()");
        }
        
              
        Div cardshealthNavigatorDiv = new Div();

        HorizontalLayout cardshealthNavigatorSideItemLayout = new HorizontalLayout();
            // Create a container div for the text content with orange left border
            Div textContainer4 = new Div();
            textContainer4.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph cardshealthNavigatorMainText = new Paragraph("Health Navigator");
            Icon arrow4 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph cardshealthNavigatorSubText = new Paragraph("Sun Life");
    
            // Style the arrow
            arrow4.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            cardshealthNavigatorMainText.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            cardshealthNavigatorSubText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer4.add(cardshealthNavigatorMainText, cardshealthNavigatorSubText);
            // Configure the HorizontalLayout
            cardshealthNavigatorSideItemLayout.setWidthFull();
            cardshealthNavigatorSideItemLayout.setJustifyContentMode(JustifyContentMode.BETWEEN);
            cardshealthNavigatorSideItemLayout.setAlignItems(Alignment.CENTER);
            cardshealthNavigatorSideItemLayout.add(textContainer4, arrow4);  // Add textContainer instead of homeParagraph
            cardshealthNavigatorDiv.add(cardshealthNavigatorSideItemLayout);

        // Single click listener for virtual healthcare section
        Component[] cardshealthNavigatorComponents = {cardshealthNavigatorDiv, cardshealthNavigatorSideItemLayout, textContainer4, 
            cardshealthNavigatorMainText, cardshealthNavigatorSubText, arrow4};

        for (Component component : cardshealthNavigatorComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("cards/health-navigator");
            updateActiveMenuItem("cards/health-navigator");
        }).addEventData("event.stopPropagation()");
        }
        
        pageMapper(cardsHealthInsuranceSideItemLayout, cardsDentalSideItemLayout, cardsVisionSideItemLayout,
        cardsPrescriptionSideItemLayout, cardshealthNavigatorSideItemLayout);

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
        divs.add(cardsHealthInsuranceDiv);
        divs.add(cardsDentalDiv);
        divs.add(cardsVisionDiv);
        divs.add(cardsPrescriptionDiv);
        divs.add(cardshealthNavigatorDiv);

        // menuItems.put("cards/health-insurance", cardsHealthInsuranceSideItemLayout); // homepage
        //     menuItems.put("cards/dental", cardsDentalSideItemLayout);
        //     menuItems.put("cards/vision", cardsVisionSideItemLayout);
        //     menuItems.put("cards/prescription-savings", cardsPrescriptionSideItemLayout);
        //     menuItems.put("cards/health-navigator", cardsHealthNavigatorSideItemLayout);

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