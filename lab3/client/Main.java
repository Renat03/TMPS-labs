package client;

import domain.factory.AbstractOrderFactory;
import domain.factory.ClothingOrderFactory;
import domain.factory.ElectronicsOrderFactory;
import domain.factory.FurnitureOrderFactory;
import domain.models.builder.OrderBuilder;
import domain.models.order.Order;
import domain.singleton.OrderProcessor;
import domain.decorator.DiscountDecorator;
import domain.decorator.GiftWrapDecorator;
import domain.strategy.CashPayment;
import domain.strategy.CreditCardPayment;
import domain.strategy.PayPalPayment;
import domain.strategy.PaymentStrategy;
import domain.observer.EmailNotificationObserver;
import domain.observer.LoggingObserver;
import domain.observer.DatabaseObserver;

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
        processor.addObserver(new EmailNotificationObserver());
        processor.addObserver(new LoggingObserver());
        processor.addObserver(new DatabaseObserver());
        processor.processOrder(electronicsOrder);

        PaymentStrategy paypalPayment = new PayPalPayment("alice@example.com");
        processor.processPayment(paypalPayment, 299.99);

        AbstractOrderFactory furnitureFactory = new FurnitureOrderFactory();
        Order customFurnitureOrder = new OrderBuilder(furnitureFactory)
                .setCustomerName("Pedri Gonzalez")
                .setAddress("Av. De Joan XVIII")
                .setProductType("Bed")
                .setQuantity(8)
                .build();

        processor.removeObserver(new EmailNotificationObserver());
        processor.processOrder(customFurnitureOrder);

        DiscountDecorator discountDecorator = new DiscountDecorator(0.10);
        GiftWrapDecorator giftWrapDecorator = new GiftWrapDecorator();

        discountDecorator.setNext(giftWrapDecorator);
        processor.processOrderWithDecorators(customFurnitureOrder, discountDecorator);

        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "Pedri Gonzalez");
        processor.processPayment(creditCardPayment, 800.0);

        AbstractOrderFactory clothingFactory = new ClothingOrderFactory();
        Order clothingOrder = new OrderBuilder(clothingFactory)
                .setCustomerName("Lamine Yamal")
                .setAddress("Cabra 304 St")
                .setProductType("Barca Jersey")
                .setQuantity(19)
                .build();

        processor.processOrder(clothingOrder);

        PaymentStrategy cashPayment = new CashPayment();
        processor.processPayment(cashPayment, 950.0);
    }
}
