import java.io.IOException;
import java.io.ObjectInputStream;

public class TClient extends Thread {
    private ObjectInputStream objectInputStream;

    public TClient(ObjectInputStream objectInputStream) {
        this.objectInputStream = objectInputStream;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Message message = (Message) this.objectInputStream.readObject();
                System.out.println(message.outputMessage());
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
