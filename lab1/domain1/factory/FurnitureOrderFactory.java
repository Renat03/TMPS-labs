package domain1.factory;

import domain1.models.order.Order;
import domain1.models.order.FurnitureOrder;

public class FurnitureOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new FurnitureOrder();
    }
}
