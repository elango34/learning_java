package test;

public class Car extends Vehicle {

    private String brand;
    private int cc;
    
    public Car(String brand, int cc) {
        // super() is automatically called here invisibly
        System.out.println("calling car");
        this.brand = brand;
        this.cc = cc;
    }
    
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }
    public int getCc() {
        return cc;
    }
    public void setCc(int cc) {
        this.cc = cc;
    }

    protected void start(String name) {
        System.out.println(name + " is started");
    }
    
}
