/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restaurantsystem;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import restaurantsystem.component.auth.Login;

import java.sql.*;
/**
 *
 * @author Shahin
 */
public class Main extends JFrame {

    public static class Model {
          public static Connection connection = null;
        Model(){
       try {
           Class.forName("org.postgresql.Driver");
           connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mvc_db",
           "swaroop","swar1234");
           if(connection!=null){
               System.out.println("Connection Established Succesfully!!");
           }
           else{
               System.out.println("Connection failed :(");
           }
       } catch (Exception e) {
           System.out.println(e);
       }
    }
   }
    public static void main(String[] args) {
        // At first, show the login page and show menu after - 
        // the authentication process completed
        
        createRequiredFileIfDoesNotExist();
        Model m = new Model();
        Login im = new Login();
        im.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        im.setVisible(true);
    }
    
    private static void createRequiredFileIfDoesNotExist() {
        String fileNames [];
        
        File rootDir = new File("storage");
        rootDir.mkdirs();
        
        fileNames = new String [] {"storage/item.txt",
            "storage/labour.txt",
            "/home/swaroop/Desktop/Store/order.txt",
            "/home/swaroop/Desktop/Store/orderLine.txt"};
        
        for (String fileName : fileNames) {
            File file = new File(fileName);
            if(!file.exists())
            {  
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
       
    }
    

}
