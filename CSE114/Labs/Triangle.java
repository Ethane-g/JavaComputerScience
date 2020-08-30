package com.company;

public class Triangle extends GeometricObject{
    private double s1 =1.0;
    private double s2 =1.0;
    private double s3 =1.0;
    public Triangle(){
    }
    public Triangle(double a, double b, double c){
        this.s1 = a;
        this.s2 = b;
        this.s3 = c;
    }

    public void setS1(double s1) {
        this.s1 = s1;
    }
    public void setS2(double s2){
        this.s2 = s2;
    }
    public void setS3(double s3){
        this.s3 = s3;
    }
    public double getArea(){
        double s = (s1+s2+s3)/2;
        return Math.pow(s*(s -s1)*(s-s2)*(s-s3),.5);
    }
    public double getPerim(){
        return s1+s2+s3;
    }
    public String toString(){
        return "Triangle: side 1= " +s1+" side 2= "+ s2+" side 3= " +s3;
    }
}
