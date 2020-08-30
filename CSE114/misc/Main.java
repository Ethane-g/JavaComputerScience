package com.company;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        // bubble sort and assignment from random array
        Scanner stdin = new Scanner(System.in);
        int[] bubblearray = new int[10];
        for (int i = 0; i < 10 - 1; i++) {
            bubblearray[i] = (int) (Math.random() * 11);
        }
        for (int i = 0; i < 9; i++) {
            System.out.print(bubblearray[i] + " ");
        }
        System.out.println("\r");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 8; j++) {
                if (bubblearray[j] > bubblearray[j + 1]) {
                    int temp = bubblearray[j];
                    bubblearray[j] = bubblearray[j + 1];
                    bubblearray[j + 1] = temp;
                }
            }
        }
        for (int i = 0; i < 10 - 1; i++) {
            System.out.print(bubblearray[i] + " ");
        }
        System.out.println("\r");


        //linear search
        System.out.println("please insert key");
        int key = stdin.nextInt();
        int loc = -1;
        for (int i = 0; i < 9; i++) {
            if (bubblearray[i] == key) {
                loc = i;
                break;
            }
        }
        if (loc == -1) {
            System.out.println("the key is not in the array");
        } else {
            System.out.println("the key is at position " + (loc + 1));
        }
        //binary search
        int low, high;
        loc = -1;
        low = 0;
        key = stdin.nextInt();
        high = bubblearray.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (bubblearray[mid] < key) {
                low = mid + 1;
            } else if (bubblearray[mid] > key) {
                high = mid - 1;
            } else if (bubblearray[mid] == key) {
                loc = mid;
                break;
            }
        }
        if (loc == -1) {
            System.out.println("the key is not in the array");
        } else {
            System.out.println("the key is at position " + (loc + 1));
        }
    }
}
