package client;

import domain.factory.AbstractOrderFactory;
import domain.factory.ClothingOrderFactory;
import domain.factory.ElectronicsOrderFactory;
import domain.factory.FurnitureOrderFactory;
import domain.models.builder.OrderBuilder;
import domain.models.order.Order;
import domain.singleton.OrderProcessor;
import domain.adapter.PayPalAdapter;
import domain.decorator.DiscountDecorator;
import domain.decorator.GiftWrapDecorator;
import domain.decorator.OrderProcessorDecorator;


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

        PayPalAdapter payPalAdapter = new PayPalAdapter("alice@example.com");
        processor.processPayment(payPalAdapter, 299.99);


    AbstractOrderFactory furnitureFactory = new FurnitureOrderFactory();
        Order customFurnitureOrder = new OrderBuilder(furnitureFactory)
                .setCustomerName("Pedri Gonzalez")
                .setAddress("Av. De Joan XVIII")
                .setProductType("Bed")
                .setQuantity(8)
                .build();

        processor.processOrder(customFurnitureOrder);
        DiscountDecorator discountDecorator = new DiscountDecorator(0.10);
        GiftWrapDecorator giftWrapDecorator = new GiftWrapDecorator();

        discountDecorator.setNext(giftWrapDecorator);
        processor.processOrderWithDecorators(customFurnitureOrder, discountDecorator);


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
