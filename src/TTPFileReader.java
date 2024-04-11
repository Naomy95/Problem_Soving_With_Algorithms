import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class TTPFileReader {
    public static void main(String[] args) throws  FileNotFoundException{
        File file = new File("Text.txt");
        Scanner scan= new Scanner(file);
System.out.println(scan.nextLine());
    }
}


//        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
//            String line;
//            while ((line = br.readLine()) != null) {
//                // Process each line as needed
//                System.out.println(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }