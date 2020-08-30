// Ethan Garcia
package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
	Scanner stdin = new Scanner(System.in);
        int flag1 = 1;
        int flag2 = 1;
        int flag3 = 1;
        double s1 = 1;
        double s2 = 1;
        double s3 =1;
        while(flag1 == 1) {
            System.out.println("please input the first parameter: ");
            String p1 = stdin.nextLine();
            try {
                s1 = Double.parseDouble(p1);
                flag1 = 0;
            }
            catch (NumberFormatException a){
                System.out.println("invalid input try again");
                flag1 = 1;
            }
            if(s1 <= 0){
                System.out.println("Please try again negative inputs are invalid");
                flag1 = 1;
            }
        }
        while(flag2 == 1) {
            System.out.println("please input the second parameter: ");
            String p2 = stdin.nextLine();
            try {
                s2 = Double.parseDouble(p2);
                flag2 = 0;
            }
            catch (NumberFormatException a){
                System.out.println("invalid input try again");
                flag2 = 1;
            }
            if(s1 <= 0){
                System.out.println("Please try again negative inputs are invalid");
                flag2 = 1;
            }
        }
        while(flag3 == 1) {
            System.out.println("please input the third parameter: ");
            String p3 = stdin.nextLine();
            try {
                s3 = Double.parseDouble(p3);
                flag3 = 0;
            }
            catch (NumberFormatException a){
                System.out.println("invalid input try again");
                flag3 = 1;
            }
            if(s1 <= 0){
                System.out.println("Please try again negative inputs are invalid");
                flag3 = 1;
            }
        }

        if ((s1 + s2) > s3 && ((s1 + s3) > s2) && ((s2 + s3) > s1)) {
               double perim = s1 + s2 + s3;
               System.out.println("the input is valid and the perimeter is " + perim);
           } else {
               System.out.println("the input is invalid");
           }
        stdin.close();
    }
}
