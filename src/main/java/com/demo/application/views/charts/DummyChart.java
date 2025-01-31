package com.demo.application.views.charts;

public class DummyChart {
    public static String jsCode = 
    "const ctx = document.createElement('canvas');" +
    "ctx.id = 'myChart';" +
    "ctx.style.width = '661px';" +
    "ctx.style.height = '397px';" +
    "document.getElementById('chartContainer').appendChild(ctx);" +
    
    "new Chart(ctx, {" +
    "   type: 'line'," +
    "   data: {" +
    "       labels: ['Jan 24 2023', 'Feb 14 2024', 'Jan 25 2025']," +
    "       datasets: [" +
    "           {" +  // Background green zone
    "               data: [44, 44, 44]," +  // Horizontal line at y=44 (top of green zone)
    "               fill: 'start'," +       // Fill to bottom
    "               backgroundColor: 'rgb(80,142,59)'," +
    "               borderWidth: 0," +
    "               pointRadius: 0," +
    "               order: 3" +
    "           }," +
    "           {" +  // Background red zone
    "               data: [85, 85, 85]," +  // Top of graph
    "               fill: '-1'," +          // Fill to previous dataset (green zone)
    "               backgroundColor: 'rgb(187,49,13)'," +
    "               borderWidth: 0," +
    "               pointRadius: 0," +
    "               order: 2" +
    "           }," +
    "           {" +  // Actual data line
    "               data: [67, 52, 50]," +
    "               borderColor: 'white'," +
    "               borderWidth: 3," +
    "               tension: 0.4," +        // This makes the line curved (0 to 1, higher = more curved)
    "               pointRadius: 6," +
    // "               pointBackgroundColor: 'white'," +
    "               pointBackgroundColor: 'rgba(255, 255, 255, 0.5)'," + // White with 50% opacity"
    "               pointBorderColor: 'white'," +
    "               pointBorderWidth: 2," +
    "               fill: false," +
    "               order: 1" +
    "           }" +
    "       ]" +
    "   }," +
    "   options: {" +
    "       responsive: true," +
    "       maintainAspectRatio: false," +
    "       scales: {" +
    "           y: {" +
    "               min: 40," +
    "               max: 85," +
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