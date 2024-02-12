package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        List<Car> carList = new ArrayList<>();
        carList = FileOperations.readFile();

        boolean flag = false;
        while (!flag) {
            System.out.println("(1) Search Cars");
            System.out.println("(2) Add Car");
            System.out.println("(3) Delete Car");
            System.out.println("(4) Exit System");
            int menuNumber = scanner.nextInt();
            switch (menuNumber) {
                case 1:
                    MenuOperations.searchCar(carList);
                    break;
                case 2:
                    MenuOperations.addCar(carList);
                    break;
                case 3:
                    MenuOperations.delCar(carList);
                    break;
                case 4:
                    FileOperations.writeFile(carList);
                    flag = true;
                    break;
                default:
                    System.out.println("error!");
            }
        }
    }
}


