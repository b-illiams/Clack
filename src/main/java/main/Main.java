package main;

import test.TestClackClient;
import test.TestClackData;
import test.TestClackServer;

/** Represents the runner for the messaging system of Clack.
 * @author Brian Williams
 * @author Shamashad Abdulla
 * @version 1.0
 * @since 1.0
 */
public class Main {

    public static void main(String[]arg){
        System.out.println("Hello world");
        TestClackData.main();
        TestClackClient.main();
        TestClackServer.main();
    }
}
