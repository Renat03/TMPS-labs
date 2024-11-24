package domain.singleton;

import domain.models.order.Order;
import domain.adapter.PaymentProcessor;
import domain.decorator.OrderProcessorDecorator;
import domain.strategy.PaymentStrategy;
import domain.observer.Observer;
import java.util.ArrayList;
import java.util.List;


public class OrderProcessor {
    private static domain.singleton.OrderProcessor instance;
    private final List<Observer> observers = new ArrayList<>();


    private OrderProcessor() {}

    public static synchronized domain.singleton.OrderProcessor getInstance() {
        if (instance == null) {
            instance = new domain.singleton.OrderProcessor();
        }
        return instance;
    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    private void notifyObservers(String event) {
        for (Observer observer : observers) {
            observer.update(event);
        }
    }

    public void processOrder(Order order) {
        System.out.println("\nProcessing order...");
        order.displayOrderDetails();
        notifyObservers("Order processed for customer: " + order.getCustomerName());
    }

    public void processPayment(PaymentStrategy paymentStrategy, double amount) {
        if (paymentStrategy == null) {
            System.out.println("No payment strategy selected. Payment cannot be processed.");
        } else {
            paymentStrategy.pay(amount);
            notifyObservers("Payment of $" + amount + " processed.");
        }
    }

    public void processOrderWithDecorators(Order order, OrderProcessorDecorator decorator) {
        decorator.process(order);
        notifyObservers("Order processed with decorators for customer: " + order.getCustomerName());
    }

}
