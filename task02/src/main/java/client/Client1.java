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

public class Client1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        int port = 80;
        String host = "68.183.239.26";
        // String host = "task02.chuklee.com";

        Socket sock = new Socket(host, port);

        // NetworkIO netIO = new NetworkIO(sock);

		// to get inputs	
        Console cons = System.console();
        String request = "";
        String response = "";
        // System.out.printf("Client online");

        InputStream is = sock.getInputStream();
        ObjectInputStream ois = new ObjectInputStream(is);
        OutputStream os = sock.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(os);


        while (true) {
			// better to put inside while loop to prevent repeats
            request = os.toString();
            request = oos.toString();

            // String id = (String) ois.readObject();
            // String nums = (String) ois.readObject();
            // System.out.println(id);
            // System.out.println(nums);

            System.out.printf("[SERVER REQ] ", request);

            //String[] listOfInt = request.split(" ");
            //System.out.println(listOfInt);
            // int[] intList = Integer.parseInt(listOfInt.split(","));
            // oos.writeUTF("ok");
						
			// type depends on usage case
            // System.out.printf(">> %f\n", answer);
        }
        

        // Close streams and dis
        // netIO.close();

        // Close sockets
        // socket.close();
    }
}
