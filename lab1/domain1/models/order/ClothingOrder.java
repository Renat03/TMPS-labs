package domain1.models.order;

public class ClothingOrder extends Order {
    @Override
    public void displayOrderDetails() {
        System.out.println("Clothing Order: " + quantity + " units of " + productType +
                " for " + customerName + " at " + address);
    }
}
