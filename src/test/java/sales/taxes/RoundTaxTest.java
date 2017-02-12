package sales.taxes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class RoundTaxTest {

    @Test
    public void roundTaxes() {
        RoundTax roundTax = new RoundTax(8.97);
        assertEquals(9.00, roundTax.getRoundedValue());

        roundTax = new RoundTax(8.96);
        assertEquals(9.00, roundTax.getRoundedValue());
    }
}
