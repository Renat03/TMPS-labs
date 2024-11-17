package client1;

import domain1.singleton.OrderProcessor;
import domain1.factory.AbstractOrderFactory;
import domain1.factory.ClothingOrderFactory;
import domain1.factory.ElectronicsOrderFactory;
import domain1.factory.FurnitureOrderFactory;
import domain1.models.builder.OrderBuilder;
import domain1.models.order.Order;

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
                .setQuantity(8)
                .build();

        processor.processOrder(customFurnitureOrder);

        AbstractOrderFactory clothingFactory = new ClothingOrderFactory();
        Order clothingOrder = new OrderBuilder(clothingFactory)
                .setCustomerName("Lamine Yamal")
                .setAddress("Cabra 304 St")
                .setProductType("Barca Jersey")
                .setQuantity(19)
                .build();

        processor.processOrder(clothingOrder);
    }
}
