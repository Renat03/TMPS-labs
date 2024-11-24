package domain2.factory;

import domain2.models.order.ClothingOrder;
import domain2.models.order.Order;

public class ClothingOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new ClothingOrder();
    }
}
