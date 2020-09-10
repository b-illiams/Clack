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
