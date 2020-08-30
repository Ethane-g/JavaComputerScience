package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class hackerrankdictionary {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, String> myMap = new HashMap<String, String>();
        int n = in.nextInt();
        in.nextLine();
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
            myMap.put(tempn,tempdig);
        }
        String[] looking = new String[n];
        for (int i = 0; i < n; i++) {
            looking[i] = in.nextLine();
        }
        for (int i = 0; i < n; i++) {
            if(myMap.containsKey(looking[i])){
                System.out.println(looking[i]+"="+myMap.get(looking[i]));
            }
            else{
                System.out.println("Not found");
            }
        }
    }
}
/*Scanner in = new Scanner(System.in);
        Map<String, String> myMap = new HashMap<String, String>();
        int n = in.nextInt();
        in.nextLine();
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
            myMap.put(tempn,tempdig);
        }
        while(in.hasNext()){
            String s = in.next();
            if(myMap.containsKey(s)){
                System.out.println(s+"="+myMap.get(s));
            }
            else{
                System.out.println("Not found");
            }
        }
        in.close();
    }
}
*/
