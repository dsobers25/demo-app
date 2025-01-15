package com.demo.application.views;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.ComponentUtil;
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
    
    private static Map<String, Div> navItems = new HashMap<>();
    private Div overlay;
    private Div overlay2;
    private Div slideOutMenu;
    private Div slideUpMenu;
    
    public MainLayout() {
        setupOverlayAndMenu();
        setupOverlayAndChat();
        setupFloatingChatButton();
        addToNavbar(createHeaderContent());
    }

    private void setupOverlayAndMenu() {
        // Create overlay
        overlay = new Div();
        overlay.setId("menu-overlay");
        overlay.getStyle()
            .set("position", "fixed")
            .set("top", "0")
            .set("left", "0")
            .set("width", "100vw")
            .set("height", "100vh")
            .set("background-color", "#000000CC")
            .set("z-index", "1000")
            .set("display", "none")
            .set("opacity", "0")
            .set("transition", "opacity 0.3s ease-in-out");

        // Create slide-out menu
        slideOutMenu = new Div();
        slideOutMenu.setId("slide-menu");
        slideOutMenu.getStyle()
            .set("position", "fixed")
            .set("top", "0")
            .set("right", "-384px")
            .set("width", "384px")
            .set("height", "100vh")
            .set("background-color", "white")
            .set("z-index", "1001")
            .set("transition", "right 0.3s ease-in-out")
            .set("box-shadow", "-2px 0 5px rgba(0, 0, 0, 0.2)");

        // Simple click listener for overlay
        overlay.getElement().addEventListener("click", e -> toggleMenu());

        // Add components to the UI
        getElement().appendChild(overlay.getElement());
        getElement().appendChild(slideOutMenu.getElement());
    }

    private void setupOverlayAndChat() {
        // Create overlay
        overlay2 = new Div();
        overlay2.setId("menu-overlay");
        overlay2.getStyle()
            .set("position", "fixed")
            .set("top", "0")
            .set("left", "0")
            .set("width", "100vw")
            .set("height", "100vh")
            .set("background-color", "#000000CC")
            .set("z-index", "1000")
            .set("display", "none")
            .set("opacity", "0")
            .set("transition", "opacity 0.3s ease-in-out");

        // Create slide-out menu
        slideUpMenu = new Div();
        slideUpMenu.setId("slide-up-section");
        slideUpMenu.getStyle()
            .set("position", "fixed")
            .set("bottom", "-112.67px") // Changed from top to bottom, starting off-screen
            .set("left", "0")           // Added left:0 instead of right
            .set("width", "100vw")      // Changed from 100vh to 100vw
            .set("height", "112.67px")
            .set("background-color", "white")
            .set("z-index", "1001")
            .set("transition", "bottom 0.3s ease-in-out")
            .set("box-shadow", "0 -2px 5px rgba(0, 0, 0, 0.2)"); // Changed shadow direction

        // Simple click listener for overlay
        overlay2.getElement().addEventListener("click", e -> toggleChat());

        // Add components to the UI
        getElement().appendChild(overlay2.getElement());
        getElement().appendChild(slideUpMenu.getElement());
    }

    private boolean isMenuOpen = false;
    
    private void openMenu() {
        if (!isMenuOpen) {
            overlay.getStyle().set("display", "block");
            // Force reflow
            // overlay.getElement().executeJs("this.offsetHeight");
            overlay.getStyle().set("opacity", "1");
            slideOutMenu.getStyle().set("right", "0");
            isMenuOpen = true;
        }
    }

    private void closeMenu() {
        if (isMenuOpen) {
            overlay.getStyle().set("opacity", "0");
            slideOutMenu.getStyle().set("right", "-384px");
            
            // Hide overlay after transition
            overlay.getStyle().set("display", "none");

            isMenuOpen = false;
        }
    }

    private void toggleMenu() {
        if (isMenuOpen) {
            closeMenu();
        } else {
            openMenu();
        }
        // System.out.println("this is the isMenuOpen value: " + isMenuOpen);
    }

    private boolean isChatOpen = false;

    private void openChat() {
        if (!isChatOpen) {
            overlay2.getStyle().set("display", "block");
            overlay2.getStyle().set("opacity", "1");
            slideUpMenu.getStyle().set("bottom", "0"); // Changed from right to bottom
            isChatOpen = true;
        }
    }

    private void closeChat() {
        if (isChatOpen) {
            overlay2.getStyle().set("opacity", "0");
            slideUpMenu.getStyle().set("bottom", "-112.67px");
            
            // Hide overlay after transition
            overlay2.getStyle().set("display", "none");

            isChatOpen = false;
        }
    }

    private void toggleChat() {
        if (isChatOpen) {
            closeChat();
        } else {
            openChat();
        }
        // System.out.println("this is the isChatOpen value: " + isChatOpen);
    }
    

    
    private static void pageMapper(Div homeNav, Div virtualHealthcareNav, 
            Div behavioralNav, Div labsNav, Div healthNavigatorNav, 
            Div benefitsNav, Div cardsNav) {
        navItems.put("", homeNav);
        navItems.put("virtual-healthcare", virtualHealthcareNav);
        navItems.put("behavioral-healthcare", behavioralNav);
        navItems.put("labs", labsNav);
        navItems.put("health-navigator", healthNavigatorNav);
        navItems.put("benefits", benefitsNav);
        navItems.put("cards", cardsNav);
    }

    private static void updateActiveNavItem(String location) {
        navItems.values().forEach(item -> {
            item.getStyle().set("border-bottom", "2px solid transparent");
        });
        
        if (navItems.containsKey(location)) {
            Div activeItem = navItems.get(location);
            activeItem.getStyle()
                .set("border-bottom", "2px solid orange");
        }
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
        svgImage.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate("");
        });
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
        
        middleItems.add(
            homeNav,
            virtualHealthcareNav,
            behavioralNav,
            labsNav,
            healthNavigatorNav,
            benefitsNav,
            cardsNav
        );
        
        pageMapper(homeNav, virtualHealthcareNav, behavioralNav, labsNav, 
                  healthNavigatorNav, benefitsNav, cardsNav);

        UI.getCurrent().access(() -> {
            String currentLocation = UI.getCurrent().getInternals()
                .getActiveViewLocation().getPathWithQueryParameters();
            updateActiveNavItem(currentLocation.isEmpty() ? "" : currentLocation);
        });

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
            .set("display", "flex")
            .set("justify-content", "center")
            .set("align-items", "center")
            .set("cursor", "pointer");

        Paragraph user = new Paragraph("J");
        user.getStyle()
            .set("color", "white")
            .set("margin", "0");
        circle.add(user);

        // Add click listener to circle
        circle.addClickListener(e -> toggleMenu());

        // Hamburger menu
        Icon hamburgerMenu = new Icon(VaadinIcon.MENU);
        hamburgerMenu.addClassName("side-menu");
        hamburgerMenu.getStyle().set("cursor", "pointer");
        
        // Add click listener to hamburger
        hamburgerMenu.addClickListener(e -> toggleMenu());
    
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
            .set("padding-bottom", "1px")
            .set("border-bottom", "2px solid transparent")
            .set("margin", "0")
            .set("white-space", "nowrap")
            .set("cursor", "pointer");
        item.setText(text);
        
        item.getElement().addEventListener("click", e -> {
            UI.getCurrent().navigate(route);
        });
        
        return item;
    }

    private void setupFloatingChatButton() {
    Div chatButton = new Div();
    chatButton.getStyle()
        .set("position", "fixed")
        .set("bottom", "20px")
        .set("right", "35px")
        .set("width", "48px")  // w-12 equivalent
        .set("height", "48px") // h-12 equivalent
        .set("background-color", "#04536F") // Your primary highlight color
        .set("border-radius", "50%")
        .set("cursor", "pointer")
        .set("display", "flex")
        .set("align-items", "center")
        .set("justify-content", "center")
        .set("z-index", "999"); // Just below the slide menu's z-index of 1001

    // Create SVG container
    Div svgContainer = new Div();
    svgContainer.getElement().setProperty("innerHTML", 
        "<svg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 24 24' fill='currentColor' style='width:28px;height:28px;color:white'>" + 
        "<path fill-rule='evenodd' d='M4.804 21.644A6.707 6.707 0 0 0 6 21.75a6.721 6.721 0 0 0 3.583-1.029c.774.182 1.584.279 2.417.279 5.322 0 9.75-3.97 9.75-9 0-5.03-4.428-9-9.75-9s-9.75 3.97-9.75 9c0 2.409 1.025 4.587 2.674 6.192.232.226.277.428.254.543a3.73 3.73 0 0 1-.814 1.686.75.75 0 0 0 .44 1.223ZM8.25 10.875a1.125 1.125 0 1 0 0 2.25 1.125 1.125 0 0 0 0-2.25ZM10.875 12a1.125 1.125 0 1 1 2.25 0 1.125 1.125 0 0 1-2.25 0Zm4.875-1.125a1.125 1.125 0 1 0 0 2.25 1.125 1.125 0 0 0 0-2.25Z' " +
        "clip-rule='evenodd'></path></svg>");

    svgContainer.getStyle().set("margin-top", "5px");

    chatButton.add(svgContainer);

    // Add click handler if needed
    chatButton.addClickListener(e -> {
        toggleChat(); // or whatever action you want
    });

    // Add to the UI
    getElement().appendChild(chatButton.getElement());
}
}