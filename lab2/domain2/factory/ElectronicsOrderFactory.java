package domain2.factory;

import domain2.models.order.ElectronicsOrder;
import domain2.models.order.Order;

public class ElectronicsOrderFactory extends AbstractOrderFactory {
    @Override
    public Order createOrder() {
        return new ElectronicsOrder();
    }
}
