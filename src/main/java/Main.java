import models.Car;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by nephrite on 02.09.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
       /* System.out.println("Введите пункт от 1 до 4: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int item = Integer.parseInt(bufferedReader.readLine());//считали пункт меню*/

        Car car = new Car("asd", 123);
        Car car1 = new Car("asd", 123);
        Car car2 = new Car("asd", 123);

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(car);
        cars.add(car1);
        cars.add(car);



        save("Cars", car);

    }
    public static void save(String fileName, Car car) {
        String string = car.toString();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.write(string);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            System.err.println("IO Exception");;
        }
    }
}
