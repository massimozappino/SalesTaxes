package sales.taxes;

import java.math.BigDecimal;

public class Price {
    private double value;

    public Price(double price) {
        value = round(price);
    }

    public Price() {

    }

    public Price(Price price) {
        value = price.getValue();
    }

    private double round(double taxValue) {
        BigDecimal bigDecimal = new BigDecimal(taxValue).setScale(2, BigDecimal.ROUND_HALF_EVEN);

        return bigDecimal.doubleValue();
    }

    public double getValue() {
        return value;
    }

    public Price sum(Price price) {
        value += price.getValue();
        value = round(value);
        return this;
    }
}
