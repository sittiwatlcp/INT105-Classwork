
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReaderWriter {
      public static void main(String[] args) {
        File fn=new File("files/mytext.txt");
        System.out.println(fn.exists());
        System.out.println(fn.getPath());
      //  writeChar(fn);
      //  readChar(fn);
        copyTextFile(fn, new File("files/mytext-copy.txt"));
    }  
    public static void copyTextFile(File sourceFile, File targetFile){
        try( FileReader fr=new FileReader(sourceFile);
             FileWriter fw=new FileWriter(targetFile) ) {            
            int ch;
            while(   (ch=fr.read())  !=-1 ){
                fw.write(ch);                
            }            
        }
        catch(IOException e){
            e.printStackTrace();
        }        
    }
    public static void writeChar(File fileName) { //throws IOException{
        //try with resources
        try(FileWriter fw=new FileWriter(fileName)){
            fw.write('A');
            fw.write("I am a lecturer.");
            fw.write("good bye");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void readChar(File fileName){
        try(FileReader fr=new FileReader(fileName)){
            int ch=fr.read();
            while(ch!=-1){
                System.out.println((char)ch);
                ch=fr.read();               
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }        
    }
    
}
