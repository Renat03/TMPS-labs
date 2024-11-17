package domain1.factory;

import domain1.models.order.ClothingOrder;
import domain1.models.order.Order;

public class ClothingOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new ClothingOrder();
    }
}
