package domain.factory;

import domain.factory.AbstractOrderFactory;
import domain.models.order.ElectronicsOrder;
import domain.models.order.Order;

public class ElectronicsOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new ElectronicsOrder();
    }
}
