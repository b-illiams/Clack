package main;

import data.ClackData;
import data.MessageClackData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerSideClientIO implements Runnable{
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

    private ClackServer server;

    private ArrayList<String> clientList;

    private Socket clientSocket;

    public ServerSideClientIO (ClackServer server, Socket clientSocket){
        this.server = server;
        this.clientSocket = clientSocket;
        this.clientList = new ArrayList<String>();
        this.closeConnection = false;
        this.inFromClient = null;
        this.outToClient = null;
        this.dataToSendToClient = null;
        this.dataToReceiveFromClient = null;
    }

    public void receiveData(){
        if(!closeConnection){
            try{
                dataToReceiveFromClient =  (data.ClackData) inFromClient.readObject();
                updateUserNames(dataToReceiveFromClient.getUserName());
            }catch(ClassNotFoundException e){
                e.printStackTrace();
                server.remove(this);
            }catch(IOException e){
                e.printStackTrace();
                server.remove(this);
            }
        }else{
            server.remove(this);
        }
    }

    public void sendData(){
        try{
            if(dataToReceiveFromClient.getType() == 0)
                dataToSendToClient = new MessageClackData(dataToSendToClient.getUserName(), sendUserNames(), 0 );
            outToClient.writeObject(dataToSendToClient);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void setDataToSendToClient(ClackData dataToSendToClient){
        this.dataToSendToClient = dataToSendToClient;
    }

    public boolean isCloseConnection(){
        return closeConnection;
    }

    public void updateUserNames(String userName){
        boolean flag = true;
        for(String x : clientList){
            if (x.equals(userName)){
                flag = false;
            }
        }

        if(flag){
            clientList.add(userName);
        }
    }

    public String sendUserNames(){
        String users = "";
        for(String x : clientList){
            users += x + "\n";
        }
        return users;
    }

    @Override
    public void run() {
        try {
            inFromClient = new ObjectInputStream(clientSocket.getInputStream());
            outToClient = new ObjectOutputStream(clientSocket.getOutputStream());

            while(!closeConnection) {
                if (!closeConnection) {
                    receiveData();
                    server.broadcast(dataToReceiveFromClient);
                    sendData();
                }
            }
            clientSocket.close();
            inFromClient.close();
            outToClient.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
