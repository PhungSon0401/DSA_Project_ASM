package Order;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class OrderTest {
    @Test
    void testAddMultipleProducts() {
        // Arrange: Create three new products
        Product p1 = new Product(1, "Car", 300);
        Product p2 = new Product(2, "Bike", 50);
        Product p3 = new Product(3, "Plane", 120);

        User user1 = new User(1, "sonfung", "0969287604", "Ha Noi");

        Order order = new Order("order414", "2025-01-12", user1, false);

        order.getOrderItemList().add(new OrderItem(p1, 1));
        order.getOrderItemList().add(new OrderItem(p2, 4));
        order.getOrderItemList().add(new OrderItem(p3, 2));

        boolean hasThreeItems = order.getOrderItemList().size() == 3;

        System.out.println("Testing adding multiple products...");
        System.out.println("Order ID: " + order.getId() + " placed by " + order.getUser().getName());
        for (OrderItem item : order.getOrderItemList()) {
            System.out.println("Product: " + item.getProduct().getName() +
                    ", Quantity: " + item.getQuantity() +
                    ", Price per unit: " + item.getProduct().getPrice());
        }

        assertTrue(hasThreeItems, "The order should contain exactly 3 products.");

        int expectedTotal = (p1.getPrice() * 1) + (p2.getPrice() * 4) + (p3.getPrice() * 2);
        int totalAmount = order.totalAmount();
        System.out.println("Total Order Amount: " + totalAmount);

        assertTrue(totalAmount == expectedTotal, "The total order amount should be calculated correctly.");

        System.out.println("Test successfully passed!");
        System.out.println("Successfully added to the order.");
    }
}
