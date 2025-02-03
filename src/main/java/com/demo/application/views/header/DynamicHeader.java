package com.demo.application.views.header;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;

public class DynamicHeader extends Div {
    private String pageGreeting; // Remove final
    private String subText;      // Remove final
    private Image img;
    private H1 greeting;
    private Paragraph subTextParagraph;
    
    public DynamicHeader(String pageGreeting, String subText) {
        this.pageGreeting = pageGreeting;
        this.subText = subText;
        this.img = null;
        configureHeader();
    }
 
    public DynamicHeader(String pageGreeting, String subText, Image img) {
        this.pageGreeting = pageGreeting;
        this.subText = subText;
        this.img = img;
        configureHeader();
    }
 
    private void configureHeader() {
        getStyle()
            .set("padding", "24px")
            .set("width", "100%")
            .set("min-height", "128px")
            .set("box-sizing", "border-box")
            .set("background-color", "#e7f5e9")
            .set("position", "relative")
            .set("top", "0")
            .set("z-index", "100")
            .set("display", "flex")
            .set("flex-direction", "column")
            .set("justify-content", "center")
            .set("margin", "0")
            .set("flex-shrink", "0");
 
        addClassName("header-height");
 
        // Initialize class fields instead of local variables
        this.greeting = new H1(pageGreeting);
        this.greeting.getStyle()
            .set("text-align", "center")
            .set("margin", "0")
            .set("padding", "8px 0")
            .set("white-space", "normal");
 
        this.subTextParagraph = new Paragraph(subText);
        this.subTextParagraph.getStyle()
            .set("text-align", "center")
            .set("margin", "0")
            .set("padding", "8px 0")
            .set("white-space", "normal");
 
        this.greeting.addClassName("pageGreeting");
        this.subTextParagraph.addClassName("subText");
 
        // Clear any existing content
    removeAll();

    // Add components in desired order
    if(this.img != null) {
        this.img.setWidth("120px");
        this.img.getStyle()
            .set("display", "block")
            .set("margin-left", "auto")
            .set("margin-right", "auto")
            .set("flex-shrink", "0")
            .set("margin-bottom", "8px");  // Add space between image and text
        
            add(this.img);
        }
 
        add(this.greeting, this.subTextParagraph);
    }
 
    public void updateContent(String pageGreeting, String subText) {
        updateContent(pageGreeting, subText, null);
    }
    
    public void updateContent(String pageGreeting, String subText, Image newImg) {
        // Update text content
        this.greeting.setText(pageGreeting);
        this.subTextParagraph.setText(subText);
        
        // Handle image updates
        if (this.img != null) {
            remove(this.img);
        }
        
        if (newImg != null) {
            this.img = newImg;
            this.img.setWidth("130px");
            this.img.getStyle()
                .set("display", "block")
                .set("margin-left", "auto")
                .set("margin-right", "auto");
     
            // Remove all and add in correct order
            removeAll();
            add(this.img);  // Image first
            add(this.greeting, this.subTextParagraph);  // Then text
        }
    }
 }