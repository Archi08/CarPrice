import com.fasterxml.jackson.databind.ObjectMapper;
import dao.CarDaoFileBasedImpl;
import generators.SimpleIdGenerator;
import models.Car;
import service.CarServiceImpl;
import service.Display;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nephrite on 02.09.17.
 */
public class Main {
    public static void main(String[] args) throws IOException {


        Car car = new Car();
        List<Car> list = new ArrayList<>();
        SimpleIdGenerator simpleIdGenerator = new SimpleIdGenerator("id");
        CarDaoFileBasedImpl carDaoFileBased = new CarDaoFileBasedImpl("Cars", simpleIdGenerator);
        CarServiceImpl carService = new CarServiceImpl(carDaoFileBased);
        Display display = new Display(carService, list, car);
        display.start();




    }
}
