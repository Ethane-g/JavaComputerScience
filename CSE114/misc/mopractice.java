package com.company;
import java.util.ArrayList;
import java.util.*;
public class mopractice {
    public static void main(String[] args){

        int[] alpha = {1,2,3,4,5,6};
        String[] beta = {"first","second","third"};
        ArrayList<Integer> numblist = new ArrayList(Arrays.asList(alpha));
        int[] alphaprint = new int[6];

        ArrayList<String> betalist = new ArrayList<>(Arrays.asList(beta));
        java.util.Collections.shuffle(betalist);
        System.out.println(betalist);
        for(int i=0;i<6;i++){
            System.out.println(alphaprint[i] + " ,");
        }
    }
}
