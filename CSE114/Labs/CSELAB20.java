package com.company;
import java.util.Scanner;
public class CSELAB20 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
    System.out.println("please the 3 sides one at a time");
    double s1 = stdin.nextInt();
    double s2 = stdin.nextInt();
    double s3 = stdin.nextInt();
    System.out.println("is it filled?");
    boolean filled = stdin.nextBoolean();
    System.out.println("What color is it?");
    String color = stdin.next();
    Triangle s = new Triangle(s1,s2,s3);
    s.setFilled(filled);
    s.setColor(color);
    System.out.println("the perimeter is " + s.getPerim());
    System.out.println("the area is " + s.getArea());
    System.out.println("is the object filled? " + s.isFilled());
    System.out.println("What color is the object? " +s.getColor());
    System.out.println("What date was the object created on?" + s.getDateCreated());

    Employee prav = new Employee();
    String al = "prav";
    prav.setName(al);
        System.out.println(prav);





    }

}
