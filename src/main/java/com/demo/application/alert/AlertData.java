package com.demo.application.alert;

// AlertData.java

public class AlertData {
    private final String label;
    private final String status;
    private final String route;

    public AlertData(String label, String status, String route) {
        this.label = label;
        this.status = status;
        this.route = route;
    }

    public String getLabel() { return label; }
    public String getStatus() { return status; }
    public String getRoute() { return route; }
}