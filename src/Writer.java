import java.io.*;
import java.util.Scanner;

public class Writer {

    Scanner scan = new Scanner(System.in);

    public Writer(String ll) {
        String fileName;

        System.out.print("Please enter your filename: ");
        fileName = scan.next();

        try {
            File f = new File(fileName + ".txt");

            if (f.createNewFile()) {
                System.out.println("The file has been created.");
            } else {
                System.out.println("The file already exists.");
            }
        } catch (IOException e) {
            System.err.println(e);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + ".txt", true));
            writer.write(ll);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
