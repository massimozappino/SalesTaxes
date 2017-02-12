package sales.taxes;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PriceTest {

    @Test
    public void emptyConstructorHasValueZero() {
        assertEquals(0.0, new Price().getValue());
    }

    @Test
    public void constructWithAnotherPriceObject() {
        assertEquals(15.96, new Price(new Price(15.96)).getValue());
    }

    @Test
    public void getValue() {
        assertEquals(100.00, new Price(100.0).getValue());
        assertEquals(100.65, new Price(100.6523).getValue());
        assertEquals(100.66, new Price(100.6553).getValue());
        assertEquals(100.66, new Price(100.66123).getValue());
        assertEquals(100.69, new Price(100.694).getValue());
        assertEquals(100.69, new Price(100.695).getValue());
        assertEquals(100.70, new Price(100.6951).getValue());
    }

    @Test
    public void sumValue() {
        Price priceBase = new Price(100.0);
        Price priceAdd = new Price(0.5686);
        assertEquals(100.57, priceBase.sum(priceAdd).getValue());
    }

    @Test
    public void sumValueAndRound() {
        Price priceBase = new Price(100.99);
        Price priceAdd = new Price(0.99);
        assertEquals(101.98, priceBase.sum(priceAdd).getValue());
    }
}