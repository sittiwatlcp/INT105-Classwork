
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author INT105
 */
public class TestInputOutputStream {
    public static void copyFile(String source, String target){
        try(BufferedInputStream bis=new BufferedInputStream(
                new FileInputStream(new File(source))) ;
            BufferedOutputStream bos=new BufferedOutputStream(
                new FileOutputStream(new File(target))) )   {    
            
            byte data[]=new byte[100];
            int readTotalBytes;
            while( (readTotalBytes=bis.read(data))!=-1){
                System.out.println("Number of read bytes: "+readTotalBytes);
                bos.write(data,0, readTotalBytes);
              
                //bos.write(bytearray, start position, number of written bytes)
                /*if(readTotalBytes<data.length)
                    bos.write(data,0, readTotalBytes);
                else
                    bos.write(data);*/
                
                
            }
            /*int data;
            while( (data=bis.read())!=-1 ){
               // System.out.println(data);
                bos.write(data);
            } */                        
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }            
    public static void main(String[] args) {
        copyFile("files/sample.bmp", "files/sample-copy.bmp");
    }
}
