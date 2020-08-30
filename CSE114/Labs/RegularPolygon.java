package com.company;

public class RegularPolygon {
    private int n;
    private double side;
    private double x;
    private double y;
    public RegularPolygon(){
        n = 3;
        side = 1;
        x = 0;
        y = 0;
    }

    public RegularPolygon(int a, double b){
        n = a;
        side = b;
        x = 0;
        y = 0;
    }

    public RegularPolygon(int a,double b,double c,double d){
        n = a;
        side = b;
        x = c;
        y = d;
    }

    public double getPerimeter(int n,double s){
        return n*s;
    }
    public double getArea(double n, double s){
        return (n*(s*s))/4*Math.tan((Math.PI)/n);
    }

    public int getN() {
        return n;
    }

    public double getSide() {
        return side;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
