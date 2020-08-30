package com.company;
// Name: Ethan Garcia
// Id: 112752608
// Summer class, section 1.
public class Simulator {
    /**
     * Simulator method for program prints the amount of requests made and how many passengers were dropped off
     * @param probability
     * double below or equal to 1.0 to represent a percentage of how possible it is for someone to make a request
     * @param numboffloor
     * int of max number of floors must be greater than 1 floor
     * @param numbelevator
     * int of elevators in building
     * used to construct an array of elevator objects to handle requests from the request queue
     * @param timelength
     * max amount of time taken for the simulation
     *
     * creates a queue of request called elevator
     * creates array of elevators and calls the default constructor for each
     * boolean source object creates the mechanism through which we pass probability, uses the requestArrive to determine whether or not a request is added to queue
     *
     * each elevator is gone through to determine its status, which is documented in the elevator class
     * if the elevator is idle, it is given a request and the status is moved to 1, which is to_source (to source of request)
     * if the elevator is to source then we move it up or down. if the floor is found then it will be picked up and then we increment the count of people picked up
     * each time the floor is found we add the count of currenttime - timeentered to total amount of time taken to wait
     *
     */
    public static void simulate(double probability, int numboffloor, int numbelevator, int timelength){
        if(probability > 1.0||probability<0||numboffloor<1||numbelevator<0||timelength<0){
            System.out.println("No simulation");
            System.exit(0);
        }
        int dropped =0;
        int requested=0;
        RequestQue elevator = new RequestQue();
        BooleanSource arrival = new BooleanSource(probability);
        Elevator[] a = new Elevator[numbelevator];
        for(int i = 0;i<numbelevator;i++){
            a[i] = new Elevator();
        }
        int elevatorsreachdestination = 0;
        double averagewait;
        int timeinelevator=0;
        for(int currentSecond =1; currentSecond<=timelength;currentSecond++){
            if(arrival.requestArrive()){
                Request in = new Request(numboffloor);
                in.setTimeEntered(currentSecond);
                elevator.enqueue(in);
                requested++;
            }
            else{
                System.out.println("no request this rotation");
            }
            if((!elevator.isEmpty())&&(elevatorAvalible(a))) {
                for (int i = 0; i < a.length; i++) {
                    if (a[i].getElevatorState() == 0) {
                        a[i].setRequest(elevator.dequeue());
                        a[i].setElevatorState(1);
                        break;
                    }
                }
            }
                for(int i=0;i<a.length;i++){
                    //for arriving at destination floors
                    if(a[i].getRequest()!=null&&a[i].getElevatorState() ==2){
                        if(a[i].getRequest().getDestinationFloor()>a[i].getCurrentFloor()){
                            System.out.println("(dest)moved up");
                            a[i].setCurrentFloor(a[i].getCurrentFloor()+1);
                        }
                        else if(a[i].getRequest().getDestinationFloor()<a[i].getCurrentFloor()){
                            System.out.println("(dest)moved down");
                            a[i].setCurrentFloor(a[i].getCurrentFloor()-1);
                        }
                    }
                    if(a[i].getRequest()!=null&&a[i].getRequest().getDestinationFloor()==a[i].getCurrentFloor()&&a[i].getElevatorState()==2){
                        System.out.println("passenger dropped off");
                        dropped++;
                        a[i].setRequest(null);
                        a[i].setElevatorState(0);
                    }
                }
                for(int i=0;i<a.length;i++){
                    //following loops are for finding source floors
                    if(a[i].getRequest()!=null&&a[i].getElevatorState() ==1){
                        if(a[i].getRequest().getSourceFloor()>a[i].getCurrentFloor()){
                            System.out.println("(source)moved up");
                            a[i].setCurrentFloor(a[i].getCurrentFloor()+1);
                        }
                         else if(a[i].getRequest().getSourceFloor()<a[i].getCurrentFloor()){
                            System.out.println("(source)moved down");
                            a[i].setCurrentFloor(a[i].getCurrentFloor()-1);
                        }
                    }
                    if(a[i].getRequest()!=null&&a[i].getRequest().getSourceFloor()==a[i].getCurrentFloor()){
                        timeinelevator = timeinelevator+(currentSecond - a[i].getRequest().getTimeEntered());
                        a[i].setElevatorState(2);
                        System.out.println("passenger picked up");
                        elevatorsreachdestination++;
                    }
                }
            for(int i=0;i<a.length;i++){
                if(a[i].getRequest()!=null)
                    System.out.print("elevator" +i+" is at " + a[i].getCurrentFloor()+ " is " + a[i].getElevatorState() + " source is " +a[i].getRequest().getSourceFloor()+" and has a destination of "+a[i].getRequest().getSourceFloor()+" ");
                System.out.println();
            }
            System.out.println(currentSecond);
        }
        averagewait = timeinelevator / elevatorsreachdestination;
        System.out.println("total passengers dropped off: "+dropped);
        System.out.println("total requests: "+requested);
        System.out.println("the average wait is " + String.format("%.2f", averagewait));
    }

    /**
     * checks if there is a elevator to take a request
     * @param a
     * array of elevators created
     * @return
     * returns true whether or not there is a free elevator
     */
    public static boolean elevatorAvalible(Elevator[] a){
        for(int i =0;i<a.length;i++){
            if(a[i].getElevatorState() == 0){
                return true;
            }
        }
        return false;
    }
}
