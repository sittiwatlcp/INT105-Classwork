
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TestDataOutputInputStream {
     public static void main(String[] args) {
        //csvToOutputStreamFile("files/student.csv", "files/studentoutput.dat");
        readInputStreamFile("files/studentoutput.dat");
    }
     
    public static void readInputStreamFile(String inputStreamFile){
        try(DataInputStream dis=new DataInputStream(
                new FileInputStream(
                new File(inputStreamFile) ) ) ){
            while(dis.available()> 0){
                System.out.print("id: "+dis.readLong());
                System.out.print(", name: "+dis.readUTF());
                System.out.println(", GPA: "+dis.readDouble());
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        
    }
    public static void csvToOutputStreamFile
        (String csvFile, String outputStreamFile){               
        //create output stream file
        try(DataOutputStream dos=
            new DataOutputStream(new FileOutputStream(
            new File(outputStreamFile)  )  )  ) {            
            //create scanner to read all lines from csvFile 
            Scanner scFile=new Scanner(new File(csvFile));            
            //create another scanner to read each line 
            //and using delimiter ',' to separate each value of line
            while(scFile.hasNextLine()){
                String line = scFile.nextLine();
                System.out.println("Line: "+line);
                Scanner scLine=new Scanner(line);
                //    \\s s=any whitespaces, *=any occurrences
                scLine.useDelimiter("\\s*,\\s*");                               
                long id=scLine.nextLong();
                String name=scLine.next();
                double gpa=scLine.nextDouble();
                System.out.println("id "+id+", name= "+name+" ,gpa= "+gpa);
                //write data to output stream file
                dos.writeLong(id);
                dos.writeUTF(name);
                dos.writeDouble(gpa);
            }            
        }
        catch(IOException e){
            e.printStackTrace();
        }                        
    }
    
   
   
}
