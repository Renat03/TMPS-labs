package domain.decorator;

import domain.models.order.Order;

public abstract class OrderProcessorDecorator {
    protected OrderProcessorDecorator nextDecorator;

    public void setNext(OrderProcessorDecorator nextDecorator) {
        this.nextDecorator = nextDecorator;
    }

    public void process(Order order) {
        if (nextDecorator != null) {
            nextDecorator.process(order);
        }
    }
}
