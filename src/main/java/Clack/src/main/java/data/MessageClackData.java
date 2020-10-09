package data;

import java.io.FileReader;
import java.io.IOException;

/** Represents data point for textual messages for the messaging system of Clack
 * @author Brian Williams
 * @author Shamashad Abdullah
 * @version 1.0
 * @since 1.0
 */
public class MessageClackData extends ClackData  {
    /**
     *String representing a message.
     */
    private String message;

    /**
     * Constructor that takes in userName, message, and type. Automatically encrypts message.
     * @param userName String representing the Client user.
     * @param message a String representing a message.
     * @param type Integer representing the time the object was created.
     * @param key String representing the encryption key
     */
    public MessageClackData(String userName, String message, int type, String key){
        super(userName, type);
        this.message = encrypt(message, key);
    }
    /**
     * Constructor that takes in userName, message, and type.
     * @param userName String representing the Client user.
     * @param message a String representing a message.
     * @param type Integer representing the time the object was created.
     */
    public MessageClackData(String userName, String message, int type){
        super(userName, type);
        this.message = message;
    }

    /**
     * Default constructor that sets userName, message, and type to default values.
     */
    public MessageClackData(){
        super();
        this.message = "";
    }

    /**
     *
     * @return value of message
     */
    @Override
    public String getData() {
        return message;
    }

    /**
     *
     * @return value of encrypted message
     */
    public String getData(String key) {
        return decrypt(message, key);
    }

    /**
     *
     * @return hash value of class.
     */
    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((super.getUserName() == null) ? 0 : super.getUserName().hashCode()); /**
        result = prime * result + (super.getType());
        result = prime * result + ((this.getData() == null) ? 0 : this.getData().hashCode());
        return result;
    }

    /**
     *
     * @param obj MessageClackData object
     * @return comparison of the values of two MessageClackDataObject objects.
     */
    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }else if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }else{
            MessageClackData o = (MessageClackData) obj;

            return super.getType() == o.getType() &&
                    super.getUserName().equals(o.getUserName()) &&
                    this.getData() == o.getData();
        }
    }

    /**
     *
     * @return String representation of class.
     */
    @Override
    public String toString() {
        return "USERNAME: " +  super.getUserName()  + "\nTYPE: " + super.getType() + "\nDATE: " + super.getDate() + "\nMESAGGE DATA:" + this.getData();
    }
}
