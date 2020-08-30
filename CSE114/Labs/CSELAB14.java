package com.company;
import java.util.Scanner;
public class CSELAB14 {
    public static void main(String[] args){
    Scanner stdin = new Scanner(System.in);
    int[] rand = new int[100];
    int[] sums = new int[10];
    for(int i=0; i<100;i++){
        rand[i] = (int)(Math.random() * 10);
    }
    for(int i=0; i<9;i++){
            sums[i] = 0;
        }
    for(int i=0; i<100;i++){
        switch(rand[i]){
            case 0:
                sums[0] += 1;
                break;
            case 1:
                sums[1] += 1;
                break;
            case 2:
                sums[2] += 1;
                break;
            case 3:
                sums[3] += 1;
                break;
            case 4:
                sums[4] += 1;
                break;
            case 5:
                sums[5] += 1;
                break;
            case 6:
                sums[6] += 1;
                break;
            case 7:
                sums[7] += 1;
                break;
            case 8:
                sums[8] += 1;
                break;
            case 9:
                sums[9] += 1;
                break;
        }
    }
    System.out.print("The amount of numbers respectively");
    for(int i = 0;i<9;i++) {
        System.out.print(sums[i] + " ");
    }
    //
    //
        System.out.println("please input the amount of columns then input amount of rows");
        int col = stdin.nextInt();
        int row = stdin.nextInt();
        System.out.println("Please input the contents of the array");
        double[][] mat = new double[col][row];
        for(int i=0;i<col;i++) {
            for (int j = 0; j < row; j++) {
                mat[i][j] = stdin.nextDouble();
            }
        }
        double diagsum = sumMajorDiagonal(mat);
        System.out.println("Sum along the major axis is " + diagsum);
    }
    private static double sumMajorDiagonal(double[][] a) {
        double sum=0;
        for(int i=0; i<a.length;i++){
                sum += a[i][i];
            }
        return sum;
    }
}
