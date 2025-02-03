package com.demo.application.views.cards;


import com.demo.application.views.MainLayout;
import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.CardsSideNav;
import com.demo.application.views.utils.SectionUtility;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="cards/health-insurance", layout=MainLayout.class)
@PageTitle("Cards Health Insurance")
public class CardsHealthInsuranceView  extends VerticalLayout {
    public CardsHealthInsuranceView() {
        
        // Remove padding and spacing
        setPadding(false);
        setSpacing(false);
        setSizeFull(); // Make the view take full height
        
        // Create a container for the entire view
        VerticalLayout mainContainer = new VerticalLayout();
        mainContainer.setPadding(false);
        mainContainer.setSpacing(false);
        mainContainer.setSizeFull();
        
        // Add the header
        // DynamicHeader header = new DynamicHeader("Welcome John!", "What can we do for you today?");
        // DynamicHeader header = new DynamicHeader("You've got cards!", "Let us explain them!");
        
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
        leftWrapper.getStyle()
            .set("width", "30%")
            .set("height", "100%")
            .set("overflow", "hidden") // Hide wrapper overflow
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("margin", "0")
            .set("padding-right", "16px"); // Add padding to the right side


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

       

        // Benefits Section

    Paragraph[][] healthInsuranceLeftSection = new Paragraph[][] {
        new Paragraph[]{new Paragraph("Provider")},
        new Paragraph[]{new Paragraph("Member Name")},
        new Paragraph[]{new Paragraph("Member ID")},
        new Paragraph[]{new Paragraph("Group Number")},
        new Paragraph[]{new Paragraph("BIN")},
        new Paragraph[]{new Paragraph("Benefit Plan")},
        new Paragraph[]{new Paragraph("Effective Date")},
        new Paragraph[]{new Paragraph("Dependants")}
    };

    Paragraph[][] healthInsuranceRightSection = new Paragraph[][] {
        new Paragraph[]{new Paragraph("Aetna")},
        new Paragraph[]{new Paragraph("John Doe")},
        new Paragraph[]{new Paragraph("ABC123456789")},
        new Paragraph[]{new Paragraph("123456")},
        new Paragraph[]{new Paragraph("6789")},
        new Paragraph[]{new Paragraph("ABC123")},
        new Paragraph[]{new Paragraph("Jun 15th 2010")},
        new Paragraph[]{new Paragraph("Jane Doe"),
                        new Paragraph("Sam Doe"),
                        new Paragraph("Sally Doe")}
    };
    

    SectionUtility section = new SectionUtility(healthInsuranceLeftSection, healthInsuranceRightSection);

    
    // Add all service cards
    cardsSectionDiv.add(
        createServiceCard("View Health Insurance card"),
        cardsDentalSections(section, scrollContainer, true)
    );

    scrollContainer.add(cardsSectionDiv);

        
        

        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }


