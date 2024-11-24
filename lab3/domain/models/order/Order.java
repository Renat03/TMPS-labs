package domain.models.order;

public abstract class Order {
    protected String customerName;
    protected String address;
    protected String productType;
    protected int quantity;

    public abstract void displayOrderDetails();

    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public void setAddress(String address) { this.address = address; }
    public void setProductType(String productType) { this.productType = productType; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public String getCustomerName() { return customerName; }
    public String getAddress() { return address; }
    public String getProductType() { return productType; }
    public int getQuantity() { return quantity; }
}
