package sales.taxes;

import org.junit.Test;
import sales.taxes.item.ExemptItem;
import sales.taxes.item.GenericItem;

import static junit.framework.TestCase.assertEquals;

public class MarketplaceTest {

    @Test
    public void buyAGenericItem() {
        Marketplace marketplace = new Marketplace();
        marketplace.addToCart(new GenericItem("a generic item", 10.00));

        Order order = marketplace.createOrder();

        assertItemStringAtPosition("a generic item: 11.00", 0, order);
        assertTotalTaxes(1.0, order);
        assertTotalPrice(order, 11.0);
    }

    @Test
    public void input1() {
        Marketplace marketplace = new Marketplace();
        marketplace.addToCart(new ExemptItem("1 book", 12.49));
        marketplace.addToCart(new GenericItem("1 music CD", 14.99));
        marketplace.addToCart(new ExemptItem("1 chocolate bar", 0.85));

        Order order = marketplace.createOrder();

        assertItemStringAtPosition("1 book: 12.49", 0, order);
        assertItemStringAtPosition("1 music CD: 16.49", 1, order);
        assertItemStringAtPosition("1 chocolate bar: 0.85", 2, order);
        assertTotalTaxes(1.5, order);
        assertTotalPrice(order, 29.83);
    }

    @Test
    public void input2() {
        Marketplace marketplace = new Marketplace();
        marketplace.addToCart(new ExemptItem("1 imported box of chocolates", 10.00).setImported());
        marketplace.addToCart(new GenericItem("1 imported bottle of perfume", 47.50).setImported());

        Order order = marketplace.createOrder();

        assertItemStringAtPosition("1 imported box of chocolates: 10.50", 0, order);
        assertItemStringAtPosition("1 imported bottle of perfume: 54.65", 1, order);
        assertTotalTaxes(7.65, order);
        assertTotalPrice(order, 65.15);
    }

    @Test
    public void input3() {
        Marketplace marketplace = new Marketplace();
        marketplace.addToCart(new GenericItem("1 imported bottle of perfume", 27.99).setImported());
        marketplace.addToCart(new GenericItem("1 bottle of perfume", 18.99));
        marketplace.addToCart(new ExemptItem("1 packet of headache pills", 9.75));
        marketplace.addToCart(new ExemptItem("1 imported box of chocolates", 11.25).setImported());

        Order order = marketplace.createOrder();

        assertItemStringAtPosition("1 imported bottle of perfume: 32.19", 0, order);
        assertItemStringAtPosition("1 bottle of perfume: 20.89", 1, order);
        assertItemStringAtPosition("1 packet of headache pills: 9.75", 2, order);
        assertItemStringAtPosition("1 imported box of chocolates: 11.85", 3, order);
        assertTotalTaxes(6.70, order);
        assertTotalPrice(order, 74.68);
    }

    private void assertItemStringAtPosition(String expected, int position, Order order) {
        assertEquals(expected, order.getItemOrderAtPosition(position).toString());
    }

    private void assertTotalPrice(Order order, double expected) {
        assertEquals(expected, order.getTotalPrice().getValue());
    }

    private void assertTotalTaxes(double expected, Order order) {
        assertEquals(expected, order.getTotalTaxes().getValue());
    }
}
