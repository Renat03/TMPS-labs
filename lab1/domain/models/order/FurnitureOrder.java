package domain.models.order;

public class FurnitureOrder extends Order {
    @Override
    public void displayOrderDetails() {
        System.out.println("Furniture Order: " + quantity + " units of " + productType +
                " for " + customerName + " at " + address);
    }
}
