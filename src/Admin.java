public  class Admin {
    private String AdminName;
    private String AdminMailId;
    private String AdminPassword;
    private String AdminMobileNumber;
    public String getAdminName() {
        return AdminName;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }

    public void setAdminName(String adminName) {
        AdminName = adminName;
    }


    public String getAdminMailId() {
        return AdminMailId;
    }

    public void setAdminMailId(String adminMailId) {
        AdminMailId = adminMailId;
    }

    public String getAdminMobileNumber() {
        return AdminMobileNumber;
    }

    public void setAdminMobileNumber(String adminMobileNumber) {
        AdminMobileNumber = adminMobileNumber;
    }

    public  boolean verify(String AdminLoginPassword){
        if(AdminPassword.equals(AdminLoginPassword)){
            return true;
        }
        return false;
    }
}
