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
import domain.composite.OrderBundle;
import domain.composite.OrderItem;
import domain.composite.Product;
import domain.strategy.CashPayment;
import domain.strategy.CreditCardPayment;
import domain.strategy.PayPalPayment;
import domain.strategy.PaymentStrategy;

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

        // Strategy Pattern: PayPal Payment
        PaymentStrategy paypalPayment = new PayPalPayment("alice@example.com");
        processor.processPayment(paypalPayment, 299.99);

        // Furniture Order with Strategy
        AbstractOrderFactory furnitureFactory = new FurnitureOrderFactory();
        Order customFurnitureOrder = new OrderBuilder(furnitureFactory)
                .setCustomerName("Pedri Gonzalez")
                .setAddress("Av. De Joan XVIII")
                .setProductType("Bed")
                .setQuantity(8)
                .build();

        processor.processOrder(customFurnitureOrder);

        // Applying decorators
        DiscountDecorator discountDecorator = new DiscountDecorator(0.10);
        GiftWrapDecorator giftWrapDecorator = new GiftWrapDecorator();

        discountDecorator.setNext(giftWrapDecorator);
        processor.processOrderWithDecorators(customFurnitureOrder, discountDecorator);

        // Pay with Credit Card
        PaymentStrategy creditCardPayment = new CreditCardPayment("1234-5678-9876-5432", "Pedri Gonzalez");
        processor.processPayment(creditCardPayment, 800.0);

        // Clothing Order with Strategy
        AbstractOrderFactory clothingFactory = new ClothingOrderFactory();
        Order clothingOrder = new OrderBuilder(clothingFactory)
                .setCustomerName("Lamine Yamal")
                .setAddress("Cabra 304 St")
                .setProductType("Barca Jersey")
                .setQuantity(19)
                .build();

        processor.processOrder(clothingOrder);

        // Pay with Cash
        PaymentStrategy cashPayment = new CashPayment();
        processor.processPayment(cashPayment, 950.0);

        // Composite Pattern: Bundling orders
        OrderItem laptop = new Product("Laptop", 1000.00);
        OrderItem smartphone = new Product("Smartphone", 500.00);
        OrderItem headphones = new Product("Headphones", 150.00);

        OrderBundle techBundle = new OrderBundle("Tech Bundle");
        techBundle.addItem(laptop);
        techBundle.addItem(smartphone);

        OrderBundle megaBundle = new OrderBundle("Mega Bundle");
        megaBundle.addItem(techBundle);
        megaBundle.addItem(headphones);

        System.out.println(techBundle.getDescription());
        System.out.println("Tech Bundle Total Price: $" + techBundle.getPrice());

        System.out.println(megaBundle.getDescription());
        System.out.println("Mega Bundle Total Price: $" + megaBundle.getPrice());
    }
}
