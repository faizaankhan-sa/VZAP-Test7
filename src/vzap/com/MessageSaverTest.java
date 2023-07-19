package vzap.com;
import java.io.File;
import java.util.Scanner;

public class MessageSaverTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the first message: ");
        String message1 = scanner.nextLine();
        System.out.print("enter the second message: ");
        String message2 = scanner.nextLine();
        File file = new File("info2.txt");
        MessageSaver messageSaver1 = new MessageSaver(file, message1);
        MessageSaver messageSaver2 = new MessageSaver(file, message2);

        messageSaver1.start();
        messageSaver2.start();
    }
}