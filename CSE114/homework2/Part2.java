package com.company;
import java.util.Scanner;
public class Part2 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Please input the first string");
        String first = stdin.nextLine();
        String firsta = first.toLowerCase();
        System.out.println("Please input the second string");
        String second = stdin.nextLine();
        String seconda = second.toLowerCase();
        char check;
        int where;
        int leng1 = first.length();
        int leng2 = second.length();
        if (leng1 != leng2){
            System.out.println("the two inputs are not anagrams");
            System.exit(0);
        }
        for(int i = 0; i <= leng1-1; i++){
                check = firsta.charAt(0);
                where = seconda.indexOf(check);
                if(where == -1){
                    System.out.println("the strings are not anagrams");
                    break;
                }
                firsta = firsta.substring(1);
                try {
                    seconda = seconda.substring(0, where) + seconda.substring(where + 1);
                }catch (StringIndexOutOfBoundsException a){
                    seconda = seconda.substring(0,where);
                }
         }
        if(seconda.equals("") && firsta.equals("")){
            System.out.println("The inputs " + first + " and " + second + " are anagrams");
        }
    }
}
