package dao;

import models.Car;

import java.util.List;

/**
 * 02.09.2017
 *
 * @author Shaikhutdinov Artur (First Software Engineering Platform)
 * @version v1.0
 */
public interface CarDao {
    void save(Car car, String fileName);
    void delete(int id);
    List<Car> findall();
}
