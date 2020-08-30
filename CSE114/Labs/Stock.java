package com.company;

public class Stock {
    private String symbol;
    private String name;
    private double currentPrice;
    private double previousClosingPrice;

    public Stock(String a, String b,double c){
        symbol = a;
        name = b;
        previousClosingPrice = c;
        currentPrice = 0;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
    public double getChangePercent(double a, double b){
        return 100*((a - b) / b);
    }
}
