import java.util.Arrays;
import java.util.Scanner;

public class AdminProductAdd {
    public static  void AddProduct(Scanner Userinput){
        System.out.println("------------------------------ENTER THE AMOUNT OF PRODUCT SHOULD Add------------------------------");
        int productCount = Userinput.nextInt();
        Userinput.nextLine();
        Product.details = new Product[productCount];
        for(int i = 0; i < Product.details.length; i++){          //-----------------------------
                System.out.println("ENETR THE PRODUCT ID : ");
                String id = Userinput.nextLine();
                System.out.println("ENTER THE PRODUCT NAME : ");
                String name = Userinput.nextLine();
                System.out.println("ENTER THE PRODUCT PRICE : ");
                String price = Userinput.nextLine();

            Product.details [i] = new Product(id,name,price);
            System.out.println("----------------------------- PRODUCT ADDED SUCCESSFULLY-----------------------------");
            }
        System.out.println(Arrays.toString(Product.details));
        }


//
//            Product product1 = new Product();
//            product1.setProductId("1");
//            product1.setProductName("Mobile");
//            product1.setProductPrice("28000");
//
//            Product product2 = new Product();
//            product2.setProductId("2");
//            product2.setProductName("MAC");
//            product2.setProductPrice("80000");
//
//
//            Product product3 = new Product();
//            product3.setProductId("3");
//            product3.setProductName("Windows");
//            product3.setProductPrice("50000");
//
//            Product product4 = new Product();
//            product4.setProductId("4");
//            product4.setProductName("Mobile");
//            product4.setProductPrice("28000");
//
//
//            Product product5 = new Product();
//            product5.setProductId("5");
//            product5.setProductName("CCTV_CAMERA");
//            product5.setProductPrice("10000");
//
//
//            Product product6= new Product();
//            product6.setProductId("6");
//            product6.setProductName("Watch");
//            product6.setProductPrice("190000");
//
//        Product.details[7] = new Product();
//
//        Product.details[0] = product1;
//        Product.details[1] = product2;
//        Product.details[2] = product3;
//        Product.details[3] = product4;
//        Product.details[4] = product5;
//        Product.details[5] = product6;

        }

//    public static void main(String[] args) {
//        AdminProductAdd.AddProduct();
//    }


