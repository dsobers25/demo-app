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

    private static void pageMapper(HorizontalLayout homeHeader, HorizontalLayout virtualHomeHeader) {
            menuItems.put("", homeHeader); // homepage
            menuItems.put("virtual-healthcare", virtualHomeHeader);
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
    
            Div home = new Div();
            HorizontalLayout homeHeader = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer = new Div();

            textContainer.getStyle().set("padding-left", "8px")
                .set("width", "100%");  // Make text container take full width
    
            Paragraph homeParagraph = new Paragraph("Home");
            Icon arrow = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph homeText = new Paragraph("Start here");
    
            // Style the arrow
            arrow.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            homeParagraph.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            homeText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer.add(homeParagraph, homeText);
    
            // Configure the HorizontalLayout
            homeHeader.setWidthFull();
            homeHeader.setJustifyContentMode(JustifyContentMode.BETWEEN);
            homeHeader.setAlignItems(Alignment.CENTER);
            homeHeader.add(textContainer, arrow);  // Add textContainer instead of homeParagraph
    
            home.add(homeHeader);
            
            // Single click listener for home section
            Component[] homeComponents = {home, homeHeader, textContainer, homeParagraph, homeText, arrow};
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

            

            
    
            Div virtualHome = new Div();
            HorizontalLayout virtualHomeHeader = new HorizontalLayout();
    
            // Create a container div for the text content with orange left border
            Div textContainer2 = new Div();
            textContainer2.getStyle()
                // .set("border-left", "9px solid orange")
                .set("padding-left", "8px");  // Add some spacing between border and text
    
            Paragraph virtualHomeParagraph = new Paragraph("Virtual Healthcare");
            Icon arrow2 = new Icon(VaadinIcon.ARROW_RIGHT);
            Paragraph virtualHomeText = new Paragraph("Access doctors online");
    
            // Style the arrow
            arrow2.getStyle()
                .set("font-size", "10px")
                .set("margin-top", "10px");
    
            // Style the paragraph
            virtualHomeParagraph.getStyle()
                .set("font-size", "16px")
                .set("margin-bottom", "0px");
    
            virtualHomeText.getStyle()
                .set("font-size", "12px")
                .set("margin-top", "0px");
    
            // Add both paragraphs to the text container
            textContainer2.add(virtualHomeParagraph, virtualHomeText);
            // Configure the HorizontalLayout
            virtualHomeHeader.setWidthFull();
            virtualHomeHeader.setJustifyContentMode(JustifyContentMode.BETWEEN);
            virtualHomeHeader.setAlignItems(Alignment.CENTER);
            virtualHomeHeader.add(textContainer2, arrow2);  // Add textContainer instead of homeParagraph
            virtualHome.add(virtualHomeHeader);

        // Single click listener for virtual healthcare section
        Component[] virtualComponents = {virtualHome, virtualHomeHeader, textContainer2, 
            virtualHomeParagraph, virtualHomeText, arrow2};

        for (Component component : virtualComponents) {
            component.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("virtual-healthcare");
            updateActiveMenuItem("virtual-healthcare");
        }).addEventData("event.stopPropagation()");
        }

        // Create virtual healthcare section
        // ... (rest of the virtual healthcare section creation remains the same)
        
        // Map the menu items BEFORE setting initial active state
        pageMapper(homeHeader, virtualHomeHeader);

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

        
        Div behavioralHealthcare = new Div("Behavioral Healthcare");
        Div labs = new Div("Labs");
        Div healthNavigator = new Div("Health Navigator");
        Div benefits = new Div("Benefits");
        Div cards = new Div("Cards");
        cards.getStyle().set("border-bottom","1px solid #333333");

        List<Div> divs = new ArrayList<>();
        divs.add(home);
        divs.add(virtualHome);
        divs.add(behavioralHealthcare);
        divs.add(labs);
        divs.add(healthNavigator);
        divs.add(benefits);
        divs.add(cards);

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
