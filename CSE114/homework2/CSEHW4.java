//Ethan Garcia

package com.company;
import java.util.Scanner;
public class CSEHW4 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        double[][] matrix1 = new double[3][3];
        System.out.println("please input the numbers for the first matrix one at a time");
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                matrix1[i][j] = stdin.nextDouble();
            }
        }
        double[][] matrix2 = new double[3][3];
        System.out.println("please input the numbers for the second matrix one at a time");
        for (int i = 0; i < matrix2.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                matrix2[i][j] = stdin.nextDouble();
            }
        }
            double[][] finmat = multiplyMatrix(matrix1, matrix2);
            for (int i = 0; i < finmat.length; i++) {
                for (int j = 0; j < finmat[0].length; j++) {
                    System.out.print(finmat[i][j] + " ");
                }
                System.out.println("\r");
            }
        }
        public static double[][] multiplyMatrix(double[][] a, double[][] b){
            double[][] finmatrix = new double[3][3];
            for (int i = 0; i < a.length; i++) {
                for (int j = 0; j < a[0].length; j++) {
                    finmatrix[i][j] = 0;
                    for (int f = 0; f < a.length; f++) {
                        finmatrix[i][j] += a[i][f] * b[f][j];
                    }
                }
            }
            return finmatrix;
        }
    }
