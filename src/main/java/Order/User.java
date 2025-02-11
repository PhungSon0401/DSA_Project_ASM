package Order;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String name;
    private String phoneNumber;
    private String address;
    private List<Order> orders;

    public User(int id, String name, String phoneNumber, String address) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }

    public void displayOrders() {
        System.out.println("Orders for " + this.name + ": ");
        for (Order order : orders) {
            System.out.println("\tOrder ID: " + order.getId());
            System.out.println("\tDate: " + order.getDate());
            System.out.println("\tStatus: " + (order.isStatus() ? "Processed" : "Processing"));
            System.out.println("\tTotal Amount: " + order.totalAmount());
            System.out.println("\tOrder Items: ");
            for (OrderItem item : order.getOrderItemList()) {
                System.out.println("\t\tProduct: " + item.getProduct().getName() +
                        ", Quantity: " + item.getQuantity() +
                        ", Total Price: " + item.amount());
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
