package com.company;

import java.util.Scanner;

public class parseint {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String[] names = new String[n];
        int[] numbers = new int[n];
        for(int i = 0; i < n; i++){
            String first = in.nextLine();
            String tempn = "";
            String tempdig = "";
            for(int j = 0;j<first.indexOf(' ');j++){
                tempn = tempn + first.charAt(j);
            }
            for(int j = first.indexOf(' ')+1;j<first.length();j++){
                tempdig = tempdig + first.charAt(j);
                System.out.println(tempdig);
            }
            names[i] = tempn;
            numbers[i] = Integer.parseInt(tempdig);
        }
    }
}
