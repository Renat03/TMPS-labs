package domain.models.builder;

import domain.factory.AbstractOrderFactory;
import domain.models.order.Order;

public class OrderBuilder {
    private String customerName;
    private String address;
    private String productType;
    private int quantity;
    private AbstractOrderFactory factory;

    public OrderBuilder(AbstractOrderFactory factory) {
        this.factory = factory;
    }

    public OrderBuilder setCustomerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public OrderBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public OrderBuilder setProductType(String productType) {
        this.productType = productType;
        return this;
    }

    public OrderBuilder setQuantity(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public Order build() {
        Order order = factory.createOrder();
        order.setCustomerName(customerName);
        order.setAddress(address);
        order.setProductType(productType);
        order.setQuantity(quantity);
        return order;
    }
}

