package domain.decorator;

import domain.decorator.OrderProcessorDecorator;
import domain.models.order.Order;

public class DiscountDecorator extends OrderProcessorDecorator {
    private final double discountRate;

    public DiscountDecorator(double discountRate) {
        this.discountRate = discountRate;
    }

    @Override
    public void process(Order order) {
        double total = order.getQuantity() * 100; //Price of 100 for testing purposes
        double discountedTotal = total - (total * discountRate);
        System.out.println("Applying discount of " + (discountRate * 100) + "%");
        System.out.println("Discounted Total: $" + discountedTotal);

        super.process(order);
    }
}
