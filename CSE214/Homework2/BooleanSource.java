package com.company;
// Name: Ethan Garcia
// Id: 112752608
// Summer class, section 1.
public class BooleanSource {
    //class written by esmaili in lecture
    private double probability;

    /**
     * boolean source object whether or not a request is made
     * @param p
     * possibility double below 1.00 but not below 0
     * @throws IllegalArgumentException
     */
    public BooleanSource(double p)throws IllegalArgumentException{
        if(p< 0.0||p>1.0) {
           throw new IllegalArgumentException();
        }
        probability = p;
    }

    /**
     * boolean for returning whether an event occurs
     * @return
     * returns whether or not the event occurs depending on decimal
     */
    public boolean requestArrive(){
        return (Math.random() <= probability);
    }
}
