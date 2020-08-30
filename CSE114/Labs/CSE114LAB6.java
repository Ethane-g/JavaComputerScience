package com.company;
import java.util.Scanner;

public class CSE114LAB6 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Please input the x and y value");
        double x = stdin.nextDouble();
        double y = stdin.nextDouble();
        double distance = Math.sqrt(Math.pow(x,2) + Math.pow(y,2));
        if(distance > 10 || distance == 10){
            System.out.println("The point is not within the circle");
        }
        else{
            System.out.println("The point is within the circle");
        }
        System.out.println("please input the number of sides and length of sides");
        int n = stdin.nextInt();
        double s = stdin.nextDouble();
        double w = (n*Math.pow(s,2));
        double r = 4*(Math.tan((Math.PI/n)));
        System.out.println(w);
        System.out.println(r);
        double Area = w/r;
        System.out.println(Area + "is the area of the polygon");
    }
}
