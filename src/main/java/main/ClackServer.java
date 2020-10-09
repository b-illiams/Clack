package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.InputMismatchException;

/** Represents a server for the messaging system of Clack.
 * @author Brian Williams
 * @author Shamashad Abdulla
 * @version 1.0
 * @since 1.0
 */
public class ClackServer {
    /**
     * Integer representing the port.
     */
    private int port;
    /**
     * boolean representing the connection status.
     */
    private boolean closeConnection;
    /**
     * ClackData representing data sent to client.
     */
    private data.ClackData dataToSendToClient;
    /**
     * ClackData representing data sent from client.
     */
    private data.ClackData dataToReceiveFromClient;

    /**
     * ObjectInputStream object that receives data packets.
     */
    private ObjectInputStream inFromClient;

    /**
     * ObjectOutputStream object that sends data packets.
     */
    private ObjectOutputStream outToClient;

    /**
     * Constructor that takes in the port.
     * @param port Integer representing the port.
     */
    public ClackServer(int port) throws IllegalArgumentException{
        this.closeConnection = false;
        this.inFromClient = null;
        this.outToClient =  null;
        if(port < 1024)
            throw new IllegalArgumentException();
        this.port =  port;
    }

    /**
     * Default Constructor that sets port to a default value.
     */
    public ClackServer(){
        this.closeConnection = false;
        this.inFromClient = null;
        this.outToClient =  null;
        this.port = 7000;
    }

    /**
     * TODO: implementation
     */
    public void start(){
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            Socket clientSocket = serverSocket.accept();
            inFromClient = new ObjectInputStream(clientSocket.getInputStream());
            outToClient = new ObjectOutputStream(clientSocket.getOutputStream());
            while(!closeConnection) {
                if (!closeConnection) {
                    receiveData();
                    printData();
                    dataToSendToClient = dataToReceiveFromClient;
                    sendData();
                }
            }
            clientSocket.close();
            inFromClient.close();
            outToClient.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * sends data to the client
     * TODO: implementation
     */
    public void sendData(){
        try{
            outToClient.writeObject(dataToSendToClient);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * receives data from the client
     * TODO: implementation
     */
    public void receiveData(){
        if(!closeConnection){
            try{
                dataToReceiveFromClient =  (data.ClackData) inFromClient.readObject();
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * prints data
     * TODO: implementation
     */
    public void printData(){
        System.out.println(dataToReceiveFromClient.getData());
    }


    /**
     * @return value of port.
     */
    public int getPort() {
        return port;
    }

    /**
     *
     * @return hash value of class.
     */
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        if(dataToSendToClient != null)
            result = prime * result + (dataToSendToClient.hashCode());
        if(dataToReceiveFromClient != null)
            result = prime * result + (dataToReceiveFromClient.hashCode());
        result = prime * result + (port);
        result = prime * result + (closeConnection ? 1 : 0);
        return result;
    }

    /**
     *
     * @param obj Clack Server object
     * @return comparison of the values of two Clack Server objects.
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }else if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }else{
            ClackServer o = (ClackServer) obj;

            boolean b1 = false;
            boolean b2 = false;

            if(dataToReceiveFromClient != null && o.dataToReceiveFromClient != null){
                if(this.dataToReceiveFromClient.equals(o.dataToReceiveFromClient) ){
                    b1 = true;
                }
            }else if(dataToReceiveFromClient == null && o.dataToReceiveFromClient == null){
                b1 = true;
            }

            if(dataToSendToClient != null && o.dataToSendToClient != null){
                if(this.dataToSendToClient.equals(o.dataToSendToClient)){
                    b2 = true;
                }
            } else if(dataToSendToClient == null && o.dataToSendToClient == null){
                b2 = true;
            }
            return b1 &&
                    b2 &&
                    this.port == o.port &&
                    this.closeConnection == o.closeConnection;
        }
    }
    /**
     *
     * @return String representation of ClackServer
     */
    @Override
    public String toString() {
        return "\nDATA TO CLIENT: -> \n" + dataToSendToClient + "\nDATA FROM CLIENT: -> \n" + dataToSendToClient + "\nPORT: " + port + "\nCLOSE CONNECTION: " + closeConnection;
    }

    public static void main (String[]args){
        ClackServer server;
        try{
            if(args[0] != null){
                server = new ClackServer(Integer.parseInt(args[0]));
            }else{
                server = new ClackServer();
            }
            server.start();
        }catch(InputMismatchException e){
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e) {
            server = new ClackServer();
            server.start();
        }
    }
}


