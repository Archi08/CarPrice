package models;

import java.io.Serializable;

/**
 * Created by nephrite on 02.09.17.
 */
public class Car implements Serializable {
    private String name;
    private int price;
    private String manager;
    private int id;

    public Car(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "models.Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
