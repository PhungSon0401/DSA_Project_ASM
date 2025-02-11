package Queue;

import java.util.ArrayList;
import java.util.List;

public class QueueADTImpl<T> implements QueueADT<T> {
    private int capacity;
    private List<T> items;

    public QueueADTImpl(int capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>(capacity);
    }

    @Override
    public void enqueue(T t) {
        if (!isFull()) {
            items.add(t);
        } else {
            System.out.println("Queue is full. Cannot enqueue.");
        }
    }
    @Override
    public T dequeue() {
        if (!isEmpty()) {
            T t = items.get(0);
            items.remove(0);
            return t;
        } else {
            System.out.println("Queue is empty. Cannot dequeue.");
            return null;
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return items.get(0);
        } else {
            System.out.println("Queue is empty. Cannot peek.");
            return null;
        }
    }

    @Override
    public boolean isFull() {
        return size() == capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public int size() {
        return items.size();
    }
}
