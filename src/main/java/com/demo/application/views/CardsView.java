/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views;

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.CardsSideNav;
import com.demo.application.views.utils.SpacerUtility;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="cards", layout=MainLayout.class)
@PageTitle("Cards")
class CardsView extends VerticalLayout {
    public CardsView() {
        // Remove padding and spacing
        setPadding(false);
        setSpacing(false);
        setSizeFull(); // Make the view take full height
        
        
        // Create a container for the entire view
        VerticalLayout mainContainer = new VerticalLayout();
        mainContainer.setPadding(false);
        mainContainer.setSpacing(false);
        mainContainer.setSizeFull();
        
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
            .set("margin", "0 32px 0 0");
            // .set("padding-right", "16px"); // Add padding to the right side


        // Get the original left side content
        Component originalContent = CardsSideNav.leftSideContent();
        
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
        // }

         Div cardsSectionDiv = new Div();
         cardsSectionDiv.getStyle()
                .set("width", "100%")
                .set("margin-top", "16px")    // Add spacing between top and bottom sections
                .set("display", "grid")       // Use grid layout
                .set("gap", "40px")          // Spacing between cards
                .set("max-width", "1000px"); // Max width as requested
                // Remove the margin-left: auto and margin-right: auto

        // Add media query for responsive grid
        UI.getCurrent().getElement().executeJs(
            "const style = document.createElement('style');" +
            "style.textContent = `" +
            "  .service-grid {" +
            "    grid-template-columns: 2fr;" +  // Single column by default
            // "    min-width: 320px;" +
            "  }" +
            "  @media (min-width: 1024px) {" +
            "    .service-grid {" +
            // "      grid-template-columns: 1fr 1fr;" +  // Two columns on wider screens
            "      grid-template-columns: repeat(2, minmax(0, 1fr));" +  // Two columns on wider screens
            //repeat(2, minmax(0, 1fr));
            "    }" +
            "  }`;" +
            "document.head.appendChild(style);");

            cardsSectionDiv.addClassName("service-grid");

        // Add all service cards
        cardsSectionDiv.add(
            createServiceCard("View Health Insurance card"),
            createServiceCard("View Dental card"),
            createServiceCard("View Vision card"),
            createServiceCard("View Prescription Savings card"),
            createServiceCard("View Health Navigator card")
        );

        scrollContainer.add(cardsSectionDiv);
        scrollContainer.add(SpacerUtility.createSpacer());
        scrollContainer.add(SpacerUtility.createSpacer());
                

        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }


