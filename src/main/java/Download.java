import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 02.09.2017
 *
 * @author Shaikhutdinov Artur (First Software Engineering Platform)
 * @version v1.0
 */
public class Download {

    ArrayList<Car> carsAvailable;
    

    public Download(ArrayList<Car> carsAvailable)  {
        this.carsAvailable = carsAvailable;
    }

    public String Ser(ArrayList<Car> carsAvailable) throws JsonProcessingException {

        ObjectMapper o = new ObjectMapper();
        String string = o.writeValueAsString(carsAvailable);
        return  string;
    }

public void toFile(String string) {}




}
