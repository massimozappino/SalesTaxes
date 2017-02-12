package sales.taxes;

public class RoundTax {
    private double roundedValue;

    public RoundTax(double taxValue) {
        double mod = taxValue % 0.05;
        taxValue += (mod == 0) ? 0 : (0.05 - mod);
        roundedValue = taxValue;
    }

    public double getRoundedValue() {
        return roundedValue;
    }
}
