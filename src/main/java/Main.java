import Order.Order;
import Order.User;
import Order.Product;
import Order.OrderItem;
import Queue.QueueADT;
import Queue.QueueADTImpl;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Product p1 = new Product(1, "Product 1", 220);
        Product p2 = new Product(2, "Product 2", 500);
        Product p3 = new Product(3, "Product 3", 20);

        User user1 = new User(1, "User 1", "123456789", "Ha Noi");
        User user2 = new User(2, "User 2", "123434789", "Cau Giay");

        // (true = processed, false = pending)
        Order o1 = new Order("order1", "2025-01-12", user1, true);
        Order o2 = new Order("order2", "2025-01-11", user1, false);
        Order o3 = new Order("order3", "2025-01-10", user2, false);

        o1.getOrderItemList().add(new OrderItem(p1, 2));
        o1.getOrderItemList().add(new OrderItem(p3, 4));

        o2.getOrderItemList().add(new OrderItem(p1, 1));
        o2.getOrderItemList().add(new OrderItem(p2, 1));

        o3.getOrderItemList().add(new OrderItem(p2, 2));
        o3.getOrderItemList().add(new OrderItem(p3, 3));

        QueueADT<Order> orderQueueADT = new QueueADTImpl<>(100);

        orderQueueADT.enqueue(o2);
        orderQueueADT.enqueue(o3);
        orderQueueADT.enqueue(o1);

        System.out.println("Queue size after adding orders: " + orderQueueADT.size());

        while (!orderQueueADT.isEmpty()) {
            Order o = orderQueueADT.dequeue();
            o.setStatus(true);
            System.out.println("Processing Order: " + o.getId());
            Thread.sleep(1000);
            System.out.println("\tUser details: ");
            System.out.println("\t\t" + o.getUser());
            System.out.println("\tTotal amount: " + o.totalAmount());
            System.out.println("\tOrder details: ");
            for (OrderItem orderItem : o.getOrderItemList()) {
                System.out.println("\t\t" + orderItem);
            }
            if (o.isStatus()) {
                System.out.println("\tStatus: Processed");
            } else {
                System.out.println("\tStatus: Processing");
            }
            System.out.println();
        }
    }
}