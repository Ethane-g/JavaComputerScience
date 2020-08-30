package com.company;

import java.util.Scanner;

public class CSELAB8 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int blah = 0;
        int random;
       for(int l = 0;l<10;l++){
           random = (int)(50+Math.random()*51);
           System.out.print(random + " ,");
           blah = blah + random;

       }
        double average = (blah)/10;
        System.out.println("The average of 10 random integers is "+average);
        System.out.print("please input the first city: \n");
        String first = stdin.nextLine();
        System.out.print("please input the second city: \n");
        String second = stdin.nextLine();
        System.out.print("please input the third city: \n");
        String third = stdin.nextLine();
        int ab = first.compareToIgnoreCase(second);
        int ac = first.compareToIgnoreCase(third);
        int ba = second.compareToIgnoreCase(first);
        int bc = second.compareToIgnoreCase(third);
        int ca = third.compareToIgnoreCase(first);
        int cb = third.compareToIgnoreCase(second);
        if((ab < 0 && ac < 0)&& bc < 0 ){
            System.out.print(first+ " ,"+ second + " ," + third + ".");
        }
        else if((ab < 0 && ac < 0)&& bc > 0 ){
            System.out.print(first+ " ,"+ third + " ," + second + ".");
        }
        if((ba < 0 && bc < 0)&&  ac < 0 ) {
            System.out.print(second+ " ,"+ first + " ," + third + ".");
        }
         else if((ba < 0 && bc < 0)&&  ac > 0 ) {
            System.out.print(second+ " ,"+ third + " ," + second + ".");
        }
        if((ca < 0 && cb < 0)&&  ba < 0 ) {
            System.out.print(third+ " ,"+ second + " ," + first + ".");
        }
        else if((ca < 0 && cb < 0)&&  ba > 0 ) {
            System.out.print(third+ " ,"+ first + " ," + second + ".");
        }
    }
}
