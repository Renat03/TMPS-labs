package domain2.factory;

import domain2.models.order.FurnitureOrder;
import domain2.models.order.Order;

public class FurnitureOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new FurnitureOrder();
    }
}
