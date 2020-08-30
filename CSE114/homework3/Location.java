//Ethan Garcia
package com.company;
import java.util.Scanner;

public class Location {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        //start of part 3
        double[][] sortarr = new double[3][3];
        System.out.println("please enter the values of the matrix one at a time");
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                sortarr[i][j] = stdin.nextDouble();
            }
        }
        for(int i=0;i<3;i++){
            System.out.println("\r");
            for(int j=0;j<3;j++){
                System.out.print(sortarr[i][j]+ " ");
            }
        }
        System.out.println("\r");
        System.out.println("\r");
        double[][] finarr = sortRows(sortarr);
        for(int i=0;i<3;i++){
            System.out.println("\r");
            for(int j=0;j<3;j++){
                System.out.print(finarr[i][j] + " ");
            }
        }
    }
    public static double[][] sortRows(double[][] a){
        double temp;
        double[][] newarr = a;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                for(int l=0;l<2;l++){
                    if(newarr[i][l]>newarr[i][l+1]){
                        temp = newarr[i][l];
                        newarr[i][l]=newarr[i][l+1];
                        newarr[i][l+1] = temp;
                    }
                }
            }
        }
        return newarr;
    }
}