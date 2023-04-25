import java.io.Serializable;

public class Car implements Display {
    private String color;
    private double horsepower;
    private double weight;

    public Car(String color, double horsepower, double weight) {
        this.color = color;
        this.horsepower = horsepower;
        this.weight = weight;
    }

    public Car() {
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", horsepower=" + horsepower +
                ", weight=" + weight +
                '}';
    }

    @Override
    public void print() {
        System.out.println(this.toString());
    }
}
