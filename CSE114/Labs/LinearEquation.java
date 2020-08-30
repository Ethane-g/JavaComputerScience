package com.company;

public class LinearEquation {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    public LinearEquation(int aa, int ba, int ca, int da, int ea, int fa){
     a =aa;
     b = ba;
     c = ca;
     d = da;
     e = ea;
     f = fa;
    }
    public boolean isSolvable(){
        if((a*d)-(b*c)!=0)
            return true;
        else
            return false;
    }
    public double getX(){
        return ((e*d)-(b*f))/((a*d)-(b*c));
    }
    public double getY(){
        return ((a*f)-(e*c))/((a*d)-(b*c));
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public int getD() {
        return d;
    }

    public int getE() {
        return e;
    }

    public int getF() {
        return f;
    }
}
