package data;

import java.io.*;
import java.util.Scanner;

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
        this.fileName = "";
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
     *
     * @return value of encrypted message
     */
    public String getData(String key) {
        return decrypt(fileContent, key);
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
     */
    public void readFileContents() throws IOException {
        try{
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            fileContent = "";
            while((line = br.readLine()) != null){
                fileContent += line + "\n";
            }
            br.close();
        }catch(FileNotFoundException e){
            throw new IOException();
        }catch(NullPointerException e){
            throw new IOException();
        }
    }

    /**
     * reads content of a specified file. Encrypts the file Content.
     */
    public void readFileContents(String key) throws IOException {
        try{
            File file = new File(fileName);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            fileContent = "";
            while((line = br.readLine()) != null){
                fileContent += line + "\n";
            }
            br.close();
        }catch(FileNotFoundException e){
            throw new IOException();
        }catch(NullPointerException e){
            throw new IOException();
        }
        fileContent = encrypt(fileContent, key);
    }

    /**
     * writes content to specified file.
     */
    public void writeFileContents(){
        try{
            File file = new File(fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file, false));
            br.flush();
            br.write(fileContent);
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     * writes decrypted content to specified file.
     */
    public void writeFileContents(String key){
        try{
            File file = new File(fileName);
            BufferedWriter br = new BufferedWriter(new FileWriter(file, false));
            br.flush();
            br.write(decrypt(fileContent, key));
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
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
