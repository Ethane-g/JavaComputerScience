package com.company;
import java.util.Scanner;
public class CSELAB9 {
    public static void main(String[] args){
        Scanner stdin =  new Scanner(System.in);
        System.out.println("please input the phone number");
        String number = stdin.nextLine();
        String first = number.substring(0,3);
        String Second = number.substring(3,6);
        String last = number.substring(6);
        System.out.println("The final format of the phone number is ("+first+")"+Second+"-"+last);
        //
        System.out.println("please input the sentence to be decrypted");
        String encrypt = stdin.nextLine();
        for(int i=0; i<encrypt.length();i++){
            if(i%2==0){
                System.out.print(encrypt.charAt(i));
            }
        }
        System.out.print(" is the decrypted string");
    }
}