    // Add this helper method to your class
    private Div createServiceCard(String title) {
        // Create the main flip container
        Div flipContainer = new Div();
        flipContainer.addClassName("flip-container");
        flipContainer.getStyle()
            .set("perspective", "2000px")
            .set("width", "100%")
            .set("max-width", "340px")
            .set("height", "220px")
            .set("margin-bottom", "30px")
            .set("transform-style", "preserve-3d")
            .set("position", "relative")
            .set("padding", "0"); // Remove any default padding
    
        // Create the flipper element
        Div flipper = new Div();
        flipper.addClassName("flipper");
        flipper.getStyle()
            .set("position", "relative")
            .set("width", "100%")
            .set("height", "100%")
            .set("transition", "transform 0.6s")
            .set("transform-style", "preserve-3d")
            .set("transform-origin", "right center") // Change origin to right side
            .set("margin", "0") // Remove any margins
            .set("padding", "0"); // Remove any padding
    
        // Front of card
        Div front = new Div();
        front.addClassName("front");
        front.getStyle()
            .set("position", "absolute")
            .set("width", "100%")
            .set("height", "100%")
            .set("backface-visibility", "hidden")
            .set("border-radius", "16px")
            .set("border", "1px solid #E6E5E5")
            .set("background", "white")
            .set("overflow", "hidden") // Prevent image overflow
            .set("display", "flex") // Use flex to center image
            .set("align-items", "center")
            .set("justify-content", "center");
    
        // Back of card
        Div back = new Div();
        back.addClassName("back");
        back.getStyle()
            .set("position", "absolute")
            .set("width", "100%")
            .set("height", "100%")
            .set("backface-visibility", "hidden")
            .set("transform", "rotateY(180deg)")
            .set("border-radius", "16px")
            .set("border", "1px solid #E6E5E5")
            .set("background", "white")
            .set("overflow", "hidden") // Prevent content overflow
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("justify-content", "center")
            .set("align-items", "center");
    
        // Add content to front
        Image cardImage = new Image();
        cardImage.setWidth("100%");
        cardImage.setHeight("100%");
        cardImage.getStyle()
            .set("border-radius", "16px")
            .set("object-fit", "contain")
            .set("object-position", "center")
            .set("padding", "0") // Remove any padding
            .set("display", "block"); // Prevent image spacing issues
    
        // Set image based on card type
        switch (title) {
            case "View Health Insurance card":
                cardImage.setSrc("./images/health-insurance-card.png");
                break;
            case "View Dental card":
                cardImage.setSrc("./images/dental-card.png");
                break;
            case "View Vision card":
                cardImage.setSrc("./images/vision-card.png");
                break;
            case "View Prescription Savings card":
                cardImage.setSrc("./images/prescription-card.png");
                break;
            case "View Health Navigator card":
                cardImage.setSrc("./images/health-navigator-card.png");
                break;
        }
    
        // Create overlay for back content
        Div overlay = new Div();
        overlay.getStyle()
            .set("position", "absolute")
            .set("top", "0")
            .set("left", "0")
            .set("width", "100%")
            .set("height", "100%")
            .set("background", "rgba(0, 0, 0, 0.7)")
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("justify-content", "center")
            .set("align-items", "center")
            .set("padding", "20px");
    
        // Style title and button
        H5 cardTitle = new H5(title);
        cardTitle.getStyle()
            .set("margin", "0 0 15px 0")
            .set("text-align", "center")
            .set("color", "white");
    
        Paragraph viewButton = new Paragraph("View Card →");
        viewButton.getStyle()
            .set("cursor", "pointer")
            .set("padding", "10px 20px")
            .set("background", "var(--lumo-primary-color)")
            .set("color", "white")
            .set("border-radius", "8px")
            .set("margin", "0");
    
        // Add click navigation
        viewButton.addClickListener(e -> {
            switch (title) {
                case "View Health Insurance card":
                    UI.getCurrent().navigate("cards/health-insurance");
                    break;
                case "View Dental card":
                    UI.getCurrent().navigate("cards/dental");
                    break;
                case "View Vision card":
                    UI.getCurrent().navigate("cards/vision");
                    break;
                case "View Prescription Savings card":
                    UI.getCurrent().navigate("cards/prescription-savings");
                    break;
                case "View Health Navigator card":
                    UI.getCurrent().navigate("cards/health-navigator");
                    break;
            }
        });
    
        // Create a duplicate image for the back
        Image backImage = new Image();
        backImage.setWidth("100%");
        backImage.setHeight("100%");
        backImage.getStyle()
            .set("object-fit", "contain")
            .set("object-position", "center");
        backImage.setSrc(cardImage.getSrc());
    
        // Assemble the card
        front.add(cardImage);
        overlay.add(cardTitle, viewButton);
        back.add(backImage, overlay);
        flipper.add(front, back);
        flipContainer.add(flipper);
    
        // Add hover effect using JavaScript with modified transform
        UI.getCurrent().getPage().executeJs(
            "const container = $0;" +
            "const flipper = container.querySelector('.flipper');" +
            "container.addEventListener('mouseenter', () => {" +
            "    flipper.style.transform = 'translateX(-100%) rotateY(180deg)';" +
            "});" +
            "container.addEventListener('mouseleave', () => {" +
            "    flipper.style.transform = 'translateX(0) rotateY(0deg)';" +
            "});", flipContainer.getElement());
    
        return flipContainer;
    }
}