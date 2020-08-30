package com.company;
import java.util.Scanner;
public class CSE114lab5 {
    public static void main(String[] args){
    Scanner stdin = new Scanner(System.in);
        int candiv6 = 0;
        int candiv5 = 0;
        int both = 0;
    System.out.println("please input the positive 3 digit integer");
    int input = stdin.nextInt();
    //obtains last digit
    int input1 = input % 10;
    //uses last 2 digits to subtract from original to obtain first digit
    int input2 = (input - (input % 100))/100;
    if(input1 == input2){
        System.out.println(input + " is a palindrome");
    }
    else{
        System.out.println(input + " is NOT a palindrome");
    }
    System.out.println("please input the digit");
    int div = stdin.nextInt();
    if((div % 5) == 0){
        candiv5 = 1;
    }
    if((div % 6) == 0){
        candiv6 = 1;
    }
    if((div % 6) == 0 && (div %5) == 0){
        both = 1;
    }
    if(candiv6 == 1 && candiv5 ==1) {
        System.out.println("is " + div + " divisible by 5 and 6? True");
    }
    else{
        System.out.println("is " + div + " divisible by 5 and 6? False");
    }
    if(candiv6 == 1 || candiv5 ==1){
        System.out.println("is " + div + " divisible by 5 or 6? True");
    }
    else{
        System.out.println("is " + div + " divisible by 5 or 6? False");
    }
    if(both == 1){
        System.out.println(("is " + div + " divisible by 5 or 6, but not both? false"));
    }
    else{
        System.out.println(("is " + div + " divisible by 5 or 6, but not both? true"));
    }
    }
}
