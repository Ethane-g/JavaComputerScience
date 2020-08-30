package com.company;
import java.util.ArrayList;
import java.util.Scanner;
public class CSELAB21 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input the string to be turned into a array list");
        String in = stdin.nextLine();
        System.out.println(toCharacterArray(in));




        ArrayList<String> list1 = new ArrayList<String>();
        list1.add("Austin");
        list1.add("Dallas");
        list1.add("San francisco");
        ArrayList<String> list2 = new ArrayList<String>();
        list2.add("Boston");
        list2.add("Chicago");
        list2.add("Denver");
        ArrayList<String> merge = mergeList(list1,list2);
        System.out.println(merge);







    }
    public static ArrayList<String> mergeList(ArrayList<String> a, ArrayList<String>b){
        ArrayList<String> merged = new ArrayList<String>();
        for(int i=0;i<a.size();i++){
            merged.add(a.get(i));
        }
        for(int i=0;i<b.size();i++){
            merged.add(b.get(i));
        }
        System.out.println(merged);
        for(int i=0;i<merged.size();i++){
            for(int j = 0;j<merged.size()-1;j++){
                if(merged.get(j).compareTo(merged.get(j+1)) > 0){
                    String temp = merged.get(j);
                    merged.set(j,merged.get(j+1));
                    merged.set(j+1,temp);
                }
            }
        }
        return merged;
    }
    public static ArrayList<Character> toCharacterArray(String a){
        ArrayList<Character> chararray = new ArrayList<Character>();
        int curr =0;
        for(int i = 0;i<a.length();i++){
            if(a.charAt(i) != ' '){
                chararray.add(a.charAt(i));
            }
        }
        return chararray;
    }
}
