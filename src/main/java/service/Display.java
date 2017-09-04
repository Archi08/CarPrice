package service;

import models.Car;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * 04.09.2017
 *
 * @author Shaikhutdinov Artur (First Software Engineering Platform)
 * @version v1.0
 */
public class Display {

    CarServiceImpl carService;
    List<Car> list;
    Car car;

    public Display(CarServiceImpl carService, List<Car> list, Car car) {
        this.carService = carService;
        this.list = list;
        this.car = car;
    }

    public void start() throws IOException {
        System.out.println("============================");
        System.out.println("|           MENU           |");
        System.out.println("============================");
        System.out.println("| Options:                 |");
        System.out.println("| 1- Добавить транспорт    |");
        System.out.println("|      2- В наличии        |");
        System.out.println("|        3- Покупка        |");
        System.out.println("|      4- Статистика       |");
        System.out.println("|       0 - Выход          |");
        System.out.println("============================");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int item = Integer.parseInt(bufferedReader.readLine());//считали пункт меню

         switch (item) {
             case 0:
                 break;
             case 1:
                 carService.createCar();
                 break;
             case 2:
                 carService.outPutCars(list);
                 break;
             case 3:
                 carService.sale(car, "Cars");
                 break;
             case 4:
                 carService.showStat(list);
                 break;
         }
    }
}
