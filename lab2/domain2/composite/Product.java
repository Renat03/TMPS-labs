package domain2.composite;

public class Product implements OrderItem {
    private final String name;
    private final double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
