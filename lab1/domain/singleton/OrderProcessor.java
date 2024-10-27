package domain.singleton;

import domain.models.order.Order;

public class OrderProcessor {
    private static OrderProcessor instance;

    private OrderProcessor() {}

    public static synchronized OrderProcessor getInstance() {
        if (instance == null) {
            instance = new OrderProcessor();
        }
        return instance;
    }

    public void processOrder(Order order) {
        System.out.println("Processing order...");
        order.displayOrderDetails();
    }
}
