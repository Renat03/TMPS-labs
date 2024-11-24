package domain.models.order;

import domain.models.order.Order;

public class ClothingOrder extends Order {
    @Override
    public void displayOrderDetails() {
        System.out.println("Clothing Order: " + quantity + " units of " + productType +
                " for " + customerName + " at " + address);
    }
}
