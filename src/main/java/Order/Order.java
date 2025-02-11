package Order;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private String id;
    private String date;
    private User user;
    private boolean status;
    private List<OrderItem> orderItemList;

    public Order() {
    }

    public Order(String id, String date, User user, boolean status) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.status = status;
        this.orderItemList = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(List<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int totalAmount() {
        int total = 0;
        for (OrderItem orderItem : orderItemList) {
            total += orderItem.amount();
        }
        return total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", date='" + date + '\'' +
                ", user=" + user +
                ", status=" + status +
                ", orderItemList=" + orderItemList +
                '}';
    }
}