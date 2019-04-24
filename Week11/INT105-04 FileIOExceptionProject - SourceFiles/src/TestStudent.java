
import int105.io.SerializedStudent;
import int105.student.Student;
import int105.student.StudentClub;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TestStudent {

    private static StudentClub footballClubMember = new StudentClub();
    
    private static void readClub() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("stdlist.dat"))) {
            SerializedStudent ss = (SerializedStudent) ois.readObject();
            for (Student s : ss.getStudentList()) {
                System.out.println(s);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void writeClub() {
        StudentClub s = new StudentClub();
        s.add(new Student(1, "A"));
        s.add(new Student(2, "B"));
        s.add(new Student(3, "C"));
        s.add(new Student(4, "D"));

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("stdlist.dat"))) {
            SerializedStudent ss = new SerializedStudent(s);
            oos.writeObject(ss);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFromDB() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conn = DriverManager.getConnection("jdbc:derby://localhost:1527/INT105", "int105", "int105");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM student");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
            conn.close();
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private static void readFromDB_v2() {
        try (Connection conn = DBConnection.GetConnection()) {
            String sql = "SELECT * FROM student";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    System.out.println(rs.getInt("id") + " " + rs.getString("name"));
                }
            }

            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static void footballClub() {
        try (Connection conn = DBConnection.GetConnection()) {
            String sql = "SELECT * FROM student";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                ResultSet rs = pst.executeQuery();
                while (rs.next()) {
                    footballClubMember.add(new Student(rs.getInt("id"), rs.getString("name")));
                    //System.out.println(rs.get);
                }
            }

            conn.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private static void showfootballMemeber() {
        while(footballClubMember.hasNext()){
            System.out.println(footballClubMember.next());
        }
    }

    public static void main(String[] args) {
        //writeClub();
        //readClub();
        //readFromDB();
        //readFromDB_v2();
        footballClub();
        showfootballMemeber();
    }

}
