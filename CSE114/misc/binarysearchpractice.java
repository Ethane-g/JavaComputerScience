package com.company;
import java.util.Scanner;
public class binarysearchpractice {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        int[] list = new int[10];
        for(int i=0;i<9;i++){
            list[i] = (int)(Math.random()*11);
        }
        for(int i=0;i<9;i++){
            System.out.print(list[i] + " ");
        }
        System.out.println("\r");
        int[] sortbin = sortarr(list);
        for(int i=0;i<9;i++){
            System.out.print(sortbin[i] + " ");
        }
        System.out.println("\r");
        System.out.println("please input num to be searched for");
        int key = stdin.nextInt();
        int loc = binsearch(sortbin,key);
        if(loc == -1){
            System.out.println("the item is not in the list");
        }
        System.out.println("The item is at position " + (loc+1));


    }
    public static int binsearch(int[]a,int key){
    int high,low;
    high = a.length-1;
    low = 0;
    int loc = -1;
    while(high >= low){
        int mid = (high+low)/2;
        if(key > a[mid]){
            low = mid+1;
        }
        else if(key < a[mid]){
            high = mid -1;
        }
        else{
            loc = mid;
            break;
        }
    }
    return loc;
    }





    public static int[] sortarr(int[] a){
        for(int i=0;i<a.length-1;i++){
            for(int j=0;j<a.length-2;j++){
                if(a[j]>a[j+1]){
                    int temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                }
            }
        }
        return a;
    }
}
