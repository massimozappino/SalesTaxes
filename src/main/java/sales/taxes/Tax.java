package sales.taxes;

public class Tax {
    private final Price price;

    public Tax(double netPrice, double taxRate) {
        this.price = new Price(calculateTaxAtRate(netPrice, taxRate));
    }

    public Price getPrice() {
        return price;
    }

    private double calculateTaxAtRate(double netPrice, double taxRate) {
        double currentTax = (netPrice * taxRate / 100);
        return new RoundTax(currentTax).getRoundedValue();
    }
}
