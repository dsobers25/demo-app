package com.demo.application.views.charts;

public class DummyChart {

    // Create the JavaScript for the chart
    public static String jsCode = 
    "const ctx = document.createElement('canvas');" +
    "ctx.id = 'myChart';" +
    "ctx.style.width = '661px';" +
    "ctx.style.height = '397px';" +
    "document.getElementById('chartContainer').appendChild(ctx);" +
    
    "new Chart(ctx, {" +
    "   type: 'line'," +
    "   data: {" +
    "       labels: ['Jan 12 2023', 'Feb 12 2024', 'Jan 13 2025']," +
    "       datasets: [" +
    "           {" +  // Background green zone
    "               data: [25, 25, 25]," +  // Horizontal line at y=25
    "               fill: 'start'," +
    "               backgroundColor: 'rgb(80,142,59)'," +
    "               borderWidth: 0," +
    "               pointRadius: 0," +
    "               order: 3" +  // Draw first (bottom layer)
    "           }," +
    "           {" +  // Background red zone
    "               data: [45, 45, 45]," +  // Top of graph
    "               fill: '-1'," +  // Fill to previous dataset
    "               backgroundColor: 'rgb(187,49,13)'," +
    "               borderWidth: 0," +
    "               pointRadius: 0," +
    "               order: 2" +  // Draw second
    "           }," +
    "           {" +  // Actual data line
    "               data: [20, 30, 40]," +
    "               borderColor: 'white'," +
    "               borderWidth: 2," +
    "               pointRadius: 3," +
    "               fill: false," +
    "               order: 1" +  // Draw last (top layer)
    "           }" +
    "       ]" +
    "   }," +
    "   options: {" +
    "       responsive: true," +
    "       maintainAspectRatio: false," +
    "       scales: {" +
    "           y: {" +
    "               min: 15," +
    "               max: 45," +
    "               ticks: {" +
    "                   stepSize: 5" +
    "               }" +
    "           }" +
    "       }," +
    "       plugins: {" +
    "           legend: {" +
    "               display: false" +
    "           }" +
    "       }" +
    "   }" +
    "});";

}
