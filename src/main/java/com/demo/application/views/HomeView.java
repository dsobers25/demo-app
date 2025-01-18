package com.demo.application.views;

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="", layout=MainLayout.class)
@PageTitle("Home")
public class HomeView extends VerticalLayout {
    public HomeView() {
        // Remove padding and spacing
        setPadding(false);
        setSpacing(false);
        setSizeFull();
        
        // Create a container for the entire view
        VerticalLayout mainContainer = new VerticalLayout();
        mainContainer.setPadding(false);
        mainContainer.setSpacing(false);
        mainContainer.setSizeFull();
        
        // Add the header
        DynamicHeader header = new DynamicHeader("Welcome John!", "What can we do for you today?");
        
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

    private Component createRightContent() {
        // Create a wrapper for the right content
        Div rightWrapper = new Div();
        rightWrapper.addClassName("right-container");
        rightWrapper.getStyle()
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
            .set("padding", "16px 16px 16px 0px");

        // Add test content
        // for (int i = 0; i < 20; i++) {
        //     scrollContainer.add(new Div("Scroll content " + i));
        // }

        Div topSectionDiv = new Div();
            topSectionDiv.getStyle().set("width", "100%");;

        // Make topItem a positioning context and ensure proper layout
        Div topItem = new Div();
        topItem.addClassName("top-item");
        topItem.getStyle()
            .set("position", "relative")  // Make it a positioning context
            .set("height", "107.36px")
            .set("box-sizing", "border-box")
            .set("background-color", "#e7f5e9")
            .set("border-radius", "16px 16px 16px 16px")
            .set("border", "1px solid #E6E5E5")
            .set("padding", "16px")
            .set("margin-bottom", "40px");

        // Add main content
        H5 mainText = new H5("You have a test order");
        mainText.getStyle().set("font-size", "20px")
            .set("margin", "0");  // Remove default margins

        Paragraph subText = new Paragraph("A doctor has ordered lab tests for you.");
        subText.getStyle()
            .set("margin", "4px 0");  // Adjust spacing as needed

        // Position learn more text
        Paragraph learnMore = new Paragraph("Click here to learn more →");
        learnMore.getStyle()
            .set("position", "absolute")  // Position absolutely within the relative parent
            .set("bottom", "16px")       // Match parent's padding
            .set("right", "16px")        // Match parent's padding
            .set("margin", "0");         // Remove default paragraph margins

        topItem.add(mainText, subText, learnMore);


        topSectionDiv.add(topItem);


        Div bottomSectionDiv = new Div();
            bottomSectionDiv.getStyle()
                .set("width", "100%")
                .set("margin-top", "16px")    // Add spacing between top and bottom sections
                .set("display", "grid")       // Use grid layout
                .set("gap", "16px")          // Spacing between cards
                .set("max-width", "1000px"); // Max width as requested
                // Remove the margin-left: auto and margin-right: auto

        // Add media query for responsive grid
        UI.getCurrent().getElement().executeJs(
            "const style = document.createElement('style');" +
            "style.textContent = `" +
            "  .service-grid {" +
            "    grid-template-columns: 1fr;" +  // Single column by default
            "  }" +
            "  @media (min-width: 1024px) {" +
            "    .service-grid {" +
            "      grid-template-columns: 1fr 1fr;" +  // Two columns on wider screens
            "    }" +
            "  }`;" +
            "document.head.appendChild(style);");

        bottomSectionDiv.addClassName("service-grid");

        // Add all service cards
        bottomSectionDiv.add(
            createServiceCard("Virtual Healthcare", 
                "Virtual Healthcare gives you access to doctors online, for both Urgent Care & Primary Care. You can manage appointments & view your diagnoses and prescriptions.",
                "Go to Virtual Healthcare"),
            createServiceCard("Labs",
                "Lab Tests gives you access to lab tests online, for both both those ordered by your doctor & those you order yourself. You can order tests & view results.",
                "Go to Labs"),
            createServiceCard("Health Navigator",
                "Health Navigator gives you access to health advocacy and care navigation services to provide you with personal support for any healthcare challenge you may be facing.",
                "Go to Health Navigator"),
            createServiceCard("Benefits",
                "Benefits gives you access to all your benefits online, to answer questions & help you navigate your healthcare challenges.",
                "Go to Benefits"),
            createServiceCard("Membership Cards",
                "Cards gives you access to, and the details of, all your assigned cards.",
                "Go to Cards")
        );

        scrollContainer.add(topSectionDiv);
        scrollContainer.add(bottomSectionDiv);

        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }

    // Add this helper method to your class
    private Div createServiceCard(String title, String description, String linkText) {
        Div card = new Div();
        card.getStyle()
            .set("position", "relative")
            .set("height", "174px")
            .set("box-sizing", "border-box")
            // .set("background-color", "#e7f5e9")
            .set("border-radius", "16px")
            .set("border", "1px solid #E6E5E5")
            .set("padding", "16px");

        H5 titleText = new H5(title);
        titleText.getStyle()
            .set("font-size", "20px")
            .set("margin", "0");

        Paragraph descText = new Paragraph(description);
        descText.getStyle()
            .set("margin", "4px 0")
            .set("font-size", "14px");

            Paragraph learnMore = new Paragraph(linkText + " →");
            learnMore.getStyle()
                .set("position", "absolute")
                .set("bottom", "16px")
                .set("right", "16px")
                .set("margin", "0")
                .set("font-size", "14px")
                .set("cursor", "pointer");  // Add cursor pointer to show it's clickable
        
            // Add click listener based on the title/linkText
            learnMore.addClickListener(e -> {
                switch (title) {
                    case "Virtual Healthcare":
                        UI.getCurrent().navigate("virtual-healthcare");
                        break;
                    case "Labs":
                        UI.getCurrent().navigate("labs");
                        break;
                    case "Health Navigator":
                        UI.getCurrent().navigate("health-navigator");
                        break;
                    case "Benefits":
                        UI.getCurrent().navigate("benefits");
                        break;
                    case "Membership Cards":
                        UI.getCurrent().navigate("cards");
                        break;
                }
            });

        card.add(titleText, descText, learnMore);
        return card;
    }
}
