package com.demo.application.history;

// AlertData.java

public class TestHistory {
    private final String label;
    private final String status;
    // field will be reused
    private final String route;

    public TestHistory(String label, String status, String route) {
        this.label = label;
        this.status = status;
        this.route = route;
    }

    public String getLabel() { return label; }
    public String getStatus() { return status; }
    public String getRoute() { return route; }
}