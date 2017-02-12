package sales.taxes;

import sales.taxes.item.Item;

public class Marketplace {

    private Cart cart;

    public Marketplace() {
        this.cart = new Cart();
    }

    public void addToCart(Item item) {
        cart.addItem(item);
    }

    public Order createOrder() {
        return cart.createOrder();
    }
}
