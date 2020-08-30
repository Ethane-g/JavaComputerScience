package com.company;
import java.util.Scanner;
public class CSELAB18 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input the first number to be converted");
        int in = stdin.nextInt();
        String out1 = dec2Bin(in);
        System.out.println(out1);
        System.out.println("please input the second number to be converted");
        String in2 = stdin.next();
        int out2 = bin2dec(in2);
        System.out.println(out2);
    }
    public static int bin2dec(String a){
        int sum = 0;
        for(int i=0;i<a.length();i++){
            char q = a.charAt(a.length()-1-i);
            if(q == '1') {
                sum = (int) (sum + (1 * Math.pow(2,i)));
            }
        }
        return sum;
    }
    public static String dec2Bin(int value){
        double num = value;
        String s = "";
        while(value > 0){
            s = s + value%2;
            value = value/2;
        }
        int[] array = new int[s.length()];
        for(int i=0;i<s.length();i++){
            array[i] = s.charAt(s.length()-i-1);
        }
        String end = "";
        for(int i=0;i<array.length;i++){
            end = end + (char)array[i];
        }
        return end;
    }
}
