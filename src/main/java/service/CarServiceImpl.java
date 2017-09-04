package service;

import com.fasterxml.jackson.core.JsonProcessingException;
import dao.CarDao;
import dao.CarDaoFileBasedImpl;
import generators.SimpleIdGenerator;
import models.Car;
import models.Carcase;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 03.09.2017
 *
 * @author Shaikhutdinov Artur (First Software Engineering Platform)
 * @version v1.0
 */
public class CarServiceImpl {
    CarDaoFileBasedImpl carDaoFileBased;


    public CarServiceImpl(CarDaoFileBasedImpl carDaoFileBased) {
        this.carDaoFileBased = carDaoFileBased;
    }



    public void createCar () throws JsonProcessingException {
        System.out.println("Введите название (марка и модель): ");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String nameCar = null;
        try {
            nameCar = bufferedReader.readLine();
        } catch (IOException e) {
            System.err.println("IO Exception =(");
        }
        System.out.println("Введите выберите тип: 1-легковой, 2-грузовой,3-мотоцикл");
        Carcase carcaseCar = null;
        int type = 0;
        try {
            type = Integer.parseInt(bufferedReader.readLine());
        } catch (IOException e) {
            System.err.println("IO Exception =(");
        }
        switch (type) {
            case 1:
                carcaseCar = Carcase.PASSENGERS;
                break;
            case 2:
                carcaseCar = Carcase.CARGO;
                break;
            case 3:
                carcaseCar = Carcase.MOTO;
                break;
        }

        Car car = new Car(nameCar, 0, null, carcaseCar);
        carDaoFileBased.save(car, "Cars");
    }

    public void outPutCars(List<Car> list) {
        list = carDaoFileBased.findAll("Cars");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Автомобиль: " + list.get(i).getName() + " типа: " + list.get(i).getCarcase()
                    + " с номером " + list.get(i).getId());
        }
    }


    public void sale(Car car, String fileName) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите id выбранной машины: ");
        try {
            int idCar = Integer.parseInt(bufferedReader.readLine());
            car = carDaoFileBased.findById(idCar, fileName);
            System.out.println("Введите имя менеджера: ");
            String manager = bufferedReader.readLine();
            System.out.println("Введите цену: ");
            int price = Integer.parseInt(bufferedReader.readLine());
            car.setManager(manager);
            car.setPrice(price);
            carDaoFileBased.save(car, "Statistic");
            carDaoFileBased.delete(idCar, fileName);
        } catch (IOException e) {
            System.err.println("IO Exception =(");
        }
    }

    public void showStat(List<Car> list) {
        list = carDaoFileBased.findAll("Statistic");
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Автомобиль: " + list.get(i).getName() + " типа: " + list.get(i).getCarcase()
                    + " с номером " + list.get(i).getId() +
                    " продавец: " + list.get(i).getManager() +
                    " цена " + list.get(i).getPrice());
        }
    }

}
