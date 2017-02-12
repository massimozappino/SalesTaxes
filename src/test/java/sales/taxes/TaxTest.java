package sales.taxes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TaxTest {
    @Test
    public void getTaxValue() {
        assertTaxIs(10.00, 100.0, 10);
        assertTaxIs(0.00, 100.0, 0);
    }

    @Test
    public void roundTaxes() {
        assertTaxIs(7.15, 47.50, 15);
        assertTaxIs(0.60, 11.25, 5);
        assertTaxIs(28.90, 192.36, 15);
    }

    private void assertTaxIs(double expected, double netPrice, int taxPercentage) {
        Tax tax = new Tax(netPrice, taxPercentage);
        assertEquals(expected, tax.getPrice().getValue());
    }
}
