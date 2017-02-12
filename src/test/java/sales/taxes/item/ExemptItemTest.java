package sales.taxes.item;

import org.junit.Test;

import static junit.framework.TestCase.assertTrue;

public class ExemptItemTest {
    @Test
    public void itemFields() {
        ExemptItem exemptItem = new ExemptItem("food", 10.0);
        assertTrue(exemptItem.isExempt());
    }
}