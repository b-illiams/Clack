package test;

import main.ClackServer;

public class TestClackServer {
    public static void main (){
        ClackServer clackServer = new ClackServer(7080);
        ClackServer cs1 = clackServer;
        ClackServer cs2 = new ClackServer(7080);

        System.out.println(clackServer.getPort());
        System.out.println(clackServer.hashCode());
        System.out.println(clackServer.equals(cs1));
        System.out.println(clackServer.equals(cs2));
        System.out.println(clackServer.toString());
    }
}
