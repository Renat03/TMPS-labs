package client2;

import domain2.factory.AbstractOrderFactory;
import domain2.factory.ClothingOrderFactory;
import domain2.factory.ElectronicsOrderFactory;
import domain2.factory.FurnitureOrderFactory;
import domain2.models.builder.OrderBuilder;
import domain2.models.order.Order;
import domain2.singleton.OrderProcessor;
import domain2.adapter.PayPalAdapter;
import domain2.decorator.DiscountDecorator;
import domain2.decorator.GiftWrapDecorator;
import domain2.composite.OrderBundle;
import domain2.composite.OrderItem;
import domain2.composite.Product;


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
