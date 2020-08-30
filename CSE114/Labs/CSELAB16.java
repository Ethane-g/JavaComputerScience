package com.company;
import java.util.Scanner;
public class CSELAB16 {
    public static void main(String[] args){
        Scanner stdin = new Scanner(System.in);
        System.out.println("please input the stock symbol, its name, and previous day price once at a time");
        String sym = stdin.nextLine();
        String name = stdin.nextLine();
        double prev = stdin.nextDouble();
        Stock a = new Stock(sym,name,prev);
        System.out.println("please input the current price");
        double b = stdin.nextDouble();
        a.setCurrentPrice(b);
        System.out.println("The percent Change is " + a.getChangePercent(a.getCurrentPrice(),a.getPreviousClosingPrice()));
        RegularPolygon alpha = new RegularPolygon();
        System.out.println("please input the number of sides, side length of the no center poly");
        int na = stdin.nextInt();
        double sidea = stdin.nextDouble();
        RegularPolygon beta = new RegularPolygon(na,sidea);
        System.out.println("please input the number of sides, side length, and x and y coordinates of the center poly");
        int n = stdin.nextInt();
        double side = stdin.nextDouble();
        double x = stdin.nextDouble();
        double y = stdin.nextDouble();
        RegularPolygon c = new RegularPolygon(n, side, x, y);
        System.out.println("the perimeter and area of the no area polygon is " + alpha.getPerimeter(alpha.getN(),alpha.getSide()) +" "+ alpha.getArea(alpha.getN(),alpha.getSide()));
        System.out.println("the perimeter and area of the no center polygon is " + beta.getPerimeter(beta.getN(),beta.getSide()) +" "+ beta.getArea(beta.getN(),beta.getSide()));
        System.out.println("the perimeter and area of the center polygon is " + c.getPerimeter(c.getN(),c.getSide()) +" "+ c.getArea(c.getN(),c.getSide()));
    }
}
