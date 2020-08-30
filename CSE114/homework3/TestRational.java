//Ethan Garcia
package com.company;
import java.util.Scanner;
public class TestRational {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input the numerator of the first fraction");
        int a = stdin.nextInt();
        System.out.println("please input the denominator of the first fraction");
        int b = stdin.nextInt();
        System.out.println("please input the numerator of the second fraction");
        int c = stdin.nextInt();
        System.out.println("please input the denominator of the second fraction");
        int d = stdin.nextInt();
        Rational first = new Rational(a,b);
        Rational second = new Rational(c,d);
        System.out.print("The simplified first fraction is ");
        Rational.printer(first);
        System.out.print("The simplified second fraction is ");
        Rational.printer(second);
        Rational add = new Rational(first.getNum(),first.getDem(),second.getNum(),second.getDem(),1);
        System.out.print("Addition of the two fractions is ");
        Rational.printer(add);
        Rational sub = new Rational(first.getNum(),first.getDem(),second.getNum(),second.getDem(),2);
        System.out.print("Subtraction of the two fractions is ");
        Rational.printer(sub);
        Rational mul = new Rational(first.getNum(),first.getDem(),second.getNum(),second.getDem(),3);
        System.out.print("Multiplication of the two fractions is ");
        Rational.printer(mul);
        Rational div = new Rational(first.getNum(),first.getDem(),second.getNum(),second.getDem(),4);
        System.out.print("division of the two fractions is ");
        Rational.printer(div);
    }
}
