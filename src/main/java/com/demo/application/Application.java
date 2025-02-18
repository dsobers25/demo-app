package com.demo.application;

import com.vaadin.flow.component.page.AppShellConfigurator;
import com.vaadin.flow.server.AppShellSettings;
import com.vaadin.flow.theme.Theme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * The entry point of the Spring Boot application.
 *
 * Use the @PWA annotation make the application installable on phones, tablets
 * and some desktop browsers.
 *
 */
@SpringBootApplication
@Theme(value = "demo-app")
public class Application extends SpringBootServletInitializer implements AppShellConfigurator {
    @Override
    public void configurePage(AppShellSettings settings) {
        settings.addFavIcon("icon", "/images/favicon.ico", "16x16");
        // settings.addFavIcon("icon", "/images/favicon-32x32.png", "32x32");
        // settings.addLink("apple-touch-icon", "/images/apple-touch-icon.png");
    }
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
