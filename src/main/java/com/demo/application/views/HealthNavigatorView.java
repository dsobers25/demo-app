/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views;

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="health-navigator", layout=MainLayout.class)
@PageTitle("Health Navigator")
class HealthNavigatorView extends VerticalLayout {
    public HealthNavigatorView() {
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
        DynamicHeader header = new DynamicHeader("Got a problem?", "We've got your back!");
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
        
        mainContainer.add(header, contentWrapper);
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
        
        rightWrapper.getStyle()
            .set("width", "70%")
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

        Div contactAndTime = new Div();
        contactAndTime.addClassName("contact-and-time");
            contactAndTime.getStyle()
                            // .set("max-width", "60%")
                            .set("background-color", "#e7f5e9")
                            .set("max-height", "20%")
                            .set("padding", "16px")
                            .set("background-color", "#e7f5e9")
                            .set("border-radius", "16px 16px 16px 16px")
                            .set("border", "1px solid #E6E5E5");

        H4 number = new H4("Call 888-352-4969");
        Paragraph timeAndDay = new Paragraph("Monday - Friday, 8:00am - 6:00pm (ET)");
        contactAndTime.add(number, timeAndDay);

        scrollContainer.add(contactAndTime);

        Paragraph textContent1 = new Paragraph("A healthcare challenge can strike when you least expect it and may leave you with questions:");

        scrollContainer.add(textContent1);

        // Create the list container
        UnorderedList list = new UnorderedList();
        list.getStyle()
            .set("padding-left", "20px")  // Adds some indentation
            .set("margin", "16px 0");     // Adds vertical spacing

        // Create list items
        ListItem item1 = new ListItem("Is my diagnosis correct?");
        ListItem item2 = new ListItem("Is this the best treatment for me?");
        ListItem item3 = new ListItem("Am I working with the right specialists?");
        ListItem item4 = new ListItem("Should I get a second opinion?");

        list.add(item1, item2, item3, item4);

        scrollContainer.add(list);

        // Second paragraph
        Paragraph textContent2 = new Paragraph("We are here for you. Contact us when you or a covered family member is looking for guidance on any health-related condition – not just those that are really complicated. Our goal is to support you by being your advisor and helping you navigate the world of healthcare. Health Navigator supports a wide variety of care navigation needs, including but not limited to:");
        textContent2.getStyle().set("margin", "16px 0");
        scrollContainer.add(textContent2);

        // Second list
        UnorderedList list2 = new UnorderedList();
        list2.getStyle()
            .set("padding-left", "20px")
            .set("margin", "16px 0");

        list2.add(
            new ListItem("Scheduling/questions on routine care"),
            new ListItem("Exploring treatment plans and options (for anything from a sports injury to a cancer diagnosis)"),
            new ListItem("Questions about a surgery"),
            new ListItem("A new serious diagnosis")
        );
        scrollContainer.add(list2);

        // Third paragraph
        Paragraph textContent3 = new Paragraph("By covering all conditions, we can help you feel empowered to make informed health decisions, no matter what type of condition you are dealing with.");
        textContent3.getStyle().set("margin", "16px 0");
        scrollContainer.add(textContent3);

        // Fourth paragraph
        Paragraph textContent4 = new Paragraph("If you or a covered family member receives a new diagnosis, has a serious medical condition or a health-related concern, our team of care advisors can:");
        textContent4.getStyle().set("margin", "16px 0");
        scrollContainer.add(textContent4);

        // Third list
        UnorderedList list3 = new UnorderedList();
        list3.getStyle()
            .set("padding-left", "20px")
            .set("margin", "16px 0");

        list3.add(
            new ListItem("Answer questions and help you understand your condition or diagnosis"),
            new ListItem("Walk you through your treatment options"),
            new ListItem("Gather, organize and forward your medical records"),
            new ListItem("Expedite and schedule appointments"),
            new ListItem("Obtain expert second opinions from leading physicians and Centers of Excellence"),
            new ListItem("Help you achieve better health outcomes"),
            new ListItem("Make informed decisions"),
            new ListItem("Achieve better medical outcomes")
        );
        scrollContainer.add(list3);

        // Final paragraph
        Paragraph textContent5 = new Paragraph("Connect with Health Navigator to get the support and guidance you need to feel confident in your healthcare decisions.");
        textContent5.getStyle().set("margin-top", "16px");
        scrollContainer.add(textContent5);
        // Add test content
        // for (int i = 0; i < 20; i++) {
        //     scrollContainer.add(new Div("Scroll content " + i));
        // }

        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }
}