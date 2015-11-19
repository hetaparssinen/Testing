

package removecomments;

import java.io.*;
import java.util.Scanner;


public class RemoveComments {

    

    public static void main(String[] args) {
        File file = new File("testFile.java");
        try {
            


            

            String test = ""; 

            
 String test2 = "";
            
            PrintWriter writer = new PrintWriter("results.java");
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
                else if (line.contains("a")) {
                    int i = line.indexOf("b");
                    String lineStart = line.substring(0, i);
                    String lineEnd = line.substring(i);
                    if (lineStart.contains("c") && lineEnd.contains("d")) {
                        writer.println(line);
                    } else {
                        writer.print(lineStart);
                        if (lineEnd.contains("a")) {
                            i = lineEnd.indexOf("b");
                            lineStart = lineEnd.substring(0, i);
                            lineEnd = lineEnd.substring(i);
                            writer.println(lineEnd);
                        } else {
                            multiple = true;
                            writer.println();
                        }
                    }
                }
                else if (line.contains("c")) {
                    int i = line.indexOf("d");
                    String lineStart = line.substring(0, i);
                    String lineEnd = line.substring(i);
                    if (lineStart.contains("e") && lineEnd.contains("g")) {
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
