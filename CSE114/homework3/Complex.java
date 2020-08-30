//Ethan Garcia
package com.company;

class Complex {
    private double real;
    private double imaginary;

    public Complex(){
        real = 1;
        imaginary = 1;
        System.out.println("no argument given");
    }
    public Complex(double newreal,double newimaginary){
        real =  newreal;
        imaginary = newimaginary;
    }
    public double getReal() {
        return real;
    }
    public double getImaginary() {
        return imaginary;
    }

    public Complex(double a, double ai, double b, double bi, int q){
        if(q ==1) {
            real = a - b;
            imaginary = ai - bi;
        }
        if(q == 2){
            real = a + b;
            imaginary = ai + bi;
        }
    }
    public static void printer(Complex a){
       System.out.print("("+a.getReal()+" "+a.getImaginary()+")");
        System.out.println("\r");
    }
}
