package data;

/** Represents data point specifically for the files of the messaging system of Clack
 * @author Brian Williams
 * @author Shamashad Abdulla
 * @version 1.0
 * @since 1.0
 */
public class FileCData extends ClackData {
    /**
     * String representing the file name.
     */
    private String fileName;
    /**
     * String representing the file content.
     */
    private String fileContent;

    /**
     * Constructor that takes in the userName, fileName, and type. filecontent set to a default value.
     * @param userName String representing the Client user.
     * @param fileName String representing the file name.
     * @param type Integer representing the time the object was created.
     */
    public FileCData(String userName, String fileName, int type){
        super(userName, type);
        this.fileName = fileName;
        this.fileContent = "";
    }

    /**
     * Default constructor that sets uesrName, fileName, type, and fileContent to a default value.
     */
    public FileCData(){
        super();
        fileName = "";
        this.fileContent = "";
    }

    /**
     * @return value of fileContent
     */
    @Override
    public String getData() {
        return fileContent;
    }

    /**
     * Sets new value to fileName
     * @param fileName String representing the file content.
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     *
     * @return value of fileContent
     */
    public String getFileName(){
        return this.fileName;
    }

    /**
     * reads content of a specified file.
     * TODO: implementation
     */
    public void readFileContents(){

    }

    /**
     * writes content to specified file.
     * TODO: implementation
     */
    public void writeFileContents(){

    }

    /**
     *
     * @return hash value of class
     */
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

    /**
     *
     * @param obj a FileCData object
     * @return comparison of the values of two FileCData objects.
     */
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

    /**
     *
     * @return String representation of class.
     */
    @Override
    public String toString() {
        return "USERNAME: " +  super.getUserName()  + "\nTYPE: " + super.getType() + "\nDATE: " + super.getDate() + "\nFILE NAME: " + this.getFileName() + "\nFILE DATA:" + this.getData();
    }
}
