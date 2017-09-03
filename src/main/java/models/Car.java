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

    public Car(String name, int price, String manager) {
        this.name = name;
        this.price = price;
        this.manager = manager;

    }

    public Car(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", manager='" + manager + '\'' +
                ", id=" + id +
                '}';
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
