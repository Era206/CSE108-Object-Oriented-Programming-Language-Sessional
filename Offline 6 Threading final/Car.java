package mypackage;

//import java.io.Serial;
import java.io.Serializable;

public class Car implements Serializable {
    //@Serial
    //private static final long serialVersionUID = 74698698638617L;
    private String carReg;
    private int yearMade;
    private String colour1;
    private String colour2;
    private String colour3;
    private String carMake;
    private String carModel;
    private int price;
    private int quantity;

    public void setCarReg(String carReg) {
        this.carReg = carReg;
    }

    public void setYearMade(int yearMade) {
        this.yearMade = yearMade;
    }

    public void setColour1(String colour1) {
        this.colour1 = colour1;
    }

    public void setColour2(String colour2) {
        this.colour2 = colour2;
    }

    public void setColour3(String colour3) {
        this.colour3 = colour3;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Car(String carReg, int yearMade, String colour1, String colour2, String colour3, String carMake, String carModel, int price, int quantity) {
        this.carReg = carReg;
        this.yearMade = yearMade;
        this.colour1 = colour1;
        this.colour2 = colour2;
        this.colour3 = colour3;
        this.carMake = carMake;
        this.carModel = carModel;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCarReg() {
        return carReg;
    }

    public int getYearMade() {
        return yearMade;
    }

    public String getColour1() {
        return colour1;
    }

    public String getColour2() {
        return colour2;
    }

    public String getColour3() {
        return colour3;
    }

    public String getCarMake() {
        return carMake;
    }

    public String getCarModel() {
        return carModel;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() { return quantity; }

    @Override
    public String toString() {
        return carReg +"," + yearMade + "," + colour1 +"," + colour2 +"," + colour3 +"," + carMake + "," + carModel + "," + price + "," + quantity;
    }
}
