package data;

import java.io.Serializable;
import java.util.Date;

/** Represents data point for the messaging system of Clack
 * @author Brian Williams
 * @author Shamashad Abdulla
 * @version 1.0
 * @since 1.0
 */
public abstract class ClackData implements Serializable {
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

    /**
     * @return value specified by subclasses.
     * @param k decryption key
     */
    public abstract String getData(String k);

    /**
     * encrypts inputStringToEncrypt utilizing key
     * @param inputStringToEncrypt
     * @param key
     * @return
     */
    protected String encrypt(String inputStringToEncrypt, String key){
        key = key.toLowerCase();
        String stringKey = "";
        String result = "";
        int keyIndex = 0;

        for(int i = 0; i < inputStringToEncrypt.length(); i++) {
            if(keyIndex == key.length()){
                keyIndex = 0;
            }

            if(Character.isAlphabetic(inputStringToEncrypt.charAt(i))) {
                stringKey += key.charAt(keyIndex);
                keyIndex++;
            }else{
                stringKey += inputStringToEncrypt.charAt(i);
            }

            int shift = 0;
            String shiftUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            String shiftLower = "abcdefghijklmnopqrstuvwxyz";

            if(Character.isUpperCase(inputStringToEncrypt.charAt(i)) && Character.isAlphabetic(inputStringToEncrypt.charAt(i))){
                int let1 = shiftUpper.indexOf(inputStringToEncrypt.charAt(i));
                int let2 = shiftUpper.toUpperCase().indexOf(stringKey.toUpperCase().charAt(i));
                shift = let1 + let2;
                if(shift > 25)
                    shift -= 26;
                result += shiftUpper.charAt(shift);

            }else if(Character.isLowerCase(inputStringToEncrypt.charAt(i)) && Character.isAlphabetic(inputStringToEncrypt.charAt(i))){
                int let1 = shiftLower.indexOf(inputStringToEncrypt.charAt(i));
                int let2 = shiftLower.toLowerCase().indexOf(stringKey.toLowerCase().charAt(i));
                shift = let1 + let2;
                if(shift > 25)
                    shift -= 26;
                result += shiftLower.charAt(shift);
            }else {
                result += inputStringToEncrypt.charAt(i);
            }
        }
        return result;
    }

    /**
     * decrypts inputStringToEncrypt utilizing key
     * @param inputStringToDecrypt
     * @param key
     * @return
     */
    protected String decrypt(String inputStringToDecrypt, String key){
        key = key.toLowerCase();
        String stringKey = "";
        String result = "";
        int keyIndex = 0;

        for(int i = 0; i < inputStringToDecrypt.length(); i++) {
            if(keyIndex == key.length()){
                keyIndex = 0;
            }

            if(Character.isAlphabetic(inputStringToDecrypt.charAt(i))) {
                stringKey += key.charAt(keyIndex);
                keyIndex++;
            }else{
                stringKey += inputStringToDecrypt.charAt(i);
            }

            int shift = 0;
            String shiftUpper = "ZYXWVUTSRQPONMLKJIHGFEDCBA";
            String shiftLower = "zyxwvutsrqponmlkjihgfedcba";

            if(Character.isUpperCase(inputStringToDecrypt.charAt(i)) && Character.isAlphabetic(inputStringToDecrypt.charAt(i))){
                int let1 = shiftUpper.indexOf(inputStringToDecrypt.charAt(i));
                int let2 = shiftUpper.toUpperCase().indexOf(stringKey.toUpperCase().charAt(i));
                shift = let1 - let2 - 1;
                if(shift < 0)
                    shift += 26;
                result += shiftUpper.charAt(shift);

            }else if(Character.isLowerCase(inputStringToDecrypt.charAt(i)) && Character.isAlphabetic(inputStringToDecrypt.charAt(i))){
                int let1 = shiftLower.indexOf(inputStringToDecrypt.charAt(i));
                int let2 = shiftLower.toLowerCase().indexOf(stringKey.toLowerCase().charAt(i));
                shift = let1 - let2 - 1;
                if(shift < 0)
                    shift += 26;
                result += shiftLower.charAt(shift);
            }else{
                result += inputStringToDecrypt.charAt(i);
            }
        }
        return result;
    }
}


