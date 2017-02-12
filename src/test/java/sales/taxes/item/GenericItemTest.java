package sales.taxes.item;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;

public class GenericItemTest {
    @Test
    public void itemFields() {
        GenericItem genericItem = new GenericItem("product", 10.0);

        assertFalse(genericItem.isExempt());
    }
}