    // Add this helper method to your class
    private Div createServiceCard(String title) {
        Div card = new Div();
        card.getStyle()
            .set("position", "relative")
            .set("box-sizing", "border-box")
            .set("border-radius", "16px")
            .set("border", "1px solid #E6E5E5")
            .set("padding", "0px")       // Reduced padding
            .set("width", "100%")  // Make card width match column
            .set("max-width", "340px") // Prevent too wide
            .set("margin-bottom", "30px"); // Center in column

        
        
        switch (title) {
            case "View Health Insurance card":
            Image svgImage = new Image("https://demo.virtualwellness.care/assets/images/health-insurance-card.png", "vision card");
                    svgImage.setWidth("100%");
                    svgImage.setMaxWidth("340px");
                    svgImage.getStyle()
                    .set("border-radius", "16px 16px 0 0"); // Match card's top corners
                    card.add(svgImage);

                break;
            case "View Dental card":
            Image svgImage2 = new Image("https://demo.virtualwellness.care/assets/images/dental-card.png", "vision card");
                svgImage2.setWidth("100%");
                svgImage2.setMaxWidth("340px");
                svgImage2.getStyle()
                .set("border-radius", "16px 16px 0 0"); 
                card.add(svgImage2);

                break;
            case "View Vision card":
            Image svgImage3 = new Image("https://demo.virtualwellness.care/assets/images/vision-card.png", "vision card");
                    svgImage3.setWidth("100%");
                    svgImage3.setMaxWidth("340px");
                    svgImage3.getStyle()
                    .set("border-radius", "16px 16px 0 0"); 
                    card.add(svgImage3);
            break;
            case "View Prescription Savings card":
            Image svgImage4 = new Image("https://demo.virtualwellness.care/assets/images/prescription-card.png", "vision card");
                    svgImage4.setWidth("100%");
                    svgImage4.setMaxWidth("340px");
                    svgImage4.getStyle()
                    .set("border-radius", "16px 16px 0 0"); 
                    card.add(svgImage4);
            break;
            case "View Health Navigator card":
            Image svgImage5 = new Image("https://demo.virtualwellness.care/assets/images/health-navigator-card.png", "vision card");
                    svgImage5.setWidth("100%");
                    svgImage5.setMaxWidth("340px");
                    svgImage5.getStyle()
                    .set("border-radius", "16px 16px 0 0"); 
                    card.add(svgImage5);
            break;
        }
        
        // svgImage.getElement().addEventListener("click", e -> {
        //     UI.getCurrent().navigate("");
        // });
        
            String linkText = title;

            Paragraph learnMore = new Paragraph(linkText + " →");
            learnMore.getStyle()
            .set("position", "relative")
            .set("display", "block") // Makes paragraph block-level
            .set("text-align", "center") // Center the text
            .set("padding", "10px") // Add some padding
            .set("font-size", "14px")
            .set("cursor", "pointer"); // Add cursor pointer to show it's clickable
        
            // Add click listener based on the title/linkText
            learnMore.addClickListener(e -> {
                switch (title) {
                    case "View Health Insurance card":
                        UI.getCurrent().navigate("benefits/health-insurance");
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

        card.add(learnMore);
        return card;
    }

    public Div cardsDentalSections(SectionUtility section,
    Div scrollContainer, boolean topMargin) {
        
        // Main container
        Div mainDiv = new Div();
        mainDiv.addClassName("card-center-dim");
        mainDiv.getStyle()
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("gap", "16px")
            .set("padding", "0px")
            .set("border-bottom", "2px solid #E6E4E4")
            .set("border-top", "2px solid #E6E4E4");

        // contentDiv added for each row
        for(int i = 0; i < section.getRows(); i++) {

        // Top content container
        Div contentDiv = new Div();
        contentDiv.getStyle()
            .set("display", "flex")
            .set("justify-content", "space-between")
            .set("width", "100%");

        if(i != section.getRows() -1) {
            contentDiv.getStyle()
            .set("border-bottom", "2px solid #E6E4E4");
        }

        // Left side
        Div leftSide = new Div();
        // leftSide.addClassName("remove-left-side");
        leftSide.getStyle()
            .set("align-items", "center");

        // Paragraph leftline1 = new Paragraph("Benefit");
        // Paragraph leftline1 = new Paragraph(left);
        // leftSide.add(leftline1);


        // leftLines array needs to be added like rightLines
        for(Paragraph p : section.getLeftside()[i]) {
            p.getStyle().set("margin", "0")
            .set("font-size", "12px");
            leftSide.add(p);

            // System.out.println(p.getText());
        }

        // Right side
        Div rightSide = new Div();
        rightSide.addClassName("shift-text");
        rightSide.getStyle()
            .set("max-width", "60%") // Adjust as needed for text wrapping
            .set("text-align", "right") // Add this to align all content right
            .set("margin-left", "auto"); // This will push the div to the right


        for(Paragraph p : section.getRightside()[i]) {
            p.getStyle().set("margin", "0")
            .set("font-size", "16px")
            .set("font-weight", "500");
            rightSide.add(p);
        }

        // Add left and right to content container
        contentDiv.add(leftSide, rightSide);
        // contentDiv.add(leftSide);

        
        // Add all components to main container
        mainDiv.add(contentDiv);
    }
    // scrollContainer.add(mainDiv);
    return mainDiv;

}
}