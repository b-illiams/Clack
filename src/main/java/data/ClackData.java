package data;

import java.util.Date;

/** Represents data point for the messaging system of Clack
 * @author Brian Williams
 * @author Shamashad Abdulla
 * @version 1.0
 * @since 1.0
 */
public abstract class ClackData {
    /**
     *String representing the Client user.
     */
    private String userName;
    /**
     *Integer representing the state of the user.
     */
    private int type;
    /**
     *Integer representing the time the object was created.
     */
    private Date date;
    /**
     *Integer representing the list state.
     */
    public final int CONSTANT_LISTUSERS = 0;
    /**
     *Integer representing the logout state.
     */
    public final int CONSTANT_LOGOUT = 1;
    /**
     *Integer representing the send message state.
     */
    public final int CONSTANT_SENDMESSAGE = 2;
    /**
     *Integer representing the send file state.
     */
    public final int CONSTANT_SENDFILE = 3;

    /**
     *Constructor that takes in userName and type. Sets date to the time the object was created.
     */
    public ClackData(String userName, int type){
        this.userName = userName;
        this.type = type;
        this.date = new Date();
    }

    /**
     *Constructor that takes in the type. Sets userName to a default value. Sets date to the time the object was created.
     */
    public ClackData(int type){
        this.userName = "Anon";
        this.type = type;
        this.date = new Date();
    }

    /**
     *Default Constructor. sets userName and type to a default value. Sets date to the time the object was created.
     */
    public ClackData(){
        this.userName = "Anon";
        this.type = CONSTANT_LOGOUT;
        this.date = new Date();
    }

    /**
     * @return value of userName.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @return value of type.
     */
    public int getType() {
        return type;
    }

    /**
     *@return value of date.
     */
    public Date getDate() {
        return date;
    }

    /**
     * @return value specified by subclasses.
     */
    public abstract String getData();
}
