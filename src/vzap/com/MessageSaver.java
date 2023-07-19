package vzap.com;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MessageSaver extends Thread {

    private File file;
    private String message;

    public MessageSaver(File file, String message) {
        this.file = file;
        this.message = message;
    }

    @Override
    public void run() {
        try  {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(message);
            writer.newLine();
            writer.flush();
            System.out.println("the message saved to the file: " + file.getName());
        } catch (IOException e) {
            System.err.println("a error occurred while trying to saving message to file: " + file.getName());
            e.printStackTrace();
        }
    }
}