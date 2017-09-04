package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import models.Car;

import java.util.List;

/**
 * 02.09.2017
 *
 * @author Shaikhutdinov Artur (First Software Engineering Platform)
 * @version v1.0
 */
public interface CarDao {
    void save(Car car, String fileName) throws JsonProcessingException;
    void delete(int id, String fileName);
    List<Car>  findAll(String fileName);
    Car findById(int id, String fileName);
}
