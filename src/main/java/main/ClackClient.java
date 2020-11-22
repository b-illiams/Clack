package main;

import data.ClackData;
import data.FileCData;
import data.MessageClackData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.InputMismatchException;
import java.util.Scanner;

/** Represents a client for the messaging system of Clack.
 * @author Brian Williams
 * @author Shamashad Abdulla
 * @version 1.0
 * @since 1.0
 */
public class ClackClient {
    /**
     * String representing a username.
     */
    private String userName;
    /**
     * String representing the host name.
     */
    private String hostName;
    /**
     * Integer representing the port.
     */
    private int port;
    /**
     * boolean representing the connection status.
     */
    private boolean closeConnection;
    /**
     * ClackData representing data sent to server.
     */
    private ClackData dataToSendToServer;
    /**
     * ClackData representing data sent from server.
     */
    private ClackData dataToReceiveFromServer;

    /**
     * Scanner that takes in input from the console.
     */
    private Scanner inFromStd;

    /**
     * ObjectInputStream object that receives data packets.
     */
    private ObjectInputStream inFromServer;

    /**
     * ObjectOutputStream object that sends data packets.
     */
    private ObjectOutputStream outToServer;

    /**
     * Constructor that takes in userName, hostName, and port. Sets closeConnection, dataToReceiveFromServer, and dataToSendToServer to default values.
     * @param userName String representing the username.
     * @param hostName String representing the host name.
     * @param port Integer representing the port.
     */
    public ClackClient(String userName, String hostName, int port) throws IllegalArgumentException{
        this.userName = userName;
        if(this.userName.equals(null)){
            throw new IllegalArgumentException();
        }
        this.hostName = hostName;
        if(this.hostName.equals(null)){
            throw new IllegalArgumentException();
        }
        this.port = port;
        if(port < 1024){
            throw new IllegalArgumentException();
        }
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
        this.inFromServer = null;
        this.outToServer = null;

    }

    /**
     * Constructor that takes in userName and hostName. Sets port, closeConnection, dataToReceiveFromServer, and dataToSendToServer to default values.
     * @param userName String representing the username.
     * @param hostName String representing the host name.
     */
    public ClackClient(String userName, String hostName) throws IllegalArgumentException{
        this.userName = userName;
        if(this.userName.equals(null)){
            throw new IllegalArgumentException();
        }
        this.hostName = hostName;
        if(this.hostName.equals(null)){
            throw new IllegalArgumentException();
        }
        this.port = 7000;
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
        this.inFromServer = null;
        this.outToServer = null;
    }

    /**
     * Constructor that takes in userName. Sets hostName, port, closeConnection, dataToReceiveFromServer, and dataToSendToServer to default values.
     * @param userName String representing the username.
     */
    public ClackClient(String userName) throws IllegalArgumentException{
        this.userName = userName;
        if(this.userName.equals(null)){
            throw new IllegalArgumentException();
        }
        this.hostName = "";
        this.port = 7000;
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
        this.inFromServer = null;
        this.outToServer = null;

    }

    /**
     * Constructor that takes in userName, hostName, and port. Sets closeConnection, dataToReceiveFromServer, and dataToSendToServer to default values.
     */
    public ClackClient(){
        this.userName = "";
        this.hostName = "";
        this.port = 7000;
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
        this.inFromServer = null;
        this.outToServer = null;

    }

    /**
     * TODO: implementation
     */
    public void start(){

        try{
            Socket socket = new Socket(hostName, port);
            inFromServer = new ObjectInputStream(socket.getInputStream());
            outToServer = new ObjectOutputStream(socket.getOutputStream());
            inFromStd = new Scanner (System.in);
            Runnable thread = new ClientSideServerListener(this);
            while(!closeConnection) {
                thread.run();
                readClientData();
                if (!closeConnection) {
                    sendData();
                }
            }

            inFromStd.close();
            inFromServer.close();
            outToServer.close();
            closeConnection = true;

        }catch(IOException e){
            e.printStackTrace();
        }

    }

    /**
     * sends data to the server
     * TODO: implementation
     */
    public void sendData(){
        try{
            outToServer.writeObject(dataToSendToServer);
        }catch(IOException e){
           e.printStackTrace();
        }


    }

