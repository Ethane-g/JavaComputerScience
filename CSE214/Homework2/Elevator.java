package com.company;
// Name: Ethan Garcia
// Id: 112752608
// Summer class, section 1.
public class Elevator {
    //idle = 0
    //to source = 1
    //to dest = 2
    final int idle = 0;
    final int tosource = 1;
    final int todest = 2;
    private int currentFloor;
    private int elevatorState;
    private Request request;

    /**
     * main constructor for individual elevators
     * all elevators originate on 1st floor
     * by default they are all idle
     * doesnt use final ints but theyre all distinct states of being
     */
    public Elevator(){
        this.currentFloor = 1;
        this.elevatorState=0;
    }

    public Request getRequest() {
        return request;
    }

    public void setRequest(Request request) {
        this.request = request;
    }

    public int getElevatorState() {
        return elevatorState;
    }

    public void setElevatorState(int elevatorState) {
        this.elevatorState = elevatorState;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    @Override
    public String toString() {
        return "Elevator{" +
                "currentFloor=" + currentFloor +
                '}';
    }
}
