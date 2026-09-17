import java.util.ArrayList;

class Vehicle {

    protected String make;
    protected String model;
    protected int year;
    protected double currentSpeed;

    public Vehicle(String make, String model, int year, double currentSpeed) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.currentSpeed = currentSpeed;
    }

    public double accelerate(double amount) {
        currentSpeed += amount;
        return currentSpeed;
    }

    public double brake(double amount) {
        currentSpeed -= amount;
        return currentSpeed;
    }

    @Override
    public String toString() {
        return "Make: " + this.make +
                ". Model: " + this.model +
                ". Year: " + this.year +
                ". Current Speed: " + this.currentSpeed;
    }
}

class Car extends Vehicle {

    protected int numberOfDoors;

    public Car(String make, String model, int year, double currentSpeed, int numberOfDoors) {
        super(make, model, year, currentSpeed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public String toString() {
        return "Make: " + super.make +
                ". Model: " + super.model +
                ". Year: " + super.year +
                ". Current Speed: " + super.currentSpeed +
                ". Number of Doors: " + this.numberOfDoors;
    }
}

class Truck extends Vehicle {

    protected double payloadCapacity;

    public Truck(String make, String model, int year, double currentSpeed, double payloadCapacity) {
        super(make, model, year, currentSpeed);
        this.payloadCapacity = payloadCapacity;
    }

    public int loadCargo(double weight) {
        if (weight > this.payloadCapacity) {
            System.out.println("Weight exceeds payload capacity.");
        } else {
            System.out.println("Successfully loaded cargo.");
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Make: " + super.make +
                ". Model: " + super.model +
                ". Year: " + super.year +
                ". Current Speed: " + super.currentSpeed +
                ". Payload Capacity: " + this.payloadCapacity;
    }
}

// The reason ElectricCar extends Car and not Vehicle is because an electric car
// is more accuratly a type of car than it is a type of vehicle. While making it
// extend Vehicle is perfecly fine, having it extend Car instead gives us the
// methods and field associated with car, which makes it more detailed.

// If we wanted to add a HybridCar class that is both of type Car and
// ElectricCar, we would need to make two interfaces that are of type Car and
// ElectricCar. Each interface would need to have method signatures as opposed
// to defined methods. This would allow us to implement both the car interface
// as well as the ElectricCar Interface, giving us a HybridCar.

class ElectricCar extends Car {

    protected int batteryCapacity;
    protected int currentCharge;

    public ElectricCar(String make, String model, int year, double currentSpeed, int numberOfDoors, int batteryCapacity,
            int currentCharge) {
        if (currentCharge > batteryCapacity) {
            System.out.println("Current charge has been capped to maximum capacity.");
            this.currentCharge = batteryCapacity;
        } else {
            this.currentCharge = currentCharge;
        }

        super(make, model, year, currentSpeed, numberOfDoors);
        this.batteryCapacity = batteryCapacity;
    }

    public void charge(double amount) {
        if (amount + currentCharge > batteryCapacity) {
            System.out.println("The amount exceeds the car's battery capacity.");
        } else {
            currentCharge += amount;
            System.out.println("The car's charge is now " + currentCharge);
        }
    }

    @Override
    public double accelerate(double amount) {
        currentSpeed += amount;
        currentCharge -= amount / 10;
        return currentSpeed;
    }

    @Override
    public String toString() {
        return "Make: " + super.make +
                ". Model: " + super.model +
                ". Year: " + super.year +
                ". Current Speed: " + super.currentSpeed +
                ". Number of Doors: " + super.numberOfDoors +
                ". Battery Capacity: " + this.batteryCapacity +
                ". Current charge: " + this.currentCharge;
    }
}

public class Cars {
    public static void main(String[] args) {
        ArrayList<Vehicle> fleet = new ArrayList<>();
        fleet.add(new Vehicle("Toyota", "Camry", 2017, 35));
        fleet.add(new Car("BMW", "430i", 2020, 40, 2));
        fleet.add(new Truck("Chevy", "Colorado", 2015, 60, 7));
        fleet.add(new ElectricCar("Hyndai", "IONIQ 9", 2026, 30, 4, 110, 80));

        fleet.get(0).accelerate(10);
        fleet.get(0).brake(5);

        ((Truck) fleet.get(2)).loadCargo(6);

        ((ElectricCar) fleet.get(3)).charge(10);
        ((ElectricCar) fleet.get(3)).accelerate(10);

        for (Vehicle vehicle : fleet) {
            System.out.println(vehicle.toString());
        }
    }
}
