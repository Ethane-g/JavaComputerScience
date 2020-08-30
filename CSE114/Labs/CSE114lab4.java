package com.company;

import java.util.Scanner;

public class CSE114lab4 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input values a,b, and c");
        double a = stdin.nextDouble();
        double b = stdin.nextDouble();
        double c = stdin.nextDouble();
        double r1;
        double r2;
        double des = (b*b) - 4*a*c;
        if(des > 0){
            des = Math.pow(des,.5);
            r1 = (-b + des)/(2*a);
            r2 = (-b - des)/(2*a);
            System.out.println("the roots are: "+ r1 + " and "+ r2);
        }
        if(des < 0){
            System.out.println("There are no real roots");
        }
        if(des == 0){
            r1 = -b / 2 * a;
            System.out.println("The singular root is: " + r1);
        }
        System.out.println("please input the weight:");
        double w = stdin.nextDouble();
        if(w >0 && w <= 1)
            System.out.println("The cost is 3.5");
        if(w >1 && w <=3)
            System.out.println("The cost is 5.5");
        if(w >3 && w <=10)
            System.out.println("The cost is 8.5");
        if(w >10 && w <=20)
            System.out.println("the cost is 10.5");
        if(w == 0 || w < 0)
            System.out.println("Invalid input");
        if(w > 20)
            System.out.println("The package cannot be shipped");
    }

}
