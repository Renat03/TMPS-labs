package domain.factory;

import domain.models.order.Order;
import domain.models.order.ElectronicsOrder;

public class ElectronicsOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new ElectronicsOrder();
    }
}
