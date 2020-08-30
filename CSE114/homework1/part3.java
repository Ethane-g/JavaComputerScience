//Ethan Garcia

package com.company;
import java.util.Scanner;
public class part3 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.println("Please type the input");
        String input = stdin.nextLine();
        int vowel = 0;
        int consonant = 0;
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
               vowel++;
            }
            else if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U'){
                vowel++;
            }
            else if(c >= 'A' && c <= 'Z') {
                consonant++;
            }
            else if((c >= 'a') && (c <= 'z')) {
                consonant++;
            }
            }
        System.out.println("The input has " + vowel + " vowels\n" +"The input has "+ consonant + " consonants");
        stdin.close();
        }
    }

