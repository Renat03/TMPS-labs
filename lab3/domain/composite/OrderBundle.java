package domain.composite;

import domain.composite.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderBundle implements domain.composite.OrderItem {
    private final String bundleName;
    private final List<domain.composite.OrderItem> items = new ArrayList<>();

    public OrderBundle(String bundleName) {
        this.bundleName = bundleName;
    }

    public void addItem(domain.composite.OrderItem item) {
        items.add(item);
    }

    public void removeItem(domain.composite.OrderItem item) {
        items.remove(item);
    }

    @Override
    public String getDescription() {
        StringBuilder description = new StringBuilder(bundleName + " contains:\n");
        for (domain.composite.OrderItem item : items) {
            if (item instanceof domain.composite.OrderBundle) {
                domain.composite.OrderBundle subBundle = (domain.composite.OrderBundle) item;
                for (domain.composite.OrderItem subItem : subBundle.items) {
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
