import java.util.Scanner;

public class AdminRemove {
//    Product[] details = Product.details;

    public static void Remove(Scanner Userinput) {
        System.out.println("ENTER THE PRODUCT ID : ");
        String ProductId = Userinput.nextLine();
        for (Product pId : Product.details) { // emp = resiter.details piD = new Product(); name, id, price
            if (pId.getProductId().equals(ProductId)) {
                pId = null;
                System.out.println("PRODUCT REMOVED!!!");
            }
        }
    }
}
