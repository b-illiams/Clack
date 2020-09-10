package main;

import data.ClackData;

public class ClackClient {
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToServe;
    private ClackData dataToReceiveFromServer;

    public ClackClient(String userName, String hostName, int port){
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        this.closeConnection = false;

    }

    public ClackClient(String userName, String hostName){
        this.userName = userName;
        this.hostName = hostName;
        this.port = 7000;
        this.closeConnection = false;
    }

    public ClackClient(String userName){
        this.userName = userName;
        this.hostName = "";
        this.port = 7000;
        this.closeConnection = false;
    }

    public ClackClient(){
        this.userName = "";
        this.hostName = "";
        this.port = 7000;
        this.closeConnection = false;
    }

    public void start(){}

    public void sendData(){}

    public void receiveData(){}

    public void printData(){}

    public String getUserName() {
        return userName;
    }

    public String getHostName(){
        return hostName;
    }

    public int getPort() {
        return port;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}