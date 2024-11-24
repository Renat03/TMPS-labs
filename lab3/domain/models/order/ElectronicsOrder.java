package domain.models.order;

import domain.models.order.Order;

public class ElectronicsOrder extends Order {
    @Override
    public void displayOrderDetails() {
        System.out.println("Electronics Order: " + quantity + " units of " + productType +
                " for " + customerName + " at " + address);
    }
}