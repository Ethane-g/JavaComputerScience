package com.company;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;
    public QuadraticEquation(double newa,double newb,double newc){
        a = newa;
        b = newb;
        c = newc;
    }
    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }

    public double getC() {
        return c;
    }
    public double getDiscriminant(){
        return (b*b)-(4*a*c);
    }
    public double getRoot1(){
        return ((-b+Math.pow((b*b)-(4*a*c),.5))/(2*a));
    }
    public double getRoot2(){
        return ((-b-Math.pow((b*b)-(4*a*c),.5))/(2*a));
    }
}
