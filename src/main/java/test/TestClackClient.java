package test;

import main.ClackClient;

public class TestClackClient {
    public static void main (){
        ClackClient clackClient = new ClackClient("bb", "nomoney", 7080);
        ClackClient cc1 = clackClient;
        ClackClient cc2 = new ClackClient("bb", "nomoney");

        System.out.println(clackClient.getUserName());
        System.out.println(clackClient.getHostName());
        System.out.println(clackClient.getPort());
        System.out.println(clackClient.hashCode());
        System.out.println(clackClient.equals(cc1));
        System.out.println(clackClient.equals(cc2));
        System.out.println(clackClient.toString());



    }
}
