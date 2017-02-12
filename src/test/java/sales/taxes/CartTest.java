package sales.taxes;

import org.junit.Test;
import sales.taxes.item.Item;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class CartTest {
    @Test
    public void addItemsToCart() {
        Cart cart = new Cart();
        cart.addItem(mock(Item.class));
        cart.addItem(mock(Item.class));

        assertEquals(2, cart.getItems().size());
    }
}