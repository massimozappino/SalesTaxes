package sales.taxes;

import sales.taxes.item.Item;

public class OrderItem {
    private static final double TAX_RATE_IMPORTED = 5;
    private static final double TAX_RATE_NOT_EXEMPT = 10;
    private Tax tax;
    private Price totalPrice;
    private Item item;

    public OrderItem(Item item) {
        this.item = item;
        Price netPrice = new Price(item.getNetPrice());
        tax = new Tax(item.getNetPrice().getValue(), calculateFullTaxRate());
        totalPrice = netPrice.sum(tax.getPrice());
    }

    public Tax getTax() {
        return tax;
    }

    public Price getTotalPrice() {
        return totalPrice;
    }

    public Item getItem() {
        return item;
    }

    public double calculateFullTaxRate() {
        double fullTaxRate = 0;
        if (item.isImported()) {
            fullTaxRate += TAX_RATE_IMPORTED;
        }
        if (!item.isExempt()) {
            fullTaxRate += TAX_RATE_NOT_EXEMPT;
        }
        return fullTaxRate;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", item.getProductName(), totalPrice.getValue());
    }
}
