package data;

public class MessageClackData extends ClackData  {

    private String message;

    public MessageClackData(String userName, String message, int type){
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
        int prime = 31;
        int result = 1;
        result = prime * result + ((super.getUserName() == null) ? 0 : super.getUserName().hashCode());
        result = prime * result + (super.getType());
        result = prime * result + ((this.getData() == null) ? 0 : this.getData().hashCode());
        return result;
    }

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

    @Override
    public String toString() {
        return "USERNAME: " +  super.getUserName()  + "\nTYPE: " + super.getType() + "\nDATE: " + super.getDate() + "\nMESAGGE DATA:" + this.getData();
    }
}
