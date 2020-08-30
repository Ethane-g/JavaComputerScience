//Ethan Garcia

package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input the string to be checked for palindrome");
        String input1 = stdin.nextLine();
        String input = input1.toLowerCase();
        boolean isPal = true;
        int front = 0;
        int back= input.length()-1;
        while(front<back){
            while(input.charAt(front) == ' '|| input.charAt(back) == ' '){
                if(input.charAt(front) == ' ') {
                    front++;
                }
                if(input.charAt(back) == ' '){
                    back--;
                }
            }
            if(input.charAt(front) != input.charAt(back)){
                isPal = false;
                break;
            }
            front++;
            back--;
        }
        if(isPal){
            System.out.println("the string " + input1 + " is a palindrome");
        }
        else{
            System.out.println("the string " + input1 + " is NOT a palindrome");
        }
    }
}

