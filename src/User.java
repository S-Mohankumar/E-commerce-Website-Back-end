public abstract class User {
    private String AccountMail;
    private String AccountPassword;

    private String customerName;
    private String userMail;
    private String userPassword;
    private String userMobileNumber;
    private String UserAddress;

    public String getUserMobileNumber() {
        return userMobileNumber;
    }

    public String getUserAddress() {
        return UserAddress;
    }

    public void setUserAddress(String userAddress) {
        UserAddress = userAddress;
    }

    public void setUserMobileNumber(String userMobileNumber) {
        this.userMobileNumber = userMobileNumber;
    }

    public String GetAccountMail() {
        return AccountMail;
    }

    public void setAccountMail(String accountMail) {
        AccountMail = accountMail;
    }

    public String GetAccountPassword() {
        return AccountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        AccountPassword = accountPassword;
    }

    public void SetcustomerName(String customerName){
        this.customerName = customerName;
    }

    public String GetcustomerName(){
        return customerName;
    }

    public void SetuserMail(String userMail){
        this.userMail = userMail;
    }

    public String GetuuserMail(){
        return userMail;
    }

    public String GetUserPassword() {
        return userPassword;
    }

    public void SetUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    abstract boolean verify(String UserPassword);


}
