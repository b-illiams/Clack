public class MessageClackData extends ClackData  {

    private String message;

    public MessageClackData(String userName, String messaage, int type){
        super(userName, type);
        this.message = message;
    }

    public MessageClackData(){
        super();
        this.message = "";
    }
    @Override
    public String getData() {
        return message;
    }

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
