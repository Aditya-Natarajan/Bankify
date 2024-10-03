package bankify.beans;

public class Customer {
    private String sFirstName;
    private String sLastName;
    private String sAadharNumber;
    private String sPhoneNumber;
    private String sEmail;
    private String sAddressLine1;
    private String sAddressLine2;
    private String sCity;
    private String sState;
    private String sPincode;

    public Customer(){
        this.sFirstName = "";
        this.sLastName = "";
        this.sAadharNumber = "";
        this.sPhoneNumber = "";
        this.sEmail = "";
        this.sAddressLine1 = "";
        this.sAddressLine2 = "";
        this.sCity = "";
        this.sState = "";
        this.sPincode = "";
    }

    public String getEmail() {
        return sEmail;
    }

    public String getPincode() {
        return sPincode;
    }

    public String getState() {
        return sState;
    }

    public String getCity() {
        return sCity;
    }

    public String getAddressLine2() {
        return sAddressLine2;
    }

    public String getAddressLine1() {
        return sAddressLine1;
    }

    public String getPhoneNumber() {
        return sPhoneNumber;
    }

    public String getAadharNumber() {
        return sAadharNumber;
    }

    public String getLastName() {
        return sLastName;
    }

    public String getFirstName() {
        return sFirstName;
    }

    public void setFirstName(String sFirstName) {
        this.sFirstName = sFirstName;
    }

    public void setLastName(String sLastName) {
        this.sLastName = sLastName;
    }

    public void setAadharNumber(String sAadharNumber) {
        this.sAadharNumber = sAadharNumber;
    }

    public void setPhoneNumber(String sPhoneNumber) {
        this.sPhoneNumber = sPhoneNumber;
    }

    public void setAddressLine1(String sAddressLine1) {
        this.sAddressLine1 = sAddressLine1;
    }

    public void setAddressLine2(String sAddressLine2) {
        this.sAddressLine2 = sAddressLine2;
    }

    public void setCity(String sCity) {
        this.sCity = sCity;
    }

    public void setState(String sState) {
        this.sState = sState;
    }

    public void setPincode(String sPincode) {
        this.sPincode = sPincode;
    }

    public void setEmail(String sEmail) {
        this.sEmail = sEmail;
    }
}
