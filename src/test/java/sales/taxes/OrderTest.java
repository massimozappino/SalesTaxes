package sales.taxes;

import org.junit.Test;
import sales.taxes.item.GenericItem;
import sales.taxes.item.Item;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class OrderTest {
    @Test
    public void createOrder() {
        List<Item> items = new ArrayList<>();
        items.add(new GenericItem("1", 10));
        items.add(new GenericItem("2", 20));
        items.add(new GenericItem("3", 30));
        Order order = new Order(new Cart(items));

        assertEquals(66.0, order.getTotalPrice().getValue());
        assertEquals(6.0, order.getTotalTaxes().getValue());
    }

    @Test
    public void createItemOrder() {
        List<Item> items = new ArrayList<>();
        items.add(new GenericItem("product one", 10));
        items.add(new GenericItem("product two", 20));
        Order order = new Order(new Cart(items));

        assertEquals("product one: 11.00", order.getItemOrderAtPosition(0).toString());
    }
}