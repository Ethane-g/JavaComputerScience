package com.company;

import java.util.Scanner;

public class CSE114lab3 {
    public static void main(String[] args) {
        //𝑓𝑎ℎ𝑟𝑒𝑛ℎ𝑒𝑖𝑡 = (9 / 5) ∗ 𝐶𝑒𝑙𝑠𝑖𝑢𝑠 + 32
        Scanner stdin = new Scanner(System.in);
        System.out.println("Please input the celsius: ");
        double c = stdin.nextDouble();
        double far = ((9.0/5)*c) +32;
        System.out.println(c+" celsius is " + far +" degrees fahrenheit");
        System.out.println("Input the Mass:");
        double mass = stdin.nextDouble();
        System.out.println("Input the initial temperature:");
        double it = stdin.nextDouble();
        System.out.println("Input the final temperature:");
        double ft = stdin.nextDouble();
        double Q = (ft-it) * mass * 4184;
        System.out.println("The final heat is: "+Q);
        stdin.close();
    }
}
