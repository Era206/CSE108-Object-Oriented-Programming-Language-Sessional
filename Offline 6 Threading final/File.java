package mypackage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class File {
    private static final String FILE_NAME = "in.txt";

    public static List<Car> readFile() {
        List<Car> carList = new ArrayList<>();
        try {
            String line;
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            while (true) {

                line = br.readLine();
              //  System.out.println(line);
                if (line == null) break;
                String[] s = line.split(",");
                String reg = s[0];
                int yearMade = Integer.parseInt(s[1]);
                String color1 = s[2];
                String color2 = s[3];
                String color3 = s[4];
                String carMake = s[5];
                String carModel = s[6];
                int price = Integer.parseInt(s[7]);
                int quantity = Integer.parseInt(s[8]);

                Car car = new Car(reg, yearMade, color1, color2, color3, carMake, carModel, price, quantity);

                carList.add(car);

            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carList;
    }


    public static void writeFile(List<Car> carList) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
            for (int i = 0; i < carList.size(); i++) {
                bw.write(carList.get(i).toString());
                bw.write("\n");
                bw.flush();
            }
            bw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }
}
