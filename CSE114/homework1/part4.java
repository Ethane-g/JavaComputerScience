//Ethan Garcia
//112752608
package com.company;
import java.util.Scanner;
public class part4 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.print("Please type your input: ");
        String input = stdin.nextLine();
        int caps = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c >= 'A' && c <= 'Z') {
                caps++;
            }
            }
        System.out.println("The string has " + caps + " capital letter(s)" );
        stdin.close();
        }
    }
