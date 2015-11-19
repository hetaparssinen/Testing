/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package removecomments;

import java.io.*;
import java.util.Scanner;
import java.nio.charset.Charset;
/**
 *
 * @author Heta
 */
public class RemoveComments {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File file = new File("C:/Code/Ohjelmistotuotanto/testFile.java");
        Charset encoding = Charset.defaultCharset();
        try {
            /* This code removes all comments 
            *  from file 
            */
            // It removes double slash comments and multiple line comments
            
            String test = ""; // It removes comment end of the line
            
            /* And it removes comment in the beginning of the line */ String test2 = "";
            
            // It doesn't remove characters between "" for example: 
            String test3 = "//";
            
            PrintWriter writer = new PrintWriter("C:/Code/Ohjelmistotuotanto/results.java");
            try {
                InputStream in = new FileInputStream(file);
                Reader reader = new InputStreamReader(in, encoding);
                // buffer for efficiency
                Reader buffer = new BufferedReader(reader);
                boolean slash = false;
                boolean multiple = false;
                boolean end = false;
                boolean line = false;
                int element;
                while ((element = buffer.read()) != -1) {
                    char c = (char) element;
                    
                    if (line) {
                        if (c == '\n') {
                            line = false;
                        }
                    }
                    else if (slash) {
                        if (c == '/') {
                            writer.println("");
                            line = true;
                            slash = false;
                        }
                        else if (c == '*') {
                            multiple = true;
                            slash = false;
                        }
                        else {
                            writer.print("/" + c);
                            slash = false;
                        }
                    }
                    else if (multiple) {
                        if (end) {
                            if (c == '/') {
                                writer.println("");
                                end = false;
                                multiple = false;
                            }
                        }
                        else if (c == '*') {
                            end = true;
                        }
                    }
                    else if (c == '/') {
                        slash = true;
                    }
                    else if (c == '\n') {
                        writer.println("");
                    }
                    else {
                        writer.print(c);
                    }
                            
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
