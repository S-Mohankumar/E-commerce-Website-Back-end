//package packages.staticExample;

//class PassWordException extends RuntimeException{
//    public PassWordException(String details) {
//        super(details);
//    }
//
//    public PassWordException() {
//    }
//}

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class  WorkOut {
    static Product[]arr = new Product [3];
    static Scanner input = new Scanner(System.in);
    public static void sum(){
        for(int i = 0; i < arr.length; i++){
            System.out.println("enter");
            String id = input.nextLine();
            String name = input.nextLine();
            String price = input.nextLine();

            arr[i] = new Product(id,name,price);
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
WorkOut.sum();
    }
}