package com.company;

public class Person {
    private String name, address, phone,email;

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}

class Employee extends Person{
    private String Office;
    private double Salary;
    private int experience;
    public String toString(){
        return this.getClass() + this.getName();
    }
}

class Faculty extends Employee{
    private int OfficeHours;
    private String Rank;
    public String toString(){
        return this.getClass() + this.getName();
    }
}

class Staff extends Employee{
    private String title;
    public String toString(){
        return this.getClass() + this.getName();
    }
}
class Student extends Person{
    private final String classStatus = null;
    public String toString(){
        return this.getClass() + this.getName();
    }
}


