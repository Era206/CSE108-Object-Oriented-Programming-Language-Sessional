package com.company;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuOperations {

    public static void addCar(List<Car> carList){
        int value = 1;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the registration number:");
        String reg = scanner.next();
        for(int i =0; i<carList.size(); i++) {
            if (carList.get(i).getCarReg().equalsIgnoreCase(reg)){
                System.out.println("Error:Duplicate registration number!");
                value = 0;
                break;
            }
        }
        if(value==1){
            System.out.println("Enter year: ");
            int yearMade = scanner.nextInt();
            System.out.println("Enter colour 1: ");
            String color1 = scanner.next();
            System.out.println("Enter colour 2: ");
            String color2 = scanner.next();
            System.out.println("Enter colour 3: ");
            String color3 = scanner.next();
            System.out.println("Enter car maker name: ");
            String carMake = scanner.next();
            System.out.println("Enter car model: ");
            String carModel = scanner.next();
            System.out.println("Enter price: ");
            int price =scanner.nextInt();
            Car car = new Car(reg, yearMade, color1, color2, color3, carMake, carModel, price);
            carList.add(car);
        }
    }

    public static void searchCar(List<Car> carList){
        Scanner scanner=new Scanner(System.in);
        boolean quit = false;
        while(!quit){
            System.out.println("Car Searching Options:");
            System.out.println("(1) By Registration Number");
            System.out.println("(2) By Car Make and Car Model");
            System.out.println("(3) Back to Main Menu");
            boolean found=false;
            int option = scanner.nextInt();
            //scanner.nextLine();
            switch (option){
                case 1:
                    System.out.print("enter registration number: ");
                    String reg = scanner.next();
                    for(int i=0;i<carList.size();i++){
                        if(carList.get(i).getCarReg().equalsIgnoreCase(reg))
                        {
                            System.out.println(carList.get(i).toString());
                            found=true;
                        }
                    }
                    if(found==false)
                        System.out.println("No such car with this Registration Number");
                    break;
                case 2:
                    System.out.println("enter car make and model: ");
                    String carMake = scanner.next();
                    String carModel = scanner.next();
                    if(carModel.equalsIgnoreCase("ANY"))
                    {

                        for(int i=0;i<carList.size();i++)
                        {
                            if(carList.get(i).getCarMake().equalsIgnoreCase(carMake))
                            {
                                found=true;
                                System.out.println(carList.get(i));
                            }

                        }
                        if(found==false)
                        {
                            System.out.println("The given car maker was not found");
                        }
                    }
                    else
                    {
                        for(int i=0;i<carList.size();i++)
                        {
                            if(carList.get(i).getCarMake().equalsIgnoreCase(carMake) && carList.get(i).getCarModel().equalsIgnoreCase(carModel))
                            {
                                System.out.println(carList.get(i));
                                found=true;
                            }
                        }
                        if(found==false)
                        {
                            System.out.println("No such car with the given make and model found");
                        }
                    }

                    break;
                case 3:
                    quit = true;
                    break;
                default:
                    System.out.println("Not found");
            }

        }
    }

    public static void delCar(List<Car> carList){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter the registration number of the car: ");
        String reg = scanner.next();
        scanner.nextLine();
        boolean found=false;
        for(int i=0; i<carList.size();i++){
            if(carList.get(i).getCarReg().equalsIgnoreCase(reg)){
                carList.remove(carList.get(i));
                found=true;
                System.out.println("Deleted successfully");
            }
        }
        if(found==false)
            System.out.println("Not found");
    }
}
