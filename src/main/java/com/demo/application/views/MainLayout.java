package com.demo.application.views;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.router.Layout;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.*;

import java.util.HashMap;
import java.util.Map;

@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout {
    
    // Map to store navigation items and their corresponding paths
    private static Map<String, Div> navItems = new HashMap<>();
    
    private static void pageMapper(Div homeNav, Div virtualHealthcareNav, 
            Div behavioralNav, Div labsNav, Div healthNavigatorNav, 
            Div benefitsNav, Div cardsNav) {
        navItems.put("", homeNav); // homepage
        navItems.put("virtual-healthcare", virtualHealthcareNav);
        navItems.put("behavioral-healthcare", behavioralNav);
        navItems.put("labs", labsNav);
        navItems.put("health-navigator", healthNavigatorNav);
        navItems.put("benefits", benefitsNav);
        navItems.put("cards", cardsNav);
    }

    private static void updateActiveNavItem(String location) {
        // Set all borders to transparent
        navItems.values().forEach(item -> {
            item.getStyle().set("border-bottom", "2px solid transparent");
        });
        
        // Set active item border to orange
        if (navItems.containsKey(location)) {
            Div activeItem = navItems.get(location);
            activeItem.getStyle()
                .set("border-bottom", "2px solid orange");
        }
    }

    public MainLayout() {
        addToNavbar(createHeaderContent());
    }
    
    private Component createHeaderContent() {
        Header header = new Header();
        header.getStyle()
            .set("background-color", "#e7f5e9")
            .set("width", "100%")
            .set("display", "flex")
            .set("justify-content", "center")
            .set("padding", "0");
    
        Div mainContainer = new Div();
        mainContainer.getStyle()
            .set("max-width", "1400px")
            .set("width", "100%")
            .set("height", "64px")
            .set("display", "flex")
            .set("justify-content", "space-between")
            .set("align-items", "center")
            .set("padding", "0 32px");
    
        // Logo section
        Div logoDiv = new Div();
        Image svgImage = new Image("./images/tall-horizontal-logo.svg", "health-care-app");
        svgImage.setWidth("162px");
        logoDiv.add(svgImage);
    
        // Middle items
        Div middleItems = new Div();
        middleItems.getStyle()
            .set("display", "flex")
            .set("gap", "24px")
            .set("justify-content", "center")
            .set("align-items", "center")
            .set("flex-grow", "1")
            .set("margin", "0 32px")
            .set("padding", "0")
            .set("flex-wrap", "nowrap")
            .set("overflow", "hidden");
        
        // Create navigation items
        Div homeNav = createNavItem("Home", "");
        Div virtualHealthcareNav = createNavItem("Virtual Healthcare", "virtual-healthcare");
        Div behavioralNav = createNavItem("Behaviorial Healthcare", "behavioral-healthcare");
        Div labsNav = createNavItem("Labs", "labs");
        Div healthNavigatorNav = createNavItem("Health Navigator", "health-navigator");
        Div benefitsNav = createNavItem("Benefits", "benefits");
        Div cardsNav = createNavItem("Cards", "cards");
        
        // Add items to middle section
        middleItems.add(
            homeNav,
            virtualHealthcareNav,
            behavioralNav,
            labsNav,
            healthNavigatorNav,
            benefitsNav,
            cardsNav
        );
        
        // Map the navigation items
        pageMapper(homeNav, virtualHealthcareNav, behavioralNav, labsNav, 
                  healthNavigatorNav, benefitsNav, cardsNav);

        // Set initial active state
        UI.getCurrent().access(() -> {
            String currentLocation = UI.getCurrent().getInternals()
                .getActiveViewLocation().getPathWithQueryParameters();
            updateActiveNavItem(currentLocation.isEmpty() ? "" : currentLocation);
        });

        // Add listener for navigation changes
        UI.getCurrent().addBeforeEnterListener(event -> {
            String location = event.getLocation().getPath();
            updateActiveNavItem(location);
        });
    
        // Circle/User section
        Div circle = new Div();
        circle.addClassName("nav-middle-items");
        circle.getStyle()
            .set("width", "40px")
            .set("height", "40px")
            .set("background-color", "#04536F")
            .set("border-radius", "50%")
            .set("justify-content", "center")
            .set("align-items", "center");

        Paragraph user = new Paragraph("J");
        user.getStyle()
            .set("color", "white")
            .set("margin", "0");
        circle.add(user);

        // Hamburger menu
        Icon hamburgerMenu = new Icon(VaadinIcon.MENU);
        hamburgerMenu.addClassName("side-menu");
    
        // Add all sections to main container
        mainContainer.add(logoDiv, middleItems, circle, hamburgerMenu);
        header.add(mainContainer);
        
        return header;
    }

    private Div createNavItem(String text, String route) {
        Div item = new Div();
        item.addClassName("nav-middle-items");
        item.getStyle()
            .set("font-size", "14px")
            .set("padding", "0")
            .set("padding-bottom", "1px")  // Add consistent padding to all items
            .set("border-bottom", "2px solid transparent")  // Add transparent border
            .set("margin", "0")
            .set("white-space", "nowrap")
            .set("cursor", "pointer");
        item.setText(text);
        
        // Add click listener for navigation
        item.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate(route);
        });
        
        return item;
    }
}