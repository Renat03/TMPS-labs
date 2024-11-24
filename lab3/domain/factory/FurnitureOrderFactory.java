package domain.factory;

import domain.factory.AbstractOrderFactory;
import domain.models.order.FurnitureOrder;
import domain.models.order.Order;

public class FurnitureOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new FurnitureOrder();
    }
}
