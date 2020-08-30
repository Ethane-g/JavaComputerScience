package com.company;
import java.util.Scanner;
public class CSELAB19 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int[][] arr = new int[5][2];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                arr[i][j] = stdin.nextInt();
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.println("\r");
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+ " ");
            }
        }
        sort(arr);
        System.out.println("\r");
        System.out.println("\r");
        System.out.println("\r");
        for(int i=0;i<arr.length;i++){
            System.out.println("\r");
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+ " ");
            }
        }
        System.out.println("\r");
        System.out.println("please input your integer");
        int a = stdin.nextInt();
        System.out.println("please input the value to compare");
        int val = stdin.nextInt();
        MyInteger int1 = new MyInteger(a);
        MyInteger int2 = new MyInteger(val);
        System.out.println("is the int even? "+ int1.isEven());
        System.out.println("is the int odd? "+ int1.isOdd());
        System.out.println("is the int prime? "+ int1.isPrime());
        System.out.println("is the int equal? " + int1.equals(val));
        System.out.println("is the int even? "+ MyInteger.isEven(int1));
        System.out.println("is the int odd? "+ MyInteger.isOdd(int1));
        System.out.println("is the int prime? "+ MyInteger.isPrime(int1));
        System.out.println("is the int equal? "+ int1.equals(int2));








    }
    public static void sort(int[][] m){
        int[] temparr = new int[2];
        int temp;
        for(int i=0;i<m.length;i++)
            for(int j=0;j<m.length-1;j++){
                if(m[j][0]>m[j+1][0]){
                    temparr[0] =m[j][0];
                    temparr[1] =m[j][1];
                    m[j][0] = m[j+1][0];
                    m[j][1] = m[j+1][1];
                    m[j+1][0] = temparr[0];
                    m[j+1][1] = temparr[1];
                }
            }
        for(int i=0;i<m.length;i++)
            for(int j=0;j<m.length-1;j++) {
                if (m[j][1] > m[j+ 1][1]) {
                    if(m[j][0] != m[j+ 1][0]){
                        continue;
                    }
                    else{
                        temp = m[j][1];
                        m[j][1] = m[j+ 1][1];
                        m[j+ 1][1] = temp;
                    }
                }
            }
    }
}
