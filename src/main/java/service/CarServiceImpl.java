package service;

import dao.CarDao;
import dao.CarDaoFileBasedImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 03.09.2017
 *
 * @author Shaikhutdinov Artur (First Software Engineering Platform)
 * @version v1.0
 */
public class CarServiceImpl {
    CarDao carDaoFileBased;

    public CarServiceImpl(CarDao carDaoFileBased) {
        this.carDaoFileBased = carDaoFileBased;
    }

   public void start() throws IOException {
       System.out.println("Введите пункт от 1 до 4: ");
       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
       int item = Integer.parseInt(bufferedReader.readLine());//считали пункт меню
       if (item == 1) {
           BufferedReader bufferedReader1 = new BufferedReader
                   (new InputStreamReader(System.in));
           String s =
       }
   }

}
