package domain2.composite;

import java.util.ArrayList;
import java.util.List;

public class OrderBundle implements OrderItem {
    private final String bundleName;
    private final List<OrderItem> items = new ArrayList<>();

    public OrderBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder(bundleName + " contains:\n");
        for (OrderItem item : items) {
            if (item instanceof OrderBundle) {
                OrderBundle subBundle = (OrderBundle) item;
                for (OrderItem subItem : subBundle.items) {
                    description.append("- ").append(subItem.getDescription()).append("\n");
                }
            } else {
                description.append("- ").append(item.getDescription()).append("\n");
            }
        }
        return description.toString();
    }


    @Override
    public double getPrice() {
        double totalPrice = 0;
        for (OrderItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
