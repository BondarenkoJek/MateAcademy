package ua.bondarenkojek.homework.oop.car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class ViewCar {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("----Creating a new car----");

            String tmp;
            Car.EngineType typeEngine;
            double maxSpeed;
            double accelerationTime;
            int maxAmountPassengers;

            while (true) {
                System.out.println("\nChoose type of engine" +
                        "\n1 - Petrol" +
                        "\n2 - Diesel" +
                        "\n3 - Electric");

                tmp = reader.readLine();

                switch (tmp) {
                    case "1":
                        typeEngine = Car.EngineType.PETROL;
                        break;
                    case "2":
                        typeEngine = Car.EngineType.DIESEL;
                        break;
                    case "3":
                        typeEngine = Car.EngineType.ELECTRIC;
                        break;
                    default:
                        System.err.println("Invalid choice, try again!");
                        continue;
                }
                System.out.println("Your choice - " + typeEngine.name());
                break;
            }

            while (true) {
                System.out.println("\nWrite max speed");

                tmp = reader.readLine();
                if (isDoubleNumeric(tmp)) {
                    maxSpeed = Double.parseDouble(tmp);
                    System.out.println("Your max speed =  " + maxSpeed);
                    break;
                }
                System.err.println("Invalid speed, try again!");
            }

            while (true) {
                System.out.println("\nWrite acceleration time");

                tmp = reader.readLine();
                if (isDoubleNumeric(tmp)) {
                    accelerationTime = Double.parseDouble(tmp);
                    System.out.println("Your acceleration time =  " + accelerationTime);
                    break;
                }
                System.err.println("Invalid acceleration time, try again!");
            }

            while (true) {
                System.out.println("\nWrite max amount passengers");

                tmp = reader.readLine();
                if (isIntegerNumeric(tmp)) {
                    maxAmountPassengers = Integer.parseInt(tmp);
                    System.out.println("Your max amount passengers =  " + maxAmountPassengers);
                    break;
                }
                System.err.println("Invalid max amount passengers, try again!");
            }

            Car car = new Car(new Date(), typeEngine, maxSpeed, accelerationTime, maxAmountPassengers);

            System.out.println("\n---------- CREATED NEW CAR ----------\n");

            boolean flag = true;
            while (flag) {
                System.out.println("\n----- Available actions -----" +
                        "\n1 - Actions with doors" +
                        "\n2 - Actions with passengers" +
                        "\n3 - Actions with wheels" +
                        "\n4 - Actions with car" +
                        "\n5 - EXIT");

                switch (reader.readLine()) {
                    case "1":
                        actionsWithDoors();
                        break;
                    case "2":
                        actionsWithPassengers();
                        break;
                    case "3":
                        actionsWithWheels();
                        break;
                    case "4":
                        actionsWithCar();
                        break;
                    case "5":
                        flag = false;
                        System.out.println("Closing the program!!!");
                        break;
                    default:
                        System.err.println("Invalid choice, try again!");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void actionsWithDoors() {

    }

    private static void actionsWithPassengers() {

    }

    private static void actionsWithWheels() {

    }

    private static void actionsWithCar() {

    }


    private static boolean isIntegerNumeric(String str) {
        return str.matches("-?\\d");
    }

    private static boolean isDoubleNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

}
