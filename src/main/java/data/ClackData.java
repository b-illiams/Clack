package data;

import java.util.Date;

public abstract class ClackData {
    private String userName;
    private int type;
    private Date date;

    public final int CONSTANT_LISTUSERS = 0;
    public final int CONSTANT_LOGOUT = 1;
    public final int CONSTANT_SENDMESSAGE = 2;
    public final int CONSTANT_SENDFILE = 3;

    public ClackData(String userName, int type){
        this.userName = userName;
        this.type = type;
        this.date = new Date();
    }

    public ClackData(int type){
        this.userName = "Anon";
        this.type = type;
        this.date = new Date();
    }

    public ClackData(){
        this.userName = "Anon";
        this.type = CONSTANT_LOGOUT;
        this.date = new Date();
    }

    public String getUserName() {
        return userName;
    }

    public int getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public abstract String getData();
}
