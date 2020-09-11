package main;

import test.TestClackClient;
import test.TestClackData;
import test.TestClackServer;

public class Main {

    public static void main(String[]arg){
        System.out.println("Hello world");
        TestClackData.main();
        TestClackClient.main();
        TestClackServer.main();
    }
}
