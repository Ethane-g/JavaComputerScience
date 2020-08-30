package com.company;

import java.util.Scanner;

public class hackerrankdictionaryWITHOUTHASH {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            in.nextLine();
            String[] names = new String[n];
            int[] numbers = new int[n];
            for (int i = 0; i < n; i++) {
                String first = in.nextLine();
                String tempn = "";
                String tempdig = "";
                for (int j = 0; j < first.indexOf(' '); j++) {
                    tempn = tempn + first.charAt(j);
                }
                for (int j = first.indexOf(' ') + 1; j < first.length(); j++) {
                    tempdig = tempdig + first.charAt(j);
                }
                names[i] = tempn;
                numbers[i] = Integer.parseInt(tempdig);
            }
            String[] looking = new String[n];
            for (int i = 0; i < n; i++) {
                looking[i] = in.nextLine();
            }
            for (int a = 0; a < n; a++) {
                int notfound = 0;
                for (int i = 0; i < n; i++) {
                    if (looking[a].equals(names[i])) {
                        System.out.println(looking[a] + "=" + numbers[a]);
                        continue;
                    } else {
                        notfound++;
                    }
                }
                if (notfound == n) {
                    System.out.println("Not found");
                }
            }
        }
    }
