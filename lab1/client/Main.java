package client;

import domain.singleton.OrderProcessor;
import domain.factory.AbstractOrderFactory;
import domain.factory.ElectronicsOrderFactory;
import domain.factory.FurnitureOrderFactory;
import domain.models.builder.OrderBuilder;
import domain.models.order.Order;

public class Main {
    public static void main(String[] args) {
        AbstractOrderFactory electronicsFactory = new ElectronicsOrderFactory();
        Order electronicsOrder = new OrderBuilder(electronicsFactory)
                .setCustomerName("John Smith")
                .setAddress("Street Name 123")
                .setProductType("Smartphone")
                .setQuantity(2)
                .build();

        OrderProcessor processor = OrderProcessor.getInstance();
        processor.processOrder(electronicsOrder);

        AbstractOrderFactory furnitureFactory = new FurnitureOrderFactory();
        Order customFurnitureOrder = new OrderBuilder(furnitureFactory)
                .setCustomerName("Pedri Gonzalez")
                .setAddress("Av. De Joan XVIII")
                .setProductType("Bed")
                .setQuantity(1)
                .build();

        processor.processOrder(customFurnitureOrder);
    }
}
