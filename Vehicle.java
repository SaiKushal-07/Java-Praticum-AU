abstract class Vehicle {
    String vehicleNumber;
    String brand;

    public Vehicle(String vehicleNumber, String brand) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
    }

    public abstract void startEngine();

    public final void showVehicleIdentity() {
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Brand          : " + brand);
    }
}

class Car extends Vehicle {
    public Car(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }

    public void startEngine() {
        System.out.println("Car Engine: Push-button start activated.");
    }
}

class Bike extends Vehicle {
    public Bike(String vehicleNumber, String brand) {
        super(vehicleNumber, brand);
    }

    public void startEngine() {
        System.out.println("Bike Engine: Self/Kick start activated.");
    }
}


class Main {
    public static void main(String[] args) {
        System.out.println("--- Car Details ---");
        Car car = new Car("KA01AB1234", "Toyota");
        car.showVehicleIdentity();
        car.startEngine();

        System.out.println();

        System.out.println("--- Bike Details ---");
        Bike bike = new Bike("KA05XY5678", "Honda");
        bike.showVehicleIdentity();
        bike.startEngine();
    }
}