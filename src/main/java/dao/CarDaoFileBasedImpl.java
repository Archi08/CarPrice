package dao;

import generators.GeneratorId;
import models.Car;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * 02.09.2017
 *
 * @author Shaikhutdinov Artur (First Software Engineering Platform)
 * @version v1.0
 */
public class CarDaoFileBasedImpl  implements  CarDao{
    GeneratorId idGenerator;

    private String fileName;

    public CarDaoFileBasedImpl(String fileName) {
        this.fileName = fileName;
    }

    public void save(Car car, String fileName) {
        car.setId(idGenerator.generateId());
        // сконвертировали в строку
        String modelDataAsString = car.toString();
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            // сохранили
            writer.write(modelDataAsString);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.err.println("IO Exception");
        }

        throw new IllegalArgumentException("Model is not implement Model interface");

    }

    public void delete(int id) {

    }

    public List<Car> findall() {
        return null;
    }
}
