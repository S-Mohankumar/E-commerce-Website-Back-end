import java.util.Scanner;

public class AdminUser {


//    private static Scanner Userinput ;
//    public AdminUser(Scanner userinput) {
//        Userinput = userinput;
//    }

    private static void AccountCreatee(Scanner AdminInput, Admin admin) {


        System.out.println("Enter your Good Name : ");
        String AdminName = AdminInput.nextLine();
        System.out.println("Enter your valid MailId : ");
        String AdminMailId = AdminInput.nextLine();
        System.out.println("Enter the Strong Password atleast 8 characters with the mix of Uppercase,Lowercase,specialCharacter");
        String AdminPassword = AdminInput.nextLine();

        if (true) {
            PassWordCheck(AdminPassword);
        }
        System.out.println("Enter Your Mobile Number : ");
        String AdminMobileNum = AdminInput.nextLine();

        admin.setAdminName(AdminName);
        admin.setAdminMailId(AdminMailId);
        admin.setAdminPassword(AdminPassword);
        admin.setAdminMobileNumber(AdminMobileNum);

        System.out.println("Account Created successfully for Admin");
//        return Currentt;
    }


    private static void PassWordCheck(String AccPassword) {
        PassWordException exp;
        try {
            int length = AccPassword.length();
            if (length >= 8 && checkUpperCase(AccPassword) == true && checkLowerCase(AccPassword) == true && checkChar(AccPassword)) {
                System.out.println("Your passWord is valid!!!");
            } else {
                if (length < 8) {
                    throw exp = new PassWordException("Enter the passWord above 8 char");
                } else if (checkUpperCase(AccPassword) != true) {
                    throw exp = new PassWordException("Enter the upperCase");
                } else if (checkLowerCase(AccPassword) != true) {
                    throw exp = new PassWordException("Enter the lowerCase");
                } else {
                    throw exp = new PassWordException("Enter the sepcial Charecter");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }


    public static boolean checkUpperCase(String passWord) {//Mohan@123
        for (int i = 0; i < passWord.length(); i++) {
            char ch = passWord.charAt(i);
            if (Character.isUpperCase(ch)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkLowerCase(String passWord) {
        for (int i = 0; i < passWord.length(); i++) {
            char ch = passWord.charAt(i);
            if (Character.isLowerCase(ch)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkChar(String passWord) {
        for (int i = 0; i < passWord.length(); i++) {
            char ch = passWord.charAt(i);
            if (ch == '@' || ch == '!' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*') {
                return true;
            }

        }
        return false;
    }

    public static String AdminLogin(Scanner Userinput ,AdminLogin adminDetails, Admin admin) {

//            AdminInput.nextLine();
            System.out.println("Enter your Valid MailID : ");
            String AdminLoginMail = Userinput.nextLine();


            System.out.println("Enter the Password : ");
            String AdminLoginPassword = Userinput.nextLine();


            adminDetails.setAdminLoginMailId(AdminLoginMail);
            adminDetails.setAdminLoginPassword(AdminLoginPassword);


            if (admin.verify(AdminLoginPassword)) {
                System.out.println("------------------------------YOU HAVE  LOGEDIN SUCCESSFULLY-------------------------------");
                System.out.println("------------------------------WELCOME TO THE E-COMMERCE-------------------------------");
                System.out.println("Welcom Mr " + admin.getAdminName());
        }
            return AdminLoginPassword;
    }

    public void AdminCreate(Scanner Userinput){
//        try (Scanner AdminInput = Userinput) {
            AdminLogin adminloginDetails = new AdminLogin();
            Admin admin = new Admin();
            System.out.println("Do you want create the Admin Account Press 1 : ");
            int option = Userinput.nextInt();
        Userinput.nextLine();
            if (option == 1) {
                AdminUser.AccountCreatee(Userinput, admin);
            }

            System.out.println("do want to login press 2 : ");
            option = Userinput.nextInt();
        Userinput.nextLine();
            String AdminLoginPassword = "";
//                    Getting the AdminLoginPassword to check to reach the else if block
            if (option == 2) {
                AdminLoginPassword =  AdminUser.AdminLogin(Userinput,adminloginDetails, admin);
            }
//                    System.out.println("1" + AdminLoginPassword);
            if(admin.verify(AdminLoginPassword) == false){
                System.out.println("------------------------------YOU HAVE  ENTERED WRONG PASSWORD------------------------------");
                System.out.println("DO YOU WANT CHANGE THE PASSWORD CLICK 1.FORGOT PASSWORD : ");
                int forgotPassword = Userinput.nextInt();
                Userinput.nextLine();
                if (forgotPassword == 1) {
                    System.out.println("Enter ur MailId : ");
                    String MailId_for_forgot = Userinput.nextLine();
                    System.out.println("We have sent the otp to your mailId enter the code below  : ");
                    String MAil_verificationCode = Userinput.nextLine();
                    boolean Boolean = true;
                    int limit_chance = 1;
                    while (Boolean == true && limit_chance <= 3) {
                        System.out.println("Enter the new Password : ");
                        String newPAssword = Userinput.nextLine();
                        System.out.println("Re-enter the new Password : ");
                        String ReEntered_password = Userinput.nextLine();
                        if (newPAssword.equals(ReEntered_password)) {
                            System.out.println("Password Changed Successfully!!!");
                            admin.setAdminPassword(newPAssword);
                            AdminUser.AdminLogin(Userinput,  adminloginDetails, admin);
                            Boolean = false;
                        } else if (limit_chance == 1) {
                            System.out.println("Password Mismatch!!!");
                            System.out.println("you have 2 more chance to change password");
                            limit_chance++;
                        } else if (limit_chance == 2) {
                            System.out.println("Password Mismatch!!!");
                            System.out.println("you have 1 more chance to change password");
                            limit_chance++;
                        } else {
                            System.out.println("Password Mismatch!!!");
                            System.out.println("Try again after some minutes!!!");
                        }
                    }
                }
            }

            System.out.println("To Add Product\nPress 1 ");
            option = Userinput.nextInt();
            if(option == 1){
                AdminProductAdd.AddProduct(Userinput);
            }
            System.out.println("DO WANT TO MODIFY THE PRODUCT\n1.YES\n2.NO");
            option = Userinput.nextInt();
            Userinput.nextInt();
            if(option == 1){
                AdminModify.ProductModify(Userinput);
            }
            else{
                System.out.println("YOU HAVE NOT MODIFIED ANYTHING!!!");
            }

        System.out.println("DO YOU WANT TO REMOVE PRODUCT\n1.YES\n2.NO");
        option = Userinput.nextInt();
        Userinput.nextLine();
        if(option == 1){
            AdminRemove.Remove(Userinput);
        }
        else{
            System.out.println("YOU HAVE NOT REMOVED ANYTHING!!!");
        }
    }


        }

