package com.company;

import java.util.ArrayList;
import java.util.Arrays;


public class exam3practice {
    public static void main(String[] args){
    String[] array = {"red", "green", "blue"};
    ArrayList < String > list = new ArrayList <>(Arrays. asList(array));
    //line below creates a new arraylist and prints largest
        System.out.println(java.util.Collections.max(new ArrayList<String>(Arrays.asList(array))));
    //below does the same thing but with alist thats already created
        System.out.println(java.util.Collections.max(list));
        String[] names = {"Sam", "Steve", "Mary", "Mark"};
        String[] cityNames = {"Delhi", "Seattle", "Chicago", "NYC", "Dallas"};
        ArrayList<String> nameList = new ArrayList<String>(Arrays.asList(names));
        ArrayList<String> cities = new ArrayList<String>(Arrays.asList(cityNames));
        System.out.println(nameList);
        System.out.println(cities);
        ArrayList<ArrayList<String>> test = new ArrayList<>();
        test.add(nameList);
        test.add(cities);
        System.out.println(test);
    }
}
