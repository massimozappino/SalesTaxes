package sales.taxes;

import sales.taxes.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Price totalTaxes;
    private Price totalPrice;
    private List<OrderItem> orderItemsList;

    public Order(Cart cart) {
        orderItemsList = new ArrayList<>();
        totalPrice = new Price();
        totalTaxes = new Price();
        for (Item item : cart.getItems()) {
            OrderItem orderItem = new OrderItem(item);
            orderItemsList.add(orderItem);
            totalPrice.sum(orderItem.getTotalPrice());
            totalTaxes.sum(orderItem.getTax().getPrice());
        }
    }

    public OrderItem getItemOrderAtPosition(int position) {
        return orderItemsList.get(position);
    }

    public Price getTotalTaxes() {
        return totalTaxes;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }
}
