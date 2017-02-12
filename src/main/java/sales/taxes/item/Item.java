package sales.taxes.item;

import sales.taxes.Price;

public abstract class Item {
    private String productName;
    private Price netPrice;
    private boolean imported;

    public Item(String productName, double netPrice) {
        this.productName = productName;
        this.netPrice = new Price(netPrice);
    }

    public String getProductName() {
        return productName;
    }

    public Price getNetPrice() {
        return netPrice;
    }

    public boolean isImported() {
        return imported;
    }

    public Item setImported() {
        this.imported = true;
        return this;
    }

    public abstract boolean isExempt();
}
