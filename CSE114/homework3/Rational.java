//Ethan Garcia
package com.company;

public class Rational {
    private int num;
    private int den;

    public Rational(){
        num = 1;
        den = 1;
        System.out.print("No arg given");
    }
    public Rational(int numerator, int denominator){
        num = numerator;
        den = denominator;
        if(num%2==0&&den%2==0)
            while(num%2==0&&den%2==0){
                num = num/2;
                den = den/2;
        }
        if(num%3==0&&den%3==0){
            while(num%3==0&&den%3==0){
                num = num/3;
                den = den/3;
            }
        }
    }
    public Rational(int a,int b,int c,int d,int q){
        if(q == 1) {
            //add
            int ad = a * d;
            int cb = c * b;
            int bd = b * d;
            num = ad + cb;
            den = bd;
        }
        if(q == 2){
            //sub
            int ad = a*d;
            int cb = c*b;
            int bd = b*d;
            num = ad - cb;
            den = bd;
        }
        if(q == 3){
            //mul
            num = a*c;
            den = b*d;
        }
        if(q == 4){
            //div
            num = a*d;
            den = b*c;
        }
        if(num%2==0&&den%2==0)
            while(num%2==0&&den%2==0){
                num = num/2;
                den = den/2;
            }
        if(num%3==0&&den%3==0){
            while(num%3==0&&den%3==0){
                num = num/3;
                den = den/3;
            }
        }
    }

    public static void printer(Rational a){
        System.out.print(a.getNum()+"/"+a.getDem());
        System.out.println("\r");
    }
    public int getNum() {
        return num;
    }
    public int getDem() {
        return den;
    }
}
