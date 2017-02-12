package sales.taxes.item;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class ItemTest {

    private Item item;

    @Before
    public void initialize() {
        item = new Item("product", 10.0) {
            @Override
            public boolean isExempt() {
                return false;
            }
        };
    }

    @Test
    public void itemFields() {
        assertEquals("product", item.getProductName());
        assertEquals(10.0, item.getNetPrice().getValue());
    }

    @Test
    public void importedFlag() {
        assertFalse(item.isImported());

        Item returnedItem = item.setImported();

        assertTrue(item.isImported());
        assertSame(returnedItem, item);
    }
}