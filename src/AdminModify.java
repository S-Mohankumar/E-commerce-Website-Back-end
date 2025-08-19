import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.Scanner;

public class AdminModify {
    public static void ProductModify(Scanner Userinput){

//        Product.details = new Product[2];
//
//        Product product1 = new Product();
//        product1.setProductId("1");
//        product1.setProductName("moha");
//        product1.setProductPrice("10");
//
//        Product product2 = new Product();
//        product2.setProductId("2");
//        product2.setProductName("yugi");
//        product2.setProductPrice("20");
//
//        Product.details[0] = product1;
//        Product.details[1] = product2;

        System.out.println("ENTER THE PRODUCT ID : ");
        String ProductId = Userinput.nextLine();
        for(Product pId : Product.details){ // emp = resiter.details piD = new Product(); name, id, price
            if(pId.getProductId().equals(ProductId)){
                System.out.println("WHICH ONE TO CHANGE\n1.PRODUCT NAME\n2.PRICE");
                int option = Userinput.nextInt();
                if(option == 1) {
                    System.out.println("ENTER THE PRODUCT NAME : ");
                    String ProductChangeName = Userinput.nextLine();
                    pId.setProductName(ProductChangeName);//here pId and product1 both are pointing the same memory
                }
                else{
                    System.out.println("ENTER THE PRODUCT PRICE : ");
                    String ProductChangePrice = Userinput.nextLine();
                    pId.setProductName(ProductChangePrice);
                }
                System.out.println(Arrays.toString(Product.details));

            }
        }
        System.out.println(Arrays.toString(Product.details));
//        for(int i = 0 ; i <  Product.details.length; i++){
//            if( (Product.details[i].getProductId()).equals(ProductId)){
//                Product.details[i].setProductName("Mohan");
//            }
//            else{
//                System.out.println("PRODUCT NOT FOUND\nENTER CORRECT ID OR UPDATE THE PRODUCT");
//            }
//        }
//
    }


}

