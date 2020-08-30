//Ethan Garcia
//112752608
package com.company;
import java.util.Scanner;

public class part2 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
    System.out.println("Please input the character!");
    char d = stdin.next().charAt(0);

    if(d == 'a' || d == 'e' || d == 'i' || d == 'o' || d == 'u'){
        System.out.println(d + " is a lower case vowel");
    }
    else if(d == 'A' || d == 'E' || d == 'I' || d == 'O' || d == 'U'){
        System.out.println(d + " is an upper case vowel");
        }
    else if(d >= 'A' && d <= 'Z') {
        System.out.println(d + " is an upper case consonant");
    }
    else if((d >= 'a') && (d <= 'z')) {
        System.out.println(d + " is an lower case consonant");
    }
    else{
        System.out.println(d + " is an invalid character");
    }
    stdin.close();
    }
}
