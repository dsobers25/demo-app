package com.demo.application.views;



/*
* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
*/

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="profile", layout=MainLayout.class)
@PageTitle("Profile")
public class ProfileView extends VerticalLayout {
     public ProfileView() {
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
        //  DynamicHeader header = new DynamicHeader("You're profile!", "some text here");
         // DynamicHeader header = new DynamicHeader("Welcome John!", "What can we do for you today?");
         
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
             .set("margin", "0");
            //  .set("padding-right", "16px"); // Add padding to the right side
 
 
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
             .set("background", "#FFFFFF");
            //  .set("padding", "var(--lumo-space-m)");
 
         // Add test content
        //  for (int i = 0; i < 20; i++) {
        //      scrollContainer.add(new Div("Scroll content " + i));
        //  }

        Div profileDiv = new Div();
        profileDiv.addClassName("license-counselor-x");
        profileDiv.getStyle()
        .set("border-top", "1px solid #E6E5E5")
        // .set("border-bottom", "1px solid #E6E5E5")
        .set("padding", "24px 0"); // Padding top and bottom only

        // Create rows
        HorizontalLayout firstNameRow = createProfileRow("Firstname", "John");
        firstNameRow.getStyle().set("border-bottom", "1px solid #E6E5E5");

        HorizontalLayout lastNameRow = createProfileRow("Lastname", "Doe");
        lastNameRow.getStyle().set("border-bottom", "1px solid #E6E5E5");

        HorizontalLayout sexRow = createProfileRow("Sex", "Male");
        sexRow.getStyle().set("border-bottom", "1px solid #E6E5E5");

        HorizontalLayout raceRow = createProfileRow("Race", "White");
        raceRow.getStyle().set("border-bottom", "1px solid #E6E5E5");

        HorizontalLayout dobRow = createProfileRow("Date Of Birth", "1980-06-15");
        dobRow.getStyle().set("border-bottom", "1px solid #E6E5E5");

        HorizontalLayout phoneRow = createProfileRow("Phone", "+1 123 123-1234");
        phoneRow.getStyle().set("border-bottom", "1px solid #E6E5E5");

        HorizontalLayout emailRow = createProfileRow("Email", "john@doe.com");
        emailRow.getStyle().set("border-bottom", "1px solid #E6E5E5");

        HorizontalLayout addressRow = createProfileRow("Address", "101 Test Street Testville");
        addressRow.getStyle().set("border-bottom", "1px solid #E6E5E5");

        // Add all rows to the container
        profileDiv.add(
        firstNameRow,
        lastNameRow, 
        sexRow,
        raceRow,
        dobRow,
        phoneRow,
        emailRow,
        addressRow
        );

        scrollContainer.add(profileDiv);
 
         rightWrapper.add(scrollContainer);
         return rightWrapper;
     }

     

        // Helper method to create consistent rows
        private HorizontalLayout createProfileRow(String label, String value) {
        HorizontalLayout row = new HorizontalLayout();
        row.setWidthFull();
        row.setJustifyContentMode(JustifyContentMode.BETWEEN);
        row.setSpacing(false);
        row.setPadding(false);
        row.getStyle().set("padding", "12px 24px"); // Add horizontal padding

        Paragraph leftText = new Paragraph(label);
        leftText.getStyle()
            .set("margin", "0")
            .set("color", "var(--lumo-secondary-text-color)"); // Lighter color for labels

        H2 rightText = new H2(value);
        rightText.getStyle()
            .set("margin", "0")
            .set("font-size", "1rem") // Adjust size as needed
            .set("font-weight", "600");

        row.add(leftText, rightText);
        return row;
        }
 }