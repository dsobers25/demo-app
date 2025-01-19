/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views;

import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="behavioral-healthcare", layout=MainLayout.class)
@PageTitle("Behavioral Healthcare")
class BehavioralHealthcareView extends VerticalLayout {
    public BehavioralHealthcareView() {
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
        DynamicHeader header = new DynamicHeader("Need a counselor?", "Talk to one online!");
        
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

        H3 topLine = new H3("Behavioral Healthcare");
        Paragraph subLine = new Paragraph("powered by CCA");
            // contactAndTime.add(number, timeAndDay);
    
        scrollContainer.add(topLine, subLine);

        Div licensedCouncelorSection = new Div();
        licensedCouncelorSection.addClassName("license-counselor");
            licensedCouncelorSection.getStyle()
                            // .set("max-width", "60%")
                            .set("background-color", "#e7f5e9")
                            .set("max-height", "25%")
                            .set("padding", "16px")
                            .set("background-color", "#e7f5e9")
                            .set("border-radius", "16px 16px 16px 16px")
                            .set("border", "1px solid #E6E5E5");

        H4 number = new H4("Call 123-321-1234");
        Paragraph tollFree = new Paragraph("for 24/7 toll-free access to licensed counselors");
        licensedCouncelorSection.add(number, tollFree);

        scrollContainer.add(licensedCouncelorSection);

        Paragraph textContent1 = new Paragraph("CCA supports members — employees and their loved ones — through a range of personal and professional issues including stress, anxiety, work/life balance, parenting, relationships, and grief via evidence-based, short-term counseling. Our counselors utilize a variety of treatment modalities such as solution focused, motivational interviewing, CBT, psychodynamic, and more.");
        Paragraph textContent2 = new Paragraph("Additionally, our masters-level intake counselors are available 24/7 to provide immediate crisis support to members in distress as well as to conduct comprehensive telephonic assessments. This assessment allows the counselor to determine the most clinically appropriate course of treatment—one that also incorporates any specific needs or preferences a member might have regarding ethnicity, language, location, areas of specialty, insurance participation, and more. Our counselors are adept at curating referrals based on each member's unique profile. After making the referral, we follow up to ensure satisfaction and inquire about any additional resources that could be helpful to the member.");

        textContent1.addClassName("license-counselor");
        textContent2.addClassName("license-counselor");

        scrollContainer.add(textContent1, textContent2);
        
        // Add test content
        // for (int i = 0; i < 20; i++) {
        //     scrollContainer.add(new Div("Scroll content " + i));
        // }

        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }
}