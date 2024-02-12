package mypackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.exit;

public class ReadThread implements Runnable{
    private final Thread thr;
    private final Main main;
    Scanner scanner = new Scanner(System.in);

    public ReadThread(Main main) {
        this.main = main;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run(){
        try{
            while(true){
                System.out.println("Enter username: 'viewer' or 'manufacturer'? press x to exit");
                Scanner scanner=new Scanner(System.in);
                String username=scanner.nextLine();
                main.getNetworkUtil().write(username);
                if(username.equalsIgnoreCase("viewer")){
                    boolean flagView = true;
                    while(flagView){
                        System.out.print("1)view all cars\n" +
                                "2)search car by registration number\n" +
                                "3)search car by make and model\n" +
                                "4)buy a car\n"+
                                "5)log out from server\n");
                        boolean found=false;
                        String option = scanner.nextLine();
                        main.getNetworkUtil().write(option);
                        if(option.equalsIgnoreCase("1")){
                           Object o = main.getNetworkUtil().read();
                            List<Car> carList = new ArrayList<>();
                            carList = (List<Car>)o;
                            for(int i=0; i<carList.size();i++){
                                System.out.println(carList.get(i).toString());
                            }
                        }
                        else if(option.equalsIgnoreCase("2")){
                            System.out.print("enter registration number: ");
                            String reg = scanner.nextLine();
                            main.getNetworkUtil().write(reg);
                            String flag =(String) main.getNetworkUtil().read();
                            if(flag.equalsIgnoreCase("true")){
                                Car car = (Car)main.getNetworkUtil().read();
                                System.out.println(car);
                            }
                            else
                                System.out.println("No such car with this Registration Number");
                        }
                        else if(option.equalsIgnoreCase("3")){
                            System.out.println("enter car make: ");
                            String carMake = scanner.nextLine();
                            main.getNetworkUtil().write(carMake);
                            System.out.println("enter car model: ");
                            String carModel = scanner.nextLine();
                            main.getNetworkUtil().write(carModel);
                            String flag =(String) main.getNetworkUtil().read();
                            if(flag.equalsIgnoreCase("true")){
                                Car car = (Car)main.getNetworkUtil().read();
                                System.out.println(car);
                            }
                            else
                                System.out.println("No such car with this car make and model");

                        }
                        else if(option.equalsIgnoreCase("4")){
                            System.out.println("Enter a registration number: ");
                            String registration=scanner.nextLine();
                            main.getNetworkUtil().write(registration);
                            String flag =(String) main.getNetworkUtil().read();
                            if(flag.equalsIgnoreCase("true"))
                                System.out.println("car sold");
                            else
                                System.out.println("stock out");
                        }
                        else if(option.equalsIgnoreCase("5")){
                            System.out.println("Logging out successfully!");
                            flagView = false;
                        }
                        else{
                            scanner.nextLine();
                            System.out.println("enter a number between 1 to 4: ");
                        }
                    }
                }
                else if(username.equalsIgnoreCase("manufacturer")){
                    System.out.println("Enter username");
                    String userName=scanner.nextLine();
                    System.out.println("Enter password");
                    String password=scanner.nextLine();
                    LoginDTO loginDTO=new LoginDTO();
                    loginDTO.setUserName(userName);
                    loginDTO.setPassword(password);
                    main.getNetworkUtil().write(loginDTO);
                    String flag1 = (String)main.getNetworkUtil().read();
                    if(flag1.equalsIgnoreCase("false"))
                        System.out.println("login unsuccessful.");
                    else if(flag1.equalsIgnoreCase("true")){
                        System.out.println("login successful");
                        boolean flagMan = true;
                        while(flagMan){
                            System.out.print("1)view all cars\n" +
                                    "2)add a car\n" +
                                    "3)edit a car\n" +
                                    "4)delete a car\n" +
                                    "5)log out from server\n");
                            String option = scanner.nextLine();
                            main.getNetworkUtil().write(option);
                            if(option.equalsIgnoreCase("1")){
                                Object o = main.getNetworkUtil().read();
                                List<Car> carList = new ArrayList<>();
                                carList = (List<Car>)o;
                                for(int i=0; i<carList.size();i++){
                                    System.out.println(carList.get(i).toString());
                                }
                            }
                            else if(option.equalsIgnoreCase("2")){
                                System.out.println("Enter the registration number:");
                                String reg = scanner.next();
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
                                System.out.println("Enter quantity");
                                int quantity=scanner.nextInt();
                                scanner.nextLine();
                                Car car = new Car(reg, yearMade, color1, color2, color3, carMake, carModel, price,quantity);
                                main.getNetworkUtil().write(car);
                                System.out.println("car added");
                                Object ob = main.getNetworkUtil().read();
                                List<Car> carList = new ArrayList<>();
                                carList = (List<Car>)ob;
                                System.out.println("car added to list. Updated list: ");
                                for(int i=0; i<carList.size();i++){
                                    System.out.println(carList.get(i).toString());
                                }
                            }
                            else if(option.equalsIgnoreCase("3")){
                                System.out.println("Search by registration:Which car do you want to edit?");
                                String REG=scanner.next();
                                main.getNetworkUtil().write(REG);
                                String surety =(String) main.getNetworkUtil().read();
                                //System.out.println(surety);
                                 if(surety.equalsIgnoreCase("true")){
                                    boolean flag2 = true;
                                    while(flag2){
                                        System.out.println("Which fields do you want to edit?Enter 0 for exiting");
                                        System.out.println("1)Year made");
                                        System.out.println("2)Colour1");
                                        System.out.println("3)Colour2");
                                        System.out.println("4)Colour3");
                                        System.out.println("5)Make");
                                        System.out.println("6)Model");
                                        System.out.println("7)Price");
                                        System.out.println("8)Quantity");
                                        String opt = scanner.next();
                                        main.getNetworkUtil().write(opt);
                                        switch(opt){
                                            case "1":
                                                System.out.println("Enter year: ");
                                                String yearMade = scanner.next();
                                                main.getNetworkUtil().write(yearMade);
                                                System.out.println("yearmade is edited");
                                                break;
                                            case "2":
                                                System.out.println("Enter colour 1: ");
                                                String color1 = scanner.next();
                                                main.getNetworkUtil().write(color1);
                                                System.out.println("colour1 is edited");
                                                break;
                                            case "3":
                                                System.out.println("Enter colour 2: ");
                                                String color2 = scanner.next();
                                                main.getNetworkUtil().write(color2);
                                                System.out.println("colour2 is edited");
                                                break;
                                            case "4":
                                                System.out.println("Enter colour 3: ");
                                                String color3 = scanner.next();
                                                main.getNetworkUtil().write(color3);
                                                System.out.println("colour3 is edited");
                                                break;
                                            case "5":
                                                System.out.println("Enter car maker name: ");
                                                String carMake = scanner.next();
                                                main.getNetworkUtil().write(carMake);
                                                System.out.println("car make is edited");
                                                break;
                                            case "6":
                                                System.out.println("Enter car model: ");
                                                String carModel = scanner.next();
                                                main.getNetworkUtil().write(carModel);
                                                System.out.println("car model is edited");
                                                break;
                                            case "7":
                                                System.out.println("Enter price: ");
                                                int price =scanner.nextInt();
                                                scanner.nextLine();
                                                main.getNetworkUtil().write(price);
                                                System.out.println("carPrice is edited");
                                                break;
                                            case "8":
                                                System.out.println("Enter quantity");
                                                int quantity=scanner.nextInt();
                                                scanner.nextLine();
                                                main.getNetworkUtil().write(quantity);
                                                if(((String) main.getNetworkUtil().read()).equalsIgnoreCase("true")){
                                                    System.out.println("quantity is edited");
                                                }
                                                else
                                                    System.out.println("quantity can't be negative");
                                                break;
                                            case "0":
                                               scanner.nextLine();

                                                flag2=false;

                                        }

                                    }
                                }
                                else{
                                    scanner.nextLine();
                                    System.out.println("No such car with this Registration Number");
                                }
                            }
                            else if(option.equalsIgnoreCase("4")){
                                System.out.print("Enter the registration number of the car: ");
                                String reg = scanner.next();
                                scanner.nextLine();
                                main.getNetworkUtil().write(reg);
                                String assure = (String)main.getNetworkUtil().read();
                                if(assure.equalsIgnoreCase("true")){
                                    System.out.println("car deleted!");
                                }
                                else{
                                    System.out.println("not found!");
                                }
                            }
                            else if(option.equalsIgnoreCase("5")){
                                System.out.println("logging out successfully!");
                                flagMan = false;
                            }
                            else{
                                scanner.nextLine();
                                System.out.println("enter a number between 1 to 5");
                            }
                        }
                    }

                }
                else if(username.equalsIgnoreCase("x")){
                    exit(0);
                }
                else{
                    System.out.println("enter appropriate userName.");
                }
        }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
