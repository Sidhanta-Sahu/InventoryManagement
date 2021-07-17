package in.sidhantasahu.inventory.App;

import in.sidhantasahu.inventory.controller.ProductController;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ProductController pc = new ProductController();
        System.out.println("Menu");
        int option;

        while(true) {
            System.out.println("\nenter 1 to see available products\nenter 2 for adding to cart\n" +
                                       "enter 3 for cart summary\n" +
                                       "enter 4 to convert order\n");
            option=Integer.parseInt(scan.nextLine());
            switch (option) {
            case 1:
                pc.displayAllProducts();
                break;

            case 2:
                //add product to cart
                int productId;
                int quantity;
                String choiceToContinue;

                do {
                    System.out.println("Enter product ID");
                    productId = Integer.parseInt(scan.nextLine());
                    if (pc.checkProductId(productId)) {
                        System.out.println("Enter quantity");
                        quantity = Integer.parseInt(scan.nextLine());
                        pc.addProductToCart(productId, quantity);
                    }

                    System.out.println("Do you want to continue? Press y for yes and n for no");
                    choiceToContinue = scan.nextLine();
                    while (!choiceToContinue.equals("y") && !choiceToContinue.equals("n")) {
                        System.out.println("Enter proper choice. Press y for yes and n for no");
                        choiceToContinue = scan.nextLine();
                    }
                } while (choiceToContinue.equals("y"));

                break;
            case 3:
                //cart Summary
                pc.displayCartSummary();
                break;

            case 4:
                //Convert Order
                String customerName;
                System.out.println("Enter your name");
                customerName=scan.nextLine();
                pc.convertOrder(customerName);
                break;
            default:
                System.out.println("Enter correct option");
            }
        }
    }
}
