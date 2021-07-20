package in.sidhantasahu.inventory.controller;

import in.sidhantasahu.inventory.model.Cart;
import in.sidhantasahu.inventory.model.Product;

import java.util.HashSet;
import java.util.Iterator;

public class CartController {
    Cart customerCart = new Cart();
    private final HashSet<Product> setOfProducts = new HashSet<>();

    /*add product to cart and generate cart id*/
    public void addToCart(Product q, int quantity) {
        customerCart.setId(customerCart.getId() + 1);
        q.setQuantity(quantity);
        setOfProducts.add(q);
        customerCart.setProducts(setOfProducts);
    }

    /* display details of products added to cart*/
    public void cartSummary() {
        System.out.println(customerCart);
        this.displayTotalPrice();
    }

    /*return cart object for processing in OrderController class*/
    public Cart getCustomerCart() {
        return customerCart;
    }

    /*display total price of products in customer's cart*/
    public void displayTotalPrice() {
        double totalPrice = 0;
        for (Product individualProduct : setOfProducts) {
            totalPrice = totalPrice + individualProduct.getPrice() * individualProduct.getQuantity();
        }
        System.out.println("Total price = " + totalPrice);
    }
}

