package client;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class NetworkIO {

    // class -> create, read, write, close
    private InputStream is;
    private ObjectInputStream ois;
    private OutputStream os;
    private ObjectOutputStream oos;

    // create new network
    public NetworkIO(Socket sock) throws IOException {
        is = sock.getInputStream();
        ois = new ObjectInputStream(is);
        os = sock.getOutputStream();
        oos = new ObjectOutputStream(os);
    }

    public String read() throws IOException {
        return ois.readUTF();
    }

    public void write(String msg) throws IOException {
        oos.writeUTF(msg);
        oos.flush();
    }

    public void writeFloat(float f) throws IOException {
        oos.writeFloat(f);
        oos.flush();
    }
    
    public void close() {
        try {
            ois.close();
            is.close();
            oos.close();
            os.close();
        } catch (IOException ex) { 
            // don't care if we get exception because we are closing the connection
        }
    }
}
