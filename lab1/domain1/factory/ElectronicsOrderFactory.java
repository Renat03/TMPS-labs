package domain1.factory;

import domain1.models.order.Order;
import domain1.models.order.ElectronicsOrder;

public class ElectronicsOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new ElectronicsOrder();
    }
}
