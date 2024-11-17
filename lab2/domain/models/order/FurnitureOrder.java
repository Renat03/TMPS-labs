package domain.models.order;

import domain.models.order.Order;

public class FurnitureOrder extends Order {
    @Override
    public void displayOrderDetails() {
        System.out.println("Furniture Order: " + quantity + " units of " + productType +
                " for " + customerName + " at " + address);
    }
}
