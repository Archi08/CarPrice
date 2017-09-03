import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CarDaoFileBasedImpl;
import generators.SimpleIdGenerator;
import models.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nephrite on 02.09.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {
       /* System.out.println("Введите пункт от 1 до 4: ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int item = Integer.parseInt(bufferedReader.readLine());//считали пункт меню*/

        Car car = new Car("asd", 1123, "adsa");


        SimpleIdGenerator simpleIdGenerator = new SimpleIdGenerator("id.txt");
        CarDaoFileBasedImpl carDaoFileBased = new CarDaoFileBasedImpl("Cars.txt", simpleIdGenerator);

        carDaoFileBased.save(car, "Cars.txt");
        List<Car> cars = new ArrayList<>();

       carDaoFileBased.delete(2, "Cars.txt");




    }
}
