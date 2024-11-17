package domain.singleton;

import domain.models.order.Order;
import domain.adapter.PaymentProcessor;

public class OrderProcessor {
    private static domain.singleton.OrderProcessor instance;

    private OrderProcessor() {}

    public static synchronized domain.singleton.OrderProcessor getInstance() {
        if (instance == null) {
            instance = new domain.singleton.OrderProcessor();
        }
        return instance;
    }

    public void processOrder(Order order) {
        System.out.println("Processing order...");
        order.displayOrderDetails();
    }

    public void processPayment(PaymentProcessor paymentProcessor, double amount) {
        paymentProcessor.processPayment(amount);
    }

}
