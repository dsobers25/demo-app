/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.demo.application.views.labs;

import org.checkerframework.checker.units.qual.t;

import com.demo.application.alert.AlertService;
import com.demo.application.history.TestHistoryService;
import com.demo.application.views.MainLayout;
import com.demo.application.views.header.DynamicHeader;
import com.demo.application.views.sidenav.SideNav;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@Route(value="labs/new", layout=MainLayout.class)
@PageTitle("Labs")
class LabNewsView extends VerticalLayout {
    public LabNewsView() {
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
        DynamicHeader header = new DynamicHeader("Need a lab?", "See your results online!");
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

        // H3 topLine = new H3("Behavioral Healthcare");
        // Paragraph subLine = new Paragraph("powered by CCA");
            // contactAndTime.add(number, timeAndDay);
    
        // scrollContainer.add(topLine, subLine);

       
        H4 testOrderMainText = new H4("You have a new test order!");
        Paragraph testOrderSubText = new Paragraph("A doctor has ordered a lab test for you. This lab test requires samples to be drawn, but don't worry, it only needs three easy steps!");
        testOrderSubText.addClassName("license-counselor");
        Paragraph testOrderSubText2 = new Paragraph("To learn more read the Next Steps below.");

        H4 quickScanBarcodeText = new H4("Quick Scan Barcode");
        quickScanBarcodeText.getStyle().set("margin-top", "40px");

        // license-counselor
        Div barcodeDiv = new Div();
        barcodeDiv.getStyle()
                            .set("width", "fit-content")
                            .set("height", "auto")
                            .set("margin-bottom", "12px")
                            .set("margin-top", "12px")
                            .set("padding", "16px")
                            .set("border-radius", "16px 16px 16px 16px")
                            .set("border", "1px solid #E6E5E5");
        Image barcodeImg = new Image("./images/barcode.png", "labs-barcode");
        barcodeDiv.add(barcodeImg);

        // Add all components to the div
        
        scrollContainer.add(testOrderMainText, testOrderSubText, testOrderSubText2, quickScanBarcodeText, barcodeDiv);

        H4 nextSteps = new H4("Next Steps");
        nextSteps.getStyle().set("color", "#1B3B1E")
        .set("margin", "12px 0");

        scrollContainer.add(nextSteps);
        // HorizontalLayout stepOne = new HorizontalLayout();
        // Div circleOne = new Div();
        // circleOne.getStyle().set("width", "64px")
        // .set("height", "64px")
        // .set("display", "flex") 
        // .set("justify-content", "center")
        // .set("align-items", "center")
        // .set("font-size", "1.5rem")
        // .set("font-weight", "700") 
        // .set("flex-shrink", "0")
        // .set("border-radius", "50%")
        // .set("border", "8px solid #e7f5e9");
        // Paragraph one = new Paragraph("1");
        // one.getStyle().set("color", "#1B3B1E");
        // circleOne.add(one);


        // Div rightOne = new Div();
        
        // H5 titleOne = new H5("Get ready");
        // Paragraph paragraphOne = new Paragraph("Before you do anything else, be sure to read and follow the preparation guidance.");

        // rightOne.add(titleOne, paragraphOne);

        // stepOne.add(circleOne, rightOne);

        scrollContainer.add(stepsSection("Get ready", "1", "Before you do anything else, be sure to read and follow the preparation guidance."));
        scrollContainer.add(stepsSection("Pick a lab", "2", "Now, it's time to choose a lab to have your sample taken. We have suggested the closest locations to you, scroll down to find them."));
        scrollContainer.add(stepsSection("Visit a lab", "2","Once you've selected a location, head on over and present the barcode at the computer kiosk in reception. Just follow the prompts to check in. If the kiosk asks about payment, choose the option that mentions someone else is taking care of it. A LabCorp clinician will assist you from there."));


        Div prepGuidanceDiv = new Div();
        prepGuidanceDiv.addClassName("license-counselor");
            prepGuidanceDiv.getStyle()
                            .set("background-color", "#e7f5e9")
                            .set("margin-bottom", "12px")
                            .set("margin-top", "30px")
                            .set("padding", "16px")
                            .set("background-color", "#1B3B1E")
                            .set("border-radius", "16px 16px 16px 16px")
                            .set("border", "1px solid #E6E5E5");

        H4 discussLabMainText = new H4("Preparation Guidance");
        discussLabMainText.getStyle().set("color", "#e7f5e9");
        Paragraph discussLabSubText = new Paragraph("To get the most accurate results, it's best to fast for 12 hours before giving a sample. During this time, you can have water, but no food or other drinks. If you're taking a supplement with biotin, it's a good idea to wait at least 72 hours before giving your sample. Biotin is also known as vitamin B7 or B8, vitamin H, or coenzyme R, and it's often found in products that support healthy hair, skin, and nails.");
        discussLabSubText.getStyle().set("color", "#e7f5e9")
        .set("text-align", "left");

        // Add all components to the div
        prepGuidanceDiv.add(discussLabMainText, discussLabSubText);
        scrollContainer.add(prepGuidanceDiv);

        H4 labLocations = new H4("Lab Locations");
        labLocations.getStyle().set("color", "#1B3B1E")
        .set("margin", "20px 0 10px 0");

        scrollContainer.add(labLocations);

        scrollContainer.add(labLocationSection(false));
        scrollContainer.add(labLocationSection(false));
        scrollContainer.add(labLocationSection(false));
        scrollContainer.add(labLocationSection(false));
        scrollContainer.add(labLocationSection(true));



        
        
        // Add test content
        // for (int i = 0; i < 20; i++) {
        //     scrollContainer.add(new Div("Scroll content " + i));
        // }

        rightWrapper.add(scrollContainer);
        return rightWrapper;
    }