    /**
     * receives data from the server
     * TODO: implementation
     */
    public void receiveData(){
        try {
            dataToReceiveFromServer = (ClackData) inFromServer.readObject();
        }catch(IOException e){
            e.printStackTrace();
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * prints data
     * TODO: robust implementation
     */
    public void printData(){
        System.out.println(dataToReceiveFromServer.getData());
    }

    /**
     * reads client data from console.
     */
    public void readClientData(){
        String contents = inFromStd.nextLine();
        Scanner contentScan = new Scanner(contents);
        if(contents.equals("DONE")){
            System.out.println("1");
             this.closeConnection = true;
        }else if(contentScan.hasNext("SENDFILE")){
            System.out.println("2");
            contents = contents.substring("SENDFILE".length() + 1);
            FileCData temp = new FileCData(userName, contents, new FileCData().CONSTANT_SENDFILE);
            try {
                temp.readFileContents();
            }catch(IOException e){
                e.printStackTrace();
            }
            dataToSendToServer = temp;

        }else if(contents.equals("LISTUSERS")){
            System.out.println("3");
            dataToSendToServer = new MessageClackData(userName, "", new MessageClackData().CONSTANT_LISTUSERS);
        }else{
            System.out.println("4");
            dataToSendToServer = new MessageClackData(userName, contents, new MessageClackData().CONSTANT_SENDMESSAGE);
        }
    }

    /**
     *
     * @return value of closeConnection.
     */
    public boolean isCloseConnection() {
        return closeConnection;
    }

    /**
     *
     * @return value of userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @return value of hostName.
     */
    public String getHostName(){
        return hostName;
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
        result = prime * result + (userName.hashCode());
        result = prime * result + (hostName.hashCode());
        if(dataToSendToServer != null)
            result = prime * result + (dataToSendToServer.hashCode());
        if(dataToReceiveFromServer != null)
            result = prime * result + (dataToReceiveFromServer.hashCode());
        result = prime * result + (port);
        result = prime * result + (closeConnection ? 1 : 0);
        return result;
    }

    /**
     *
     * @param obj Clack Client object
     * @return comparison of the values of two Clack Client objects.
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }else if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }else{
            ClackClient o = (ClackClient) obj;
            boolean b1 = false;
            boolean b2 = false;

            if(dataToReceiveFromServer != null && o.dataToSendToServer != null){
                if(this.dataToReceiveFromServer.equals(o.dataToReceiveFromServer) ){
                    b1 = true;
                }
            }else if(dataToReceiveFromServer == null && o.dataToReceiveFromServer == null){
                b1 = true;
            }

            if(dataToSendToServer != null && o.dataToSendToServer != null){
                if(this.dataToSendToServer.equals(o.dataToSendToServer)){
                    b2 = true;
                }
            } else if(dataToSendToServer == null && o.dataToSendToServer == null){
                b2 = true;
            }

            return b1 &&
                    b2 &&
                    this.userName.equals(o.userName) &&
                    this.hostName.equals(o.hostName) &&
                    this.port == o.port &&
                    this.closeConnection == o.closeConnection;
        }
    }

    /**
     *
     * @return String representation of ClackClient
     */
    @Override
    public String toString() {
        return "\nUSERNAME: " + userName + "\nHOST NAME: " + hostName + "\nDATA TO CLIENT: -> \n" + dataToSendToServer + "\nDATA FROM SERVER: -> \n" + dataToReceiveFromServer + "\nPORT: " + port + "\nCLOSE CONNECTION: " + closeConnection;
    }

    public static void main (String[]args){
        ClackClient client;
        try{
            if(args[0] != null){
                client = new ClackClient(args[0]);
            }else if (args[0] != null && args[0].contains("@")){
                client = new ClackClient(args[0].substring(0, args[0].indexOf("@")), args[0].substring(args[0].indexOf("@")));
            }else if (args[0] != null && args[0].contains("@") && args[0].contains(":")){
                client = new ClackClient(args[0].substring(0, args[0].indexOf("@")));
            }else{
                client = new ClackClient();
            }
            client.start();
        }catch(InputMismatchException e){
            e.printStackTrace();
        }catch(ArrayIndexOutOfBoundsException e){

        }

    }
}