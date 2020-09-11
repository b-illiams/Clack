package data;

public class FileCData extends ClackData {

    private String fileName;
    private String fileContent;
    public FileCData(String userName, String fileName, int type){
        super(userName, type);
        this.fileName = fileName;
        this.fileContent = "";
    }

    public FileCData(){
        super();
        fileName = "";
        this.fileContent = "";
    }

    @Override
    public String getData() {
        return fileContent;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName(){
        return this.fileName;
    }

    public void readFileContents(){

    }

    public void writeFileContents(){

    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((super.getUserName() == null) ? 0 : super.getUserName().hashCode());
        result = prime * result + (super.getType());
        result = prime * result + ((this.getData() == null) ? 0 : this.getData().hashCode());
        result = prime * result + ((this.getFileName() == null) ? 0 : this.getFileName().hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }else if (obj == null || obj.getClass() != this.getClass()){
            return false;
        }else{
            FileCData o = (FileCData) obj;

            return super.getType() == o.getType() &&
                    super.getUserName().equals(o.getUserName()) &&
                    this.getData() == o.getData() &&
                    this.getFileName().equals(o.getFileName());
        }
    }

    @Override
    public String toString() {
        return "USERNAME: " +  super.getUserName()  + "\nTYPE: " + super.getType() + "\nDATE: " + super.getDate() + "\nFILE NAME: " + this.getFileName() + "\nFILE DATA:" + this.getData();
    }
}
