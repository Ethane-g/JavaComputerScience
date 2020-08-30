package com.company;

public class MyInteger {
    private int numb;
    public MyInteger(int a){
        this.numb = a;
    }
    public int getNumb(){
        return this.numb;
    }
    public boolean isEven(){
        if(numb%2==0)
            return true;
        else
            return false;
    }
    public boolean isOdd(){
        if(numb%3==0)
            return true;
        else
            return false;
    }
    public boolean isPrime(){
        if (numb <= 1)
            return false;
        for (int i = 2; i < numb; i++)
            if (numb % i == 0)
                return false;
        return true;
    }
    public boolean equals(int a){
        if(this.numb == a)
            return true;
        else
            return false;
    }
    public static boolean isEven(MyInteger a){
        if(a.getNumb()%2==0)
            return true;
        else
            return false;
    }
    public static boolean isOdd(MyInteger a){
        if(a.getNumb()%3==0)
            return true;
        else
            return false;
    }
    public static boolean isPrime(MyInteger a){
        if (a.getNumb() <= 1)
            return false;
        for (int i = 2; i < a.getNumb(); i++)
            if (a.getNumb() % i == 0)
                return false;
        return true;
    }    public boolean equals(MyInteger a){
        if(this.numb == a.getNumb())
            return true;
        else
            return false;
    }

}
