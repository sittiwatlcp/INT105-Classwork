/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int105.io;

import int105.student.Student;
import int105.student.StudentClub;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Umaporn
 */
public class SerializedStudent implements Serializable {

    private StudentClub stdClubIn;
    private ArrayList<Student> stdList;

    public SerializedStudent(StudentClub s) {
        stdClubIn = s;
    }

    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        stdList = new ArrayList<>();
        try {
            while (true) {
                int id = ois.readInt();
                String name = ois.readUTF();
                Student tmp = new Student(id, name);
                stdList.add(tmp);
            }
        } catch (EOFException e) {
            System.out.println("End of File");
        }
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        while (stdClubIn.hasNext()) {
            Student s = stdClubIn.next();
            oos.writeInt(s.getId());
            oos.writeUTF(s.getName());
        }

    }

    public ArrayList<Student> getStudentList() {
        return stdList;
    }
}
