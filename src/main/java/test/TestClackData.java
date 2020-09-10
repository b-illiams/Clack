package test;

import data.ClackData;
import data.FileCData;
import data.MessageClackData;

public class TestClackData {
    public static void main (String[]args){
        ClackData messageClackData = new MessageClackData();
        ClackData fileClackData = new FileCData();

        messageClackData.getData();
        messageClackData.getDate();
        messageClackData.getType();
        messageClackData.getUserName();
        messageClackData.hashCode();
        messageClackData.toString();
        messageClackData.equals(fileClackData);

        fileClackData.getData();
        fileClackData.getDate();
        fileClackData.getType();
        fileClackData.getUserName();
        fileClackData.hashCode();
        fileClackData.toString();
        fileClackData.equals(messageClackData);
    }
}
