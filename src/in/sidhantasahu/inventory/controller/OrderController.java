package in.sidhantasahu.inventory.controller;

import in.sidhantasahu.inventory.model.*;
import in.sidhantasahu.inventory.repository.ProductRepository;

import java.util.Iterator;
import java.util.Set;

public class OrderController {
    private final Order customerOrder = new Order();

    public OrderController() {

    }

    /* confirm order and display order details. Update repository with reduced quantity of products ordered*/
    public void displayOrder(String customerName, ProductRepository repo, Cart customerCart) {

        customerOrder.setOrderId(customerOrder.getOrderId() + 1);
        customerOrder.setCustomer_name(customerName);
        customerOrder.setProducts(customerCart.getProducts());
        System.out.println(customerOrder);
        this.displayTotalPrice(customerOrder);
        this.modifyRepo(repo, customerOrder);
        customerCart.setProducts(null);
    }

    /*display total price of products in customer order*/
    public void displayTotalPrice(Order customerOrder) {
        double totalPrice = 0;

        for (Product individualProduct : customerOrder.getProducts()) {
            totalPrice = totalPrice + individualProduct.getPrice() * individualProduct.getQuantity();
        }
        System.out.println("Total price = " + totalPrice);
    }

    /*modify product quantity in repo as per order*/
    public void modifyRepo(ProductRepository repo, Order customerOrder) {
        Set<Product> repoProductsSet = repo.getAllProducts();    //get products from repo
        Set<Product> orderedProductsSet = customerOrder.getProducts(); //get products from customer's order
        Iterator<Product> checkOrder = orderedProductsSet.iterator();  //to iterate over products in customer's order
        Iterator<Product> checkRepo = repoProductsSet.iterator();  //to iterate over products in customer's order

        /*reduce quantity of each product in repository by the customer's ordered quantity*/
        int[] productIds = new int[10];
        int[] quantities = new int[10];
        Product[] orderedProduct = new Product[10];
        int i = 0;
        while (checkOrder.hasNext()) {
            orderedProduct[i] = repo.getProductById(checkOrder.next().getId());
            productIds[i] = orderedProduct[i].getId();
            quantities[i] = orderedProduct[i].getQuantity();
            i++;
        }
        Product repoProducts[]=new Product[10];
        for (int j = 0; j < i; j++) {
            repoProducts[j]=repo.getProductById(productIds[j]);
            repoProducts[j].toString();
            repoProducts[j].setQuantity(repoProducts[j].getQuantity());
            repo.deleteProduct(productIds[j]);
            repo.addProduct(repoProducts[j]);
        }

    }
}
