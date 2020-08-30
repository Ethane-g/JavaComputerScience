package com.company;
import java.util.Scanner;
// Name: Ethan Garcia
// Id: 112752608
// Summer class, section 1.
public class Analysis {
    /**
     * main driver
     * @param args
     */
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input the probability an individual will enter the elevator");
        double prob = stdin.nextDouble();
        System.out.println("please input the number of floors");
        int floors = stdin.nextInt();
        System.out.println("please input the number of elevators");
        int elevators = stdin.nextInt();
        System.out.println("please give the time length of the simulation");
        int time = stdin.nextInt();
        Simulator.simulate(prob,floors,elevators,time);
    }
}
