package com.company;
import java.util.Arrays;
import java.util.Scanner;
public class CSELab11 {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input the amount of numbers for the input");
        int num = stdin.nextInt();
        double[] inputs = new double[num];
        System.out.println("please input the numbers to be averaged");
        for (int i = 0; i < num; i++) {
            inputs[i] = stdin.nextDouble();
        }
        System.out.println("mean is: " + mean(inputs, num));
        System.out.println("deviation is: " + deviation(inputs, num));
        //
        //
        //
        //
        //
        //
        System.out.println("please input the amount of numbers for the input");
        int[] reps = new int[10];
        for (int a = 0; a < num; a++) {
            reps[a] = stdin.nextInt();
        }
        System.out.println(Arrays.toString(eliminateDuplicate(reps)));
    }

    public static double mean(double[] x, int lol) {
        double result = 0;
        for (int i = 0; i < 10; i++) {
            result += x[i];
        }
        return result / lol;
    }

    public static double deviation(double[] x, int lol) {
        double result = 0;
        for (int i = 0; i < 10; i++) {
            result += x[i];
        }
        double mean = result / lol;
        double summationin = 0;
        for (int a = 0; a < lol; a++) {
            summationin += Math.pow((x[a] - mean), 2);
        }
        return (Math.sqrt(summationin / (lol - 1)));
    }

    public static int[] eliminateDuplicate(int[] list) {
        int counter = 0;
        int o = 0;
        int[] temparray = new int[10];
        for (int a = 0; a < 10; a++) {
            for (int b = 0; b < 10; b++) {
                if ((a == 9) && (b == 9)) {
                    temparray[o] = list[a];
                    counter++;
                    o++;
                    break;
                }
                if (a == b) {
                    continue;
                }
                if (a < b && list[a] == list[b]) {
                    temparray[o] = list[a];
                    counter++;
                    o++;
                    break;
                }
               if(list[a] == list[b]){
                   break;
               }
                if ((list.length - 1 == b) && list[a] != list[b]) {
                    temparray[o] = list[a];
                    counter++;
                    o++;
                }
            }
        }
        int haha[] = new int[counter];
        for (int g = 0; g < counter; g++) {
            haha[g] = temparray[g];
        }
        return haha;
    }
}

