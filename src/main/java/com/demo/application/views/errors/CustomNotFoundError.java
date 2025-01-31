package com.demo.application.views.errors;

import com.demo.application.views.MainLayout;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.ErrorParameter;
import com.vaadin.flow.router.HasErrorParameter;
import com.vaadin.flow.router.NotFoundException;
import jakarta.servlet.http.HttpServletResponse;

public class CustomNotFoundError extends VerticalLayout implements HasErrorParameter<NotFoundException> {

   public CustomNotFoundError() {
       setSizeFull();
       setJustifyContentMode(JustifyContentMode.CENTER);
       setAlignItems(Alignment.CENTER);
       
       // Set gradient background
       getStyle()
           .set("background", "linear-gradient(180deg, #FFFFFF 0%, #40E0D0 100%)")
           .set("margin", "0")
           .set("padding", "0");

       // Create error content container
       Div contentDiv = new Div();
       contentDiv.getStyle()
           .set("text-align", "center")
           .set("padding", "24px")
           .set("background", "rgba(255, 255, 255, 0.9)")
           .set("border-radius", "8px")
           .set("box-shadow", "0 4px 6px rgba(0, 0, 0, 0.1)");

       H1 header = new H1("Page Not Found (404)");
       header.getStyle()
           .set("margin", "0 0 16px 0")
           .set("color", "#333333");

       Paragraph errorText = new Paragraph("The requested page could not be found.");
       errorText.getStyle()
           .set("margin", "0 0 24px 0")
           .set("color", "#666666");

       // Home button/link
       Anchor homeLink = new Anchor("/", "Go Back Home");
       homeLink.getStyle()
           .set("display", "inline-block")
           .set("padding", "12px 24px")
           .set("background-color", "#40E0D0")
           .set("color", "white")
           .set("text-decoration", "none")
           .set("border-radius", "4px")
           .set("font-weight", "bold")
           .set("transition", "background-color 0.3s")
           .set("cursor", "pointer");

       // Hover effect for the button
       homeLink.getElement().executeJs(
           "this.addEventListener('mouseover', () => this.style.backgroundColor = '#3CC0B0');" +
           "this.addEventListener('mouseout', () => this.style.backgroundColor = '#40E0D0');"
       );

       contentDiv.add(header, errorText, homeLink);
       add(contentDiv);
   }

   @Override
   public int setErrorParameter(BeforeEnterEvent event, ErrorParameter<NotFoundException> parameter) {
       // Get the attempted URL path
       String attemptedPath = event.getLocation().getPath();
       
       // Add the attempted path to the error message
       Paragraph urlText = new Paragraph("Attempted URL: " + attemptedPath);
       urlText.getStyle()
           .set("margin", "0 0 24px 0")
           .set("color", "#666666")
           .set("font-family", "monospace");
       
       // Add it after the error text but before the button
       getChildren().findFirst().ifPresent(component -> {
           if (component instanceof Div) {
               Div contentDiv = (Div) component;
               // Insert the URL text before the last child (the home button)
               contentDiv.getChildren().reduce((a, b) -> b).ifPresent(lastComponent -> 
                   contentDiv.addComponentAsFirst(urlText)
               );
           }
       });

       return HttpServletResponse.SC_NOT_FOUND;
   }
}