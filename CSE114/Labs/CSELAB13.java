package com.company;
import java.util.Scanner;
public class CSELAB13 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input the amount of rows and columns respectively");
        int row = stdin.nextInt();
        int col = stdin.nextInt();
        double[][] matrix = new double[row][col];
        System.out.println("please input the contents of the array");
        for (int i = 0; i <matrix.length; i++) {
            for (int j = 0; j <matrix[0].length; j++) {
                matrix[i][j] = stdin.nextDouble();
            }
        }
        int[] location = locateLargest(matrix);
        System.out.println("The max value is located at "+ location[0] + ", "+ location[1]);
//
        //
        //
        //
        //
        double[][] markov = new double[3][3];
        for (int i = 0; i <markov.length; i++) {
            for (int j = 0; j <markov[0].length; j++) {
                markov[i][j] = stdin.nextDouble();
            }
        }
        boolean isMarkov = checkMark(markov);
        if(isMarkov)
            System.out.println("The matrix is a markov matrix");
        else
            System.out.println("The matrix is NOT a markov matrix");
    }
    public static int[] locateLargest(double[][] a) {
        double max = a[0][0];
        int[] location = new int[2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                if (a[i][j] > max) {
                    max = a[i][j];
                    location[0] = i;
                    location[1] = j;
                }
            }
        }
        return location;
    }
    public static boolean checkMark(double[][] a){
        boolean check = true;
        double sum=0;
        for(int j =0; j < a[0].length;j++ ){
            sum =0;
            for(int i=0;i<a.length;i++){
                sum += a[i][j];
            }
            if(sum != 1){
                check = false;
                break;
            }
            System.out.println("sum of line is " +sum);
        }
        return check;
    }
}

