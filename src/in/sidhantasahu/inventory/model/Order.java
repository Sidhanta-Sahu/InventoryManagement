package in.sidhantasahu.inventory.model;

import java.util.Set;

public class Order {
    private int orderId;
    private String customer_name;
    private Set<Product> products;

    public Order() {
    }

    public Order(int orderId, String customer_name, Set<Product> products) {
        this.orderId = orderId;
        this.customer_name = customer_name;
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customer_name='" + customer_name + '\'' +
                ", products=" + products +
                '}';
    }
}
