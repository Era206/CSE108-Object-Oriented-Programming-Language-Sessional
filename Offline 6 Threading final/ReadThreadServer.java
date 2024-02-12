package mypackage;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ReadThreadServer implements Runnable{
    private final Thread thr;
    private final NetworkUtil networkUtil;
    public HashMap<String, String> userMap;


    public ReadThreadServer(HashMap<String, String> map, NetworkUtil networkUtil) {
        this.userMap = map;
        this.networkUtil = networkUtil;
        this.thr = new Thread(this);
        thr.start();
    }

    public void run(){
        try{
            while(true) {
                Object o = networkUtil.read();
                if (o != null) {
                    String userName = (String) o;
                    if (((String) o).equalsIgnoreCase("viewer")) {
                        System.out.println("now connected to client");
                        boolean flagView = true;
                        while (flagView) {
                            Object object=networkUtil.read();
                            if(object!=null){
                            String option = (String) object;
                            String found = "false";
                            if (option.equalsIgnoreCase("1")) {
                                networkUtil.getOos().reset();
                                networkUtil.write(Server.carList);
                            }
                            else if (option.equalsIgnoreCase("2")) {
                                String reg = (String)networkUtil.read();
                                Car car = null;
                                for (int i = 0; i < Server.carList.size(); i++) {
                                    if (Server.carList.get(i).getCarReg().equalsIgnoreCase(reg)) {
                                        found = "true";
                                        car = Server.carList.get(i);
                                        break;
                                    }
                                }
                                networkUtil.write(found);
                                if (found.equalsIgnoreCase("true")) {
                                    networkUtil.write(car);
                                }
                            }
                            else if(option.equalsIgnoreCase("3")){
                                String  carMake = (String)networkUtil.read();
                                String carModel = (String)networkUtil.read();
                                Car car = null;
                                for(int i=0;i<Server.carList.size();i++)
                                {
                                    if(Server.carList.get(i).getCarMake().equalsIgnoreCase(carMake) && Server.carList.get(i).getCarModel().equalsIgnoreCase(carModel))
                                    {
                                        found="true";
                                        car = Server.carList.get(i);
                                        break;
                                    }
                                }
                                networkUtil.write(found);
                                if(found.equalsIgnoreCase("true")){
                                    networkUtil.write(car);
                                }
                            }
                            else if(option.equalsIgnoreCase("4")){
                                String reg = (String)networkUtil.read();
                                int n = 0;
                                for(int i=0;i<Server.carList.size();i++)
                                {
                                    if(Server.carList.get(i).getCarReg().equalsIgnoreCase(reg))
                                    {
                                        Server.carList.get(i).setQuantity(Server.carList.get(i).getQuantity()-1);
                                        found = "true";
                                        n = i;
                                        break;
                                    }
                                }
                                if(Server.carList.get(n).getQuantity()<0)
                                    found = "False";
                                networkUtil.write(found);
                                Server.carList.get(n).setQuantity(0);
                            }
                            else if(option.equalsIgnoreCase("5")){
                                flagView = false;
                                break;
                            }
                            File.writeFile(Server.carList);
                        }
                        }
                    }
                    else if(((String) o).equalsIgnoreCase("manufacturer")){
                        Object obj = networkUtil.read();
                        String found = "false";
                        if(obj!= null){
                            LoginDTO loginDTO = (LoginDTO) obj;
                            String username = loginDTO.getUserName();
                            String password = userMap.get(loginDTO.getUserName());
                            loginDTO.setStatus(loginDTO.getPassword().equals(password));
                            if(loginDTO.isStatus()){
                                found = "true";
                            }
                            networkUtil.write(found);
                            if(found.equalsIgnoreCase("true")){
                                boolean flagMan = true;
                                while(flagMan){
                                    Object object=networkUtil.read();
                                    if(object!= null){
                                        String option = (String) object;
                                        String found1 = "false";
                                        if(option.equalsIgnoreCase("1")){
                                            networkUtil.getOos().reset();
                                            networkUtil.write(Server.carList);
                                        }
                                        else if(option.equalsIgnoreCase("2")){
                                            Car car = (Car)networkUtil.read();
                                            Server.carList.add(car);
                                            networkUtil.write(Server.carList);
                                        }
                                        else if(option.equalsIgnoreCase("3")){
                                            String reg = (String) networkUtil.read();
                                            Car car=null;
                                            for(int i=0;i<Server.carList.size();i++)
                                            {
                                                if(Server.carList.get(i).getCarReg().equals(reg)) {

                                                    car = Server.carList.get(i);
                                                    found1 = "true";
                                                    break;
                                                }
                                            }
                                            networkUtil.write(found1);

                                            if(found1.equalsIgnoreCase("true")){
                                                boolean stop=false;
                                        while(!stop) {

                                            Object objT = networkUtil.read();
                                            if (objT != null) {
                                                String opt = (String) objT;
                                                switch (opt) {
                                                    case "1":
                                                        int yearMade = Integer.parseInt((String) networkUtil.read());
                                                        car.setYearMade(yearMade);
                                                        break;
                                                    case "2":

                                                        Object objColor = networkUtil.read();
                                                        if(objColor!=null) {
                                                         String string=(String ) objColor;

                                                            car.setColour1(string);
                                                        }
                                                        break;
                                                    case "3":
                                                        car.setColour2((String) networkUtil.read());
                                                        break;
                                                    case "4":
                                                        car.setColour3((String) networkUtil.read());
                                                        break;
                                                    case "5":
                                                        car.setCarMake((String) networkUtil.read());
                                                        break;
                                                    case "6":
                                                        car.setCarModel((String) networkUtil.read());
                                                        break;
                                                    case "7":
                                                        car.setPrice((int) networkUtil.read());
                                                        break;
                                                    case "8":
                                                        int quantity = (int)networkUtil.read();
                                                        String yes = "true";
                                                        if(quantity<0){
                                                            yes = "false";
                                                        }
                                                        else{
                                                            car.setQuantity(quantity);
                                                        }
                                                        networkUtil.write(yes);
                                                        break;
                                                    case "0":
                                                         stop=true; break;
                                                }
                                            }

                                        }
                                            }
                                        }
                                        else if(option.equalsIgnoreCase("4")){
                                            String reg = (String)networkUtil.read();
                                            for(int i=0; i<Server.carList.size();i++){
                                                if(Server.carList.get(i).getCarReg().equalsIgnoreCase(reg)){
                                                    Server.carList.remove(Server.carList.get(i));
                                                    found1 = "true";
                                                    break;
                                                }
                                            }
                                            networkUtil.write(found1);
                                        }
                                        else if(option.equalsIgnoreCase("5")){
                                            flagMan = false;
                                            break;
                                        }

                                        File.writeFile(Server.carList);
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
