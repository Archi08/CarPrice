package dao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import generators.GeneratorId;
import models.Car;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 02.09.2017
 *
 * @author Shaikhutdinov Artur (First Software Engineering Platform)
 * @version v1.0
 */
public class CarDaoFileBasedImpl  implements  CarDao{

    private GeneratorId idGenerator;
    private String fileName;

    public CarDaoFileBasedImpl(String fileName, GeneratorId idGenerator) {
        this.fileName = fileName;
        this.idGenerator = idGenerator;
    }

    public void save(Car car, String fileName) throws JsonProcessingException {

        car.setId(idGenerator.generateId());
        ObjectMapper o = new ObjectMapper();
        String modelDataAsString = o.writeValueAsString(car);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            // сохранили
            writer.write(modelDataAsString);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            System.err.println("IO Exception");
        }

    }

    public void delete(int id, String fileName) {
        try {
            List<String> models = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String current = reader.readLine();
            ObjectMapper o = new ObjectMapper();
            Car car = o.readValue(current, Car.class);

            int finded = 0; // счетчик, что бы больше одного не удалить
            while (current != null) {
                 int curId =  car.getId();
                if (curId == id && finded == 0) {
                    finded++;
                } else {
                    models.add(current);
                }
                current = reader.readLine();
            }
            // переписываем наш файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            for (int i = 0; i < models.size(); i++) {
                writer.write(models.get(i));
                writer.newLine();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not Found Exception!!");
        } catch (IOException e) {
            System.err.println("IO Exception =(");
        }


    }

    public List<Car> findall(String fileName) {
        try {

            ArrayList<Car> cars = new ArrayList<>();
            ObjectMapper o = new ObjectMapper();

            BufferedReader reader = new BufferedReader(new FileReader(fileName));

            String currentModel = reader.readLine();

            while (currentModel != null) {

                Car car = o.readValue(currentModel, Car.class);


                cars.add(car);

                currentModel = reader.readLine();
            }
            reader.close();
            return cars;
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
        return new ArrayList<Car>();
    }
}
