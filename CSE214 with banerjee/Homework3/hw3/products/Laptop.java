package com.company.hw3.hw3.products;

import java.util.Objects;

/**
 * TODO: The 'Laptop' object should be comparable.
 *
 * @author Ritwik Banerjee
 */
public class Laptop implements Comparable<Laptop>{

    private String brand;
    private double processorSpeed;
    private int    ram;
    private int    price;
    private double screenSize;

    private Laptop(LaptopBuilder laptopBuilder) {
        this.brand = laptopBuilder.brand;
        this.processorSpeed = laptopBuilder.processorSpeed;
        this.ram = laptopBuilder.ram;
        this.price = laptopBuilder.price;
        this.screenSize = laptopBuilder.screenSize;
    }

    public String getBrand()          { return brand; }

    public double getProcessorSpeed() { return processorSpeed; }

    public int getRam()               { return ram; }

    public int getPrice()             { return price; }

    public double getScreenSize()     { return screenSize; }

    /**
     * Uses price to compare two laptops. A laptop with a cheaper price will result in 1 being returned, thus putting it
     * as greater than a parent laptop. -1 if the price is greater, and zero if the price is the same.
     * @param o
     * @return
     */
    @Override
    public int compareTo(Laptop o) {
        int a = this.getPrice();
        int b = o.getPrice();
        if(a<b){
            return 1;
        }
        else if(a==b){
            return 0;
        }
        else{
            return -1;
        }
    }

    /**
     * Compares two laptops for equality in all aspects. NOT JUST PRICE.
     * @param o laptop to be compared
     * @return boolean whether or not the laptops are equivalent
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Laptop)) return false;
        Laptop laptop = (Laptop) o;
        return Double.compare(laptop.processorSpeed, processorSpeed) == 0 &&
                ram == laptop.ram &&
                price == laptop.price &&
                Double.compare(laptop.screenSize, screenSize) == 0 &&
                Objects.equals(brand, laptop.brand);
    }

    private static class LaptopBuilder {
        private String brand;
        private double processorSpeed;
        private int    ram;
        private int    price;
        private double screenSize;

        LaptopBuilder withBrand(String brand) {
            this.brand = brand;
            return this;
        }

        LaptopBuilder withProcessorSpeed(double processorSpeed) {
            this.processorSpeed = processorSpeed;
            return this;
        }

        LaptopBuilder withMemory(int ram) {
            this.ram = ram;
            return this;
        }

        LaptopBuilder withPrice(int price) {
            this.price = price;
            return this;
        }

        LaptopBuilder withScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        Laptop build() {
            return new Laptop(this);
        }
    }

    public static Laptop fromString(String s) {
        if (s.isEmpty())
            return null;
        String[]      aspects = s.split(",");
        LaptopBuilder builder = new LaptopBuilder();

        try {
            builder.withBrand(aspects[0].toLowerCase());
            builder.withProcessorSpeed(Double.parseDouble(aspects[1]));
            builder.withMemory(Integer.parseInt(aspects[2]));
            builder.withPrice(Integer.parseInt(aspects[3]));
            builder.withScreenSize(Double.parseDouble(aspects[4]));
        } catch (Exception e) {
            System.out.println("Invalid input line.");
        }

        return builder.build();
    }

    // !!DO NOT MODIFY THIS CODE!!
    @Override
    public String toString() {
        return "products.Laptop{" + "brand='" + brand + '\'' +
                ", processorSpeed=" + processorSpeed +
                ", ram=" + ram +
                ", price=" + price +
                ", screenSize=" + screenSize +
                '}';
    }

    // !!DO NOT MODIFY THIS CODE!!
    @Override public int hashCode() {
        int  result;
        long temp;
        result = brand.hashCode();
        temp = Double.doubleToLongBits(processorSpeed);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + ram;
        result = 31 * result + price;
        temp = Double.doubleToLongBits(screenSize);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
