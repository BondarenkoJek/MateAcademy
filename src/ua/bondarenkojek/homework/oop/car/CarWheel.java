package ua.bondarenkojek.homework.oop.car;


public class CarWheel {

    private double wheelState;

    public CarWheel() {
        wheelState = 1.0;
    }

    public void putNewTire() {
        this.wheelState = 1.0;
    }

    public void useTire(double wearRate) {
        double wear = wearRate / 100;
        if (wheelState > wear) {
            wheelState -= wear;
        } else {
            wheelState = 0;
        }
    }

    public double getWheelState() {
        return wheelState;
    }

    public void showState() {
        System.out.println("The wheel state = " + (wheelState * 100) + "%");
    }
}
