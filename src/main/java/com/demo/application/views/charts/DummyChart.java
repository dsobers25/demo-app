package com.demo.application.views.charts;

public class DummyChart {
    public static String jsCode = 
    "const ctx = document.createElement('canvas');" +
    "ctx.id = 'myChart';" +
    // Set initial dimensions but make it responsive
    "ctx.style.width = '623px';" +
    "ctx.style.height = '374px';" +
    "ctx.style.maxWidth = '100%';" +  // Make it responsive
    "ctx.style.display = 'block';" +
    "ctx.style.boxSizing = 'border-box';" +
    
    "const container = document.getElementById('chartContainer');" +
    "container.style.width = 'fit-content';" +
    "container.style.maxWidth = '100%';" + // Allow container to shrink on smaller screens
    "document.getElementById('chartContainer').appendChild(ctx);" +
    
    "new Chart(ctx, {" +
    "   type: 'line'," +
    "   data: {" +
    "       labels: ['Jan 24 2023', 'Feb 14 2024', 'Jan 25 2025']," +
    "       datasets: [" +
    "           {" +
    "               data: [44, 44, 44]," +
    "               fill: 'start'," +
    "               backgroundColor: 'rgb(80,142,59)'," +
    "               borderWidth: 0," +
    "               pointRadius: 0," +
    "               order: 3" +
    "           }," +
    "           {" +
    "               data: [85, 85, 85]," +
    "               fill: '-1'," +
    "               backgroundColor: 'rgb(187,49,13)'," +
    "               borderWidth: 0," +
    "               pointRadius: 0," +
    "               order: 2" +
    "           }," +
    "           {" +
    "               data: [67, 52, 50]," +
    "               borderColor: 'white'," +
    "               borderWidth: 3," +
    "               tension: 0.4," +
    "               pointRadius: 6," +
    "               pointBackgroundColor: 'rgba(255, 255, 255, 0.5)'," +
    "               pointBorderColor: 'white'," +
    "               pointBorderWidth: 2," +
    "               fill: false," +
    "               order: 1" +
    "           }" +
    "       ]" +
    "   }," +
    "   options: {" +
    "       responsive: true," +
    "       maintainAspectRatio: true," + // Changed to true to maintain aspect ratio
    "       aspectRatio: 1.67," + // This matches your desired ratio (623/374 ≈ 1.67)
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