    HorizontalLayout stepsSection(String label, String num, String content) {
        HorizontalLayout step = new HorizontalLayout();
        step.addClassName("license-counselor");
        step.getStyle().set("margin-bottom", "15px");
        Div circle = new Div();
        circle.getStyle().set("width", "64px")
        .set("height", "64px")
        .set("display", "flex") 
        .set("justify-content", "center")
        .set("align-items", "center")
        .set("font-size", "1.5rem")
        .set("font-weight", "700") 
        .set("flex-shrink", "0")
        .set("border-radius", "50%")
        .set("border", "8px solid #e7f5e9");
        Paragraph one = new Paragraph(num);
        one.getStyle().set("color", "#1B3B1E");
        circle.add(one);


        Div right = new Div();
        
        H5 title = new H5(label);
        Paragraph paragraph = new Paragraph(content);

        right.add(title, paragraph);

        step.add(circle, right);

        return step;
    }

    HorizontalLayout labLocationSection(boolean bottomDiv) {
        HorizontalLayout labLocationHorizontalLayout = new HorizontalLayout();
        labLocationHorizontalLayout.addClassName("license-counselor");
        labLocationHorizontalLayout.getStyle()
                .set("border-top", "2px solid #E6E5E5")
                .set("margin-bottom", "15px")
                .set("box-sizing", "border-box")
                .set("padding", "5px");  // Move padding here from the image

        Div leftImgDiv = new Div();
        Image labcorpLogo = new Image("./images/Labcorp_Logo.svg", "labcorp");
        labcorpLogo.getStyle()
                .set("width", "90px");
                // Removed padding from here
        leftImgDiv.add(labcorpLogo);
        
        Div rightDiv = new Div();
        Paragraph addressP1 = new Paragraph("101 Test Ave Suite 777");
        addressP1.getStyle()
                .set("font-weight", "600")
                .setMargin("0");
        Paragraph addressP2 = new Paragraph("Testville, TX 12345");
        addressP2.getStyle()
                .set("font-weight", "600")
                .setMargin("0");
        Paragraph phone = new Paragraph("Phone: (123) 123-1234");
        phone.getStyle().setMargin("0");
        Paragraph dayAndTime = new Paragraph("M-T: 8am-5pm F: 8am-1:30pm");
        dayAndTime.getStyle().setMargin("0");

        if(bottomDiv) {
            labLocationHorizontalLayout.getStyle()
                .set("border-bottom", "2px solid #E6E5E5");
        }

        rightDiv.add(addressP1, addressP2, phone, dayAndTime);
        labLocationHorizontalLayout.add(leftImgDiv, rightDiv);

        return labLocationHorizontalLayout;
}
}