package vzap.com;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SaveBinaryData {

    private DataOutputStream outputStream;

    public SaveBinaryData() {
        try {
            outputStream = new DataOutputStream(new FileOutputStream("salaries.bin", true));
        } catch (IOException e) {
            System.err.println("an error occurred while writing data to file");
            e.printStackTrace();
        }
    }

    public boolean saveData(double salin) {
        try {
            outputStream.writeDouble(salin);
            outputStream.flush();
            return true;
        } catch (IOException e) {
            System.err.println("an error occurred while writing data to file");
            e.printStackTrace();
            return false;
        }
    }

    public boolean closeFiles() {
        try {
            outputStream.close();
            return true;
        } catch (IOException e) {
            System.err.println("error while for file");
            e.printStackTrace();
            return false;
        }
    }

    public static void main(String[] args) {
        SaveBinaryData saveBinaryData = new SaveBinaryData();
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter real numbers and enter a random character to stop");
        while (scanner.hasNextDouble()) {
            double salary = scanner.nextDouble();
            saveBinaryData.saveData(salary);
        }
        saveBinaryData.closeFiles();
    }
}

