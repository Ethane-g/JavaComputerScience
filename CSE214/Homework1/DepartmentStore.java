package com.company;

import java.util.Scanner;

public class DepartmentStore {
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        char option = 0;
        ItemList shelf = new ItemList();
        do{
            menu();
            String in = stdin.nextLine();
            option = in.charAt(0);
            if(option == 'C'||option =='c'){
                System.out.println("Cleaning store...");
                shelf.Cleanup();
            }
            if(option == 'I'||option =='i'){
                System.out.println("what is the name of the item?");
                String name = stdin.nextLine();
                System.out.println("What is the rfid tag?");
                String rfid = stdin.nextLine();
                System.out.println("What is the price");
                double price = stdin.nextDouble();
                stdin.nextLine();
                System.out.println("What is the location?");
                String locat = stdin.nextLine();
                String placeholder = null;
            shelf.Insert(name,rfid,price,locat,placeholder);
            }
            if(option == 'L'||option =='l'){
                System.out.println("please input the location to be listed: shelf or cart");
                String searching = stdin.nextLine();
                if(searching.equalsIgnoreCase("shelf")){
                    shelf.printallbylocation('s');
                }
                else if(searching.equalsIgnoreCase("cart")){
                    shelf.printallbylocation('c');
                }
            }
            if(option == 'M'||option =='m'){
                System.out.println("please input the rfid to be moved");
                String rfid = stdin.nextLine();
                System.out.println("please input the source");
                String source = stdin.nextLine();
                System.out.println("please input the destination");
                String dest = stdin.nextLine();
                shelf.moveitem(rfid,source,dest);
            }
            if(option == 'O'||option =='o'){
                shelf.checkout();
            }
            if(option == 'P'||option =='p'){
                shelf.printall();
            }
            if(option == 'R'||option =='r'){
                System.out.println("please give the rfid to be checked for");
                String rfid = stdin.nextLine();
                shelf.printallbyrf(rfid);
            }
            if(option == 'U'||option =='u'){
            shelf.removeallpurchased();
            }
        }while(option != 'q' && option != 'Q');
        System.out.println("program terminates normally");
    }

    /**
     * prints all menu options
     * O(1)
     */
    public static void menu(){
        System.out.println("Welcome!");
        System.out.println("C - Clean store");
        System.out.println("I - Insert an item into the list");
        System.out.println("L - List by location");
        System.out.println("M - Move an item in the store");
        System.out.println("O - Checkout");
        System.out.println("P - Print all items in store");
        System.out.println("R - Print by RFID tag number");
        System.out.println("U - Update inventory system");
        System.out.println("Q - Exit the program.");
    }
}
