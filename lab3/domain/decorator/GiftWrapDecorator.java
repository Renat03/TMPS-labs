package domain.decorator;

import domain.decorator.OrderProcessorDecorator;
import domain.models.order.Order;

public class GiftWrapDecorator extends OrderProcessorDecorator {
    @Override
    public void process(Order order) {
        System.out.println("Adding gift wrapping to the order for " + order.getCustomerName());
        super.process(order);
    }
}
