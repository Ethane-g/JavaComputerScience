package com.company;
import java.util.Scanner;
public class CSELAB10 {
    public static void main(String[] args){
        System.out.println("please type in a character to check occurrence");
        Scanner stdin = new Scanner(System.in);
        String in = stdin.nextLine();
        char a = in.charAt(0);
        System.out.println("please input the string");
        in = stdin.nextLine();
        int occur = count(in, a);
        System.out.println(a + " occurs in the string " + in + " " + occur + " times");
        System.out.println("i\t" + "m(i)");
        double c=0;
        for(int i =1; i <= 20; i++){
            c += table(i);
            System.out.println(i+"\t"+c);
        }
    }
    public static double table(double a){
        return  a/(a+1);
    }
    public static int count(String str, char b){
        int occur= 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == (b))
                occur++;
        }
        return occur;
    }

}
