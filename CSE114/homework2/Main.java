package com.company;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int space = 0;
        int spacepos;
        char test;
        Scanner stdin = new Scanner(System.in);
        System.out.print("Please type your input: ");
        String input = stdin.nextLine();
        String initial = input;
        for (int i = 0; i < input.length(); i++) {
        test = input.charAt(i);
        if(test ==  ' '){
            space++;
        }
        }
        for (int a=0; a <space;a++){
            spacepos = input.indexOf(' ');
            input = input.substring(0,spacepos) + input.substring(spacepos+1);
        }
        input = input.toLowerCase();
        int len = input.length();
        int begin,end;
        boolean pall = true;
        for(int i = 0;i<=len/2;i++){
             begin =i;
             end = len-1-i;
             if(input.charAt(begin) != input.charAt(end)){
                 pall = false;
                 break;
             }
        }
        if(pall){
            System.out.println(initial+" is a palindrome ");
        }
        else{
            System.out.println(initial+" is NOT a palindrome ");
        }
    }
}

