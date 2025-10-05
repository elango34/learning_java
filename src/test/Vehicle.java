package test;
public class Vehicle {
    
    private int wheels;
    private String type;
    private String fuel;

    public Vehicle() {
        wheels = 2;
        fuel = "petrol";
    }

    public void start() {
        System.out.println("engine started");
    }

    public void ignition() {
        System.out.println("ignition started");
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }
}
