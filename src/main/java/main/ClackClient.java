package main;

import data.ClackData;

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
     * Constructor that takes in userName, hostName, and port. Sets closeConnection, dataToReceiveFromServer, and dataToSendToServer to default values.
     * @param userName String representing the username.
     * @param hostName String representing the host name.
     * @param port Integer representing the port.
     */
    public ClackClient(String userName, String hostName, int port){
        this.userName = userName;
        this.hostName = hostName;
        this.port = port;
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;

    }

    /**
     * Constructor that takes in userName and hostName. Sets port, closeConnection, dataToReceiveFromServer, and dataToSendToServer to default values.
     * @param userName String representing the username.
     * @param hostName String representing the host name.
     */
    public ClackClient(String userName, String hostName){
        this.userName = userName;
        this.hostName = hostName;
        this.port = 7000;
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;
    }

    /**
     * Constructor that takes in userName. Sets hostName, port, closeConnection, dataToReceiveFromServer, and dataToSendToServer to default values.
     * @param userName String representing the username.
     */
    public ClackClient(String userName){
        this.userName = userName;
        this.hostName = "";
        this.port = 7000;
        this.closeConnection = false;
        this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;

    }

    /**
     * Constructor that takes in userName, hostName, and port. Sets closeConnection, dataToReceiveFromServer, and dataToSendToServer to default values.
     */
    public ClackClient(){
        this.userName = "";
        this.hostName = "";
        this.port = 7000;
        this.closeConnection = false;this.dataToReceiveFromServer = null;
        this.dataToSendToServer = null;

    }

    /**
     * TODO: implementation
     */
    public void start(){}

    /**
     * sends data to the server
     * TODO: implementation
     */
    public void sendData(){}

    /**
     * receives data from the server
     * TODO: implementation
     */
    public void receiveData(){}

    /**
     * prints data
     * TODO: implementation
     */
    public void printData(){}

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
}