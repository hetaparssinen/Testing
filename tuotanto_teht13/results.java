

package removecomments;

import java.io.*;
import java.util.Scanner;


public class RemoveComments {

    

    public static void main(String[] args) {
        File file = new File("C:/Code/Ohjelmistotuotanto/testFile.java");
        try {
            

            
            
            String test = ""; 
            
            */ String test2 = "";
            
            
            String test3 = "//";
            
            PrintWriter writer = new PrintWriter("C:/Code/Ohjelmistotuotanto/results.java");
            Scanner scan = new Scanner(file);
            boolean multiple = false;
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                if (multiple) {
                    if (line.contains("*/")) {
                        int i = line.indexOf("*/");
                        line = line.substring(i + 2);
                        writer.println(line);
                        multiple = false;
                    }
                }
                else if (line.contains("/*")) {
                    int i = line.indexOf("/*");
                    String lineStart = line.substring(0, i);
                    String lineEnd = line.substring(i);
                    if (lineStart.contains("\"") && lineEnd.contains("\"")) {
                        writer.println(line);
                    } else {
                        writer.print(lineStart);
                        if (lineEnd.contains("*/")) {
                            i = lineEnd.indexOf("*/");
                            lineStart = lineEnd.substring(0, i);
                            lineEnd = lineEnd.substring(i);
                            writer.println(lineEnd);
                        } else {
                            multiple = true;
                            writer.println();
                        }
                    }
                }
                else if (line.contains("//")) {
                    int i = line.indexOf("//");
                    String lineStart = line.substring(0, i);
                    String lineEnd = line.substring(i);
                    if (lineStart.contains("\"") && lineEnd.contains("\"")) {
                        writer.println(line);
                    } else {
                        writer.println(lineStart);
                    }
                }
                else {
                    writer.println(line);
                }
            }
            scan.close();
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
}
