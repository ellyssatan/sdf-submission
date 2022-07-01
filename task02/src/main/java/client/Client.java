package client;

import java.io.Console;
import java.io.IOException;
import java.net.Socket;

public class Client {
    static String requestID;
    static float total;
    static int count;
    public static void main(String[] args) throws IOException {

        int port = 80;
        String host = "68.183.239.26";
        // String host = "task02.chuklee.com";

        Socket sock = new Socket(host, port);

        NetworkIO netIO = new NetworkIO(sock);
        // NetworkIO2 netIO = new NetworkIO2(sock);


		// to get inputs	
        Console cons = System.console();
        String request = "";
        String response = "";


        while (true) {
			// better to put inside while loop to prevent repeats
            
            request = netIO.read();
            System.out.printf("[SERVER REQ] ", request);

            requestID = request.split(" ")[0];
            String[] intList = request.split(" ")[1].split(",");

            netIO.write(requestID);
            System.out.printf("[CLIENT REPLY] requestID:", requestID);

            String name  = cons.readLine("Full name as per NRIC: ");
            netIO.write(name);
            System.out.printf("[CLIENT REPLY] Name:", name);

            String email  = cons.readLine("Email: ");
            netIO.write(email);
            System.out.printf("[CLIENT REPLY] Email:", email);


            for (String i : intList) {
                int num = Integer.parseInt(i);
                num+=total;
                count++;
            }
            float average = total/count;
            netIO.writeFloat(average);            
            System.out.printf("[CLIENT REPLY] Average:", average);

            netIO.close();
            sock.close();

        }

    }
}
