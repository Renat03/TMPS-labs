package domain2.decorator;

import domain2.models.order.Order;

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
