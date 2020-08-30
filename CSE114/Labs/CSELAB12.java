package com.company;
import java.util.Scanner;
public class CSELAB12 {
    public static void main(String[] args){
        Scanner stdin =  new Scanner(System.in);
        System.out.println("please input the first list size and its contents");
        int size1 = stdin.nextInt();
        int[] list1 = new int[size1+1];
        list1[0] = size1;
        for(int i=1; i<=size1; i++){
            list1[i] = stdin.nextInt();
        }

        System.out.println("please input the second list size and its contents");
        int size2 = stdin.nextInt();
        int[] list2 = new int[size2+1];
        list2[0] = size2;
        for(int i=1; i<=size2; i++){
            list2[i] = stdin.nextInt();
        }
        // above is initializing the two arrays
        int[] finarray = merge(list1, list2);
        for(int i=0; i< size1+ size2;i++ ){
            System.out.print(finarray[i] + " ");
        }
        //below is part 2
        System.out.println("\n");
        System.out.println("please input the 10 digit array to be reversed");
        int[] reversein = new int[10];
        for(int i=0; i < 10;i++){
            reversein[i] = stdin.nextInt();
        }
        int[] rev = reversed(reversein);
        for(int i=0; i<10;i++){
            System.out.print(rev[i] + " ");
        }
    }
    public static int[] merge(int[] list1, int[] list2){
    int[] finarray = new int[(list1[0] + list2[0])+1];
    for(int i =0; i<list1[0];i++) {
            finarray[i] = list1[i+1];
    }
    for(int a =1;a<=list2[0];a++){
            finarray[a + list1[0]-1] = list2[a];
    }
    int temp;
    for(int c=0; c < list1[0] + list2[0];c++){
        for(int j = 0; j<(list1[0] + list2[0])-1;j++){
            if(finarray[j]>finarray[j+1]){
                temp=finarray[j];
                finarray[j] = finarray[j+1];
                finarray[j+1] = temp;
            }
        }
    }
    return finarray;
    }
    public static int[] reversed(int[] in){
    int temp = 0;
    for(int i= 0; i<5;i++){
        temp = in[((5*2)-1)-i];
        in[((5*2)-1)-i] = in[i];
        in[i] = temp;
    }
    return in;
    }
    }
