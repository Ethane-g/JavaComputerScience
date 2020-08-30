//Ethan Garcia
package com.company;
import java.util.Scanner;
public class TestComplex {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input the real part of the first complex number");
        double firstReal = stdin.nextDouble();
        System.out.println("please input the imaginary part of the first complex number");
        double firstimaginary = stdin.nextDouble();
        System.out.println("please input the real part of the second complex number");
        double secondReal = stdin.nextDouble();
        System.out.println("please input the imaginary part of the second complex number");
        double secondimaginary = stdin.nextDouble();
        Complex firstcomplex = new Complex(firstReal, firstimaginary);
        Complex secondcomplex = new Complex(secondReal,secondimaginary);
        System.out.print("The first complex number is " );
        Complex.printer(firstcomplex);
        System.out.print("The second complex number is ");
        Complex.printer(secondcomplex);
        Complex Addition = new Complex(firstcomplex.getReal(),firstcomplex.getImaginary(),secondcomplex.getReal(),secondcomplex.getImaginary(),2);
        System.out.print("Addition of the two complex numbers results in ");
        Complex.printer(Addition);
        Complex Subtraction = new Complex(firstcomplex.getReal(),firstcomplex.getImaginary(),secondcomplex.getReal(),secondcomplex.getImaginary(),1);
        System.out.print("Subtraction of the two complex numbers results in ");
        Complex.printer(Subtraction);
    }
}
