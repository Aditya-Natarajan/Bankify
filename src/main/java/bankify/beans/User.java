package bankify.beans;

public class User {
     private String sPassWord;
     private String sPhoneNumber;
     private int iAccessLevel;

    public User() {
        this.sPassWord = "";
        this.iAccessLevel = 0;
        this.sPhoneNumber = "";
    }

    public User(String sPassWord, int iClearance, String sPhoneNumber){
        this.sPassWord = sPassWord;
        this.iAccessLevel = iClearance;
        this.sPhoneNumber = sPhoneNumber;
    }

    public int getAccessLevel() {
        return iAccessLevel;
    }

    public String getPhoneNumber() {
        return sPhoneNumber;
    }

    public String getPassword() {
        return sPassWord;
    }

    public void setPassWord(String sPassWord) {
        this.sPassWord = sPassWord;
    }

    public void setPhoneNumber(String sPhoneNumber) {
        this.sPhoneNumber = sPhoneNumber;
    }

    public void setAccessLevel(int iAccessLevel) {
        this.iAccessLevel = iAccessLevel;
    }
}
