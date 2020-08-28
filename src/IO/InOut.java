package IO;

import Objects.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class InOut {
    public InOut(){}

    public void writeObjectToFile(ArrayList<Person> serObj) {
        try {
            FileOutputStream fileOut = new FileOutputStream("person.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList<Person> readFromFile() {
        try {
            FileInputStream fileIn = new FileInputStream("person.dat");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            ArrayList<Person> list = (ArrayList<Person>) objectIn.readObject();
            objectIn.close();
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}