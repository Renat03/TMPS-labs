package domain.factory;

import domain.models.order.ClothingOrder;
import domain.models.order.Order;

public class ClothingOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new ClothingOrder();
    }
}
