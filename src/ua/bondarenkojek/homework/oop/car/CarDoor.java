package ua.bondarenkojek.homework.oop.car;


public class CarDoor {

    private boolean doorState;
    private boolean windowState;

    public CarDoor() {
        this.doorState = false;
        this.windowState = false;
    }

    public CarDoor(boolean doorState, boolean windowState) {
        this.doorState = doorState;
        this.windowState = windowState;
    }

    public void openDoor() {
        this.doorState = true;
    }

    public void closeDoor() {
        this.doorState = false;
    }

    public void openCloseDoor() {
        doorState = doorState ? false : true;
    }

    public void openWindow() {
        this.windowState = true;
    }

    public void closeWindow() {
        this.windowState = false;
    }

    public void openCloseWindow() {
        windowState = windowState ? false : true;
    }

    public void showState() {
        String doorShow = "The door " + (doorState ? "opened" : "closed");
        String windowShow = "The window " + (windowState ? "opened" : "closed");

        System.out.println(doorShow + "\n" + windowShow);
    }
}
