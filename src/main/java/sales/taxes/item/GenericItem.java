package sales.taxes.item;

public class GenericItem extends Item {

    public GenericItem(String productName, double netPrice) {
        super(productName, netPrice);
    }

    @Override
    public boolean isExempt() {
        return false;
    }
}
