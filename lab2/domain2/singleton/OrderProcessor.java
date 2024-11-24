package domain2.singleton;

import domain2.models.order.Order;
import domain2.adapter.PaymentProcessor;
import domain2.decorator.OrderProcessorDecorator;


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
        System.out.println("\nProcessing order...");
        order.displayOrderDetails();
    }

    public void processPayment(PaymentProcessor paymentProcessor, double amount) {
        paymentProcessor.processPayment(amount);
    }

    public void processOrderWithDecorators(Order order, OrderProcessorDecorator decorator) {
        System.out.println("Processing order with additional features for: " + order.getCustomerName());
        decorator.process(order);
    }

}
