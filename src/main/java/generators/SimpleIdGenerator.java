package generators;

import java.io.*;

/**
 * 02.09.2017
 *
 * @author Shaikhutdinov Artur (First Software Engineering Platform)
 * @version v1.0
 */
public class SimpleIdGenerator implements GeneratorId{

    private String idFileName;

    private int lastGeneratedId;


    public SimpleIdGenerator(String idFileName) {
        this.idFileName = idFileName;
        try {
            BufferedReader reader
                    = new BufferedReader(
                    new FileReader(idFileName));
            String id = reader.readLine();
            lastGeneratedId = Integer.parseInt(id);
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("IO Exception");
        }
    }

    public int generateId() {
        int newId = lastGeneratedId + 1;
        lastGeneratedId = newId;
        try {
            Writer writer = new FileWriter(idFileName);
            writer.write(newId+"");
            writer.close();
            return newId;
        } catch (IOException e) {
            System.err.println("File not found");
        }
        return -1;
    }





}
