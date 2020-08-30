package com.company;

import java.util.ArrayList;
// Name: Ethan Garcia
// Id: 112752608
// Summer class, section 1.
public class RequestQue {
    private ArrayList<Request> Mainqueue;

    /**
     * constructs an arraylist for queues
     *
     * USES ARRAYLIST
     */
    public RequestQue(){
        Mainqueue = new ArrayList<>(0);
    }

    /**
     * adds a request to the queue, to the back of the queue
     * @param a
     * a is a request object
     * print method is to ensure that there is
     */
    public void enqueue(Request a){
        Mainqueue.add(Mainqueue.size(), a);
        System.out.println(a+" has been added to the queue");
        printQueue();
    }

    /**
     * removes the first item to the list and returns it
     * @return
     * removes the returned item
     */
    public Request dequeue(){
        System.out.println(Mainqueue.get(0)+" has been removed from the queue");
        Request a = Mainqueue.get(0);
        Mainqueue.remove(0);
        return a;
    }

    /**
     *
     * @return
     * returns first item
     */
    public Request getfirst(){
        return Mainqueue.get(0);
    }

    /**
     *
     * @return
     * returns true whether or not the list is empty
     */
    public boolean isEmpty(){
        return Mainqueue.isEmpty();
    }

    /**
     * prints every item in the list
     */
    public void printQueue(){
        System.out.print("items in queue are");
        for(int i=0;i<Mainqueue.size();i++){
            System.out.print(Mainqueue.get(i));
        }
        System.out.println();
    }
}
