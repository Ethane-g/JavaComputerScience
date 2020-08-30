//Ethan Garcia
//112752608
package com.company;
import java.util.Scanner;
import static java.lang.Integer.parseInt;

public class Main {
    static boolean isgamegoing = true;
    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);
        //initialize game board
        char[][] board = new char[6][7];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = ' ';
            }
        }
        boardprint(board);
        char color = 'R';
        int column =0;
        String input;
        boolean isvalid = false;
        while (isgamegoing) {
            System.out.println("it is " + color + "'s turn. please make a selection from 1-7");
            input = stdin.nextLine();
            isvalid = false;
            while(!isvalid) {
                try {
                    column = parseInt(input);
                    if(column<1||column>7){
                        System.out.println("please make a valid input");
                        input = stdin.nextLine();
                        continue;
                    }
                    if(board[0][column-1] != ' '){
                        System.out.println("please make a valid input");
                        input = stdin.nextLine();
                        continue;
                    }
                        isvalid = true;

                } catch (NumberFormatException e) {
                    System.out.println("please make a valid input");
                    input = stdin.nextLine();
                }
            }
                isvalid = false;
            board = placechip(board, column, color);
            boardcheckvertical(board);
            boardcheckdiagonalleft(board);
            boardcheckhorizontal(board);
            boardcheckdiagonalright(board);
            boardprint(board);
            int drawcheck= 0;
            for(int i=0;i<7;i++){
                if(board[0][i] != ' '){
                    drawcheck++;
                }
            }
            if(drawcheck==7){
                System.out.println("the game has ended in a draw");
                System.exit(1);
            }
            if(isgamegoing==false){
                break;
            }
            if (color == 'R') {
                color = 'Y';
                continue;
            }
            if (color == 'Y') {
                color = 'R';
            }
        }
        System.out.println("the winner is "+ color);
    }



    public static void boardcheckdiagonalright(char[][] a) {
        int[] target = new int[2];
        for (int q = 0; q < 3; q++) {
            for (int p = 0; p < 4; p++) {
                target[0] = q;
                target[1] = 6 - p;
                char currcolor = a[target[0]][target[1]];
                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    if ((a[target[0]+i][target[1]-i] == currcolor)&&currcolor!=' ') {
                        sum++;
                    }
                }
                if (sum == 4) {
                    isgamegoing = false;
                    break;
                }
            }
        }
    }


    public static void boardcheckhorizontal(char[][] a) {
        int[] target = new int[2];
        for (int q = 0; q < a.length; q++) {
            for (int p = 0; p < 4; p++) {
                target[0] = q;
                target[1] = p;
                int sum = 0;
                char currcolor = a[target[0]][target[1]];
                for (int i = 0; i < 4; i++) {
                    if ((a[target[0]][target[1]+i] == currcolor)&&currcolor!=' ') {
                        sum++;
                    }
                }
                if (sum == 4) {
                    isgamegoing = false;
                    break;
                }
            }
        }
    }



    public static void boardcheckdiagonalleft(char[][] a) {
        int[] target = new int[2];
        for (int q = 0; q < 3; q++) {
            for (int p = 0; p < 4; p++) {
                target[0] = q;
                target[1] = p;
                char currcolor = a[target[0]][target[1]];
                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    if ((a[target[0]+i][target[1]+i] == currcolor)&&currcolor!=' ') {
                        sum++;
                    }
                }
                if (sum == 4) {
                    isgamegoing = false;
                    break;
                }
            }
        }
    }
    public static void boardcheckvertical(char[][] a){
        int[] target = new int[2];
        for(int q = 0;q<3;q++) {
            for (int p = 0; p < 6; p++) {
                target[0] = q;
                target[1] = p;
                char currcolor = a[target[0]][target[1]];
                int sum = 0;
                for (int i = 0; i < 4; i++) {
                    if ((a[target[0] + i][target[1]] == currcolor)&&currcolor!=' ') {
                        sum++;
                    }
                }
                if (sum == 4) {
                    isgamegoing = false;
                    break;
                }
            }
        }
    }
    public static char[][] placechip(char[][] a,int b,char w) {
        //function to put a chip on the board
        //must move a space up if it is filled in
        //b is which column
        //called once per turn
        b = b - 1;
            int counter = 0;
            if(a[6 - counter - 1][b] != ' ') {
                while (a[6 - counter - 1][b] != ' ') {
                    counter++;
                }
                a[6 - counter - 1][b] = w;
            }
            else{
                a[6 - counter - 1][b] = w;
            }
        return a;
    }
    public static void boardprint(char[][] a){
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                System.out.print("|"+a[i][j]);
            }
            System.out.println("|");
        }
        for(int i=1;i<8;i++){
            System.out.print(" "+i);
        }
        for(int i=0;i<2;i++)
            System.out.println("\r");

    }

}