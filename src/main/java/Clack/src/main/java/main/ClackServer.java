package main;

public class ClackServer {
    private int port;
    private boolean closeConnection;
    private data.ClackData dataToSendToClient;
    private data.ClackData dataToReceiveFromClient;

    public ClackServer(int port){
        this.port =  port;
    }

    public ClackServer(){
        this.port = 7000;
    }

    public void start(){}
    public void sendData(){ }
    public void receiveData(){ }
    public int getPort() {
        return port;
    }
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        /*result = prime * result + (dataToSendToClient.hashCode());
        result = prime * result + (dataToReceiveFromClient.hashCode());*/
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
            ClackServer o = (ClackServer) obj;
            return this.dataToSendToClient.equals(o.dataToSendToClient) &&
                    this.dataToReceiveFromClient.equals(o.dataToReceiveFromClient) &&
                    this.port == o.port &&
                    this.closeConnection == o.closeConnection;
        }
    }

    @Override
    public String toString() {
        return "\nDATA TO CLIENT: -> \n" + dataToSendToClient + "\nDATA FROM CLIENT: -> \n" + dataToSendToClient + "\nPORT: " + port + "\nCLOSE CONNECTION: " + closeConnection;
    }


}


