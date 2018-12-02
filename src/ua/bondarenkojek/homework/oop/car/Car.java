package ua.bondarenkojek.homework.oop.car;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Car {
    private final Date creationDate;
    private EngineType type;
    private double maxSpeed;
    private double speed;
    private double accelerationTime;
    private int maxAmountPassengers;
    private int amountPassengers;
    private List<CarWheel> wheels;
    private List<CarDoor> doors;
    private static final double MAX_WHEEL_STATE = 1.0;

    public Car(Date creationDate) {
        this.creationDate = creationDate;
        this.wheels = new ArrayList<>();
        this.doors = new ArrayList<>();
        this.speed = 0;

        for (int i = 0; i < 4; i++) {
            wheels.add(new CarWheel());
            doors.add(new CarDoor());
        }
    }

    public Car(Date creationDate, EngineType type, double maxSpeed, double accelerationTime,
               int maxAmountPassengers) {
        this(creationDate);
        this.type = type;
        this.maxSpeed = maxSpeed;
        this.accelerationTime = accelerationTime;
        this.maxAmountPassengers = maxAmountPassengers;
    }

    public boolean changeSpeed(double speed) {
        if (speed <= getRealMaxSpeed()) {
            this.speed = speed;
            return true;
        }
        return false;
    }

    public boolean getInPassenger() {
        if (amountPassengers < maxAmountPassengers) {
            amountPassengers++;
            return true;
        }
        return false;
    }

    public boolean getOutPassenger() {
        if (amountPassengers > 0) {
            amountPassengers--;
            return true;
        }
        return false;
    }

    public boolean getOutAllPassengers() {
        if (amountPassengers > 0) {
            amountPassengers = 0;
            return true;
        }
        return false;
    }

    public CarWheel getCarWheel(int wheelIndex) {
        if (wheelIndex > wheels.size()) {
            return null;
        }
        return wheels.get(wheelIndex - 1);
    }

    public CarDoor getCarDoor(int doorIndex) {
        if (doorIndex > doors.size()) {
            return null;
        }
        return doors.get(doorIndex-1);
    }

    public void removeAllWheels() {
        if (wheels.size() > 0) {
            wheels.clear();
        }
        throw new NullPointerException("Car without wheels");
    }

    public void putOnWheels(List<CarWheel> wheels) {
        this.wheels.addAll(wheels);
    }

    public double getRealMaxSpeed() {
        if (amountPassengers == 0 || wheels.size() < 4) {
            return 0;
        }

        //temp variable
        double minWheelState = MAX_WHEEL_STATE;

        for (CarWheel wheel : wheels) {
            if (wheel.getWheelState() < minWheelState) {
                minWheelState = wheel.getWheelState();
            }
        }

        return maxSpeed * minWheelState;
    }

    public void showCarState() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println(
                "---------- INFO OF CAR ----------" +
                        "\nDate of creation: " + dateFormat.format(creationDate) +
                        "\nEngine type - " + type.name() +
                        "\nMax speed - " + maxSpeed +
                        "\nReal max speed - " + getRealMaxSpeed() +
                        "\nReal speed - " + speed +
                        "\nAcceleration time - " + accelerationTime +
                        "\nMax amount of passengers - " + maxAmountPassengers +
                        "\nAmount of passengers - " + amountPassengers +
                        "\n\n--------- INFO OF WHEELS --------");

        for (CarWheel wheel : wheels) {
            wheel.showState();
        }

        System.out.println("\n------- INFO OF PASSENGERS ------");

        for (CarDoor door : doors) {
            door.showState();
        }
    }


    public void setType(EngineType type) {
        this.type = type;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public void setAccelerationTime(double accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public void setMaxAmountPassengers(int maxAmountPassengers) {
        this.maxAmountPassengers = maxAmountPassengers;
    }

    public enum EngineType {
        PETROL,
        DIESEL,
        ELECTRIC
    }
}
