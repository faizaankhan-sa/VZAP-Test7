package vzap.com;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class RecordReadRecords {
    private static final String FILE_NAME = "productRecords.txt";
    private static final int RECORD_SIZE = 20;

    public static void main(String[] args) {
        RecordReadRecords program = new RecordReadRecords();
        program.run();
    }

    public void run() {
        Scanner in = new Scanner(System.in);
        boolean exit = false;
        try  {
            RandomAccessFile file = new RandomAccessFile(FILE_NAME, "rw");
            while (!exit) {
                System.out.println("+---------------------------------+");
                System.out.println("|  1. Add Product                 |");
                System.out.println("|  2. Display a specific Product  |");
                System.out.println("|  3. Display all Products        |");
                System.out.println("|  4. Exit                        |");
                System.out.println("+---------------------------------+");
                System.out.print("enter a number: ");
                int choice = in.nextInt();
                switch (choice) {
                    case 1:
                        addProduct(file, in);
                        break;
                    case 2:
                        displaySpecificProduct(file, in);
                        break;
                    case 3:
                        displayAllProducts(file);
                        break;
                    case 4:
                        exit = true;
                        break;
                    default:
                        System.out.println("invalid choice");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            File file = new File(FILE_NAME);
            file.delete();
            in.close();
        }
    }

    private void addProduct(RandomAccessFile file, Scanner scanner){
        System.out.print("enter a product id: ");
        int productID = scanner.nextInt();
        System.out.print("enter a product price: ");
        double prodPrice = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("enter a product description: ");
        String prodDescription = scanner.nextLine();

        try {
            file.seek(file.length());
            file.writeInt(productID);
            file.writeDouble(prodPrice);
            file.writeUTF(prodDescription);
            System.out.println("the product successfully added.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displaySpecificProduct(RandomAccessFile file, Scanner scanner){
        System.out.print("enter the product number to display: ");
        int productNumber = scanner.nextInt();

        try {
            if (productNumber <= 0 || productNumber > file.length() / RECORD_SIZE) {
                System.out.println("wrong product number.");
                return;
            }

            file.seek((long) (productNumber - 1) * RECORD_SIZE);
            int productID = file.readInt();
            double prodPrice = file.readDouble();
            String prodDescription = file.readUTF();

            System.out.println("product id is: " + productID);
            System.out.println("product price is: " + prodPrice);
            System.out.println("product description is: " + prodDescription);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void displayAllProducts(RandomAccessFile file){
        try {

            if (file.length() == 0) {
                System.out.println("There are no products found.");
                return;
            }


            file.seek(0);
            int recordNumber = 1;
            while (file.getFilePointer() < file.length()) {
                int productID = file.readInt();
                double prodPrice = file.readDouble();
                String prodDescription = file.readUTF();

                System.out.println("record number is: " + recordNumber);
                System.out.println("product id is: " + productID);
                System.out.println("product price is: " + prodPrice);
                System.out.println("product description is: " + prodDescription);
                System.out.println();
                recordNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}