package sales.taxes.item;

public class ExemptItem extends Item {
    public ExemptItem(String productName, double netPrice) {
        super(productName, netPrice);
    }

    @Override
    public boolean isExempt() {
        return true;
    }
}
