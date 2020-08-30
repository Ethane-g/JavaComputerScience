package com.company;
// Name: Ethan Garcia
// Id: 112752608
// Summer class, section 1.
public class Request {
    private int sourceFloor;
    private int destinationFloor;
    private int timeEntered;

    /**
     * Request constructor
     * @param numbFloors
     * int as number of floors
     * time entered is not known at creation, so a mutator is used to alter that at desired time
     *
     * both source floor and destination floor are determined randomly with max floor being the max number of floors in the building
     */
    public Request(int numbFloors){
        this.sourceFloor = (int)(1+ Math.random() *(numbFloors-1));
        this.destinationFloor = (int)(1+ Math.random() *(numbFloors-1));
    }

    public int getTimeEntered() {
        return timeEntered;
    }

    public void setTimeEntered(int timeEntered) {
        this.timeEntered = timeEntered;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }

    public int getSourceFloor() {
        return sourceFloor;
    }

    public void setSourceFloor(int sourceFloor) {
        this.sourceFloor = sourceFloor;
    }

    @Override
    public String toString() {
        return "Request{" +
                "sourceFloor=" + sourceFloor +
                ", destinationFloor=" + destinationFloor +
                ", timeEntered=" + timeEntered +
                '}';
    }
}
