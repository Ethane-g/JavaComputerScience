package com.company;
public class CSE114LAB7 {
    public static void main(String[] args) {
        char a = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
        System.out.println("The random character is " + a + "\n");
        System.out.println("Generating plate...\n");
        for (int i = 0; i < 3; i++) {
            char b = (char) ('A' + Math.random() * ('Z' - 'A' + 1));
            System.out.print(b);
        }
        for (int i = 0; i < 4; i++) {
            char c = (char) (48 + Math.random() * 10);
            System.out.print(c);
        }
    }
}

