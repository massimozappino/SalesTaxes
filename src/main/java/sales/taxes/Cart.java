package sales.taxes;


import sales.taxes.item.Item;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart() {
        items = new ArrayList<>();
    }
    public Cart(List<Item> items) {
        this.items = items;
    }

    public Order createOrder() {
        return new Order(this);
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
