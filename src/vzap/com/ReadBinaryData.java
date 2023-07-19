package vzap.com;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadBinaryData {

    public static void main(String[] args) {
        try  {
            DataInputStream inputStream = new DataInputStream(new FileInputStream("salaries.bin"));
            while (inputStream.available() > 0) {
                double salary = inputStream.readDouble();
                System.out.println(salary);
            }
        } catch (IOException e) {
            System.err.println("an error occurred while reading data from the file");
            e.printStackTrace();
        }
    }
}
