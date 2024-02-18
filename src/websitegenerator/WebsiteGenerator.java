/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package websitegenerator;

import java.io.*;
import java.util.*;

/**
 *
 * @author user
 */
public class WebsiteGenerator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        Scanner fileIn; //Input file connection
        PrintWriter fileOut; //HTML file connection
        String filenameIn; //orginal file name 
        String filenameOut; //new HTML file;
        int dotIndex; //Hold postion of any dots within the file name 
        String line = null; //line from the input file
        
        //Ask user for a file name (or file location)
        System.out.println("Enter file name or file path");
        filenameIn = scanner.nextLine();
        
        //Check if file exists 
        try{
            //Rename the fileform txt to html
            fileIn = new Scanner(new FileReader(filenameIn));
            dotIndex = filenameIn.lastIndexOf(".");
            if(dotIndex == -1){
                filenameOut = filenameIn + ".html";
            }
            else{
                filenameOut = filenameIn.substring(0,dotIndex) + ".html";
            }
            fileOut = new PrintWriter(filenameOut);
            
            //determine if the file is empty
            try{
                line = fileIn.nextLine();
            }catch(NoSuchElementException e){
                System.out.println("Error "+e.getMessage());
            }
            if(line == null){
                System.out.println("This file is empty");
            }
            else{
                //read each line and insert necessary <tags>
                fileOut.println("<html>");
                fileOut.println("<head>");
                fileOut.println("</head>");
                fileOut.println("<body>");
                fileOut.println(line);
                 while(fileIn.hasNextLine()){
                     fileOut.println("br");
                     line  = fileIn.nextLine();
                     
                     if(line.isEmpty()){
                         fileOut.println("br");
                     }
                     else{
                         fileOut.println(line);
                     }
                 }
                fileOut.println("</body>");
                fileOut.println("</html>");
                
                System.out.println("HTML file is processed!");
            }
            fileOut.close();
            
        }catch(FileNotFoundException e){
            System.out.println("File not found");
        }
    }

}
