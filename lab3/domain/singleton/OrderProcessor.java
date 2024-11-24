package domain.singleton;

import domain.models.order.Order;
import domain.adapter.PaymentProcessor;
import domain.decorator.OrderProcessorDecorator;
import domain.strategy.PaymentStrategy;



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
        System.out.println("\nProcessing order...");
        order.displayOrderDetails();
    }

    public void processPayment(PaymentStrategy paymentStrategy, double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy selected. Payment cannot be processed.");
        } else {
            paymentStrategy.pay(amount);
        }
    }

    public void processOrderWithDecorators(Order order, OrderProcessorDecorator decorator) {
        System.out.println("Processing order with additional features for: " + order.getCustomerName());
        decorator.process(order);
    }

}
