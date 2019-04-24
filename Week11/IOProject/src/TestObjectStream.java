
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author INT105
 */
public class TestObjectStream {

    public static void main(String[] args) {
        String fileName = "files/employeeoutput.dat";
        writeObject(fileName);
        readObject(fileName);
    }

    public static void writeObject(String fileName) {
        Employee e1 = new Employee(1, "A");
        Employee e2 = new Employee(2, "B");
        Employee e3 = new Employee(3, "C");


        try (FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            e1.setAutoId(5);
            e2.setAutoId(10);
            e3.setAutoId(855);
            oos.writeObject(e1);
            oos.writeObject(e2);
            oos.writeObject(e3);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readObject(String fileName) {
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis);) {
            while (true) {
                Employee tmp = (Employee) ois.readObject();
                System.out.println("Read Employee: " + tmp);
                //tmp.setAutoId(20);
                System.out.println("Auto Id: " +tmp.getAutoId());
            }
        } catch (EOFException e) {
            System.out.println("End Of file.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
