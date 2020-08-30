package com.company;
import java.util.Scanner;
public class CSELAB17 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int[] rows = new int[4];
        int[] column = new int[4];
        int[][] arr = new int[4][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                arr[i][j] = (int)(Math.random() *2);
            }
        }
        for(int i=0;i<4;i++) {
            System.out.println("\r");
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(arr[i][j] == 1){
                    rows[i] +=1;
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(arr[j][i] == 1){
                    column[i] +=1;
                }
            }
        }
        int alpha = 0;
        int beta = 0;
        for(int b=0; b < 4;b++ ){
            if(rows[alpha]<rows[b]){
                alpha = b;
            }
        }
        for(int b=0; b < 4;b++ ){
            if(column[beta]<column[b]){
                beta = b;
            }
        }
        alpha += 1;
        beta +=1;
        System.out.println("\r");
        System.out.println("the largest row is "+ alpha);
        System.out.println("the largest column is "+ beta);
        System.out.println("\r");
        System.out.println("please enter the variables");
        int a = stdin.nextInt();
        int b = stdin.nextInt();
        int c = stdin.nextInt();
        int d = stdin.nextInt();
        int e = stdin.nextInt();
        int f = stdin.nextInt();
        LinearEquation charlie = new LinearEquation(a,b,c,d,e,f);
        if(charlie.isSolvable()){
            System.out.println("X is equal to "+ charlie.getX());
            System.out.println("Y is equal to "+ charlie.getY());
        }
        String q = stdin.nextLine();
        String s = "blah ";
        System.out.println(q+s);
    }
}

