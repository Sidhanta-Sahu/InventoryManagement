package in.sidhantasahu.inventory.controller;

import in.sidhantasahu.inventory.model.Product;
import in.sidhantasahu.inventory.repository.ProductRepository;
import in.sidhantasahu.inventory.seed.ProductSeed;

import java.util.Iterator;
import java.util.Set;

public class ProductController {

    private final CartController customerCartController = new CartController();
    private final ProductRepository repo = ProductSeed.createProductDataSet();
    private final OrderController customerOrderController=new OrderController();

    public void displayAllProducts() {
        repo.getAllProducts().forEach((P) -> System.out.println(P.toString()));
    }

    /*check if product id is valid and requested quantity is available. If yes, then add product to cart*/
    public boolean checkProductId(int productId) {
        Product p = repo.getProductById(productId);

        /*display error message if product id is not found*/
        if (p == null) {
            System.out.println("Enter correct product ID");
            return false;
        }

        /* display details of the product chosen if found*/
        System.out.println(p);
        return true;
    }

    public void addProductToCart(int productId, int quantity) {
        Product p = repo.getProductById(productId);

        /*display error message if quantity required exceeds available quantity*/
        if (quantity > p.getQuantity()) {
            System.out.println("Enter valid quantity");
        } else {
            /* if product id and quantity is validated, add the product to customer's cart*/
            customerCartController.addToCart(p, quantity);
        }
    }

    /*display products in cart (implemented in CartController class)*/
    public void displayCartSummary() {
        customerCartController.cartSummary();
    }

    /* process order and display order details (Implemented in OrderController class)*/
    public void convertOrder(String name) {
        customerOrderController.displayOrder(name, repo,customerCartController.getCustomerCart());
    }
}
