import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Store extends AdminUser{
    private static Customer AccountCreate(Scanner Userinput) {

        Customer Currentt = new Customer();
        System.out.println("Enter your valid MailId : ");
        String AccMailId = Userinput.nextLine();
        System.out.println("Enter the Strong Password atleast 8 characters with the mix of Uppercase,Lowercase,specialCharacter");
        String AccPassword = Userinput.nextLine();

        if(true){
            PassWordCheck(AccPassword);
        }


        Currentt.setAccountMail(AccMailId);
        Currentt.setAccountPassword(AccPassword);
        return Currentt;
    }

    private static  void PassWordCheck(String AccPassword){
        PassWordException exp ;
        try{
            int length = AccPassword.length();
            if(length >= 8 && checkUpperCase(AccPassword)== true && checkLowerCase(AccPassword) == true && checkChar(AccPassword) ){
                System.out.println("Your passWord is valid!!!");
            }

            else{
                if(length < 8) {
                    throw exp = new PassWordException("Enter the passWord above 8 char");
                }
                else if(checkUpperCase(AccPassword) != true){
                    throw exp = new PassWordException("Enter the upperCase");
                }
                else if(checkLowerCase(AccPassword) != true){
                    throw exp = new PassWordException("Enter the lowerCase");
                }
                else{
                    throw exp = new PassWordException("Enter the sepcial Charecter");
                }
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());

        }

    }


    public static boolean checkUpperCase(String passWord){//Mohan@123
        for(int i = 0; i < passWord.length(); i++){
            char ch = passWord.charAt(i);
            if(Character.isUpperCase(ch)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkLowerCase(String passWord ){
        for(int i = 0; i < passWord.length(); i++){
            char ch = passWord.charAt(i);
            if(Character.isLowerCase(ch)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkChar(String passWord ){
        for(int i = 0; i < passWord.length(); i++){
            char ch = passWord.charAt(i);
            if(ch == '@' || ch == '!' || ch == '#' || ch == '$' || ch == '%' || ch == '^' || ch == '&' || ch == '*'){
                return true;
            }

        }
        return false;
    }

    public static ArrayList<Product> CartDetails(Product[]productList,Scanner Userinput){

//       Scanner Userinput = new Scanner(System.in);
       int option;
       System.out.println("How many items do u want to add from the above catalog!!!");
       option = Userinput.nextInt();
       ArrayList<Product>CartList = new ArrayList<>();
       for(int i = 0; i < option; i++){
           CartList.add(productList[i]);
       }
       return CartList;
    }

    public static boolean MobileNumVerify(Customer Main_Current, String MobileNum){
        if(Main_Current.getUserMobileNumber().equals(MobileNum)){
            return true;
        }
        return false;
    }

    public static  String UserLogin(Scanner Userinput, Customer Main_Current){
        System.out.println("Enter your Good Name : ");
        Userinput.nextLine();
        String UserName = Userinput.nextLine();

        System.out.println("Enter your Valid MailID : ");
        String UserLoginMail = Userinput.nextLine();

        System.out.println("Enter the Password : ");
        String UserPassword = Userinput.nextLine();

        System.out.println("Enter your MobileNumber : ");
        String UserMobileNumber = Userinput.nextLine();

        Main_Current.SetcustomerName(UserName);
        Main_Current.SetuserMail(UserLoginMail);
        Main_Current.SetUserPassword(UserPassword);
        Main_Current.setUserMobileNumber(UserMobileNumber);

        if (Main_Current.verify(UserPassword)) {
            System.out.println("------------------------------YOU HAVE  LOGEDIN SUCCESSFULLY-------------------------------");
            System.out.println("------------------------------WELCOME TO THE E-COMMERCE-------------------------------");
        }
        return UserPassword;
    }

    public static void main(String[] args) {


        try (Scanner Userinput = new Scanner(System.in)) {
//            AdminUser Admin = new AdminUser();
            Store mainObj = new Store();
            Customer Main_Current = new Customer();
            mainObj.AdminCreate(Userinput);
            System.out.println("Do you want to create Account or want to login press 1. create Account : ");
            int option = Userinput.nextInt();
            Userinput.nextLine();
            if (option == 1) {
                Main_Current =  Store.AccountCreate(Userinput);
            }
            System.out.println("Do you want to login press 2.login : ");
            int optionLogin = Userinput.nextInt();
            String UserPassword = "";
            if (optionLogin == 2) {
                UserPassword = Store.UserLogin(Userinput, Main_Current);
            }
            if(Main_Current.verify(UserPassword) == false){
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
                                Main_Current.setAccountPassword(newPAssword);
                                Store.UserLogin(Userinput, Main_Current);
                                Boolean = false;
                            } else if(limit_chance == 1){
                                System.out.println("Password Mismatch!!!");
                                System.out.println("you have 2 more chance to change password");
                                limit_chance++;
                            } else if(limit_chance == 2){
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


            Catalog catalog = new Catalog();
            System.out.println("Here is the Product catalog");
            Product[] productList = catalog.GetProductList();
            System.out.println(Arrays.toString(productList));

            System.out.println("Add Items to checkOut");
            System.out.println(Store.CartDetails(productList, Userinput));
            System.out.println("Product are loaded in Your Cart you check out when ever you want!!!");

            //--------------------------------------------------------------------------------------------//

            System.out.println("do you want to checkOut the product in the cart Press 1 below!!!");
            option = Userinput.nextInt();
            Userinput.nextLine();
            if(option == 1){
                System.out.println("Enter Your Delivery Address");
                String UserAddress = Userinput.nextLine();
                Main_Current.setUserAddress(UserAddress);
                System.out.println("Select the Payment method!!!");
                System.out.println("Here the option for Pay with UPI : " + "1.PhonePay \n  2.Gpay \n  3.Paytm \n  4.BHMI \n 5.Cash on Delivery");
                option = Userinput.nextInt();
                Userinput.nextLine();
                System.out.println("Enter your mobile number linked with PhonePay & Gpay & Paytm & BHMI Or Give number for COD ");
                String MobileNum = Userinput.nextLine();
                if(option == 1) {
                    if (MobileNumVerify(Main_Current, MobileNum) ) {
                        System.out.println("Redircting to the PhonePay");
                    }
                }
                else if(option == 2){
                    if (MobileNumVerify(Main_Current, MobileNum) ) {
                        System.out.println("Redircting to the Gpay");
                    }
                }
                else if(option == 3){
                    if (MobileNumVerify(Main_Current, MobileNum) ) {
                        System.out.println("Redircting to the Paytm");
                    }
                }
                else if(option == 4){
                    if (MobileNumVerify(Main_Current, MobileNum) ) {
                        System.out.println("Redircting to the BHMI");
                    }
                }
                else if(option == 5){
                    System.out.println("Cash on Delivery" + "Pay when you Receive Product");
                }
//
//                Thread obj = new Thread(){
//                    @Override
//                    public void run() {
//
//                    }
//                };
//                try {
//                    Thread.sleep(5000);
//                }
//                catch(Exception exp){
//                    System.out.println(exp.getMessage());
//                }
//                obj.start();
//                try{
//                    obj.join();
//                }
//                catch(Exception exp){
//                    System.out.println(exp.getMessage());
//                }
                System.out.println("Your Order has been successfully placed");
                System.out.println("You can track Your Order");
                System.out.println("------------------------------"+ "THANKS FOR CHOOSING OUR E-COMMERCE"+ "------------------------------");
                }


            }
        }
    }


