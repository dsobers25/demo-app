package com.demo.application.views;


import com.vaadin.flow.component.Component;
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
import com.vaadin.flow.theme.lumo.LumoUtility.AlignItems;
import com.vaadin.flow.theme.lumo.LumoUtility.Display;
import com.vaadin.flow.theme.lumo.LumoUtility.FontSize;
import com.vaadin.flow.theme.lumo.LumoUtility.FontWeight;
import com.vaadin.flow.theme.lumo.LumoUtility.Gap;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.theme.lumo.LumoUtility.TextColor;
import com.vaadin.flow.theme.lumo.LumoUtility.Whitespace;

/**
 * The main view is a top-level placeholder for other views.
 */
@Layout
@AnonymousAllowed
public class MainLayout extends AppLayout {
    
    /**
     * A simple navigation item component, based on ListItem element.
     */
    public static class MenuItemInfo extends ListItem {

        private final Class<? extends Component> view;
        
        public MenuItemInfo(String menuTitle, Component icon, Class<? extends Component> view) {
            this.view = view;
            // Div layout = new Div();
            // layout.getStyle().set("width", "100vw");
            // layout.getStyle().set("height", "30vh");
            // add(layout);
            RouterLink link = new RouterLink();
            // Use Lumo classnames for various styling
            link.addClassNames(Display.FLEX, Gap.XSMALL, AlignItems.CENTER, Padding.Horizontal.SMALL,
                    TextColor.BODY);
                    link.setRoute(view);
                    // link.getStyle().set("border-bottom", "2px solid");
                    // link.getStyle().set("border-bottomp-color", "orange");
                    
            link.addClassName("nav-link");

            // link.addClickListener(event -> {
            //     // Check if the Div already has the 'active' style name
            //     if (link.getStyle().contains("active")) {
            //         // If it does, remove the style name
            //         link.removeStyleName("active");
            //     } else {
            //         // If it doesn't, add the style name
            //         link.addStyleName("active");
            //     }
            // });
            

            

            Span text = new Span(menuTitle);
            // Use Lumo classnames for various styling
            text.addClassNames(FontWeight.MEDIUM, FontSize.MEDIUM, Whitespace.NOWRAP);

            if (icon != null) {
                link.add(icon);
            }
            link.add(text);
            add(link);
        }

        public Class<?> getView() {
            return view;
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
            .set("justify-content", "center")  // Center the inner layout
            .set("padding", "0");
    
        // Main container with max width
        Div mainContainer = new Div();
        mainContainer.getStyle()
            .set("max-width", "1024px")
            .set("width", "100%")
            .set("height", "64px") // adding height fixed issue 001 where the mainContainer had padding showing above and below it
            .set("display", "flex")
            .set("justify-content", "space-between")  // Spread items
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
        .set("padding", "0")       // Add this
        .set("flex-wrap", "nowrap")// Prevent wrapping
        .set("overflow", "hidden"); // Hide overflow
        
        String[] navItems = {
            "Home", "Virtual Healthcare", "Behaviorial Healthcare",
            "Labs", "Health Navigator", "Benefits", "Cards"
        };
        
        for (String navItem : navItems) {
            Div item = new Div();
            item.addClassName("nav-middle-items"); 
            item.getStyle()
                .set("font-size", "14px")
                .set("padding", "0")    // Remove padding
                .set("margin", "0")     // Remove margin
                .set("white-space", "nowrap"); // Prevent text wrappin
            item.setText(navItem);
            item.setId(String.valueOf("nav-item-" + navItem));
            middleItems.add(item);
        }
    
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

        

        // Create hamburger menu icon
        Icon hamburgerMenu = new Icon(VaadinIcon.MENU);
        // hamburgerMenu.getStyle().setColor("red");
        hamburgerMenu.addClassName("side-menu");
    
        // Add all sections to main container
        mainContainer.add(logoDiv, middleItems, circle, hamburgerMenu);
        
        // Add main container to header
        header.add(mainContainer);
        
        return header;
    }
}