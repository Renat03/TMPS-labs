package domain.factory;

import domain.models.order.Order;
import domain.models.order.FurnitureOrder;

public class FurnitureOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new FurnitureOrder();
    }
}
