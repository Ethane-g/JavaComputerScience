package com.company;
import java.util.Scanner;
public class CSELAB15 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        rectangle rectangle1 = new rectangle();
        rectangle rectangle2 = new rectangle(4, 40);
        rectangle rectangle3 = new rectangle(3.5, 35.9);
        System.out.println(rectangle1.getArea());
        System.out.println(rectangle2.getArea());
        System.out.println(rectangle3.getArea());
        System.out.println(rectangle1.getPerim());
        System.out.println(rectangle2.getPerim());
        System.out.println(rectangle3.getPerim());
        System.out.println("please input the a b and c of the quadratic equation one at a time");
        double A = stdin.nextDouble();
        double B = stdin.nextDouble();
        double C = stdin.nextDouble();
        QuadraticEquation QuadraticEquation1 = new QuadraticEquation(A, B, C);
        if (QuadraticEquation1.getDiscriminant()==0)
            System.out.print("The equation has one root:"+QuadraticEquation1.getRoot1());
        else if (QuadraticEquation1.getDiscriminant()>0)
            System.out.print("The equation has two roots"+QuadraticEquation1.getRoot1()+"and"+QuadraticEquation1.getRoot2());
        else
            System.out.print("The equation has no real roots.");
    }
}
