package Order;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TotalAmountTest {

    @Test
    void verifyOrderTotalCalculation() {
        Product productA = new Product(101, "Iphone", 300);
        Product productB = new Product(102, "Headphones", 150);
        Product productC = new Product(103, "Charger", 100);

        User customer = new User(1, "sonfung", "0969287604", "Hanoi");

        Order order = new Order("order414", "2025-01-12", customer, false);

        order.getOrderItemList().add(new OrderItem(productA, 3));
        order.getOrderItemList().add(new OrderItem(productB, 2));
        order.getOrderItemList().add(new OrderItem(productC, 4));

        double expectedTotal = (productA.getPrice() * 3) + (productB.getPrice() * 2) + (productC.getPrice() * 4);

        double actualTotal = order.totalAmount();

        System.out.println("====================================");
        System.out.println("| Product     | Quantity | Price | Total Price |");
        System.out.println("====================================");

        for (OrderItem item : order.getOrderItemList()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            double totalPrice = product.getPrice() * quantity;
            System.out.printf("| %-12s | %-8d | %-5d | %-11.2f |\n", product.getName(), quantity, product.getPrice(), totalPrice);
        }

        System.out.println("====================================");
        System.out.printf("| %-12s | %-8s | %-5s | %-11.2f |\n", "Total", "", "", actualTotal);
        System.out.println("====================================");

        System.out.println("Expected Order Total: " + expectedTotal);
        System.out.println("Calculated Order Total: " + actualTotal);

        assertTrue(Math.abs(expectedTotal - actualTotal) < 0.001, "The total should be 1600");

        if (Math.abs(expectedTotal - actualTotal) < 0.001) {
            System.out.println("Test passed! The calculated total is correct.");
        } else {
            System.out.println("Test failed! The calculated total is incorrect.");
        }
    }
}
