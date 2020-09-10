public class ClackServer {
    private int port;
    private boolean closeConnection;
    private data.ClackData dataToSendToClient;
    private data.ClackData dataToReceiveFromClient;

    ClackServer(int port){
        this.port =  port;
    }

    ClackServer(){
        this.port = 7000;
    }

    public void start(){}
    public void sendData(){ }
    public void recieveData(){ }

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


