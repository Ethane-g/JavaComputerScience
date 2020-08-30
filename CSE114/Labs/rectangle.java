package com.company;
class rectangle{
    private double width;

    private double length;

    public rectangle(){
        width = 1.0;
        length = 1.0;
        System.out.println("No argument given");
    }

    public rectangle(double newWidth,double newLength){
        width = newWidth;
        length =  newLength;
    }

    public double getArea(){
        return width*length;
    }
    public double getPerim(){
        return (length*2)+(width*2);
    }
}