package com.company;
import java.util.Scanner;
public class tests {
    static boolean isgame = false;
    static char winner = 'Y';
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        char[][] arr = new char[6][6];
        for(int i=0; i<6;i++){
            for(int j=0; j<6;j++){
                arr[i][j] = 'O';
            }
        }
        boardprint(arr);
        /*for(int i=0;i<4;i++){
            arr[i][i] = 'Y';
        }
        for(int i=0;i<4;i++){
            arr[i][5] = 'Y';
        }
        for(int i=0;i<4;i++){
            arr[0][i] = 'Y';
        }
        */

        for(int i = 0;i<4;i++){
            arr[0+i][5-i] = 'Y';
        }
        boardprint(arr);
        System.out.println(isgame);

    }
    public static void boardprint(char[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print("|"+a[i][j]);
            }
            System.out.println("|");
        }
        for(int i=0;i<5;i++)
            System.out.println("\r");

    }
    public static void boardcheckdiagonalleft(char[][] a){
        int[] target = new int[2];
        target[0] = 0;
        target[1] = 0;
        int sum = 0;
        for(int i = 0; i<4;i++){
            if(a[0+i][0+i]=='Y'){
                sum++;
            }
        }
        if(sum ==4){
            isgame = true;
        }
    }
    public static void boardcheckvertical(char[][] a){
        int[] target = new int[2];
        target[0] = 0;
        target[1] = 5;
        int sum = 0;
        for(int i=0;i<4;i++){
            if(a[target[0]+i][target[1]] == 'Y'){
                sum++;
            }
        }
        if(sum ==4){
            isgame = true;
        }
    }
    public static void boardcheckhorizontal(char[][] a){
        int[] target = new int[2];
        target[0] = 0;
        target[1] = 0;
        int sum = 0;
        for(int i=0;i<4;i++){
            if(a[target[0]][target[0]+i] == 'Y'){
                sum++;
            }
        }
        if(sum ==4){
            isgame = true;
        }
    }
}
