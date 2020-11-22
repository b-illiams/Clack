package main;

import java.io.IOException;

/** Represents a client side server listener that receives and prints data from the server
 * @author Brian Williams
 * @author Shamashad Abdulla
 * @version 1.0
 * @since 1.0
 */
public class ClientSideServerListener implements Runnable {
    /**
     * Represents the client to the server.
     */
    ClackClient client;


    public ClientSideServerListener(ClackClient client){
        this.client = client;
    }

    @Override
    public void run() {
            while (client.isCloseConnection()) {
                client.receiveData();
                client.printData();
            }

    }
}
