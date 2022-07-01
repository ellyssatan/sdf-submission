package client;

import java.io.Console;
import java.io.DataInput;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client {

    static String requestID;
    static float total;
    static int count;
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int port = 80;
        String host = "68.183.239.26";
        // String host = "task02.chuklee.com";

        Socket sock = new Socket(host, port);

        OutputStream os = sock.getOutputStream();
        InputStream is = sock.getInputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);
        ObjectInputStream ois = new ObjectInputStream(is);

        while (true) {
            String request = ois.readUTF();
            // System.out.println(request);

            requestID = request.split(" ")[0];
            String[] intList = request.split(" ")[1].split(",");

            oos.writeUTF(requestID);
            System.out.printf("[CLIENT REPLY] requestID:", requestID);

            String name  = "Tan Jia Yi Ellyssa";
            oos.writeUTF(name);
            System.out.printf("[CLIENT REPLY] Name:", name);

            String email  = "ellyssa.tan1807@gmail.com";
            oos.writeUTF(email);
            System.out.printf("[CLIENT REPLY] Email:", email);

            for (String i : intList) {
                int num = Integer.parseInt(i);
                total += num;
                count++;
            }
            float average = total/count;
            oos.writeFloat(average);            
            System.out.printf("[CLIENT REPLY] Average:", average);

            boolean result = ois.readBoolean();

            if (result == true) {
                System.out.println("SUCCESS");
            } else {
                System.out.println("FAILED");
                String error = ois.readUTF();
                System.out.println(error);
            }

            ois.close();
            oos.close();
            sock.close();
            
        }
        
    }
}
