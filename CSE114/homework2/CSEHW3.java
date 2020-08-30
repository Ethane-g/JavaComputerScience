//Ethan Garcia

package com.company;
import java.util.Scanner;
public class CSEHW3 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        String[] cities = new String[10];
        String temp;
        System.out.println("Please input the cities names one at a time");
        for(int a=0;a<10;a++){
            cities[a] = stdin.nextLine();
        }
        for(int i=0;i<10;i++){
            for (int j = i+1;j<10;j++){
                    if (cities[i].compareTo(cities[j]) > 0) {
                        temp = cities[j];
                        cities[j] = cities[i];
                        cities[i] = temp;
                }
            }
        }
        System.out.println("The sorted strings are ");
        for(int a=0;a<10;a++){
            System.out.print(cities[a]   + " ");
        }
    }
}
