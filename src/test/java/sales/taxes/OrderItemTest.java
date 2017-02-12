package sales.taxes;

import org.junit.Test;
import sales.taxes.item.ExemptItem;
import sales.taxes.item.GenericItem;
import sales.taxes.item.Item;

import static junit.framework.TestCase.assertEquals;

public class OrderItemTest {

    @Test
    public void taxesAndTotalPriceRounded() {
        Item genericItem = new GenericItem("item", 95.65);

        assertEquals(9.60, new OrderItem(genericItem).getTax().getPrice().getValue());
        assertEquals(105.25, new OrderItem(genericItem).getTotalPrice().getValue());
    }

    @Test
    public void testToString() {
        Item item = new GenericItem("item", 10.0);
        assertEquals("item: 11.00", new OrderItem(item).toString());
    }

    @Test
    public void calculateFullTaxRate() {
        assertEquals(0.0, new OrderItem(new ExemptItem("item", 10.0)).calculateFullTaxRate());
        assertEquals(5.0, new OrderItem(new ExemptItem("item", 10.0).setImported()).calculateFullTaxRate());
        assertEquals(10.0, new OrderItem(new GenericItem("item", 10.0)).calculateFullTaxRate());
        assertEquals(15.0, new OrderItem(new GenericItem("item", 10.0).setImported()).calculateFullTaxRate());
    }

    @Test
    public void taxesForImportedItem() {
        Item item = new ExemptItem("item", 10.00).setImported();

        assertEquals(0.50, new OrderItem(item).getTax().getPrice().getValue());
        assertEquals(10.50, new OrderItem(item).getTotalPrice().getValue());
    }

    @Test
    public void itemPriceIsNotOverwritten() {
        Item foodItem = new ExemptItem("item", 10.00).setImported();
        new OrderItem(foodItem);

        assertEquals(10.00, foodItem.getNetPrice().getValue());
    }
}