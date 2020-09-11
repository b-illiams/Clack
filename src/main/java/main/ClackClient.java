package main;

import data.ClackData;

public class ClackClient {
    private String userName;
    private String hostName;
    private int port;
    private boolean closeConnection;
    private ClackData dataToSendToServer;
    private ClackData dataToReceiveFromServer;

    public ClackClient(String userName, String hostName, int port){
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;

    }

    public ClackClient(String userName, String hostName){
        this.userName = userName;
        this.hostName = hostName;
        this.port = 7000;
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
    }

    public ClackClient(String userName){
        this.userName = userName;
        this.hostName = "";
        this.port = 7000;
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;

    }

    public ClackClient(){
        this.userName = "";
        this.hostName = "";
        this.port = 7000;
        this.closeConnection = false;this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;

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
        int prime = 31;
        int result = 1;
        result = prime * result + (userName.hashCode());
        result = prime * result + (hostName.hashCode());
        result = prime * result + (dataToSendToServer.hashCode());
        result = prime * result + (dataToReceiveFromServer.hashCode());
        result = prime * result + (port);
        result = prime * result + (closeConnection ? 1 : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }else if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }else{
            ClackClient o = (ClackClient) obj;

            return this.dataToSendToServer.equals(o.dataToSendToServer) &&
                    this.dataToReceiveFromServer.equals(o.dataToReceiveFromServer) &&
                    this.port == o.port &&
                    this.closeConnection == o.closeConnection;
        }
    }

    @Override
    public String toString() {
        return "\nUSERNAME: " + userName + "\nHOST NAME: " + hostName + "\nDATA TO CLIENT: -> \n" + dataToSendToServer + "\nDATA FROM SERVER: -> \n" + dataToReceiveFromServer + "\nPORT: " + port + "\nCLOSE CONNECTION: " + closeConnection;
    }
}