package test;

import data.ClackData;
import data.FileCData;
import data.MessageClackData;

public class TestClackData {
    /** Represents testing class for ClackData.
     * @author Brian Williams
     * @author Shamashad Abdulla
     * @version 1.0
     * @since 1.0
     */
    public static void main(){
        ClackData messageClackData = new MessageClackData("bbno$", "hello", 0);
        ClackData m1 = messageClackData;
        ClackData m2 = new MessageClackData("bbno$", "ello", 0);
        ClackData fileClackData = new FileCData("bbno$", "bb.txt", 0);
        ClackData f1 = fileClackData;
        ClackData f2 = new FileCData("bbno$", "b.txt", 0);

        System.out.println(messageClackData.getData());
        System.out.println(messageClackData.getDate());
        System.out.println(messageClackData.getType());
        System.out.println(messageClackData.getUserName());
        System.out.println(messageClackData.hashCode());
        System.out.println(messageClackData.toString());
        System.out.println(messageClackData.equals(fileClackData));
        System.out.println(messageClackData.equals(m1));
        System.out.println(messageClackData.equals(m2));

        System.out.println(fileClackData.getData());
        System.out.println(fileClackData.getDate());
        System.out.println(fileClackData.getType());
        System.out.println(fileClackData.getUserName());
        System.out.println(fileClackData.hashCode());
        System.out.println(fileClackData.toString());
        System.out.println(fileClackData.equals(messageClackData));
        System.out.println(fileClackData.equals(f1));
        System.out.println(fileClackData.equals(f2));
    }
}
